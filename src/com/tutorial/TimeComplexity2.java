package com.tutorial;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TimeComplexity2 {

    public void executeTimeComplexity2() {
        //HW1 > Adjacent Differences Array
        ArrayList<Integer> inputHW1 = new ArrayList<Integer>(Arrays.asList(6, 2, 4, 4, 3));
        ArrayList<Integer> outputHW1 = adjacentDifferenceArray(inputHW1);
        System.out.print("HW1 - Adjacent Differences Array :");
        outputHW1.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println("");

        //HW2 > Array - Array with consecutive elements
        ArrayList<Integer> inputHW2 = new ArrayList<Integer>(Arrays.asList(3, 2, 1, 4, 5));
        //ArrayList<Integer> inputHW2 = new ArrayList<Integer>(Arrays.asList(285, 223, 327, 320, 107, 127, 266, 277, 324, 282, 322, 260));
        int outputHW2 =  checkArrayWithConsecutiveElements(inputHW2);
        System.out.println("HW2 - Array with consecutive elements :" + outputHW2);


//        //HW3> Array - Count Duplicates
//        //List<Integer> inputHW3 = Arrays.asList(1, 10, 20, 1, 25, 1, 10, 30, 25, 1);
//        List<Integer> inputHW3 = Arrays.asList(156629687, 156629687, 950873097, -816928664, 633452756, 156629687, -816928664, 950873097, 950873097);
//        int outputHW3 =  countDuplicatesInArray(inputHW3);
//        System.out.println("HW Q3 - Count Duplicates :" + outputHW3);

        // HW5 > Lower Triangular Matrix
        ArrayList<Integer> hw5a = new ArrayList<Integer>(Arrays.asList(1, 0, 0));
        ArrayList<Integer> hw5b = new ArrayList<Integer>(Arrays.asList(0, 0, 0));
        ArrayList<Integer> hw5c = new ArrayList<Integer>(Arrays.asList(-7, -8, 9));
        List<ArrayList<Integer>> inputHW5 = new ArrayList<>(); inputHW5.add(hw5a); inputHW5.add(hw5b); inputHW5.add(hw5c);
        int outputHW5 = lowerTriangularMatrix(inputHW5);
        System.out.println("HW5 - Lower Triangular Matrix :" + outputHW5);

        // HW6 > Is It Identity Matrix?
        ArrayList<Integer> hw6a = new ArrayList<Integer>(Arrays.asList(1, 0));
        ArrayList<Integer> hw6b = new ArrayList<Integer>(Arrays.asList(0, 1));
        List<ArrayList<Integer>> inputHW6 = new ArrayList<>(); inputHW6.add(hw6a); inputHW6.add(hw6b);
        int outputHW6 = identityMatrix(inputHW6);
        System.out.println("HW6 - Is It Identity Matrix :" + outputHW6);
    }

    /**
     * HW1 > Adjacent Differences Array
     * You have to construct and return an array containing all the adjacent / consecutive element differences (A[i + 1] - A[i]) in the same order.
     * Example => [6, 2, 4, 4, 3] => [-4, 2, 0, -1]
     * @param A
     * @return
     */
    private ArrayList<Integer> adjacentDifferenceArray(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < A.size() - 1; i++) {
            result.add(A.get(i + 1) - A.get(i));
        }
        return result;
    }

    /**
     * HW2 > Array with consecutive elements
     * Given an array of positive integers A, check and return whether the array elements are consecutive or not.
     * Example => [3, 2, 1, 4, 5] => 1
     * [1, 3, 2, 5] => 0
     * @param A
     * @return
     */
    private int checkArrayWithConsecutiveElements(ArrayList<Integer> A) {
        //Brute Force - bad solution - Time Limit Exceeded - for long arrays this fails
        //        int result = 1;
        //        int lowestNumber = Integer.MAX_VALUE;
        //        int highestNumber = Integer.MIN_VALUE;
        //        for (int i = 0;  i < A.size(); i++) {
        //            if (A.get(i) < lowestNumber) {
        //                lowestNumber = A.get(i);
        //            }
        //            if (A.get(i) > highestNumber) {
        //                highestNumber = A.get(i);
        //            }
        //        }
        //
        //        int startNumber = lowestNumber + 1;
        //        while (startNumber != highestNumber) {
        //            Boolean isFound = true;
        //            for (int j = 0; j < A.size(); j++ ){
        //                if (A.get(j) == startNumber) {
        //                    isFound = true;
        //                    startNumber++;
        //                    break;
        //                }
        //            }
        //            if (!isFound) {
        //                result = 0;
        //                break;
        //            }
        //        }
        //        return result;

        //Better with Bubble sort
        //        int result = 1;
        //        int size = A.size();
        //        for (int i = 0; i < size - 1; i++) {
        //            for (int j = 0; j < size - i - 1; j++) {
        //                if (A.get(j) > A.get(j + 1)) {
        //                    int temp = A.get(j);
        //                    A.set(j, A.get(j + 1));
        //                    A.set((j + 1), temp);
        //                }
        //            }
        //        }
        //        for (int i = 0; i < A.size() - 1; i++) {
        //            if (A.get(i + 1) - A.get(i) != 1) {
        //                result = 0;
        //                break;
        //            }
        //        }
        //        return result;

        //Collection sort
        Collections.sort(A);
        int minn = A.get(0);
        for (int x: A) {
            if (x != minn)
                return 0;
            minn++;
        }
        return 1;
    }

    /**
     * NOTE: Tricky - equals didn't work , XOR did
     * HW3 > Problem Description: You are given an integer array A having length N. You have to find the number of duplicate(redundant) elements in the array.
     * Example: A = [1, 10, 20, 1, 25, 1, 10, 30, 25, 1] Output => 5
     * Explanation:
     *  i> 1 is present 4 times in the array. So, 3 of them are redundant.
     *  ii> 10 is present 2 times in the array. So, 1 of them is redundant.
     *  iii> 25 is present 2 times in tha array. So, 1 of them is redundant.
     *  iv> Total duplicates(redundants) = 3 + 1 + 1 = 5
     * @param A
     * @return
     */
    private int countDuplicatesInArray(final List<Integer> A) {
        //My Solution
        //        int duplicateCount = 0;
        //        List<Integer> traversedNumbers = new ArrayList<>();
        //        for (int i = 0; i < A.size(); i++) {
        //            for (int j = 0; j < A.size(); j++) {
        //                if (i != j) {
        //                    if ((A.get(i) ^ A.get(j)) == 0 && traversedNumbers.indexOf(A.get(i)) == -1) {
        //                        duplicateCount++;
        //                    }
        //                }
        //                if (j == (A.size() - 1)) {
        //                    traversedNumbers.add(A.get(i));
        //                }
        //            }
        //        }
        //        return duplicateCount;

        //Req solution
        int duplicateCount = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                if ((A.get(i) == A.get(j))) { //Interesting that this doesn't work with big numbers BUT xor does
                    duplicateCount++;
                    break;
                }
        //                if ((A.get(i) ^ A.get(j)) == 0) {
        //                    duplicateCount++;
        //                    break;
        //                }
            }
        }
        return duplicateCount;
    }

    /**
     * HW5 > Lower Triangular Matrix
     * You are given a N X N integer matrix A. You have to tell whether it is a lower triangular matrix or not.
     * A square matrix is called lower triangular if all the entries above the main diagonal are zero.
     * For any matrix P if elements P[i, j] = 0 (where j > i (1-based)).
     * Example =>
     * A = [[1, 0, 0],
     *      [0, 0, 0],
     *      [-7, -8, 9]]
     * O/P => 1
     * @param A
     * @return
     */
    private int lowerTriangularMatrix(final List<ArrayList<Integer>> A) {
        int isLowerTriangleMatrix = 1;
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.size(); j++) {
                if (j > i) {
                    if (A.get(i).get(j) != 0) {
                        isLowerTriangleMatrix = 0;
                        break;
                    }
                }
            }
        }
        return isLowerTriangleMatrix;
    }

    /**
     * HW5 > Is It Identity Matrix?
     * You are given a N X N square integer matrix A. You have to tell whether A is an identity matrix or not.
     * Identity matrix is a special square matrix whose main diagonal elements are equal to 1 and all other elements are 0.
     * Example => [[1, 0]
     *             [0, 1]]
     * o/p => 1
     * @param A
     * @return
     */
    private int identityMatrix(final List<ArrayList<Integer>> A) {
        int isIdentityMatrix = 1;
        for (int i = 0; i < A.size(); i++ ) {
            for (int j = 0; j < A.get(i).size(); j++) {
                if (i == j) {
                    if (A.get(i).get(j) != 1) {
                        isIdentityMatrix = 0;
                        break;
                    }
                }
            }
        }
        return isIdentityMatrix;
    }
}
