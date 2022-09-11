package main.tutorial.AdvancedDSA.M3_BitManipulations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day40_BitManipulation1 {
    public void execute() {
        //AS1 > Single Number 1 - All double occurrence except 1
        ArrayList<Integer> inputAS1 = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 1));
        System.out.println("AS1 > Single Number 1 - All double occurrence except 1 [XOR] [1, 2, 2, 3, 1] => " + this.findSingleNumber1_AllDoubleExcept1_xor(inputAS1));

        //AS1 > Single Number 1 - All double occurrence except 1
        System.out.println("AS1 > Single Number 1 - All double occurrence except 1 [Bit shift] [1, 2, 2, 3, 1] => " + this.findSingleNumber1_AllDoubleExcept1_shift(inputAS1));

        //AS2 > Single Number 2 - All triple occurrence except 1 [Bit shift]
        ArrayList<Integer> inputAS2 = new ArrayList<>(Arrays.asList(1, 2, 3, 1, 2, 3, 1, 2, 3, 7));
        System.out.println("AS2 > Single Number 2 - All triple occurrence except 1 [Bit shift] [1, 2, 3, 1, 2, 3, 1, 2, 3, 7] => " + this.findSingleNumber2_AllTripleExcept1_shift(inputAS2));

        //AS3 > Number of 1 Bits
        System.out.println("AS3 > Number of 1 Bits (11) => " + this.numberOfSetBits(11));
        System.out.println("AS3 > Number of 1 Bits (101) => " + this.numberOfSetBits(101));

        //AS4 > Add Binary Strings
        System.out.println("AS4 > Add Binary Strings => " + this.addBinaryString("101", "111"));
        System.out.println("AS4 > Add Binary Strings => " + this.addBinaryString("1010110111001101101000", "1000011011000000111100110"));
    }

    /**
     * AS1 > Single Number 1 - All double occurrence except 1 [XOR]
     * Given an array of integers A, every element appears twice except for one. Find that single one.
     * @param A
     * @return
     */
    private int findSingleNumber1_AllDoubleExcept1_xor(List<Integer> A) {
        //Approach 1 - using XOR
        int result = 0;
        for (int i = 0; i < A.size(); i++) {
            result = result ^ A.get(i);
        }
        return result;
    }

    /**
     * AS1 > Single Number 1 - All double occurrence except 1 [Bit shift]
     * @param A
     * @return
     */
    private int findSingleNumber1_AllDoubleExcept1_shift(List<Integer> A) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int setCount = 0;
            int conversionNumber = 1 << i;
            for (int j = 0; j < A.size(); j++) {
                if ((conversionNumber & A.get(j)) >= 1) {
                    setCount++;
                }
            }
            if ((setCount & 1) == 1) { // Check if odd number of set bits at this position
                result = result | (1 << i);
            }
        }
        return result;
    }

    /**
     * AS2 > Single Number 2 - All triple occurrence except 1 [Bit shift]
     * @param A
     * @return
     */
    private int findSingleNumber2_AllTripleExcept1_shift(List<Integer> A) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            int conversionNumber = 1 << i;
            for (int j = 0; j < A.size(); j++) {
                if ((conversionNumber & A.get(j)) >= 1) {
                    count++;
                }
            }
            if ((count % 3) == 1) {
                result = result | (1 << i);
            }
        }
        return result;
    }

    /**
     * AS3 > Number of 1 Bits
     * Takes an integer and returns the number of 1 bits it has.
     * @param A
     * @return
     */
    private int numberOfSetBits(int A) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int conversionNumber = 1 << i;
            if ((conversionNumber & A) >= 1) {
                count ++;
            }
        }
        return count;
    }

    /**
     * AS4 > Add Binary Strings
     * Given two binary strings, return their sum (also a binary string).
     * "100" + "11" = "111"
     * @param A
     * @param B
     * @return
     */
    private String addBinaryString(String A, String B) {
        int diff = Math.abs(A.length() - B.length());
        String appendStr = "";
        for (int i = 0; i < diff; i++) {
            appendStr = appendStr + "0";
        }
        if (A.length() > B.length()) {
            B = appendStr + B;
        } else {
            A = appendStr + A;
        }

        String result = "";
        int carryBit = 0;
        for (int i = A.length()-1; i >= 0; i--) {
            int a = Integer.parseInt(A.charAt(i) + "");
            int b = Integer.parseInt(B.charAt(i) + "");
            int total = a + b + carryBit;
            result = ((total) % 2) + "" + result;
            carryBit = total / 2;
            if (i == 0 && carryBit > 0) {
                result = carryBit + "" + result;
            }
        }
        return result;
    }
}
