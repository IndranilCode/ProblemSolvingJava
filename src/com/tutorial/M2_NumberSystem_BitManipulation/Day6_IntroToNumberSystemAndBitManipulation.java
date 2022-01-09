package com.tutorial.M2_NumberSystem_BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day6_IntroToNumberSystemAndBitManipulation {
    public void execute() {
        System.out.println("Day6: IntroToNumberSystemAndBitManipulation------------------------");

        //AS1 > Single Number
        ArrayList<Integer> inputAS1 = new ArrayList<Integer>(Arrays.asList(1, 2, 2, 3 ,1));
        int outputAS1 = this.singleNumber(inputAS1);
        System.out.println("AS1 > Single Number (1 non repeated # in array): " + outputAS1);

        //AS2 > Number of 1 Bits
        int inputAS2 = 455;
        int outputAS2 = this.numberOfSetBits(inputAS2);
        System.out.println("AS2 > Number of 1 Bits (Set bits in a number): " + outputAS2);

        //HW1 > Add Binary String
        System.out.println("HW1 > Add Binary Strings (1010110 + 111): " + this.addBinary("1010110", "111"));
        System.out.println("HW1 > Add Binary Strings (11 + 10): " + this.addBinary("11", "10"));
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

    /**
     * AS2 > Number of 1 Bits
     * Returns the number of 1 bits it has.
     * @param A
     * @return
     */
    private int numberOfSetBits(int A) {
        // Approach 1 : Repeated div
        //        int numberOfSetBits = 0;
        //
        //        while (A != 0) {
        //            int rem = A % 2;
        //            if (rem  == 1) numberOfSetBits++;
        //            A = A/2;
        //        }
        //        return numberOfSetBits;

        // Approach 2 : Repeated right shift & AND
        int numberOfSetBits = 0;
        while (A > 0) {
            if ((A & 1) == 1) numberOfSetBits++;
            A = A >> 1;
        }
        return numberOfSetBits;
    }

    /**
     * HW1 > Add Binary Strings
     * Given two binary strings, return their sum (also a binary string).
     * @param A
     * @param B
     * @return
     */
    private String addBinary(String A, String B) {
        if (A.length() > B.length()) {
            while (A.length() != B.length()) {
                B = "0" + B;
            }
        } else {
            while (A.length() != B.length()) {
                A = "0" + A;
            }
        }
        String result = "";
        int len = A.length();
        int carryBit = 0;
        for (int i = len - 1; i >= 0; i--) {
            int currentBitAdd = carryBit + Integer.parseInt(A.charAt(i) + "") + Integer.parseInt(B.charAt(i) + "");
            result = (currentBitAdd % 2) + result;
            carryBit = currentBitAdd / 2;
            if (i == 0 && carryBit > 0) {
                result = carryBit + result;
            }
        }
        return result;
    }
}
