package main.tutorial.M2_NumberSystem_BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;

public class Day7_BitManipulations {
    public void execute() {
        //CW1 > Left shift demo
        System.out.println("CW1 > Left shift demo: ");
        this.leftShiftDemo();

        //CW2 > Right shift demo
        System.out.println("CW2 > Right shift demo: (NOTE: -ve nos remain -ve as MSB 1 is copied as 1)");
        this.rightShiftDemo();

        //CW3 > Check if nth bit is set or not
        System.out.println("CW3> Check if nth bit is set or not : 24 (..0011000) , n=2 =>" + this.isNthBitSetForNumber(24, 2));
        System.out.println("CW3> Check if nth bit is set or not : 24 (..0011000) , n=3 =>" + this.isNthBitSetForNumber(24, 3));

        //CW4 > Set the ith bit 1 for a number
        System.out.println("CW4> Set the ith bit 1 for a number: 8 , n=1 =>" + this.setIthBitOfNumber(8, 1));
        System.out.println("CW4> Set the ith bit 1 for a number: 8 , n=0 =>" + this.setIthBitOfNumber(8, 0));

        //CW5 > Unset the ith bit of a number
        System.out.println("CW5> Unset the ith bit of a number: 5 (101) , n=2 =>" + this.unsetIthBitOfNumber(5, 2));
        System.out.println("CW5> Unset the ith bit of a number: 5 (101) , n=0 =>" + this.unsetIthBitOfNumber(5, 0));

        //CW6 > Count set bits in a number
        System.out.println("CW6> Count set bits in a number: 5 (101) => " + this.countSetBitsInPositiveNumber(5));

        //AS1 > 2 Single Numbers
        ArrayList<Integer> inputAS1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 1, 2, 4));
        ArrayList<Integer> outputAS1 = this.find2NosAppearingSingleTimes(inputAS1);
        System.out.print("AS1> 2 Single Numbers [1, 2, 3, 1, 2, 4]: ");
        outputAS1.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println("");

        //HW2> Reverse Bits
        long outputHW2 = this.reverseBits(3);
        System.out.print("HW2> Reverse Bits (3): " + outputHW2);
    }

    /**
     * CW1 > Left shift demo
     * When << causes 1 to reach MSB it becomes -ve
     */
    private void leftShiftDemo() {
        //int => size 32
        int no1 = 1;
        for (int i = 0; i <= 32; i++) {
            System.out.print(no1 + " ,");
            no1 = no1 << 1;
        }
        System.out.println("");

        //byte => size 8
        byte no2 = 1;
        for (int i = 0; i <= 32; i++) {
            System.out.print(no2 + " ,");
            no2 = (byte) (no2 << 1);
        }
        System.out.println("");

        //short => size 16
        short no3 = 1;
        for (int i = 0; i <= 32; i++) {
            System.out.print(no3 + " ,");
            no3 = (short) (no3 << 1);
        }
        System.out.println("");
    }

    /**
     * CW2 > Right shift demo
     * NOTE: -ve nos remain -ve as MSB 1 is copied as 1
     */
    private void rightShiftDemo() {
        //int => size 32
        int no4 = -2147483648; //(Integer.MIN_VALUE)
        for (int i = 0; i <= 34; i++) {
            System.out.print(no4 + " ,");
            no4 = no4 >> 1;
        }
        System.out.println("");

        int no5 = 50;
        for (int i = 0; i <= 34; i++) {
            System.out.print(no5 + " ,");
            no5 = no5 >> 1;
        }
        System.out.println("");
    }

    /**
     * CW3 > Check if nth bit is set or not.
     * Eg 24 = ..0000011000 => 2nd bit is unset, 3rd bit is set
     * 14 = ..001110 => 3rd bit is set
     * @param number
     * @param n
     * @return
     */
    private boolean isNthBitSetForNumber(int number, int n) {
        return ((number >> n) & 1) == 1;
    }

    /**
     * CW4 > Set the ith bit 1 for a number
     * if ith bit is 1 keep it 1 , if 0 mame it 1
     * @param number
     * @param n
     * @return
     */
    private int setIthBitOfNumber(int number, int n) {
        return (1 << n) | number;
    }

    /**
     * CW5 > Unset the ith bit for a number
     * @param number
     * @param n
     * @return
     */
    private int unsetIthBitOfNumber(int number, int n) {
        return number & ~(1 << n);
    }

    /**
     * CW6 > Count set bits in a number
     * @param number
     * @return
     */
    private int countSetBitsInPositiveNumber(int number) {
        //Approach 1 => right shift till 0
        //        int countOfSetBits = 0;
        //        while (number != 0) {
        //            if ((number & 1) == 1) {
        //                countOfSetBits++;
        //            }
        //            number = number >> 1;
        //        }
        //        return countOfSetBits;

        //Approach 2 => n & (n-1) till 0
        int countOfSetBits = 0;
        while (number != 0) {
            countOfSetBits ++;
            number = number & (number - 1);
        }
        return countOfSetBits;
    }

    /**
     * AS1 > 2 Single Numbers
     * Given an array of numbers A , in which exactly two elements appear only once and all the other elements appear exactly twice.
     * Find the two elements that appear only once.
     * @param A
     * @return
     */
    private ArrayList<Integer> find2NosAppearingSingleTimes(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Integer ans1 = 0, ans2 = 0;
        Integer finalXor = 0;
        Integer pos = 0;
        for (int i = 0; i < A.size(); i++) {
            finalXor = finalXor ^ A.get(i);
        }
        while (finalXor != 0) {
            if (((finalXor >> pos) & 1) == 1) {
                break;
            }
            pos++;
        }

        for (int i = 0; i < A.size(); i++) {
            if (((A.get(i) >> pos) & 1) == 1) {
                ans1 = ans1 ^ A.get(i);
            } else {
                ans2 = ans2 ^ A.get(i);
            }
        }
        if (ans1 > ans2) {
            result.add(ans2);
            result.add(ans1);
        } else {
            result.add(ans1);
            result.add(ans2);
        }
        return result;
    }

    /**
     * HW1 > Smallest XOR
     * Given two integers A and B, find a number X such that A xor X is minimum possible, and the number of set bits in X equals B.
     * @param A
     * @param B
     * @return
     */
    private int solve(int A, int B) {
        return 0;
    }

    /**
     * HW2> Reverse Bits
     * Reverse the bits of an 32 bit unsigned integer A.
     * Eg 3 => 00000000000000000000000000000011 => o/p 11000000000000000000000000000000
     * @param a
     * @return
     */
    private long reverseBits(long a) {
        String resultBinary = "";
        for (int i = 0; i < 32; i++) {
            String lastBit = ((a >> i) & (1)) + "";
            resultBinary =  resultBinary + lastBit;
        }
        return Long.parseLong(resultBinary, 2);
    }
}
