package com.tutorial.AdvancedDSA.M6_BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class Day48_BinarySearch1 {
    public void execute() {
        ArrayList<Integer> inputCW1 = new ArrayList<>(Arrays.asList(1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10, 14, 17, 20));
        System.out.println("CW1 > Binary Search [1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10, 14, 17, 20] => " + this.binarySearch(inputCW1, 0, inputCW1.size() - 1, 17));
        System.out.println("    > Binary Search [1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10, 14, 17, 20] => " + this.binarySearch(inputCW1, 0, inputCW1.size() - 1, 1));
        System.out.println("    > Binary Search [1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10, 14, 17, 20] => " + this.binarySearch(inputCW1, 0, inputCW1.size() - 1, 5));
        System.out.println("    > Binary Search [1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10, 14, 17, 20] => " + this.binarySearch(inputCW1, 0, inputCW1.size() - 1, 11));

        ArrayList<Integer> inputCW1_2 = new ArrayList<>(Arrays.asList(1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10, 14, 17, 20));
        System.out.println("CW1.1 > Binary Search - w/o recursion [1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10, 14, 17, 20] => " + this.binarySearch_iterative(inputCW1_2 , 17));
        System.out.println("      > Binary Search - w/o recursion [1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10, 14, 17, 20] => " + this.binarySearch_iterative(inputCW1_2 , 1));
        System.out.println("      > Binary Search - w/o recursion [1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10, 14, 17, 20] => " + this.binarySearch_iterative(inputCW1_2 , 5));
        System.out.println("      > Binary Search - w/o recursion [1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10, 14, 17, 20] => " + this.binarySearch_iterative(inputCW1_2 , 11));

        ArrayList<Integer> inputCW2 = new ArrayList<>(Arrays.asList(-5, 2, 3, 6, 9, 10, 11, 14, 18));
        System.out.println("CW2 > Floor of K(5) [-5, 2, 3, 6, 9, 10, 11, 14, 18] => " + this.floorOfGivenK_linear(inputCW2 , 5));
        System.out.println("    > Floor of K(4) [-5, 2, 3, 6, 9, 10, 11, 14, 18] => " + this.floorOfGivenK_linear(inputCW2 , 4));
        System.out.println("    > Floor of K(10) [-5, 2, 3, 6, 9, 10, 11, 14, 18] => " + this.floorOfGivenK_linear(inputCW2 , 10));
        System.out.println("    > Floor of K(-7) [-5, 2, 3, 6, 9, 10, 11, 14, 18] => " + this.floorOfGivenK_linear(inputCW2 , -7));
        System.out.println("    > Floor of K(-3) [-5, 2, 3, 6, 9, 10, 11, 14, 18] => " + this.floorOfGivenK_linear(inputCW2 , -3));
    }

    /**
     * CW1 > Binary Search (Recursion)
     * @param a
     * @param start
     * @param end
     * @param searchVal
     * @return
     */
    private int binarySearch(ArrayList<Integer> a, int start, int end, int searchVal) {
        if (start >= end) return -1;
        int mid = (start + end) / 2;
        if (a.get(mid) == searchVal) return mid;
        if (searchVal >= start && searchVal <= mid) {
            return this.binarySearch(a, start, mid-1, searchVal);
        } else {
            return this.binarySearch(a, mid + 1, end, searchVal);
        }
    }

    /**
     * CW1.1 > Binary Search - w/o recursion
     * @param a
     * @param searchVal
     * @return
     */
    private int binarySearch_iterative(ArrayList<Integer> a, int searchVal) {
        int result = -1;
        int start = 0;
        int end = a.size() - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (a.get(mid) == searchVal) {
                result = mid;
                break;
            } else if (searchVal > a.get(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    /**
     * CW2 > Floor of K
     * fLOOR - greatest <= k
     * @param a
     * @param k
     * @return
     */
    private int floorOfGivenK_linear(ArrayList<Integer> a, int k) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) <= k) {
                result = a.get(i);
            } else {
                break;
            }
        }
        return result;
    }
}
