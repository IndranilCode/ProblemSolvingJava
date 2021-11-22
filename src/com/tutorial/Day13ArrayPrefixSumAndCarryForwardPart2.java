package com.tutorial;

import java.util.ArrayList;
import java.util.Arrays;

public class Day13ArrayPrefixSumAndCarryForwardPart2 {
    public void executeArrayPrefixSumAndCarryForwardPart2() {
        //AS1 > Subarray with least average
        //ArrayList<Integer> inputAS1a = new ArrayList<Integer>(Arrays.asList(3, 7, 90, 20, 10, 50, 40));
        ArrayList<Integer> inputAS1a = new ArrayList<Integer>(Arrays.asList(15, 7, 11, 7, 9, 8, 18, 1, 16, 18, 6, 1, 1, 4, 18));

        int inputAS1b = 6;
        int outputAS1 = subarrayWithLeastAverage(inputAS1a, inputAS1b);
        System.out.println("AS1 - Subarray with least average :" + outputAS1);
    }

    /**
     * AS1 > Subarray with least average
     * Given an array of size N, Find the subarray with least average of size k.
     * Example => A=[3, 7, 90, 20, 10, 50, 40] , B=3 => O/P = 3
     * Subarray between indexes 3 and 5. The subarray {20, 10, 50} has the least average among all subarrays of size 3.
     * @param A
     * @param B
     * @return
     */
    private int subarrayWithLeastAverage(ArrayList<Integer> A, int B) {
        int leastSubarrayIndex = 0;
        int smallestSubarraySum = 0;
        int subarraySum = 0;
        for (int i = 0; i < B; i++) {
            subarraySum = subarraySum + A.get(i);
        }
        smallestSubarraySum = subarraySum;

        for (int i = 1; i < A.size() - B; i++) {
            subarraySum = subarraySum - A.get(i - 1) + A.get(i + B -1);
            if (subarraySum < smallestSubarraySum) {
                smallestSubarraySum = subarraySum;
                leastSubarrayIndex = i;
            }
        }
        return leastSubarrayIndex;
    }
}
