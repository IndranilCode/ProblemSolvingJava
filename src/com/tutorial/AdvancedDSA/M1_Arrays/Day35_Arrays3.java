package com.tutorial.AdvancedDSA.M1_Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Day35_Arrays3 {
    public void execute() {
        System.out.println("---------------Day35 => Arrays3---------------");
        /*------------CLASSWORK------------*/
        ArrayList<Integer> inputCW1a = new ArrayList<>(Arrays.asList(1, 3, -1));
        System.out.println("CW1 > Max absolute difference - Brute Force : " + this.maxDifferenceInArrayForEquation_BruteForce(inputCW1a));

        ArrayList<Integer> inputCW1b = new ArrayList<>(Arrays.asList(1, 3, -1));
        System.out.println("CW1 > Max absolute difference - Converted equation : " + this.maxDifferenceInArrayForEquation(inputCW1b));

        ArrayList<Integer> inputCW2 = new ArrayList<>(Arrays.asList(1, 3, -1));
        System.out.println("CW2 > Pair of (i,j) where [Aj - Ai = j - i] AND i != j : " + this.findIJPairForEquation_Converted(inputCW2));

        /*------------ASSIGNMENTS------------*/

        ArrayList<Integer> inputAS1 = new ArrayList<>(Arrays.asList(3, 4, -1, 1));
        System.out.println("AS1 > First Missing Integer (3, 4, -1, 1) : " + this.firstMissingInteger(inputAS1));

        ArrayList<Integer> inputAS4 = new ArrayList<>(Arrays.asList(1, 3, -1));
        System.out.println("AS4 > Maximum Absolute Difference [1, 3, -1] : " + this.maxAbsDifference(inputAS4));
    }

    /*------------CLASSWORK------------*/

    /**
     * CW1 > Max absolute difference - Brute Force
     * Given, f(i,j) = |Ai - Aj] + |i - j|
     * @param a
     * @return
     */
    private int maxDifferenceInArrayForEquation_BruteForce(ArrayList<Integer> a) {
        //TC = O(N2) - double loop
        //SC = O(1)
        int maxDifference = Integer.MIN_VALUE;
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size(); j++) {
                int currentVal = Math.abs(a.get(i) - a.get(j)) + Math.abs(i - j);
                if (currentVal > maxDifference) {
                    maxDifference = currentVal;
                }
            }
        }
        return maxDifference;
    }

    /**
     * CW1 > Max absolute difference - Converted equation
     * Given, f(i,j) = |Ai - Aj] + |i - j|
     * @param a
     * @return
     */
    private int maxDifferenceInArrayForEquation(ArrayList<Integer> a) {
        //Convert equation =>  f(i,j) = |Ai - Aj] + |i - j|
        //1. [Ak + k] min & max [Case1]
        //2. [Ak - k] min & max [Case2]
        int case1Max = Integer.MIN_VALUE;
        int case1Min = Integer.MAX_VALUE;
        int case2Max = Integer.MIN_VALUE;
        int case2Min = Integer.MAX_VALUE;
        for (int k = 0; k < a.size(); k++) {
            int case1Val = a.get(k) + k;
            int case2Val = a.get(k) - k;

            //Find case1 min & max
            if (case1Val > case1Max) {
                case1Max = case1Val;
            }
            if (case1Val < case1Min) {
                case1Min = case1Val;
            }

            //Find case2 min & max
            if (case2Val > case2Max) {
                case2Max = case2Val;
            }
            if (case2Val < case2Min) {
                case2Min = case2Val;
            }
        }
        int case1MinMaxDifference = case1Max - case1Min;
        int case2MinMaxDifference = case2Max - case2Min;

        return case1MinMaxDifference > case2MinMaxDifference ? case1MinMaxDifference : case2MinMaxDifference;
    }

    /**
     * CW2 > Pair of (i,j) where [Aj - Ai = j - i] AND i != j
     * @return
     */
    private boolean findIJPairForEquation_Converted(ArrayList<Integer> a) {
        //Given Aj - Ai = j - i
        //Aj - j = Ai - i
        int[] aKMinusK = new int[a.size()];
        for (int k = 0; k < a.size(); k++) {
            aKMinusK[k] = a.get(k) - k;
        }
        //Now find in aKMinusK[] if there is any repeating numbers - use Map
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int k = 0; k < a.size(); k++) {
            if (!freqMap.containsKey(k)) {
                freqMap.put(k, 1);
            } else {
                int curFreq = freqMap.get(k);
                freqMap.put(k , curFreq++);
            }
        }

        boolean result = false;
        for(Integer key : freqMap.keySet()) {
            if (freqMap.get(key) > 1) {
                result = true;
            }
        }
        return result;
    }

    /*------------ASSIGNMENTS------------*/

    /**
     * AS1 > First Missing Integer
     * Given an unsorted integer array A of size N. Find the first missing positive integer.
     * Note: Your algorithm should run in O(n) time and use constant space.
     * @param A
     * @return
     */
    private int firstMissingInteger(ArrayList<Integer> A) {
        //Copy into array
        int[] numbers = new int[A.size() + 1];
        Arrays.fill(numbers,0);
        for (int i = 0; i < A.size(); i++) {
            numbers[i + 1] = A.get(i);
        }

        int temp = -1000;
        for (int i = 1; i <= A.size(); i++) {
            if (numbers[i] != i || numbers[i] < A.size() || numbers[i] > 0) {
                //Current number is out of place - swap with the number at that index (where its supposed to be)
                //Do below till the number in current index is right OR negative or > highest number
                //                while ( (numbers[i] < A.size() && numbers[i] > 0 && numbers[i] != i) ||    )     numbers[i] != i || (numbers[i] > 0 && numbers[i] < A.size()) || numbers[i] > 1) {
                while (numbers[i] <= A.size() && numbers[i] > 0 && numbers[i] != i) {
                    //Swap - take value of numbers[i], this is the index from where you grab the number
                    int currentVal = numbers[i];
                    int currentIndex = i;
                    int otherVal = numbers[numbers[i]];
                    int otherIndex = numbers[i];

                    temp = currentVal; //copy currentVal to temp
                    numbers[i] = otherVal; //set currentIndexNumber = otherVal
                    numbers[otherIndex] = temp; //set otherIndexNumber = temp
                }
            }
        }

        int firstMissingNumber = A.size(); //By default assume highest as first missing
        for (int i = 1; i < A.size(); i++) {
            if (numbers[i] != i) {
                firstMissingNumber = i;
                break;
            }
        }
        return firstMissingNumber;
    }

    /**
     * AS4 > Maximum Absolute Difference
     * |A[i] - A[j]| + |i - j|,
     * @param A
     * @return
     */
    private int maxAbsDifference(ArrayList<Integer> A) {
        //Convert equation =>  f(i,j) = |Ai - Aj] + |i - j|
        //1. [Ak + k] min & max [Case1]
        //2. [Ak - k] min & max [Case2]
        int case1Max = Integer.MIN_VALUE;
        int case1Min = Integer.MAX_VALUE;
        int case2Max = Integer.MIN_VALUE;
        int case2Min = Integer.MAX_VALUE;
        for (int k = 0; k < A.size(); k++) {
            int case1Val = A.get(k) + k;
            int case2Val = A.get(k) - k;

            //Find case1 min & max
            if (case1Val > case1Max) {
                case1Max = case1Val;
            }
            if (case1Val < case1Min) {
                case1Min = case1Val;
            }

            //Find case2 min & max
            if (case2Val > case2Max) {
                case2Max = case2Val;
            }
            if (case2Val < case2Min) {
                case2Min = case2Val;
            }
        }
        int case1MinMaxDifference = case1Max - case1Min;
        int case2MinMaxDifference = case2Max - case2Min;

        return case1MinMaxDifference > case2MinMaxDifference ? case1MinMaxDifference : case2MinMaxDifference;
    }


}
