package main.tutorial.IntermediateDSA.M_SubsequenceAndSubsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Day29_35_SubsequencesAndSubsets {
    ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();

    public void execute() {
        System.out.println("----------Day 29(35) Intermediate: Subsequence & Subsets---------------");
        System.out.println("---------------------------------ASSIGNMENT----------------------------");

        //AS3 > Subset (Non recursion)
        ArrayList<Integer> inputAS3 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<ArrayList<Integer>> resultAS3_1 = this.allSubsets_NonRecursion(inputAS3);
        System.out.print("AS3 > Subset (Non recursion) [1, 2, 3] => [ ");
        resultAS3_1.forEach(e -> {
            System.out.print("[");
            e.forEach(g -> System.out.print(g + ","));
            System.out.print("]");
        });
        System.out.println(" ]");

        ArrayList<ArrayList<Integer>> resultAS3_2 = this.allSubsets_recursion(inputAS3);
        System.out.print("AS3 > Subset (Recursion) [1, 2, 3] => [ ");
        resultAS3_2.forEach(e -> {
            System.out.print("[");
            e.forEach(g -> System.out.print(g + ","));
            System.out.print("]");
        });
        System.out.println(" ]");

        System.out.println("---------------------------------HOMEWORK------------------------------");

        //HW1 > Sum the Difference
        ArrayList<Integer> inputHW1 = new ArrayList<>(Arrays.asList(3, -4, 1));
        System.out.println("HW1 > Sum the Difference (Contribution technique) [3, -4, 1] => " + this.sumTheDifference_allSubArraysMaxMin(inputHW1));

        //HW3 > Find subsequence
        System.out.println("HW3 > Find subsequence ; MainString = dfbkjijgbbiihbmmt, SmallString = bit => " + this.isSubsequence("bit", "dfbkjijgbbiihbmmt"));
        System.out.println("    > Find subsequence ; MainString = dfbkjijgbbiihbmmt, SmallString = bits => " + this.isSubsequence("bits", "dfbkjijgbbiihbmmt"));
        System.out.println("    > Find subsequence ; MainString = dfbkjijgstbbiihbmmt, SmallString = bits => " + this.isSubsequence("bits", "dfbkjijgstbbiihbmmt"));

        //HW4 > Subsequence-Sum Problem
        ArrayList<Integer> inputHW4_1 = new ArrayList<>(Arrays.asList(1, 20, 13, 4, 5));
        System.out.println("HW4 > Subsequence-Sum Problem [1, 20, 13, 4, 5] Sum = 18 => " + this.subsequenceSumMatch(inputHW4_1, 18));

        //HW5 > Odd Even Subsequences
        ArrayList<Integer> inputHW5_1 = new ArrayList<>(Arrays.asList(1, 2, 2, 5, 6));
        System.out.println("HW5 > Odd Even Subsequences [1, 2, 2, 5, 6] Max length => " + this.oddEvenSubsequenceLength(inputHW5_1));
    }

    /*---------------ASSIGNMENT--------------*/

    /**
     * AS3 > Subset (Non recursion)
     * Given a set of distinct integers A, return all possible subsets.
     * @param A
     * @return
     */
    private ArrayList<ArrayList<Integer>> allSubsets_NonRecursion(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();

        int numberOfCombinations = 1 << A.size();
        for (int i = 0; i < numberOfCombinations; i++) {
            ArrayList<Integer> eachCombination = new ArrayList<>();
            //Find the bits set in current number (i)
            for (int j = 0; j < A.size(); j++) {
                //Right shift i each time (j times - no of array items) & check if that bit is set - if set then include jth bit
                if (((i >> j) & 1) == 1) {
                    eachCombination.add(A.get(j));
                }
            }
            allSubsets.add(eachCombination);
        }
        return allSubsets;
    }

    private ArrayList<ArrayList<Integer>> allSubsets_recursion(ArrayList<Integer> A) {
        this.generateSubset(new ArrayList<>(), A);
        return allSubsets;
    }

    private void generateSubset(ArrayList<Integer> selection, ArrayList<Integer> residue) {
        if (residue.size() == 0) {
            ArrayList<Integer> selectedSelections = new ArrayList<>();
            for (int i : selection) {
                selectedSelections.add(i);
            }

            allSubsets.add(selectedSelections);
            return;
        }

        Integer currentElementToAdd = residue.get(0);
        //Remove 0th element from residue
        residue.remove(0);

        //2 Choices - select / not select
        //a> Don't add currentElementToAdd to selection
        this.generateSubset(selection, residue);

        //b> Add currentElementToAdd to selection
        selection.add(currentElementToAdd);
        this.generateSubset(selection, residue);
    }

    /*---------------HOMEWORK----------------*/

    /**
     * HW1 > Sum the Difference
     * Given an integer array, A of size N.
     * Find all possible non-empty subsequences, for each subsequence, find difference between the largest and smallest numbers in that subsequence.
     * Then add up all the differences to get the number.
     * As the number may be large, output the number modulo 1e9 + 7 (1000000007).
     * NOTE: Subsequence can be non-contiguous.
     * @param A
     * @return
     */
    private int sumTheDifference_allSubArraysMaxMin(ArrayList<Integer> A) {
        Collections.sort(A, Collections.reverseOrder());
        int mod = 1000000007;
        int n = A.size() - 1;
        long maxSum = 0;
        long minSum = 0;

        //NOTE: 2 << (n-1) % mod => give issues - only smaller multiplications % mod works fine
        for (int i = 0; i <= n; i++) {
            // maxSum = maxSum + (1 << (n - i)) * A.get(i);
            // minSum = minSum + (1 << i) * A.get(i);
            maxSum = (maxSum << 1) % mod;
            maxSum = (maxSum + A.get(i)) % mod;

            // maxSum = maxSum + (((1 << (n - i)) % mod) * A.get(i)) % mod;
            // minSum = minSum + (((1 << i) % mod) * A.get(i)) % mod;
        }
        for (int i = n; i >= 0; i--) {
            minSum = (minSum << 1) % mod;
            minSum = (minSum + A.get(i)) % mod;
        }

        long ans = (maxSum - minSum + mod) % mod;
        // int modAns = (int)(ans % mod);
        // return modAns < 0 ? (modAns + mod) : modAns;
        return (int)ans;
    }

    /**
     * HW2 > Special Subsequences "AG"
     * You have given a string A having Uppercase English letters.
     * You have to find how many times subsequence "AG" is there in the given string.
     * NOTE: Return the answer modulo 109 + 7 as the answer can be very large.
     * @param wholeString
     * @return
     */
    private int specialSequenceAG(String wholeString) {
        long totalAGCount = 0;
        int gCounter = 0;
        int mod = 1000000007;
        for (int i = wholeString.length()-1; i >= 0; i--) {
            Character currentChar = wholeString.charAt(i);
            if (currentChar.equals('G')) {
                gCounter++;
            } else if (currentChar.equals('A')) {
                totalAGCount = totalAGCount + gCounter;
            }
        }
        int result = (int)(totalAGCount % mod);
        return result < 0 ? result + mod : result;
    }

    /**
     * HW3 > Find subsequence
     * Given two strings A and B, find if A is a subsequence of B.
     * Return "YES" if A is a subsequence of B, else return "NO".
     * @param largeString
     * @param smallString
     * @return
     */
    private String isSubsequence(String smallString, String largeString) {
        int currentFoundIndex = 0;
        for (int i = 0; i < smallString.length(); i++) {
            Character currentChar = smallString.charAt(i);
            while (currentFoundIndex < largeString.length() && largeString.charAt(currentFoundIndex) != currentChar) {
                currentFoundIndex++;
            }
            if (currentFoundIndex >= largeString.length()) {
                return "NO";
            }
        }
        return "YES";
    }

    /**
     * HW4 > Subsequence-Sum Problem
     * You are given an array of integers of N size.
     * You have to find that there is any subsequence exists or not whose sum is equal to B.
     * @param A
     * @param givenSum
     * @return
     */
    private int subsequenceSumMatch(ArrayList<Integer> A, int givenSum) {
        int totalCombinations = 2 << A.size();
        for (int i = 0; i < totalCombinations; i++) {
            int currentCombinationTotal = 0;
            for (int j = 0; j < A.size(); j++) {
                //Right shift i each time (j times - no of array items) & check if that bit is set - if set then include jth bit
                if (((i >> j) & 1) == 1) {
                    currentCombinationTotal = currentCombinationTotal + A.get(j);
                }
            }
            if (currentCombinationTotal == givenSum) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * HW5 > Odd Even Subsequences
     * Given an array of integers A of size, N. Find the longest subsequence of A, which is odd-even.
     * @param A
     * @return
     */
    private int oddEvenSubsequenceLength(ArrayList<Integer> A) {
        Boolean isEven = (A.get(0) % 2) == 0; //1st number - is it even OR not
        int evenOddLength = 1; //Consider that number
        Boolean isFindEven = !isEven; //Look opposite of it
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) % 2 != 0 && !isFindEven) {
                //CurrentNo odd + intended in odd => count 1 length ; look for even now
                evenOddLength++;
                //Next look for even
                isFindEven = !isFindEven;
            } else if (A.get(i) % 2 == 0 && isFindEven){
                //CurrentNo even + intended is even => count 1 length ; look for odd now
                evenOddLength++;
                isFindEven = !isFindEven;
            }
        }
        return evenOddLength;
    }
}
