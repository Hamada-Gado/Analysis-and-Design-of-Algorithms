package org.example;

public class RingToss {
    public static int RingTossGreedy(int[] pegs) {
        int pegsLength = pegs.length;
        int totalTosses = 0;
        int startIndex = 0;

        while (startIndex < pegsLength) {
            if (pegs[startIndex] == 0) {
                startIndex++;
                continue;
            }

            int endIndex = startIndex;

            while (endIndex < pegsLength - 1 && pegs[endIndex + 1] >= pegs[endIndex]) {
                endIndex++;
            }

            int diff;
            if (endIndex + 1 >= pegsLength)
                diff = pegs[startIndex];
            else
                diff = pegs[endIndex] - pegs[endIndex + 1];
            int maxToss = Math.max(Math.min(pegs[startIndex], diff), 1);
            for (int i = startIndex; i <= endIndex; i++) {
                pegs[i] -= maxToss;
                if (pegs[i] == 0)
                    startIndex = i + 1;
            }

            totalTosses += maxToss;
        }

        return totalTosses;
    }

    public static void main(String[] args) {
        int[] pegs;
        int tosses;

        pegs = new int[]{2,3,4,2,1};
        tosses = RingToss.RingTossGreedy(pegs);
        System.out.println(tosses);
    }
}