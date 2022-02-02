package com.tutorial.Advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day33_AdvancedDSAArrays1 {
    public void execute() {

        //AS2 > Max Subarray Sum - Kadane's Algo
        ArrayList<Integer> inputAS2A = new ArrayList<>(Arrays.asList(5, 6, 7, -3, 2, -10, -12, 8, 12, 21));
        int outputAS2A = this.maxSubArray(inputAS2A);
        System.out.println("AS2> Max Subarray Sum - Kadane's Algo [5, 6, 7, -3, 2, -10, -12, 8, 12, 21]: " + outputAS2A);
        ArrayList<Integer> inputAS2B = new ArrayList<>(Arrays.asList(-5, -6, -3, -2, -10));
        int outputAS2B = this.maxSubArray(inputAS2B);
        System.out.println("AS2> Max Subarray Sum - Kadane's Algo [-5, -6, -3, -2, -10]: " + outputAS2B);

        //AS4 > Beggars outside temple
        Integer inputAS4A = 5;
        ArrayList<ArrayList<Integer>> inputAS4B = new ArrayList<>();
        inputAS4B.add(new ArrayList<>(Arrays.asList(1, 2, 10)));
        inputAS4B.add(new ArrayList<>(Arrays.asList(2, 3, 20)));
        inputAS4B.add(new ArrayList<>(Arrays.asList(2, 5, 25)));
        ArrayList<Integer> outputAS4 = this.beggarsOutsideTemple(inputAS4A, inputAS4B);
        System.out.print("AS4> Beggars outside temple : ");
        outputAS4.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println("");
    }

    /**
     * AS2 > Max Subarray Sum - Kadane's Algo
     * @param A
     * @return
     */
    public int maxSubArray(final List<Integer> A) {
        //KADANES ALGO - Find Largest subarray sum in O(N)
        int maxSum = Integer.MIN_VALUE;
        int runningSum = 0;

        for (int i = 0; i < A.size(); i++) {
            runningSum = runningSum + A.get(i);
            if (runningSum > maxSum) {
                maxSum = runningSum;
            }
            if (runningSum < 0) {
                runningSum = 0;
            }
        }

        return maxSum;
    }

    /**
     * AS4 > Beggars outside temple
     * Note 1 based array inputs (not 0 based)
     * @param A
     * @param B
     * @return
     */
    public ArrayList<Integer> beggarsOutsideTemple(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> beggars = new ArrayList<Integer>();
        for (int i = 0; i < A; i++) {
            beggars.add(0);
        }

        B.forEach(eachCase -> {
            int index = eachCase.get(0) - 1;
            int newCount = beggars.get(index) + eachCase.get(2);
            beggars.set(index, newCount);

            index = eachCase.get(1) - 1;
            if (index + 1 < A) {
                newCount = beggars.get(index + 1) - eachCase.get(2);
                beggars.set((index + 1), newCount);
            }
        });

        int sum = 0;
        for (int i = 0; i < A; i++) {
            sum = sum + beggars.get(i);
            beggars.set(i, sum);
        }

        return beggars;
    }
}
