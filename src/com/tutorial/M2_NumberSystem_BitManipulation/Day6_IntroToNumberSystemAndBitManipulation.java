package com.tutorial.M2_NumberSystem_BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day6_IntroToNumberSystemAndBitManipulation {
    public void execute() {
        ArrayList<Integer> inputAS1 = new ArrayList<Integer>(Arrays.asList(1, 2, 2, 3 ,1));
        int outputAS1 = this.singleNumber(inputAS1);
        System.out.println("AS1 > Single Number :" + outputAS1);
    }

    /**
     * AS1 > Single Number
     * Given an array of integers A, every element appears twice except for one. Find that single one.
     * @param A
     * @return
     */
    private int singleNumber(final List<Integer> A) {
        int singleNonRepeatingNumber = 0;
        for (int i = 0 ; i < A.size(); i++) {
            singleNonRepeatingNumber = singleNonRepeatingNumber ^ A.get(i);
        }
        return singleNonRepeatingNumber;
    }
}
