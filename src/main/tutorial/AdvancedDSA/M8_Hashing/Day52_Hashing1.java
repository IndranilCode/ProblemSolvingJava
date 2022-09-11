package main.tutorial.AdvancedDSA.M8_Hashing;

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

        ArrayList<Integer> inputAS4c = new ArrayList<>(Arrays.asList(1, 2, 3, -2, 4, -4, -1, 6, 5, -5, 4, -4, 3, -3, 2, -2, -6));
        ArrayList<Integer> resultAS4c = this.largestContinuousSequence0Sum(inputAS4c);
        System.out.print("    > Largest Continuous Sequence Zero Sum [1, 2, 3, -2, 4, -4, -1, 6, 5, -5, 4, -4, 3, -3, 2, -2, -6] => [");
        resultAS4c.forEach(e -> System.out.print(e + ", "));
        System.out.println("]");

        //AS5 > Distinct Numbers in Window (BRUTE FORCE)
        ArrayList<Integer> inputAS5a = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 3));
        ArrayList<Integer> resultAS5a = this.distinctNumberInWindow_BruteForce(inputAS5a, 3);
        System.out.print("AS5 > Distinct Numbers in Window (Brute Force) [1, 2, 1, 3, 4, 3] => [");
        resultAS5a.forEach(e -> System.out.print(e + ", "));
        System.out.println("]");

        //AS5 > Distinct Numbers in Window (SLIDING WINDOW)
        ArrayList<Integer> inputAS5_1 = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 3));
        ArrayList<Integer> resultAS5_1 = this.distinctNumberInWindow_SlidingWindow(inputAS5_1, 3);
        System.out.print("AS5.1 > Distinct Numbers in Window (Sliding Window) [1, 2, 1, 3, 4, 3] => [");
        resultAS5_1.forEach(e -> System.out.print(e + ", "));
        System.out.println("]");

        System.out.println("------------HOMEWORK------------------");

        //AS1 > Sort Array in given Order
        ArrayList<Integer> inputHW1_a = new ArrayList<>(Arrays.asList(12, 7));
        ArrayList<Integer> inputHW1_b = new ArrayList<>(Arrays.asList(7, 1, 6, 17, 2, 19, 10));
        ArrayList<Integer> resultHW1 = this.sortArrayInGivenOrder(inputHW1_a, inputHW1_b);
        System.out.print("AS1 > Sort Array in given Order [12, 7] , [7, 1, 6, 17, 2, 19, 10]  => [");
        resultHW1.forEach(e -> System.out.print(e + ", "));
        System.out.println("]");

        //AS2 >
        this.isColourfulNumber(5034);

        //AS3 > Check Palindrome - II
        System.out.println("AS3 > Check Possible Palindrome - II  => " + this.checkPalindrome2("madam"));
        System.out.println("    > Check Possible Palindrome - II  => " + this.checkPalindrome2("mamayalal"));
        System.out.println("    > Check Possible Palindrome - II  => " + this.checkPalindrome2("lamymalaya"));
        System.out.println("    > Check Possible Palindrome - II  => " + this.checkPalindrome2("maddammd"));
