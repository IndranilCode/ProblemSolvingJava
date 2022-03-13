package com.tutorial.AdvancedDSA.M6_BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class Day48_BinarySearch1 {
    public void execute() {
        System.out.println("------------BINARY SEARCH 1------------");
        System.out.println("------------CLASSWORK------------------");
        //CW1 > Binary Search (Recursion)
        ArrayList<Integer> inputCW1 = new ArrayList<>(Arrays.asList(1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10, 14, 17, 20));
        System.out.println("CW1 > Binary Search [1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10, 14, 17, 20] => " + this.binarySearch(inputCW1, 0, inputCW1.size() - 1, 17));
        System.out.println("    > Binary Search [1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10, 14, 17, 20] => " + this.binarySearch(inputCW1, 0, inputCW1.size() - 1, 1));
        System.out.println("    > Binary Search [1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10, 14, 17, 20] => " + this.binarySearch(inputCW1, 0, inputCW1.size() - 1, 5));
        System.out.println("    > Binary Search [1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10, 14, 17, 20] => " + this.binarySearch(inputCW1, 0, inputCW1.size() - 1, 11));

        //CW1.1 > Binary Search (Iterative)
        ArrayList<Integer> inputCW1_2 = new ArrayList<>(Arrays.asList(1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10, 14, 17, 20));
        System.out.println("CW1.1 > Binary Search - w/o recursion [1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10, 14, 17, 20] => " + this.binarySearch_iterative(inputCW1_2 , 17));
        System.out.println("      > Binary Search - w/o recursion [1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10, 14, 17, 20] => " + this.binarySearch_iterative(inputCW1_2 , 1));
        System.out.println("      > Binary Search - w/o recursion [1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10, 14, 17, 20] => " + this.binarySearch_iterative(inputCW1_2 , 5));
        System.out.println("      > Binary Search - w/o recursion [1, 2, 3 ,4 ,5 ,6, 7, 8, 9, 10, 14, 17, 20] => " + this.binarySearch_iterative(inputCW1_2 , 11));

        //CW2 > Floor of K (Linear)
        ArrayList<Integer> inputCW2 = new ArrayList<>(Arrays.asList(-5, 2, 3, 6, 9, 10, 11, 14, 18));
        System.out.println("CW2 > Floor of K Linear(5) [-5, 2, 3, 6, 9, 10, 11, 14, 18] => " + this.floorOfGivenK_linear(inputCW2 , 5));
        System.out.println("    > Floor of K Linear(4) [-5, 2, 3, 6, 9, 10, 11, 14, 18] => " + this.floorOfGivenK_linear(inputCW2 , 4));
        System.out.println("    > Floor of K Linear(10) [-5, 2, 3, 6, 9, 10, 11, 14, 18] => " + this.floorOfGivenK_linear(inputCW2 , 10));
        System.out.println("    > Floor of K Linear(-7) [-5, 2, 3, 6, 9, 10, 11, 14, 18] => " + this.floorOfGivenK_linear(inputCW2 , -7));
        System.out.println("    > Floor of K Linear(-3) [-5, 2, 3, 6, 9, 10, 11, 14, 18] => " + this.floorOfGivenK_linear(inputCW2 , -3));

        //CW2.1 > Floor of K (Binary)
        ArrayList<Integer> inputCW2_2 = new ArrayList<>(Arrays.asList(-5, 2, 3, 6, 9, 10, 11, 14, 18));
        System.out.println("CW2.1 > Floor of K Binary(5) [-5, 2, 3, 6, 9, 10, 11, 14, 18] => " + this.floorOfGivenK_binary(inputCW2_2 , 5));
        System.out.println("      > Floor of K Binary(4) [-5, 2, 3, 6, 9, 10, 11, 14, 18] => " + this.floorOfGivenK_binary(inputCW2_2 , 4));
        System.out.println("      > Floor of K Binary(10) [-5, 2, 3, 6, 9, 10, 11, 14, 18] => " + this.floorOfGivenK_binary(inputCW2_2 , 10));
        System.out.println("      > Floor of K Binary(-7) [-5, 2, 3, 6, 9, 10, 11, 14, 18] => " + this.floorOfGivenK_binary(inputCW2_2 , -7));
        System.out.println("      > Floor of K Binary(-3) [-5, 2, 3, 6, 9, 10, 11, 14, 18] => " + this.floorOfGivenK_binary(inputCW2_2 , -3));

        //CW3 > Find frequency of k in array (INCOMPLETE)
        ArrayList<Integer> inputCW3 = new ArrayList<>(Arrays.asList(-5, -5, -3, 0, 0, 1, 1, 5, 5, 5, 5, 5, 5, 5, 8, 10, 10, 15));
        this.frequencyOfKInSortedArray_binary(inputCW3, 5);

        /*------------ASSIGNMENTS------------*/

        System.out.println("------------ASSIGNMENTS-----------------");
        ArrayList<Integer> inputAS1 = new ArrayList<>(Arrays.asList(1, 3 ,5, 6));
        System.out.println("AS1 > Sorted Insert Position (5) [1, 3 ,5, 6] => " + this.sortedInsertPosition(inputAS1 , 5));
        System.out.println("    > Sorted Insert Position (4) [1, 3 ,5, 6] => " + this.sortedInsertPosition(inputAS1 , 4));
        System.out.println("    > Sorted Insert Position (-10) [1, 3 ,5, 6] => " + this.sortedInsertPosition(inputAS1 , -10));
        System.out.println("    > Sorted Insert Position (20) [1, 3 ,5, 6] => " + this.sortedInsertPosition(inputAS1 , 20));
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
     * CW2 > Floor of K (Linear)
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

    /**
     * CW2 > Floor of K (Binary)
     * @param a
     * @param k
     * @return
     */
    private int floorOfGivenK_binary(ArrayList<Integer> a, int k) {
        int result = Integer.MIN_VALUE;
        int mid;
        int low = 0;
        int high = a.size() - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a.get(mid) > k) {
                high = mid - 1;
            } else if (a.get(mid) == k) {
                result = a.get(mid);
                break;
            } else {
                result = a.get(mid);
                low = mid + 1;
            }
        }
        return result;
    }

    /**
     * CW3 > Find frequency of k in array
     * @param a
     * @param k
     * @return
     */
    private int frequencyOfKInSortedArray_binary(ArrayList<Integer> a, int k) {
        //1. Find first occurrence of K with BS
        //2. Find last occurrence of K with BS

        int firstIndex = 0;
        int lastIndex = 0;
        int low = 0;
        int high = a.size() - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a.get(mid) > k) {
                //Reject right
                high = mid - 1;
            } else if (a.get(mid) < k) {
                //Reject left
                low = mid + 1;
            } else {
                //K found - may/maynot be first - still goto left (reject right)
                firstIndex = mid;
                high = mid - 1;
            }
        }

        return 0;
    }

    /*------------ASSIGNMENTS------------*/

    /**
     * AS1 > Sorted Insert Position
     * @param A
     * @param B
     * @return
     */
    private int sortedInsertPosition(ArrayList<Integer> A, int B) {
        //Similar to Floor finding
        int result = 0;
        int mid;
        int low = 0;
        int high = A.size() - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (A.get(mid) > B) {
                high = mid - 1;
            } else if (A.get(mid) == B) {
                result = mid;
                break;
            } else { //<B - so element may be inserted @ mid + 1 => find better position - go right
                result = mid + 1;
                low = mid + 1;
            }
        }
        return result;
    }
}
