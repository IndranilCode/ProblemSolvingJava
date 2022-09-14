package main.tutorial.IntermediateDSA.M3_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Day13_ArrayPrefixSumAndCarryForwardPart2 {
    public void execute() {
        System.out.println("----------Intermediate : Day 13: Array - Prefix Sum & Carry Forward 2----------");
        System.out.println("------------------------------------ASSIGNMENT---------------------------------");

        //AS1 > Subarray with least average
        ArrayList<Integer> inputAS1a = new ArrayList<Integer>(Arrays.asList(3, 7, 90, 20, 10, 50, 40));
        System.out.println("AS1 > Subarray with least average (3, 7, 90, 20, 10, 50, 40) [Window : 3] => " + this.subarrayWithLeastAverage(inputAS1a, 3));
        ArrayList<Integer> inputAS1a_2 = new ArrayList<Integer>(Arrays.asList(15, 7, 11, 7, 9, 8, 18, 1, 16, 18, 6, 1, 1, 4, 18));
        System.out.println("    > Subarray with least average (15, 7, 11, 7, 9, 8, 18, 1, 16, 18, 6, 1, 1, 4, 18) [Window : 6] => " + this.subarrayWithLeastAverage(inputAS1a_2, 6));

        System.out.println("------------------------------------HOMEWORK-----------------------------------");

        //HW1 > Xor queries
        ArrayList<Integer> inputHW1A_1 = new ArrayList<>(Arrays.asList(1, 0, 0, 0, 1));
        ArrayList<ArrayList<Integer>> inputHW1B_1 = new ArrayList<>();
        inputHW1B_1.add(new ArrayList<>(Arrays.asList(2, 4)));
        inputHW1B_1.add(new ArrayList<>(Arrays.asList(1, 5)));
        inputHW1B_1.add(new ArrayList<>(Arrays.asList(3, 5)));
        ArrayList<ArrayList<Integer>> resultHW1 = this.xorQueries(inputHW1A_1, inputHW1B_1);
        System.out.print("HW1 > Xor queries => ");
        System.out.println(resultHW1);

        //HW2 > Minimum Absolute Difference
        ArrayList<Integer> inputHW2_1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("HW2 > Minimum Absolute Difference (1, 2, 3, 4, 5) => " + this.minimumAbsoluteDifference(inputHW2_1));
        ArrayList<Integer> inputHW2_2 = new ArrayList<>(Arrays.asList(5, 17, 100, 11));
        System.out.println("    > Minimum Absolute Difference (5, 17, 100, 11) => " + this.minimumAbsoluteDifference(inputHW2_2));

        //HW3 > Special Index
        ArrayList<Integer> inputHW3_1 = new ArrayList<>(Arrays.asList(2, 1, 6, 4));
        System.out.println("HW3 > Special Index (2, 1, 6, 4) => " + this.specialIndexCount(inputHW3_1));
        ArrayList<Integer> inputHW3_2 = new ArrayList<>(Arrays.asList(1, 1, 1));
        System.out.println("    > Special Index (1, 1, 1) => " + this.specialIndexCount(inputHW3_2));
    }

    //-------------------------------------------------------------------------------------------

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

    //-------------------------------------------------------------------------------------------

    /**
     * HW1 > Xor queries
     * You are given an array A (containing only 0 and 1) as element of N length.
     * Given L and R, you need to determine value of XOR of all elements from L to R (both inclusive) and number of unset bits (0's) in the given range of the array.
     * @param A
     * @param B
     * @return
     */
    private ArrayList<ArrayList<Integer>> xorQueries(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> xorPS = new ArrayList<>();
        ArrayList<Integer> zeroesCountPS = new ArrayList<>();
        int runningSum = 0;
        int runningXor = 0;
        for (int i = 0; i < A.size(); i++) {
            runningSum = runningSum + (A.get(i) == 0 ? 1 : 0); //Count of 0's
            zeroesCountPS.add(runningSum);

            runningXor = runningXor ^ A.get(i);
            xorPS.add(runningXor);
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //NOTE: 1 based indexing
        for (int q = 0; q < B.size(); q++) {
            int startIndex = B.get(q).get(0) - 1;
            int endIndex = B.get(q).get(1) - 1;
            ArrayList<Integer> eachQueryResult = new ArrayList<>();

            //Xor series
            int startXorVal = startIndex > 0 ? xorPS.get(startIndex - 1) : 0;
            eachQueryResult.add(xorPS.get(endIndex) ^ startXorVal);
            result.add(eachQueryResult);

            //Count of 0's
            int start0Val = startIndex > 0 ? zeroesCountPS.get(startIndex - 1) : 0;
            eachQueryResult.add(zeroesCountPS.get(endIndex) - start0Val);
        }
        return result;
    }

    /**
     * HW2 > Minimum Absolute Difference
     * Given an array of integers A, find and return the minimum value of | A [ i ] - A [ j ] | where i != j and |x| denotes the absolute value of x.
     * @param A
     * @return
     */
    private int minimumAbsoluteDifference(ArrayList<Integer> A) {
        Collections.sort(A);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < A.size(); i++) {
            int diff = A.get(i) - A.get(i-1);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }

    /**
     * HW3 > Special Index
     * Given array of size N, find the count of array indices such that :
     * removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
     * @param A
     * @return
     */
    private int specialIndexCount(ArrayList<Integer> A) {
        ArrayList<Integer> evenPs = new ArrayList<>();
        ArrayList<Integer> oddPs = new ArrayList<>();

        //Form evenPs & oddPs
        int evenSum = 0;
        int oddSum = 0;
        for (int i = 0; i < A.size(); i++) {
            if (i % 2 == 0) {
                //Even index
                evenSum = evenSum + A.get(i);
                evenPs.add(evenSum);
                oddPs.add(oddSum);
            } else {
                //Odd index
                oddSum = oddSum + A.get(i);
                oddPs.add(oddSum);
                evenPs.add(evenSum);
            }
        }

        int n = A.size();
        int specialIndexCount = 0;
        int evenIndexTotal = 0, oddIndexTotal = 0;
        //Handle 0th index
        evenIndexTotal = oddPs.get(n-1);
        oddIndexTotal = evenPs.get(n-1) - evenPs.get(0);
        if (evenIndexTotal == oddIndexTotal) {
            specialIndexCount++;
        }

        for (int i = 1; i < n; i++) {
            evenIndexTotal = evenPs.get(i-1) + (oddPs.get(n-1) - oddPs.get(i));
            oddIndexTotal = oddPs.get(i-1) + (evenPs.get(n-1) - evenPs.get(i));
            if (evenIndexTotal == oddIndexTotal) {
                specialIndexCount++;
            }
        }
        return specialIndexCount;

        //DEMO:

        //        2 1 6 4
        //Even => 2 2 8 8
        //Odd  => 0 1 1 5

        //Handling 0th index
        //         1 6 4
        // Even => 1 + 4
        // Odd  => 6
    }
}
