package com.tutorial;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Day19IntroductionToHashingLibraries1 {
    public void executeIntroductionToHashing() {
        //AS1 > Common Elements
        ArrayList<Integer> inputAS1Aa = new ArrayList<Integer>(Arrays.asList(1, 2, 2, 1));
        ArrayList<Integer> inputAS1b = new ArrayList<Integer>(Arrays.asList(2, 3, 1, 2));
        ArrayList<Integer> outputAS1 = commonElements(inputAS1Aa, inputAS1b);
        System.out.print("AS1 - Common Elements :");
        outputAS1.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println("");

        //AS2 > First Repeating element
        ArrayList<Integer> inputAS2 = new ArrayList<Integer>(Arrays.asList(10, 5, 3, 4, 3, 5, 6));
        Integer outputAS2 = firstRepeatingElement(inputAS2);
        System.out.println("AS2 - First Repeating element :" + outputAS2);

        //AS3 > Largest Continuous Sequence Zero Sum
        //ArrayList<Integer> inputAS3 = new ArrayList<Integer>(Arrays.asList(1, 5, 8, -5, -2, -6, 2, -2, 8, -6));
        //ArrayList<Integer> inputAS3 = new ArrayList<Integer>(Arrays.asList( 1, 2, -2, 4, -4));
        //ArrayList<Integer> inputAS3 = new ArrayList<Integer>(Arrays.asList( 1, 2, -3, 3));
        //ArrayList<Integer> inputAS3 = new ArrayList<Integer>(Arrays.asList( 0, -10, 20, 3, 23, 10, -20, 2, 19, -29, 0));
        //ArrayList<Integer> inputAS3 = new ArrayList<Integer>(Arrays.asList( -19, 8, 2, -8, 19, 5, -2, -23));
        //ArrayList<Integer> inputAS3 = new ArrayList<Integer>(Arrays.asList(-9, -13, 6, -28, 27, -5, -27, 17, 15, -17, -25, 6, -8, 2, -13, -13, -23, 21, -4, 22, -9, -10, 0, -28, -11, 8, 8, 17));
        //ArrayList<Integer> inputAS3 = new ArrayList<Integer>(Arrays.asList(15, 18, -23, 22, -15, 26, -28, -25, 3, 3, 7, -22, 12, -13, 21, 18, -15, -23, -5));
        ArrayList<Integer> inputAS3 = new ArrayList<Integer>(Arrays.asList(0, -10, 20, 3, 23, 10, -20, 2, 19, -29, 0));
        ArrayList<Integer> outputAS3 = largestContinuousSequenceZeroSum(inputAS3);
        System.out.print("AS3 - Largest Continuous Sequence Zero Sum :");
        outputAS3.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println("");

        //AS4 > Sub-array with 0 sum
        ArrayList<Integer> inputAS4 = new ArrayList<Integer>(Arrays.asList(1, -1));
        Integer outputAS4 = subArrayWith0Sum(inputAS4);
        System.out.println("AS4 - Sub-array with 0 sum :" + outputAS4);

        //AS5 Shaggy and distances [OK-OK]
        ArrayList<Integer> inputAS5 = new ArrayList<>(Arrays.asList(7, 1, 3, 4, 1, 7));
        Integer outputAS5 = shaggyAndDistances(inputAS5);
        System.out.println("AS2 - Shaggy and distances :" + outputAS5);





        //HW1 > K Occurrences [NO-TRICK]
        ArrayList<Integer> inputHW1 = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3));
        Integer outputHW1 = kOccurrences(5, 2, inputHW1);
        System.out.println("HW1 - K Occurrences :" + outputHW1);

        //HW1 > Check Palindrome
        int outputHW2 =  possiblePalindrome("inttnikjmjbemrberk");
        System.out.println("HW2 - Check Palindrome :" + outputHW2);

        //HW3 > Colorful Number
        int outputHW3 = colorfulNumber(236);
        System.out.println("HW3 - Colorful Number :" + outputHW3);
    }

    /**
     * AS1 > Common Elements [NO TRICK]
     * Given two integer array A and B of size N and M respectively. Your task is to find all the common elements in both the array.
     * NOTE:
     * Each element in the result should appear as many times as it shows in both arrays. The result can be in any order.
     *  A = [1, 2, 2, 1] ; B = [2, 3, 1, 2] =>O/P [1, 2, 2]
     * @param A
     * @param B
     * @return
     */
    private ArrayList<Integer> commonElements(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> arrayBFrequency = new HashMap<>();
        for (int j = 0; j < B.size(); j++) {
            if (arrayBFrequency.containsKey(B.get(j))) {
                Integer currFreq = arrayBFrequency.get(B.get(j));
                arrayBFrequency.put(B.get(j), currFreq + 1);
            } else {
                arrayBFrequency.put(B.get(j), 1);
            }
        }
        for (int i = 0; i< A.size(); i++) {
            if (arrayBFrequency.containsKey(A.get(i)) && arrayBFrequency.get(A.get(i)) > 0) {
                result.add(A.get(i));
                Integer currFreq = arrayBFrequency.get(A.get(i));
                if (currFreq == 1) {
                    arrayBFrequency.remove(A.get(i));
                } else {
                    arrayBFrequency.put(A.get(i), currFreq -1);
                }
            }
        }
        return result;
    }

    /**
     * AS2 > First Repeating element [NO-TRICK]
     * Given an integer array A of size N, find the first repeating element in it.
     * We need to find the element that occurs more than once and whose index of first occurrence is smallest.
     * If there is no repeating element, return -1.
     * Example => A = [10, 5, 3, 4, 3, 5, 6] => o/p => 5
     * [6, 10, 5, 4, 9, 120] => o/p => -1
     * @param A
     * @return
     */
    private int firstRepeatingElement(ArrayList<Integer> A) {
        HashMap<Integer, Integer> arrayFreq = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            if (arrayFreq.containsKey(A.get(i))) {
                Integer currFreq = arrayFreq.get(A.get(i));
                arrayFreq.put(A.get(i), currFreq + 1);
            } else {
                arrayFreq.put(A.get(i), 1);
            }
        }
        for (int i = 0; i < A.size(); i++) {
            if (arrayFreq.get(A.get(i)) > 1) {
                return A.get(i);
            }
        }
        return -1;
    }

    /**
     * AS3 > Largest Continuous Sequence Zero Sum
     * Given an array A of N integers, find the largest continuous sequence in a array which sums to zero.
     * Return an array denoting the longest first continuous sequence with total sum of zero.
     * Example => A = [1,2,-2,4,-4] => o/p => [2,-2,4,-4]
     * @param A
     * @return
     */
