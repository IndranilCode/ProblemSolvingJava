package com.tutorial.IntermediateDSA.M5_Hashing2;

import java.util.*;

public class Day21_Hashing1 {
    public void execute() {
        System.out.println("------------ Day21 Hashing 1-----------------");
        System.out.println("----------------ASSIGNMENT-------------------");

        //AS1 > Common Elements
        ArrayList<Integer> inputAS1_A = new ArrayList<>(Arrays.asList(1, 2, 2, 1));
        ArrayList<Integer> inputAS1_B = new ArrayList<>(Arrays.asList(2, 3, 1, 2));
        List<Integer> resultAS1 = this.findCommonElements(inputAS1_A, inputAS1_B);
        System.out.print("AS1 > Common Elements A=[1, 2, 2, 1] ; B=[2, 3, 1, 2] => [ ");
        resultAS1.forEach(e -> System.out.print(e.toString() + ", "));
        System.out.println(" ]");

        //AS2 > First Repeating element
        ArrayList<Integer> inputAS2 = new ArrayList<>(Arrays.asList(10, 5, 3, 4, 3, 5, 6));
        System.out.println("AS2 > First Repeating element [10, 5, 3, 4, 3, 5, 6] => " + this.firstRepeatingElement(inputAS2));
        ArrayList<Integer> inputAS2_2 = new ArrayList<>(Arrays.asList(6, 10, 5, 4, 9, 120));
        System.out.println("    > First Repeating element [6, 10, 5, 4, 9, 120] => " + this.firstRepeatingElement(inputAS2_2));

        //AS3 > Largest Continuous Sequence Zero Sum
        ArrayList<Integer> inputAS3 = new ArrayList<>(Arrays.asList(1, 2, -2, 4, -4, 9));
        System.out.print("AS3 > Largest Continuous Sequence Zero Sum [1, 2, -2, 4, -4, 9] => [ ");
        ArrayList<Integer> resultAS3 = this.largestContinuousZero_subArray(inputAS3);
        resultAS3.forEach(e -> System.out.print(e.toString() + ", "));
        System.out.println(" ]");

        //AS4 > Sub-array with 0 sum
        ArrayList<Integer> inputAS4 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("AS4 > Sub-array with 0 sum [1, 2, 3, 4, 5] => " + this.isSubArray_With0Sum(inputAS4));
        ArrayList<Integer> inputAS4_2 = new ArrayList<>(Arrays.asList(-1, 1));
        System.out.println("    > Sub-array with 0 sum [-1, 1] => " + this.isSubArray_With0Sum(inputAS4_2));

        //AS5 > Shaggy and distances
        ArrayList<Integer> inputAS5 = new ArrayList<>(Arrays.asList(7, 1, 3, 4, 1, 7));
        System.out.println("AS5 > Shaggy and distances [7, 1, 3, 4, 1, 7] => " + this.shaggyAndDistances(inputAS5));

        System.out.println("-----------------HOMEWORK--------------------");

        //HW1 > K Occurrences
        int inputHW1_N = 5;
        int inputHW1_K = 2;
        ArrayList<Integer> inputHW1 = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3));
        System.out.println("HW1 > K Occurrences N = 5, K = 5, C = [1, 2, 2, 3, 3] => " + this.kOccurrences_getSum(inputHW1_N, inputHW1_K, inputHW1));

        //HW2 > Check Palindrome - II
        System.out.println("HW2 > Check Palindrome - II (abcde) => " + this.checkIsPalindromePossible("abcde"));
        System.out.println("    > Check Palindrome - II (abbaee) => " + this.checkIsPalindromePossible("abbaee"));

        //HW3 > Colorful Number
        System.out.println("HW3 > Colorful Number (236) => " + this.isColourfulNumber(236));
        System.out.println("    > Colorful Number (23) => " + this.isColourfulNumber(23));

        System.out.println("---------------------------------------------");
    }

    //---------------ASSIGNMENT-------------------

    /**
     * AS1 > Common Elements
     * Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.
     * A = [1, 2, 2, 1]
     * B = [2, 3, 1, 2]
     * O/P => [1, 2, 2]
     * @param A
     * @param B
     * @return
     */
    private ArrayList<Integer> findCommonElements(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer, Integer> bFreqMap = new HashMap<>();
        //Create B's freq map
        int currentElement;
        for (int i = 0; i < B.size(); i++) {
            currentElement = B.get(i);
            bFreqMap.put(currentElement, bFreqMap.containsKey(currentElement) ? (bFreqMap.get(currentElement) + 1) : 1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        int newFreq;
        //Parse through A - consult bFreqMap and
        for (int i = 0; i < A.size(); i++) {
            currentElement = A.get(i);
            if (bFreqMap.containsKey(currentElement)) {
                //Add the existing element to result
                result.add(currentElement);
                //Modify the bFreqMap to reduce/remove the considered element
                newFreq = bFreqMap.get(currentElement) - 1;
                if (newFreq == 0) {
                    bFreqMap.remove(currentElement);
                } else {
                    bFreqMap.put(currentElement, newFreq);
                }
            }
        }
        return result;
    }

    /**
     * AS2 > First Repeating element
     * Given an integer array A of size N, find the first repeating element in it.
     * We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.
     * If there is no repeating element, return -1.
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
     * A = [1,2,-2,4,-4] => o/p : [2,-2,4,-4]
     * @param A
     * @return
     */
    private ArrayList<Integer> largestContinuousZero_subArray(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> prefixSumFirstOccurrenceEntries = new HashMap<>();
        int startIndex = 0;
        int endIndex = -1;
        int largestLength = 0;
        int runningSum = 0;
        int firstOccurrenceIndexOfCurrentSum;
        for (int i = 0; i < A.size(); i++) {
            runningSum = runningSum + A.get(i);

            //Prefix sum at some index = 0 => means subaaray is there with 0 sum. Calculate length and if larger than existing result add it.
            if (runningSum == 0) {
                //Seq from 0 - i is sum = 0, check length, if larger than recorded length - replace it.
                if (i + 1 > largestLength) {
                    startIndex = 0;
                    endIndex = i;
                    largestLength = i + 1;
                }
                continue;
            }

            //Check if the same runningSum was accompanied earlier (1st index is always maintained) then calculate length and update start end index
            if (prefixSumFirstOccurrenceEntries.containsKey(runningSum)) {
                firstOccurrenceIndexOfCurrentSum = prefixSumFirstOccurrenceEntries.get(runningSum);
                //Check length from first occurring index
                if ((i - firstOccurrenceIndexOfCurrentSum) > largestLength) {
                    startIndex = firstOccurrenceIndexOfCurrentSum + 1;
                    endIndex = i;
                    largestLength = i - firstOccurrenceIndexOfCurrentSum;
                }
            } else {
                //runningSum seen 1st time - enter into map
                prefixSumFirstOccurrenceEntries.put(runningSum, i);
            }
        }

        //Build the longestContinuousSequenceResult from 1st & end index
        if (endIndex >= startIndex) {
            for (int i = startIndex; i <= endIndex; i++) {
                result.add(A.get(i));
            }
        }

        return result;
    }

    /**
     * AS4 > Sub-array with 0 sum
     * Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
     * If the given array contains a sub-array with sum zero return 1, else return 0.
     * @param A
     * @return
     */
    private int isSubArray_With0Sum(ArrayList<Integer> A) {
        //Single iteration => find prefix sum ; if 0 then YES, else if same PS Value earlier then YES
        Set<Long> prefixSumEntries = new HashSet<>();
        Long runningSum = 0L;
        for (int i = 0; i < A.size(); i++) {
            runningSum = runningSum + A.get(i);
            if (runningSum == 0) return 1; //Prefix sum at some index = 0 => means subaaray is there with 0 sum
            if (prefixSumEntries.contains(runningSum)) { //Some older index prefix sum == runningSum => means that place to here is subarray sum 0
                return 1;
            } else {
                prefixSumEntries.add(runningSum);
            }
        }
        return 0;
    }

    /**
     * AS5 > Shaggy and distances
     * A = [7, 1, 3, 4, 1, 7]
     * Here we have 2 options:
     * 1. A[1] and A[4] are both 1 so (1,4) is a special pair and |1-4|=3.
     * 2. A[0] and A[5] are both 7 so (0,5) is a special pair and |0-5|=5.
     * So the minimum possible distance is 3.
     * @param A
     * @return
     */
    private int shaggyAndDistances(ArrayList<Integer> A) {
        Map<Integer, ArrayList<Integer>> elementAndIndexMap = new HashMap<>();
        int leastDistance = Integer.MAX_VALUE;
        int currentNumber, currentDistance;
        ArrayList<Integer> existingIndexList;
        int indexListSize;

        //Build map of numbers and their 2 closest
        for (int i = 0; i < A.size(); i++) {
            currentNumber = A.get(i);
            if (elementAndIndexMap.containsKey(currentNumber)) {
                //Previous entry with index is present
                existingIndexList = elementAndIndexMap.get(currentNumber);
                indexListSize = existingIndexList.size();
                currentDistance = i - existingIndexList.get(indexListSize - 1); //Current distance = current index - last index
                if (currentDistance < leastDistance) {
                    leastDistance = currentDistance;
                }
                //Add the current found index to consult with further occurrences
                existingIndexList.add(i);
                elementAndIndexMap.replace(currentNumber, existingIndexList);
            } else {
                //New element to be added
                elementAndIndexMap.put(currentNumber, new ArrayList<>(Arrays.asList(i)));
            }
        }
        return leastDistance == Integer.MAX_VALUE ? -1 : leastDistance;
    }

    //-----------------HOMEWORK-------------------

    /**
     * HW1 > K Occurrences
     * @param A
     * @param B
     * @param C
     * @return
     */
    private int kOccurrences_getSum(int A, int B, ArrayList<Integer> C) {
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
     * HW2 > Check Palindrome - II
     * @param A
     * @return
     */
    private int checkIsPalindromePossible(String A) {
        Map<Character, Integer> letterFrequency = new HashMap<>();
        Character currentChar;
        Integer freq;
        for (int i = 0; i < A.length(); i++) {
            currentChar = A.charAt(i);
            if (letterFrequency.containsKey(currentChar)) {
                freq = letterFrequency.get(currentChar);
                letterFrequency.put(currentChar, ++freq);
            } else {
                letterFrequency.put(currentChar, 1);
            }
        }

        int result = 1;
        int oddSet = 0;

        for (Integer eachFreq: letterFrequency.values()) {
            if ((eachFreq % 2) == 1) {
                //Odd
                oddSet++;
                if (oddSet > 1) {
                    result = 0;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * HW3 > Colorful Number
     * Given a number A, find if it is COLORFUL number or not. 1 or 0
     * A = 236 => [2, 3, 6, 23, 36, 236] =>
     * 2 -> 2
     *  3 -> 3
     *  6 -> 6
     *  23 -> 6  (product of digits)
     *  36 -> 18  (product of digits)
     *  236 -> 36  (product of digits)
     *  This number is not a COLORFUL number since the product sequence 23  and sequence 6 is same.
     * @param A
     * @return
     */
    private int isColourfulNumber(int A) {
        HashSet<Integer> hashSet = new HashSet<>();
        ArrayList<Integer> numbers = new ArrayList<>(); // 236 => 6, 3, 2
        while (A != 0) {
            int num = A % 10;
            numbers.add(num);
            A /= 10;
        }

        int n = numbers.size();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int prod = 1;
                for (int k = i; k <= j; k++) {
                    prod *= numbers.get(k);
                }
                if (hashSet.contains(prod))
                    return 0;
                hashSet.add(prod);
            }
        }
        return 1;
    }
}
