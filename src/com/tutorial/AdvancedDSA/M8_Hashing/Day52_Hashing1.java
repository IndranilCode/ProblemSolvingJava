package com.tutorial.AdvancedDSA.M8_Hashing;

import java.util.*;

public class Day52_Hashing1 {
    public void execute() {
        System.out.println("--------------HASHING 1---------------");
        System.out.println("------------ASSIGNMENTS------------------");

        //AS1 > Longest Consecutive Sequence
        ArrayList<Integer> inputAS1 = new ArrayList<>(Arrays.asList(100, 4, 200, 1, 3, 2));
        System.out.println("AS1 > Longest Consecutive Sequence [100, 4, 200, 1, 3, 2] => " + this.longestConsecutiveSequenceOfNumbers(inputAS1));

        //AS2 > Shaggy and distances
        ArrayList<Integer> inputAS2 = new ArrayList<>(Arrays.asList(7, 1, 3, 4, 1, 7, 7));
        System.out.println("AS2 > Shaggy and distances [7, 1, 3, 4, 1, 7, 7] => " + this.shaggyAndDistances(inputAS2));

        //AS3 > Sub-array with 0 sum
        ArrayList<Integer> inputAS23a= new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("AS3 > Sub-array with 0 sum [1, 2, 3, 4, 5] => " + this.subarrayWith0Sum(inputAS23a));
        ArrayList<Integer> inputAS23b= new ArrayList<>(Arrays.asList(1, 2, 3, -2, -3, 5));
        System.out.println("    > Sub-array with 0 sum [1, 2, 3, -2, -3, 5] => " + this.subarrayWith0Sum(inputAS23b));

        //AS4 > Largest Continuous Sequence Zero Sum
        ArrayList<Integer> inputAS4a = new ArrayList<>(Arrays.asList(1, 2, -2, 4, -4));
        ArrayList<Integer> resultAS4a = this.largestContinuousSequence0Sum(inputAS4a);
        System.out.print("AS4 > Largest Continuous Sequence Zero Sum [1, 2, -2, 4, -4] => [");
        resultAS4a.forEach(e -> System.out.print(e + ", "));
        System.out.println("]");

        ArrayList<Integer> inputAS4b = new ArrayList<>(Arrays.asList(1, 2, -2, 4, -4, -1, 6));
        ArrayList<Integer> resultAS4b = this.largestContinuousSequence0Sum(inputAS4b);
        System.out.print("    > Largest Continuous Sequence Zero Sum [1, 2, -2, 4, -4, -1, 6] => [");
        resultAS4b.forEach(e -> System.out.print(e + ", "));
        System.out.println("]");

        ArrayList<Integer> inputAS4c = new ArrayList<>(Arrays.asList(1, 2, 3 -2, 4, -4, -1, 6, 5, -5, 4, -4, 3, -3, 2, -2, -6));
        ArrayList<Integer> resultAS4c = this.largestContinuousSequence0Sum(inputAS4c);
        System.out.print("    > Largest Continuous Sequence Zero Sum [1, 2, 3, -2, 4, -4, -1, 6, 5, -5, 4, -4, 3, -3, 2, -2, -6] => [");
        resultAS4c.forEach(e -> System.out.print(e + ", "));
        System.out.println("]");
    }

    /**
     * AS1 > Longest Consecutive Sequence
     * Given an unsorted integer array A of size N. Find the length of the longest set of consecutive elements from array A.
     * @param A
     * @return
     */
    private int longestConsecutiveSequenceOfNumbers(List<Integer> A) {
        //O(n) approach
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < A.size(); i++) {
            numbers.add(A.get(i));
        }

        int currentNumber, nextNumber;
        int maxCount = 0, runningCount = 0;

        for (int no : numbers) {
            currentNumber = no;
            if (!numbers.contains(currentNumber-1)) {
                //Starting number of a consecutive sequence found (count current number as runningCount = 1)
                runningCount = 1;
                nextNumber = currentNumber + 1; //Build next number and continue searching for next number
                while (numbers.contains(nextNumber)) {
                    runningCount = runningCount + 1;
                    nextNumber = nextNumber + 1;
                }
                if (runningCount > maxCount) {
                    maxCount = runningCount;
                }
                runningCount = 0;
            } else {
                continue;
            }
        }
        return maxCount;
    }

    /**
     * AS2 > Shaggy and distances
     * Array A consisting of N elements. We call a pair of distinct indices in that array a special if elements at those indices in the array are equal.
     * Find a special pair such that the distance between that pair is minimum. Distance between two indices is defined as |i-j|. If there is no special pair in the array, then return -1.
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

    /**
     * AS3 > Sub-array with 0 sum
     * Array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
     * If the given array contains a sub-array with sum zero return 1, else return 0
     * @param A
     * @return
     */
    private int subarrayWith0Sum(ArrayList<Integer> A) {
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
     * AS4 > Largest Continuous Sequence Zero Sum
     * Given an array A of N integers. Find the largest continuous sequence in a array which sums to zero.
     * @param A
     * @return
     */
    private ArrayList<Integer> largestContinuousSequence0Sum(ArrayList<Integer> A) {
        ArrayList<Integer> longestContinuousSequenceResult = new ArrayList<>();
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
                longestContinuousSequenceResult.add(A.get(i));
            }
        }
        return longestContinuousSequenceResult;
    }
}
