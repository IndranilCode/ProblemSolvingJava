package com.tutorial;

import com.tutorial.Arrays.Day16_ArrayAndMath;
import com.tutorial.Trees.Day27_TreesBasic1;
import com.tutorial.Trees.Day28_TreesBasic2;
import com.tutorial.oops.Example;
import com.tutorial.recursion.Day23Recursion1;
import com.tutorial.recursion.Day24Recursion2;

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

        //Day 14 - 2D Matrix
        //new Day14Matrix2D().executeMatrix2D();

        //
        //new Day16_ArrayAndMath().execute();

        //Day17 - Sorting - IntroductionToSorting
        //new Day17IntroductionToSorting().executeIntroductionToSorting();

        //Day19 - Sorting - Introduction to Hashing Libraries - 1
        //new Day19IntroductionToHashingLibraries1().executeIntroductionToHashing();

        //Day20 - Intermediate Strings
        //new Day20IntermediateStrings().executeIntermediateStrings();


        //Day23 - Recursion 1
        //new Day23Recursion1().execute();

        //Day24 - Recursion 2
        //        new Day24Recursion2().execute();



        //Day27 - Trees Basics
        //new Day27_TreesBasic1().execute();

        //----OOPS Basics----
        //new Example().Main();

        new Day28_TreesBasic2().execute();
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
