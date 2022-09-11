package main.tutorial.AdvancedDSA.M6_BinarySearch;

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
        //AS1 > Sorted Insert Position
        ArrayList<Integer> inputAS1 = new ArrayList<>(Arrays.asList(1, 3 ,5, 6));
        System.out.println("AS1 > Sorted Insert Position (5) [1, 3 ,5, 6] => " + this.sortedInsertPosition(inputAS1 , 5));
        System.out.println("    > Sorted Insert Position (4) [1, 3 ,5, 6] => " + this.sortedInsertPosition(inputAS1 , 4));
        System.out.println("    > Sorted Insert Position (-10) [1, 3 ,5, 6] => " + this.sortedInsertPosition(inputAS1 , -10));
        System.out.println("    > Sorted Insert Position (20) [1, 3 ,5, 6] => " + this.sortedInsertPosition(inputAS1 , 20));

        //AS2 > Find a peak element
        ArrayList<Integer> inputAS2a = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("AS2 > Find a peak element [1, 2, 3, 4, 5] => " + this.findAnyPeakElement(inputAS2a));
        ArrayList<Integer> inputAS2b = new ArrayList<>(Arrays.asList(5, 17, 100, 11));
        System.out.println("    > Find a peak element [5, 17, 100, 11] => " + this.findAnyPeakElement(inputAS2b));
        ArrayList<Integer> inputAS2c = new ArrayList<>(Arrays.asList(5, 17, 100, 11, 17, 16, 9, 7, 8, 3));
        System.out.println("    > Find a peak element [5, 17, 100, 11, 17, 16, 9, 7, 8, 3] => " + this.findAnyPeakElement(inputAS2c));


        /*------------HOMEWORK------------*/

        System.out.println("------------HOMEWORK-----------------");
        //HW1 > Matrix Search
        ArrayList<ArrayList<Integer>> inputHW1 = new ArrayList();
        inputHW1.add(new ArrayList<>(Arrays.asList(1, 3, 5, 7)));
        inputHW1.add(new ArrayList<>(Arrays.asList(10, 11, 16, 20)));
        inputHW1.add(new ArrayList<>(Arrays.asList(23, 30, 34, 50)));
        System.out.println("HW1 > Matrix Search (0) => " + this.searchInMatrix(inputHW1, 0));
        System.out.println("    > Matrix Search (3) => " + this.searchInMatrix(inputHW1, 3));
        System.out.println("    > Matrix Search (34) => " + this.searchInMatrix(inputHW1, 34));
        System.out.println("    > Matrix Search (22) => " + this.searchInMatrix(inputHW1, 22));
        System.out.println("    > Matrix Search (55) => " + this.searchInMatrix(inputHW1, 22));
    }

    /*------------CLASSWORK------------*/

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

    /**
     * AS2 > Find a peak element
     * Array of integers A, find and return any peak element in it. An array element is peak if it is NOT smaller than its neighbors.
     * For corner elements, we need to consider only one neighbor.
     * @param A
     * @return
     */
    private int findAnyPeakElement(ArrayList<Integer> A) {
        int peak = Integer.MIN_VALUE;

        //Handle edge case
        //1 element - return that
        //Check borders - if so return border element
        if (A.size() > 1) {
            if (A.get(0) > A.get(1)) {
                return A.get(0);
            }
            if (A.get(A.size() - 1) > A.get(A.size() - 2)) {
                return A.get(A.size() - 1);
            }
        } else {
            return A.get(0);
        }

        //Check inside peaks
        int low = 0;
        int high = A.size() - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;

            //Non border
            if (mid != 0 && mid != (A.size() - 1)) {
                if (A.get(mid) > A.get(mid - 1) && A.get(mid) > A.get(mid + 1)) {
                    peak = mid;
                    break;
                } else if (A.get(mid - 1) > A.get(mid) && A.get(mid + 1) < A.get(mid)) {  //Left is higher than right - goto left
                    high = mid - 1;
                } else { //Right is higher than left
                    low = mid + 1;
                }
            } else {
                peak = mid;
                break;
            }
        }
        return A.get(peak);
    }


    /*------------HOMEWORK------------*/

    /**
     * HW1 > Matrix Search
     * Given matrix of integers A of size N x M. Algorithm that searches for integer B in matrix A.
     * This matrix A has the following properties:
     * 1. Integers in each row are sorted from left to right.
     * 2. The first integer of each row is greater than or equal to the last integer of the previous row.
     * Return 1 if B is present in A, else return 0.
     * @param A
     * @param B
     * @return
     */
    private int searchInMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        //Identify which row its in then in that row apply BS
        int rows = A.size();
        int cols = A.get(0).size();

        int targetRow = -1;
        for (int i = 0; i < rows; i++) {
            if (B >= A.get(i).get(0) && B <= A.get(i).get(cols - 1)) {
                targetRow = i;
                break;
            }
        }

        int result = 0;
        //Only if a row exists proceed
        if (targetRow >= 0) {
            int low = 0;
            int high = cols - 1;
            int mid;
            while (low <= high) {
                mid = (low + high)/2;
                if (A.get(targetRow).get(mid) == B) {
                    result = 1;
                    break;
                } else if (B < A.get(targetRow).get(mid)) { //Reject right
                    high = mid - 1;
                } else { //Reject left
                    low = mid + 1;
                }
            }
        }

        return result;
    }
}
