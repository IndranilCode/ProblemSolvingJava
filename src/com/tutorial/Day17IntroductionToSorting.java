package com.tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Day17IntroductionToSorting {
    public void executeIntroductionToSorting() {
        //AS1 > Arithmetic Progression
        ArrayList<Integer> inputAS1 = new ArrayList<Integer>(Arrays.asList(3, 5, 1, 7, 9));
        int outputAS1 = arithmeticProgression(inputAS1);
        System.out.println("AS1 - Arithmetic Progression :" + outputAS1);

        //AS2 > Noble Integer
        ArrayList<Integer> inputAS2 = new ArrayList<Integer>(Arrays.asList(-6, -4, -2, -1, 0));
        //ArrayList<Integer> inputAS2 = new ArrayList<Integer>(Arrays.asList(3, 2, 1, 3));
        int outputAS2 = nobleInteger(inputAS2);
        System.out.println("AS2 - Noble Integer :" + outputAS2);

        //AS2 > Noble Integer
        ArrayList<Integer> inputAS3 = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 0, 1, 2));
        ArrayList<Integer> outputAS3 = sortByColor(inputAS3);
        System.out.print("AS3 - Sort by Color :");
        outputAS3.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println("");

        //HW2 > Elements Removal
        ArrayList<Integer> inputHW2 = new ArrayList<Integer>(Arrays.asList(2, 1));
        //ArrayList<Integer> inputAS2 = new ArrayList<Integer>(Arrays.asList(3, 2, 1, 3));
        int outputHW2 = elementRemoval(inputHW2);
        System.out.println("HW2 - Elements Removal :" + outputHW2);
    }

    /**
     * AS1 > Arithmetic Progression
     * Given an integer array A of size N. Return 1 if the array can be rearranged to form an arithmetic progression, otherwise, return 0.
     * Example => A = [3, 5, 1] => O/P = 1
     * [2, 4, 1] => O/P = 0
     * @param A
     * @return
     */
    private int arithmeticProgression(ArrayList<Integer> A){
        int isArithmeticProgression = 1;
        int arithmeticDifference = 0;
        Collections.sort(A);
        if (A.size() > 1) {
            arithmeticDifference = A.get(1)-A.get(0);
        }
        if (A.size() > 2) {
            for (int i = 1; i < A.size() - 1; i++) {
                if (A.get(i + 1) - A.get(i) != arithmeticDifference) {
                    isArithmeticProgression = 0;
                    break;
                }
            }
        }
        return isArithmeticProgression;
    }

    /**
     * AS2 > Noble Integer
     * Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p.
     * Example => A = [3, 2, 1, 3] => O/P = 1
     * [1, 1, 3, 3] => O/P = -1
     * @param A
     * @return
     */
    private int nobleInteger(ArrayList<Integer> A){
        int isNobleInteger = -1;
        Collections.sort(A);

        for (int i = 0; i < A.size(); i++) {
            if (i < A.size()-1) {
                if (A.get(i) == (A.size() - i - 1) && A.get(i) != A.get(i+1)) { //N-i-1 items on right + should be the rightmost element if duplicates
                    isNobleInteger = 1;
                }
            } else {
                if (A.get(i) == (A.size() - i - 1)) { //N-i-1 items on right
                    isNobleInteger = 1;
                }
            }

        }
        return isNobleInteger;
    }

    /**
     * AS3 > Sort by Color
     * Array of n objects colored R, W or B, sort them so that objects of the same color are adjacent - R -> W -> B.
     * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
     * Note: Using library sort function is not allowed.
     * [0 1 2 0 1 2] => O/P = [0 0 1 1 2 2]
     * @param A
     * @return
     */
    private ArrayList<Integer> sortByColor(ArrayList<Integer> A){
        ArrayList<Integer> result = new ArrayList<Integer>();
        int rCount = 0;
        int wCount = 0;
        int bCount = 0;
        for (int i = 0; i < A.size(); i++) {
            switch (A.get(i)) {
                case 0:
                    rCount++;
                    break;
                case 1:
                    wCount++;
                    break;
                case 2:
                    bCount++;
                    break;
            }
        }
        for (int i = 0; i < rCount; i++) {
            result.add(0);
        }
        for (int i = 0; i < wCount; i++) {
            result.add(1);
        }
        for (int i = 0; i < bCount; i++) {
            result.add(2);
        }
        return result;

        //NOTE: Better solution is to get (swap) all 0's to front [starting index = 0] and get(swap) all 2's to back [starting index = N-1]
        //Would be more space efficient
    }

    //-----------------------------------------------------------------------

    /**
     * HW2 > Largest Number
     * Given integer array A of size N. In one operation, you can remove any element from the array,
     * and the cost of this operation is the sum of all elements in the array present before this operation.
     * Find the minimum cost to remove all elements from the array.
     * Example => [2, 1] => o/p = 4
     * Given array A = [2, 1]
     *  Remove 2 from the array => [1]. Cost of this operation is (2 + 1) = 3.
     *  Remove 1 from the array => []. Cost of this operation is (1) = 1.
     *  So, total cost is = 3 + 1 = 4.
     * @param A
     * @return
     */
    private int elementRemoval(ArrayList<Integer> A) {
        int cost = 0;
        Collections.sort(A);
        ArrayList<Integer> prefixSumArray = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            int lastElementOfPrefixSumArray = prefixSumArray.size() > 0 ? prefixSumArray.get(prefixSumArray.size() -1) : 0;
            int latestSum = A.get(i) +lastElementOfPrefixSumArray;
            prefixSumArray.add(latestSum);
        }
        for (int i = 0; i < prefixSumArray.size(); i++) {
            cost = cost + prefixSumArray.get(i);
        }
        return cost;
    }

    /**
     * HW2 > Elements Removal
     * Given integer array A of size N. In one operation, you can remove any element from the array,
     * and the cost of this operation is the sum of all elements in the array present before this operation.
     * Find the minimum cost to remove all elements from the array.
     * Example => [2, 1] => o/p = 4
     * Given array A = [2, 1]
     *  Remove 2 from the array => [1]. Cost of this operation is (2 + 1) = 3.
     *  Remove 1 from the array => []. Cost of this operation is (1) = 1.
     *  So, total cost is = 3 + 1 = 4.
     * @param A
     * @return
     */
    private int elementRemoval(ArrayList<Integer> A) {
        int cost = 0;
        Collections.sort(A);
        ArrayList<Integer> prefixSumArray = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            int lastElementOfPrefixSumArray = prefixSumArray.size() > 0 ? prefixSumArray.get(prefixSumArray.size() -1) : 0;
            int latestSum = A.get(i) +lastElementOfPrefixSumArray;
            prefixSumArray.add(latestSum);
        }
        for (int i = 0; i < prefixSumArray.size(); i++) {
            cost = cost + prefixSumArray.get(i);
        }
        return cost;
    }
}
