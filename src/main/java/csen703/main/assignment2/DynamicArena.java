package csen703.main.assignment2;

import java.util.Arrays;

public class DynamicArena {
    public static int ClimbDynamicArenaDP(int[] floors) {
        int[] mem = new int[floors.length];
        for (int start = floors.length - 1; start >= 0; start--) {
            helper(start, floors, mem);
        }
        System.out.println(Arrays.toString(mem));
        return mem[0];
    }

    public static void helper(int start, int[] floors, int[] mem) {
        if (start >= floors.length - 1)
            return;

        if (mem[start] != 0)
            return;

        if (floors[start] > floors[start + 1]) {
            mem[start] = mem[start + 1];
            return;
        }

        int max = 0;
        for (int fight = start + 1; fight < floors.length; fight++) {
            int diff = floors[fight] - floors[start];

            if (diff < 0)
                continue;

            int nextStart = 0;
            if (fight + 2 < floors.length)
                nextStart = mem[fight + 2];

            int reward = diff + nextStart;
            max = Math.max(reward, max);
        }

        mem[start] = Math.max(max, mem[start + 1]);
    }

    public static void main(String[] args) {
        int[] floors;
        floors = new int[]{1, 7, 5, 3, 6, 4, 5, 8};
//        floors = new int[]{1, 2, 7};
//        floors = new int[]{4, 3, 2, 1};
        System.out.println("Answer: " + ClimbDynamicArenaDP(floors));
    }
}