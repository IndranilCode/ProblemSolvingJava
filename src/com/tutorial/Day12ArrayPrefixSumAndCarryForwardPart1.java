package com.tutorial;

import java.security.PublicKey;

public class Day12ArrayPrefixSumAndCarryForwardPart1 {

    public void executeArrayPrefixSumAndCarryForwardPart1() {


        
        //AS4 > Special Subsequences "AG"
        String inputAS4 = "GUGPUAGAFQBMPYAGGAAOALAELGGGAOGLGEGZ";
        // String inputAS4 = "ABCGAG";
        int outputAS4 = specialSequencesAG(inputAS4);
        System.out.println("AS4 - Special Subsequences \"AG\" :" + outputAS4);
    }


    /**
     * AS4 > Special Subsequences "AG"
     * You have given a string A having Uppercase English letters. You have to find that how many times subsequence "AG" is there in the given string.
     * Example => A = "ABCGAG" => O/P => 3
     * @param a
     * @return
     */
    private int specialSequencesAG(String a) {
        int result = 0;
        int flowingPrefixCount = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            char currentChar = a.charAt(i);
            switch (currentChar) {
                case 'G':
                    flowingPrefixCount++;
                    break;
                case 'A':
                    result = result + flowingPrefixCount;
                    break;
            }
        }
        return result;
    }
}
