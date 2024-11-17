package org.example;

public class RingToss {

    public static int RingTossGreedy(int[] pegs) {
        int pegsLength = pegs.length;
        int[] pegsThrown = new int[pegsLength];

        int totalPegsThrown = 0;
        int startIndex = 0;
        int endIndex = 0;

        int currentIndex;
        int nextIndex;
        int currentPeg;
        int nextIndexPeg;

        while (true) {
            while (startIndex < pegsLength - 1 && pegs[startIndex] - pegsThrown[startIndex] == 0)
                startIndex++;

            if (startIndex >= endIndex) {
                endIndex = startIndex;
            }

            if (endIndex != pegsLength - 1) {
                currentIndex = endIndex;
                nextIndex = endIndex + 1;
                currentPeg = pegs[currentIndex] - pegsThrown[currentIndex];
                nextIndexPeg = pegs[nextIndex] - pegsThrown[nextIndex];


                while (nextIndexPeg >= currentPeg) {
                    endIndex++;
                    currentIndex = endIndex;
                    nextIndex = endIndex + 1;

                    if (nextIndex == pegsLength) break;

                    currentPeg = pegs[currentIndex] - pegsThrown[currentIndex];
                    nextIndexPeg = pegs[nextIndex] - pegsThrown[nextIndex];
                }
            }

            if (endIndex == pegsLength - 1 && pegs[endIndex] == pegsThrown[endIndex])
                break;

            for (int i = startIndex; i <= endIndex; i++) {
                pegsThrown[i] += 1;
            }
            totalPegsThrown += 1;
        }

        return totalPegsThrown;
    }

    public static void main(String[] args) {
        long startTime, endTime;
        int[] pegs;
        int tosses;

        pegs = new int[]{1, 2, 1, 2, 1};
        tosses = RingToss.RingTossGreedy(pegs);
        System.out.println(tosses);
    }
}