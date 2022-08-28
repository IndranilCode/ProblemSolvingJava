package com.tutorial;

//import com.tutorial.AdvancedDSA.M12_Queue.Day63_Queues1;
import com.tutorial.AdvancedDSA.M12_Queue.Day64_76_QueueAndDeque;
import com.tutorial.AdvancedDSA.M13_Trees.Day71_83_ProblemOnTrees;
import com.tutorial.AdvancedDSA.M19_Tries.Day72_84_Tries;
import com.tutorial.IntermediateDSA.Day39_ContestDiscussion;
import com.tutorial.IntermediateDSA.M5_Hashing2.Day22_26_Hashing2;
import com.tutorial.IntermediateDSA.M_SubsequenceAndSubsets.Day29_35_SubsequencesAndSubsets;
import com.tutorial.IntermediateDSA.M_Trees.Day27_34_TreesBasic1;
import com.tutorial.IntermediateDSA.M_Trees.Day28_TreesBasic2;

public class Main {

    public static void main(String[] args) {
        //Intermediate
        //System.out.println("----------------INTERMEDIATE-----------------");
        //new Day21_Hashing1().execute();
        //new Day22_26_Hashing2().execute();

        //System.out.println();
        //new Day33_Arrays1().execute();

        //new Day25_30_LinkedListBasics().execute();

        //Tree Basics
        //new Day27_34_TreesBasic1().execute();
        new Day28_TreesBasic2().execute();

        //Subsequence & Subsets
        //new Day29_35_SubsequencesAndSubsets().execute();


        //Contest
        //new Day39_ContestDiscussion().execute();

	// write your code here

        //Day 4 - (18 Oct) - Introduction to Problem Solving
        //new Day4IntroductionToProblemSolving().executeIntroductionToProblemSolving();

        //M2 - Bit manipulations
        //Day 6 - Intro to number system & bit manipulation
        //new Day6_IntroToNumberSystemAndBitManipulation().execute();
        //new Day7_BitManipulations().execute();

        //2. Add Binary String [a = "100" , b = "11", a+b = "111"]
        //System.out.println(addBinary("1000", "10"));

        //Day9 - TimeComplexity2
        //new TimeComplexity2().executeTimeComplexity2();

        //Day10 - ArraysDynamicArrays
        //new Day10ArraysDynamicArrays().execute();

        //Day12 -  Array - Prefix sum and carry forward (Day 1)
        //new Day12ArrayPrefixSumAndCarryForwardPart1().executeArrayPrefixSumAndCarryForwardPart1();

        //Day13 - Array - Prefix sum and carry forward (Day 2)
        //new Day13ArrayPrefixSumAndCarryForwardPart2().execute();

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


        //Day25 - Link List
        //new Day25_LinkListBasics().execute();



        //Day27 - Trees Basics
        //new Day27_TreesBasic1().execute();

        //----OOPS Basics----
        //new Example().Main();

        //new Day28_TreesBasic2().execute();

        //-------------Advanced DSA - Arrays------------------
        //Day33_Arrays1
        //new Day33_Arrays1().execute();

        //Day34_Arrays2
        //new Day34_Arrays2().execute();

        //Day35_Arrays3
        //new Day35_Arrays3().execute();

        //-------------Advanced DSA - Maths------------------
        //new Day37_GCD().execute();
        //new Day38_PrimeNumbers().execute();

        //new Day39_Combinatorics().execute();

        //-------------Advanced DSA - Bit Manipulations------------------
        //new Day40_BitManipulation1().execute();

        //------------
        //new Day42_Recursion1().execute();

        //-------------Sorting-------------------
        //new Day45_Sorting1().execute();
        //new Day46_Sorting2().execute();
        //new Day47_Sorting3().execute();

        //-------------Binary Search-------------
        //new Day48_BinarySearch1().execute();
        //new Day55_SortingSearchingFollowUp().execute();

        //-------------2 Pointers-------------
        //new Day51_2Pointer().execute();

        //-------------Hashing-------------
        //new Day52_Hashing1().execute();
        //new Day53_Hashing2().execute();

        //Strings
        //new Day56_StringPatternMatching().execute();

        //LinkList
        //new Day58_LinkList1().execute();
        //new Day59_71_LinkList2().execute();
        //new Day60_72_LinkList3().execute();

        //Stacks
        //new Day61_Stack1().execute();
        //new Day62_Stack2().execute();

        //Queue
        //new Day63_Queues1().execute();
        //new Day64_76_QueueAndDeque().execute();

        //Trees
        //new Day65_Trees1().execute();
        //new Day66_Trees2().execute();

        //new I1_Cisco().execute();
        //new Day71_83_ProblemOnTrees().execute();

        //BST
        //        new Day68_BST1().execute();
        //new Day69_BST2().execute();
        //new Day70_LCA_BST().execute();


        //Graphs
        //new Day87_100_Graphs1().execute();
        //new Day88_101_Graphs2().execute();
        //new Day88_Graphs2().execute();

        //Tries
        //new Day72_84_Tries().execute();
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
