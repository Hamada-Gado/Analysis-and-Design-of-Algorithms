package csen703.main.assignment2;

import java.util.Arrays;

public class DynamicArena {
    public static int ClimbDynamicArenaDP(int[] floors) {
        // mem[index] holds the optimal cost for starting at index in floors
        int[] mem = new int[floors.length];
        int max = -1;
        for (int i = floors.length - 1; i >= 0; i--) {
            helper(i, floors, mem);
            if (max < mem[i])
                max = mem[i];
        }
        System.out.println(Arrays.toString(mem));
        return max;
    }

    public static void helper(int start, int[] floors, int[] mem) {
        if (start >= floors.length - 1)
            return;
        if (floors[start] > floors[start + 1]) {
            mem[start] = -1;
            return;
        }


        if (mem[start] != 0)
            return;

        int diff = floors[start + 1] - floors[start];

        // No Skip
        helper(start + 3, floors, mem);
        int noSkip = 0;
        if (start + 3 < floors.length)
            noSkip = mem[start + 3];

        // Skip
        helper(start + 4, floors, mem);
        int skip = 0;
        if (start + 4 < floors.length)
            skip = mem[start + 4];

        mem[start] = diff + Math.max(noSkip, skip);
    }

    public static void main(String[] args) {
//        int[] floors = {1, 7, 5, 3, 6, 4, 5, 8};
//        int[] floors = {1, 2, 7};
        int[] floors = {4, 3, 2, 1};
        System.out.println("Answer: " + ClimbDynamicArenaDP(floors));
    }
}