//
//        colourfulNumber(2345);
    }

    /*------------ASSIGNMENTS------------*/

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

    /**
     * AS5 > Distinct Numbers in Window (BRUTE FORCE)
     * Return the of count of distinct numbers in all windows of size B.
     * @param A
     * @param B
     * @return
     */
    private ArrayList<Integer> distinctNumberInWindow_BruteForce(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        Set<Integer> uniqueContainer;
        int end = A.size() - B + 1;
        for (int i = 0; i < end; i++) {
            uniqueContainer = new HashSet<>();
            for (int j = i; j < (i + B); j++) {
                uniqueContainer.add(A.get(j));
            }
            result.add(uniqueContainer.size());
        }
        return result;
    }

    /**
     * AS5.1 > Distinct Numbers in Window (SLIDING WINDOW)
     * @param A
     * @param B
     * @return
     */
    private ArrayList<Integer> distinctNumberInWindow_SlidingWindow(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> frequencyInsideWindow = new HashMap<>();
        int currentNumber, currentFreq;

        //Build the 1st window and add the frequency
        for (int i = 0; i < B; i++) {
            currentNumber = A.get(i);
            if (frequencyInsideWindow.containsKey(currentNumber)) {
                currentFreq = frequencyInsideWindow.get(currentNumber);
                frequencyInsideWindow.put(currentNumber, ++currentFreq);
            } else {
                frequencyInsideWindow.put(currentNumber, 1);
            }
        }
        result.add(frequencyInsideWindow.size());
        int numberToRemove, removalNumberFreq;

        for (int i = B; i < A.size(); i++) {
            //To window => Add the current number & remove the 1st from older window
            currentNumber = A.get(i);
            //Add the new number to window
            if (frequencyInsideWindow.containsKey(currentNumber)) {
                currentFreq = frequencyInsideWindow.get(currentNumber);
                frequencyInsideWindow.put(currentNumber, ++currentFreq);
            } else {
                frequencyInsideWindow.put(currentNumber, 1);
            }
            //Remove older number from window
            numberToRemove = A.get(i - B);
            removalNumberFreq = frequencyInsideWindow.get(numberToRemove);
            if (removalNumberFreq == 1) {
                frequencyInsideWindow.remove(numberToRemove);
            } else {
                frequencyInsideWindow.put(numberToRemove, --removalNumberFreq);
            }
            //Add unique size to result
            result.add(frequencyInsideWindow.size());
        }
        return result;
    }

    /*------------HOMEWORK------------*/

    /**
     * AS1 > Sort Array in given Order
     * Given two arrays of integers A and B, Sort A in such a way that the relative order among the elements will be the same as those are in B.
     * For the elements not present in B, append them at last in sorted order.
     * Return the array A after sorting from the above method.NOTE: Elements of B are unique.
     * @param A
     * @param B
     * @return
     */
    private ArrayList<Integer> sortArrayInGivenOrder(ArrayList<Integer> A, ArrayList<Integer> B) {
        SortedMap<Integer, Integer> sortedMapFreq = new TreeMap<>();
        int currentNumber, currentFreq;
        for (int i = 0; i < A.size(); i++) {
            currentNumber = A.get(i);
            if (sortedMapFreq.containsKey(currentNumber)) {
                currentFreq = sortedMapFreq.get(currentNumber);
                sortedMapFreq.put(currentNumber, ++currentFreq);
            } else {
                sortedMapFreq.put(currentNumber, 1);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            currentNumber = B.get(i);
            if (sortedMapFreq.containsKey(currentNumber)) {
                currentFreq = sortedMapFreq.get(currentNumber);
                for (int j = 0; j < currentFreq; j++) {
                    result.add(currentNumber);
                }
                sortedMapFreq.remove(currentNumber);
            }
        }
        for (Map.Entry<Integer, Integer> eachEntry : sortedMapFreq.entrySet()) {
            currentNumber = eachEntry.getKey();
            currentFreq = eachEntry.getValue();
            for (int j = 0; j < currentFreq; j++) {
                result.add(currentNumber);
            }
        }
        return result;
    }

//    private int colourfulNumber(int A) {
//        Map<Long, Integer> productFreq = new HashMap<>();
//        long product = numberProducts(A);
//        productFreq.put(product, 1);
//
//
//
//
//        System.out.println(product);return 1;
//    }
//    private int numberProducts(int a, Map<Long, Integer> productFreq) {
//        if (a < 10) return a;
//        return (a % 10) * numberProducts(a / 10);
//    }

    private int isColourfulNumber(int A) {
        String str = (A + "");
        ArrayList<Integer> brokenNumber = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            brokenNumber.add(Integer.parseInt(str.charAt(i) + ""));
        }

        for (int i = 0; i < brokenNumber.size(); i++) {

        }
        return 0;
    }

    /**
     * AS3 > Check Possible Palindrome - II
     * Given a string A consisting of lowercase characters.
     * Check if characters of the given string can be rearranged to form a palindrome.
     * Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0
     * @param A
     * @return
     */
    private int checkPalindrome2(String A) {
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
}
