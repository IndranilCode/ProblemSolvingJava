package com.tutorial;

import java.util.ArrayList;
import java.util.Arrays;

public class Day4IntroductionToProblemSolving {

    public void executeIntroductionToProblemSolving() {
        //HW1 > Smaller and Greater
        ArrayList<Integer> inputHW1 = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        int outputHW1 = smallerAndGreater(inputHW1);
        System.out.println("HW1 - Smaller and Greater :" + outputHW1);

        //HW2 > Elements which have at-least two greater elements
        ArrayList<Integer> inputHW2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> outputHW2 = elementsWithAtleast2GreaterElements(inputHW1);
        System.out.print("HW2 - Elements which have at-least two greater elements :");
        outputHW2.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println("");

        //HW3 > MINIMUM PICKS
        ArrayList<Integer> inputHW3 = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        int outputHW3 = minimumPicks(inputHW3);
        System.out.println("HW3 - MINIMUM PICKS :" + outputHW1);
    }

    /**
     * HW1 > Smaller and Greater
     * Find for how many elements, there is a strictly smaller element and a strictly greater element.
     * Example => A = [1, 2, 3] => 1 (ie no 2)
     * @param A
     * @return
     */
    private int smallerAndGreater(ArrayList<Integer> A) {
        int maxNumber = Integer.MIN_VALUE;
        int minNumber = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > maxNumber) {
                maxNumber = A.get(i);
            }
            if (A.get(i) < minNumber) {
                minNumber = A.get(i);
            }
        }
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > minNumber && A.get(i) < maxNumber) {
                count++;
            }
        }
        return count;
    }

    /**
     * HW2 > Elements which have at-least two greater elements
     * You are given an array of distinct integers A, you have to find and return all elements in array which have at-least two greater elements than themselves.
     * Example => [1, 2, 3, 4, 5] => [1, 2, 3]
     * @param A
     * @return
     */
    private ArrayList<Integer> elementsWithAtleast2GreaterElements(ArrayList<Integer> A) {
        ArrayList<Integer> answers = new ArrayList<Integer>();

        A.forEach(eachElem -> {
            int elderCount = 0;
            for (int a = 0; a < A.size(); a++) {
                if (A.get(a) > eachElem) {
                    elderCount++;
                }
                if (elderCount >= 2) {
                    break;
                }
            }
            if (elderCount >= 2) {
                answers.add(eachElem);
            }

        });

        return answers;
    }

    /**
     * HW3 > MINIMUM PICKS
     * Return the difference between the maximum among all even numbers of A and the minimum among all odd numbers in A.
     * @param A
     * @return
     */
    private int minimumPicks(ArrayList<Integer> A) {
        int maxEven = Integer.MIN_VALUE;
        int minOdd = Integer.MAX_VALUE;

        for(int a = 0 ; a < A.size(); a++) {
            int currentNo = A.get(a);
            if (currentNo % 2 == 0) {
                //Even
                if (currentNo > maxEven) {
                    maxEven = currentNo;
                }
            } else {
                //Odd
                if (currentNo < minOdd) {
                    minOdd = currentNo;
                }
            }
        }
        return maxEven - minOdd;
    }

    /**
     * HW4 > Pattern Printing -1
     * Print a Pattern According to The Given Value of A.
     * Example: For A = 3 pattern looks like:
     * 1 0 0
     * 1 2 0
     * 1 2 3
     * @param A
     * @return
     */
    private ArrayList<ArrayList<Integer>> patternPrinting1(int A) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        for (int i = 1; i<= A ; i++) {
            ArrayList<Integer> currentRow = new ArrayList<Integer>();
            for (int j = 1 ; j <= A ; j++) {
                if (i < j) {
                    currentRow.add(0);
                }
                if (i >= j) {
                    currentRow.add(j);
                }
            }
            answer.add(currentRow);
        }
        return answer;
    }
}