//    private ArrayList<Integer> largestContinuousSequenceZeroSum(ArrayList<Integer> A) {
//        //1. Form prefix sum array
//        ArrayList<Integer> prefixSumArray = new ArrayList<>();
//        for (int i = 0; i < A.size(); i++) {
//            if (i == 0) {
//                prefixSumArray.add(A.get((i)));
//            } else {
//                prefixSumArray.add(A.get((i)) + prefixSumArray.get(i - 1));
//            }
//        }
//        //2. Collect indexes of same value from prefix sum array
//        //HashMap<Integer, ArrayList<Integer>> arrayIndexFrequencyHM = new HashMap<>();
//        //Approach 1 => Long logic
//        //        for (int i = 0; i < prefixSumArray.size(); i++) {
//        //            ArrayList<Integer> indexList;
//        //            if (!arrayIndexFrequencyHM.containsKey(prefixSumArray.get(i))) {
//        //                indexList = new ArrayList<>();
//        //            } else {
//        //                indexList = arrayIndexFrequencyHM.get(prefixSumArray.get(i));
//        //            }
//        //            indexList.add(i);
//        //            arrayIndexFrequencyHM.put(prefixSumArray.get(i), indexList);
//        //        }
//        //        int startIndex = -1;
//        //        int endIndex = -1;
//        //        int largestSize = Integer.MIN_VALUE;
//        //        for (Integer key : arrayIndexFrequencyHM.keySet()) {
//        //            if (arrayIndexFrequencyHM.get(key).size() > 1) {
//        //                //The 1st and last index in value of hashtable is the longest sequence
//        //                int currentEndIndex = arrayIndexFrequencyHM.get(key).get(arrayIndexFrequencyHM.get(key).size() - 1);
//        //                int currentStartIndex = arrayIndexFrequencyHM.get(key).get(0) + 1;
//        //                if ((currentEndIndex - currentStartIndex + 1) > largestSize) {
//        //                    endIndex = currentEndIndex;
//        //                    startIndex = currentStartIndex;
//        //                    largestSize = currentEndIndex - startIndex + 1;
//        //                }
//        //            }
//        //        }
//        //
//        //        for (int i = prefixSumArray.size() - 1; i >= 0; i--) {
//        //            if ((prefixSumArray.get(i) == 0) && (i + 1 > largestSize)) {
//        //                startIndex = 0;
//        //                endIndex = i;
//        //                largestSize = i + 1;
//        //            }
//        //        }
//        //
//        //        ArrayList<Integer> longest0SubArray = new ArrayList<>();
//        //        if (endIndex >= startIndex & startIndex!= -1) {
//        //            for (int i = startIndex; i <= endIndex; i++) {
//        //                longest0SubArray.add(A.get(i));
//        //            }
//        //        }
//        //        return longest0SubArray;
//
//        //-----------------------------------------------------------------------------------------------
//        //Approach 2 => TA logic
//
//        Integer sum = 0;
//        Integer startIndex = -2, endIndex = -3;
//        HashMap<Integer, Integer> sumFreq = new HashMap<>();
//        //sumFreq.put
//        for (int i = 0; i < A.size(); i++) {
//            sum = sum + A.get(0);
//            if (sumFreq.containsKey(sum)) {
//                int olderIndex = sumFreq.get(sum) + 1;
//                if (i - olderIndex > (endIndex - startIndex)) {
//                    endIndex = i;
//                    startIndex = olderIndex;
//                }
//            } else {
//                sumFreq.put(sum, i);
//            }
//        }
//
//        ArrayList<Integer> answer = new ArrayList<>();
//        if (startIndex == -2) {
//            return answer;
//        }
//        for (int i = startIndex; i <= endIndex; i++) {
//            answer.add(A.get(i));
//        }
//        return answer;
//    }

    private ArrayList<Integer> largestContinuousSequenceZeroSum(ArrayList<Integer> A) {
        ArrayList<Integer> prefixSum = new ArrayList<Integer>();
        Integer sum = 0;
        for (int i = 0; i < A.size(); i++) {
            sum = sum + A.get(i);
            prefixSum.add(sum);
        }

        HashMap<Integer, ArrayList<Integer>> prefixSumFreq = new HashMap<>();
        for (int i = 0; i < prefixSum.size(); i++) {
            if (prefixSumFreq.containsKey(prefixSum.get(i))) {
                ArrayList<Integer> thisKeyIndexList = prefixSumFreq.get(prefixSum.get(i));
                thisKeyIndexList.add(i);
                prefixSumFreq.put(prefixSum.get(i), thisKeyIndexList);
            } else {
                ArrayList<Integer> thisKeyIndexList = new ArrayList<Integer>();
                thisKeyIndexList.add(i);
                prefixSumFreq.put(prefixSum.get(i), thisKeyIndexList);
            }
        }

        int startIndex = -10;
        int endIndex = -11;
        int maxSize = -1;
        for (Integer key: prefixSumFreq.keySet()) {
            ArrayList<Integer> freqList = prefixSumFreq.get(key);
            if (freqList.size() > 1 && key != 0) {
                int currentStartIndex = freqList.get(0) + 1;
                int currentEndIndex = freqList.get(freqList.size() - 1);
                int currentNumberMaxLength = currentEndIndex - currentStartIndex;
                if (currentNumberMaxLength > maxSize) {
                    maxSize = currentNumberMaxLength;
                    startIndex = currentStartIndex;
                    endIndex = currentEndIndex;
                }
            }
            if (freqList.size() > 0 && key == 0) {
                int currentStartIndex = 0;
                int currentEndIndex = freqList.get(freqList.size() - 1);
                int currentNumberMaxLength = currentEndIndex - currentStartIndex;
                if (currentNumberMaxLength > maxSize) {
                    maxSize = currentNumberMaxLength;
                    startIndex = currentStartIndex;
                    endIndex = currentEndIndex;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        if (endIndex >= startIndex) {
            for (int i = startIndex; i <= endIndex; i++) {
                result.add(A.get(i));
            }
        }
        return result;

        // 0. 1.  2. 3
        // 1, 2, -3, 3
        // 1, 3,  0, 3

        // 0.   1.  2   4.  4.  5.   6.  7.  8.   9  10
        // 0, -10, 20,  3, 23, 10, -20,  2, 19, -29, 0
        // 0, -10, 10, 13, 36, 46,  26, 28, 47,  18, 18

        //0 : 0

    }

    /**
     * AS4 > Sub-array with 0 sum [Prefix sum + HashMap]
     * Array of integers A, return whether the given array contains a non-empty subarray with a sum equal to 0.
     * If the given array contains a sub-array with sum zero return 1 else return 0.
     * Example => A = [1, 2, 3, 4, 5] => o/p = 0 => No subarray has sum 0.
     * A = [-1, 1] => o/p = 1 => The array has sum 0.
     * @param A
     * @return
     */
    private int subArrayWith0Sum(ArrayList<Integer> A) {
        ArrayList<Long> B = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (i == 0) {
                B.add(Long.valueOf(A.get(i)));
            } else {
                B.add(Long.valueOf(A.get(i) + B.get(i-1)));
            }
        }
        HashMap<Long, Integer> arrayFrequency = new HashMap<>();
        for (int i = 0; i < B.size(); i++) {
            if (arrayFrequency.containsKey(B.get(i)) || B.get(i) == 0) {
                return 1;
            } else {
                arrayFrequency.put(B.get(i), 1);
            }
        }
        return 0;
    }

    /**
     * AS5 > Shaggy and distances [OK-OK]
     * Array of N elements. Find minimum distance between any distinct numbers.
     * Example => A = [7, 1, 3, 4, 1, 7] => O/P = 3 => Here we have 2 options:
     *      1. A[1] and A[4] are both 1 so (1,4) is a special pair and |1-4|=3.
     *      2. A[0] and A[5] are both 7 so (0,5) is a special pair and |0-5|=5.
     *      Therefore the minimum possible distance is 3.
     * @param A
     * @return
     */
    private int shaggyAndDistances(ArrayList<Integer> A) {
        HashMap<Integer, ArrayList<Integer>> arrayFrequencyTracking = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            ArrayList<Integer> positions;
            if (!arrayFrequencyTracking.containsKey(A.get(i))) {
                //Element not present
                positions = new ArrayList<>();
            } else {
                //Element already present
                positions = arrayFrequencyTracking.get(A.get(i));
            }
            positions.add(i);
            arrayFrequencyTracking.put(A.get(i), positions);
        }
        Integer minDistance = Integer.MAX_VALUE;
        for (Integer key : arrayFrequencyTracking.keySet()) {
            if (arrayFrequencyTracking.get(key).size() > 1) {
                for (int i = 0; i < arrayFrequencyTracking.get(key).size() - 1; i++) {
                    if (arrayFrequencyTracking.get(key).get(i + 1) - arrayFrequencyTracking.get(key).get(i) < minDistance) {
                        minDistance = arrayFrequencyTracking.get(key).get(i + 1) - arrayFrequencyTracking.get(key).get(i);
                    }
                }
            }
        }
        return minDistance != Integer.MAX_VALUE ? minDistance : -1;
    }




    /**
     * HW1 > K Occurrences [NO-TRICK]
     * @param A
     * @param B
     * @param C
     * @return
     */
    private int kOccurrences(int A, int B, ArrayList<Integer> C) {
        Integer kOccurrenceSum = 0;

        HashMap<Integer, Integer> frequencyHM = new HashMap<>();
        for (int i = 0; i < C.size(); i++) {
            if (frequencyHM.containsKey(C.get(i))) {
                Integer newFrequency = frequencyHM.get(C.get(i)) + 1;
                frequencyHM.put(C.get(i), newFrequency);
            } else {
                frequencyHM.put(C.get(i), 1);
            }
        }
        Boolean isFound = false;

        for (Integer key : frequencyHM.keySet()) {
            if (frequencyHM.get(key) == B) {
                kOccurrenceSum = kOccurrenceSum + key;
                isFound = true;
            }
        }
        return isFound ? kOccurrenceSum : -1;
    }

    /**
     * HW2 > Check Palindrome!
     * Given a string A consisting of lowercase characters. Check if characters of the given string can be rearranged to form a palindrome.
     * Return 1 or 0.
     * Example => A = "abbaee" => o/p = 1
     * A = "abcde" => o/p = 0
     * @param A
     * @return
     */
    private int possiblePalindrome(String A) {
        HashMap<Character, Integer> frequencyHM = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            if (frequencyHM.containsKey(A.charAt(i))) {
                Integer currentFreq = frequencyHM.get(A.charAt(i));
                frequencyHM.put(A.charAt(i), currentFreq + 1);
            } else {
                frequencyHM.put(A.charAt(i), 1);
            }
        }
        Integer oddCount = 0;
        for (Character ch : frequencyHM.keySet()) {
            if (frequencyHM.get(ch) % 2 != 0) {
                oddCount ++;
            }
        }
        return oddCount == 0 || oddCount == 1 ? 1 : 0;
    }

    /**
     * HW3 > Colorful Number
     * Given Number A find if its COLORFUL number or not. If number A is a COLORFUL number return 1 else return 0.
     * A number can be broken into different contiguous sub-subsequence parts.
     * Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
     * And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different.
     * Example => A = 236 => Output =>
     * Possible Sub-sequences: [2, 3, 6, 23, 36, 236] where
     *  2 -> 2
     *  3 -> 3
     *  6 -> 6
     *  23 -> 6  (product of digits)
     *  36 -> 18  (product of digits)
     *  236 -> 36  (product of digits)
     *  This number is not a COLORFUL number since the product sequence 23  and sequence 6 is same.
     * @param A
     * @return
     */
    private int colorfulNumber(int A) {
        Integer newA = A;
        String numberString = newA.toString();
        HashMap<Integer, Integer> sumFrequency = new HashMap<Integer, Integer>();
        int isColourful = 1;

        for (int i = 0 ; i < numberString.length(); i++) {
            for (int j = i; j < numberString.length(); j++) {
                Integer sum = 1;
                for (int k = i; k <= j; k++) {
                    sum = sum * Integer.parseInt(String.valueOf(numberString.charAt(k)));
                }
                if (sumFrequency.containsKey(sum)) {
                    isColourful = 0;
                } else {
                    sumFrequency.put(sum, 1);
                }
            }
        }
        return isColourful;


        // 2369
        // 0 - 3 : 0
        // 0-3. [2, 23, 236, 2369]
        // 0 - 3 : 1
        // 1-3. [3, 36, 369]
        // 0 - 3 : 2
        // 2-3. [6, 69]

        // 0 - 3 : 3
        // 3-3. [9]
    }
}
