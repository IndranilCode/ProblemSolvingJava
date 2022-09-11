package main.tutorial;

import java.util.ArrayList;
import java.util.Arrays;

public class Day13ArrayPrefixSumAndCarryForwardPart2 {
    public void execute() {
        //AS1 > Subarray with least average
        ArrayList<Integer> inputAS1a = new ArrayList<Integer>(Arrays.asList(3, 7, 90, 20, 10, 50, 40));
        //ArrayList<Integer> inputAS1a = new ArrayList<Integer>(Arrays.asList(15, 7, 11, 7, 9, 8, 18, 1, 16, 18, 6, 1, 1, 4, 18));
        //        int inputAS1b = 6;
        int inputAS1b = 3;
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
        int smallestSubarraySum = Integer.MAX_VALUE;

        int runningSum = 0;
        ArrayList<Integer> prefixSum = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            runningSum = runningSum + A.get(i);
            prefixSum.add(runningSum);
        }

        for (int i = 0; i <= (A.size() - B); i++) {
            int upperLimitValue = prefixSum.get(i + B - 1);
            int lowerLimitValue = (i - 1 >= 0 ) ? prefixSum.get(i - 1) : 0;
            int currentSubarraySum = upperLimitValue - lowerLimitValue;

            if (currentSubarraySum < smallestSubarraySum) {
                smallestSubarraySum = currentSubarraySum;
                leastSubarrayIndex = i;
            }
        }
        return leastSubarrayIndex;
    }
}
