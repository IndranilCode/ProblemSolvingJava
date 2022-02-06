package com.tutorial.Advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day33_AdvancedDSAArrays1 {
    public void execute() {
        //CW1 > Find max subarray => Kadane's algo + indexes (start , end)
        ArrayList<Integer> inputCW1 = new ArrayList<>(Arrays.asList(-10, 2, 3, 5, -4 , -1, 20, -3, -100));
        this.kadanesAlgo(inputCW1);
        this.maxSubarraySumBruteForce(inputCW1);

        //AS1> Rain Water Trapped
        ArrayList<Integer> inputAS1 = new ArrayList<>(Arrays.asList(1, 0, 3, 7, 4, 8));
        int outputAS1 = this.waterTrap(inputAS1);
        System.out.println("AS1> Rain Water Trapped : " + outputAS1);

        //AS2 > Max Subarray Sum - Kadane's Algo
        ArrayList<Integer> inputAS2A = new ArrayList<>(Arrays.asList(5, 6, 7, -3, 2, -10, -12, 8, 12, 21, -100));
        int outputAS2A = this.maxSubArray(inputAS2A);
        System.out.println("AS2> Max Subarray Sum - Kadane's Algo [5, 6, 7, -3, 2, -10, -12, 8, 12, 21]: " + outputAS2A);
        ArrayList<Integer> inputAS2B = new ArrayList<>(Arrays.asList(-5, -6, -3, -2, -10));
        int outputAS2B = this.maxSubArray(inputAS2B);
        System.out.println("AS2> Max Subarray Sum - Kadane's Algo [-5, -6, -3, -2, -10]: " + outputAS2B);

        flip("1001100001");
        flip("10011001");
        flip("111");


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
     * CW1> Kadane's algo. Find max subarray
     * TC = O(n) , SC = O(1)
     * @param A
     */
    private void kadanesAlgo(List<Integer> A) {
        int tempLeft = 0;
        int startIndex = 0;
        int endIndex = 0;
        int maxSubarrySum = Integer.MIN_VALUE;
        int runningSum = 0;

        //[ -10, 2, 3, 5, -4 , -1, 20, -3, -100]

        for (int i = 0; i < A.size(); i++) {
            runningSum = runningSum + A.get(i);

            if (runningSum < 0) {
                runningSum = 0;
                tempLeft = i + 1; //Note: here if last index sum is -ve too this can go out of bound [But the temp copy protects the final]
            }
            if (runningSum > maxSubarrySum) {
                maxSubarrySum = runningSum;
                endIndex = i;
                startIndex = tempLeft;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = startIndex; i <= endIndex; i++) {
            result.add(A.get(i));
        }

        System.out.println("CW1> Kadane's algo " + A + " => Max: " + maxSubarrySum + ", StartIndex: " + startIndex + ", EndIndex:" + endIndex + ", Result:" + result);
    }

    /**
     * CW2> Max subarray sum (Brute Force)
     * @param A
     */
    private void maxSubarraySumBruteForce(List<Integer> A) {
        int totalSize = A.size();
        int maxSubarraySum = Integer.MIN_VALUE;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < totalSize; i++) {
            for (int j = i; j < totalSize; j++) {
                int runningSum = 0;
                for (int k = i; k <= j; k++) {
                    runningSum = runningSum + A.get(k);
                }
                if (runningSum > maxSubarraySum) {
                    maxSubarraySum = runningSum;
                    startIndex = i;
                    endIndex = j;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = startIndex; i <= endIndex; i++) {
            result.add(A.get(i));
        }
        System.out.println("CW2> Brute Force max subarray sum" + A + " => Max: " + maxSubarraySum + ", StartIndex: " + startIndex + ", EndIndex:" + endIndex + ", Result:" + result);
    }

    /**
     * AS1> Rain Water Trapped
     * Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1,
     * compute how much water it is able to trap after raining
     * @param A
     * @return
     */
    private int waterTrap(final List<Integer> A) {
        ArrayList<Integer> lmax = new ArrayList();
        ArrayList<Integer> rmax = new ArrayList();

        int currentLMax = 0;
        int currentRMax = 0;
        for (int i = 0; i < A.size(); i++) {
            currentLMax = A.get(i) > currentLMax ? A.get(i) : currentLMax;
            lmax.add(currentLMax);
        }
        for (int i = A.size() - 1; i >= 0; i--) {
            currentRMax = A.get(i) > currentRMax ? A.get(i) : currentRMax;
            rmax.add(currentRMax);
        }
        Collections.reverse(rmax); //rmax = rmax.reverse(); [WONT WORK]

        int totalStorage = 0;

        for (int i = 0; i < A.size(); i++) {
            int currentPossibleStorage = (lmax.get(i) < rmax.get(i) ? lmax.get(i) : rmax.get(i)) - A.get(i);
            totalStorage = totalStorage + currentPossibleStorage;
        }
        return totalStorage;
    }

    /**
     * AS2 > Max Subarray Sum - Kadane's Algo
     * @param A
     * @return
     */
    private int maxSubArray(final List<Integer> A) {
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
     * AS3 > Flip
     * Given a binary string A of 0/1, choose two indices L and R, flip the characters ( 0 -> 1, 1 -> 0).
     * Aim is to perform ATMOST one operation such that in final string number of 1s is maximised.
     * @param A
     * @return
     */
    private ArrayList<Integer> flip(String A) {
        ArrayList<Integer> weightedString = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            weightedString.add(A.charAt(i) == '1' ? -1 : 1);
        }
        System.out.println(weightedString);

        int l = 0;
        int startIndex = Integer.MIN_VALUE;
        int endIndex = Integer.MIN_VALUE;
        int runningSum = 0;
        int maxSum = Integer.MIN_VALUE;


        for (int i = 0; i < weightedString.size(); i++) {
            int currentNumber = Integer.parseInt(weightedString.get(i) + "");
            runningSum = runningSum + currentNumber;

            if (runningSum < 0) {
                runningSum = 0;
                l = i + 1;
            }

            if (runningSum > maxSum) {
                maxSum = runningSum;
                endIndex = i;
                startIndex = l;
            }
        }
        System.out.println(maxSum + " startIndex:" + startIndex + " endIndex: " + endIndex);

        ArrayList<Integer> result = new ArrayList<>();
        if (endIndex > startIndex) {
            result.add(startIndex + 1);
            result.add(endIndex + 1);
        }
        return result;
    }

    /**
     * AS4 > Beggars outside temple
     * Note 1 based array inputs (not 0 based)
     * @param A
     * @param B
     * @return
     */
    private ArrayList<Integer> beggarsOutsideTemple(int A, ArrayList<ArrayList<Integer>> B) {
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
