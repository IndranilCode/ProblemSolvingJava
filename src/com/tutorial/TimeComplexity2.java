package com.tutorial;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimeComplexity2 {

    public void executeTimeComplexity2() {

        //HW2 > Array - Array with consecutive elements
//        ArrayList<Integer> inputHW2 = new ArrayList<Integer>(Arrays.asList(3, 2, 1, 2, 3, 4, 5, 6, 5));
        ArrayList<Integer> inputHW2 = new ArrayList<Integer>(Arrays.asList(285, 223, 327, 320, 107, 127, 266, 277, 324, 282, 322, 260));
        int outputHW2 =  checkArrayWithConsecutiveElements(inputHW2);
        System.out.println("HW Q2 - Array with consecutive elements :" + outputHW2);

//        //HW3> Array - Count Duplicates
//        //List<Integer> inputHW3 = Arrays.asList(1, 10, 20, 1, 25, 1, 10, 30, 25, 1);
//        List<Integer> inputHW3 = Arrays.asList(156629687, 156629687, 950873097, -816928664, 633452756, 156629687, -816928664, 950873097, 950873097);
//        int outputHW3 =  countDuplicatesInArray(inputHW3);
//        System.out.println("HW Q3 - Count Duplicates :" + outputHW3);
    }

    private int checkArrayWithConsecutiveElements(ArrayList<Integer> A) {
        int lowestNumber = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) < lowestNumber) {
                lowestNumber = A.get(i);
            }
        }
        for (int i = 0; i < A.size(); i++) {

        }

        return 3;
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
}
