package com.tutorial.IntermediateDSA.M5_Hashing2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Day22_Hashing2 {
    public void execute(){

        // AS2 > Diffk II
        ArrayList<Integer> inputAS2_A = new ArrayList<>(Arrays.asList(1, 5, 3));
        int inputAS2_B = 2;
        System.out.println("AS2 > Diffk II [1, 5, 3] , K = 2 => " + this.diffPossible(inputAS2_A, inputAS2_B));
        ArrayList<Integer> inputAS2_A_2 = new ArrayList<>(Arrays.asList(0));
        int inputAS2_B_2 = 0;
        System.out.println("    > Diffk II [0] , K = 0 => " + this.diffPossible(inputAS2_A_2, inputAS2_B_2));
    }

    /**
     * AS2 > Diffk II
     * Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
     * @param A
     * @param B
     * @return
     */
    private int diffPossible(final List<Integer> A, int B) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        //Build frequency map
        for (int i = 0; i < A.size(); i++) {
            int currentNumber = A.get(i);
            if (!frequencyMap.containsKey(currentNumber)) {
                frequencyMap.put(currentNumber, 1);
            } else {
                frequencyMap.put(currentNumber, (frequencyMap.get(currentNumber) + 1));
            }
        }

        int result = 0;
        //Process: Parse through list, pick each number , find alternate [a - b = k ; b = a - k ]
        //Search for b (alternate) in hashmap
        //If a == b, then
        for (int i = 0; i < A.size(); i++) {
            int currentNumber = A.get(i);
            int numberToSearch = currentNumber - B;

            if (currentNumber != numberToSearch) {
                // a != b ; just see if b is present in array
                if (frequencyMap.containsKey(numberToSearch)) {
                    return 1;
                }
            } else {
                // a == b; check frequency now so that same number isn't found again
                int numberToSearchFrequency = frequencyMap.get(numberToSearch);
                if (numberToSearchFrequency > 1) {
                    return 1;
                }
            }
        }
        return result;
    }
}
