package com.tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Day19IntroductionToHashingLibraries1 {
    public void executeIntroductionToHashing() {
        //AS1 > Common Elements
        ArrayList<Integer> inputAS1Aa = new ArrayList<Integer>(Arrays.asList(1, 2, 2, 1));
        ArrayList<Integer> inputAS1b = new ArrayList<Integer>(Arrays.asList(2, 3, 1, 2));
        ArrayList<Integer> outputAS1 = commonElements(inputAS1Aa, inputAS1b);
        System.out.print("AS1 - Common Elements :");
        outputAS1.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println("");

        //AS2 > First Repeating element
        ArrayList<Integer> inputAS2 = new ArrayList<Integer>(Arrays.asList(10, 5, 3, 4, 3, 5, 6));
        Integer outputAS2 = firstRepeatingElement(inputAS2);
        System.out.print("AS2 - First Repeating element :" + outputAS2);
    }

    /**
     * AS1 > Common Elements [NO TRICK]
     * Given two integer array A and B of size N and M respectively. Your task is to find all the common elements in both the array.
     * NOTE:
     * Each element in the result should appear as many times as it shows in both arrays. The result can be in any order.
     *  A = [1, 2, 2, 1] ; B = [2, 3, 1, 2] =>O/P [1, 2, 2]
     * @param A
     * @param B
     * @return
     */
    private ArrayList<Integer> commonElements(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> arrayBFrequency = new HashMap<>();
        for (int j = 0; j < B.size(); j++) {
            if (arrayBFrequency.containsKey(B.get(j))) {
                Integer currFreq = arrayBFrequency.get(B.get(j));
                arrayBFrequency.put(B.get(j), currFreq + 1);
            } else {
                arrayBFrequency.put(B.get(j), 1);
            }
        }
        for (int i = 0; i< A.size(); i++) {
            if (arrayBFrequency.containsKey(A.get(i)) && arrayBFrequency.get(A.get(i)) > 0) {
                result.add(A.get(i));
                Integer currFreq = arrayBFrequency.get(A.get(i));
                if (currFreq == 1) {
                    arrayBFrequency.remove(A.get(i));
                } else {
                    arrayBFrequency.put(A.get(i), currFreq -1);
                }
            }
        }
        return result;
    }

    /**
     * AS2 > First Repeating element [NO-TRICK]
     * Given an integer array A of size N, find the first repeating element in it.
     * We need to find the element that occurs more than once and whose index of first occurrence is smallest.
     * If there is no repeating element, return -1.
     * Example => A = [10, 5, 3, 4, 3, 5, 6] => o/p => 5
     * [6, 10, 5, 4, 9, 120] => o/p => -1
     * @param A
     * @return
     */
    private int firstRepeatingElement(ArrayList<Integer> A) {
        HashMap<Integer, Integer> arrayFreq = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            if (arrayFreq.containsKey(A.get(i))) {
                Integer currFreq = arrayFreq.get(A.get(i));
                arrayFreq.put(A.get(i), currFreq + 1);
            } else {
                arrayFreq.put(A.get(i), 1);
            }
        }
        for (int i = 0; i < A.size(); i++) {
            if (arrayFreq.get(A.get(i)) > 1) {
                return A.get(i);
            }
        }
        return -1;
    }

    /**
     * AS3 > Largest Continuous Sequence Zero Sum [NO-TRICK]
     * Given an array A of N integers, find the largest continuous sequence in a array which sums to zero.
     * Return an array denoting the longest first continuous sequence with total sum of zero.
     * Example => A = [1,2,-2,4,-4] => o/p => [2,-2,4,-4]
     * @param A
     * @return
     */
    private ArrayList<Integer> largestContinuousSequenceZeroSum(ArrayList<Integer> A) {
        return null;
    }
}
