package com.tutorial;

import com.tutorial.oops.Example;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //Day 4 - (18 Oct) - Introduction to Problem Solving
        //new Day4IntroductionToProblemSolving().executeIntroductionToProblemSolving();

        //2. Add Binary String [a = "100" , b = "11", a+b = "111"]
        //System.out.println(addBinary("1000", "10"));

        //Day9 - TimeComplexity2
        //new TimeComplexity2().executeTimeComplexity2();

        //Day10 - ArraysDynamicArrays
        //new ArraysDynamicArrays().executeArraysDynamicArrays();

        //Day12 -  Array - Prefix sum and carry forward (Day 1)
        //new Day12ArrayPrefixSumAndCarryForwardPart1().executeArrayPrefixSumAndCarryForwardPart1();

        //Day13 - Array - Prefix sum and carry forward (Day 2)
        //new Day13ArrayPrefixSumAndCarryForwardPart2().executeArrayPrefixSumAndCarryForwardPart2();

        //Day17 - Sorting - IntroductionToSorting
        new Day17IntroductionToSorting().executeIntroductionToSorting();

        //----OOPS Basics----
        //new Example().Main();
    }


    public static String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int higherlength = Math.max(aLen, bLen);
        int lowerLength = Math.min(aLen, bLen);

        String preConnectString = "";

        for (int i = 0; i< (higherlength-lowerLength); i++) {
            preConnectString = preConnectString + "0";
        }
        if (aLen < higherlength) {
            a = preConnectString + a;
        }
        if (bLen < higherlength) {
            b = preConnectString + b;
        }

        String result = "";

        for(int i = higherlength-1 ; i >= 0; i--) {
            int aBit = Integer.parseInt(a.substring(i,i+1));
            int bBit = Integer.parseInt(b.substring(i,i+1));
            result = ((int)aBit | (int)bBit) + result;
        }
        return result;
    }
}
