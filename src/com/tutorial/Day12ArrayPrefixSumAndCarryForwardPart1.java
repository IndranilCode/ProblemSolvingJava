package com.tutorial;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;

public class Day12ArrayPrefixSumAndCarryForwardPart1 {

    public void executeArrayPrefixSumAndCarryForwardPart1() {
        //AS1 > Beggars Outside Temple
        ArrayList<ArrayList<Integer>> inputAS1 = new ArrayList<>();
        inputAS1.add(new ArrayList<>(Arrays.asList(1, 2, 10)));
        inputAS1.add(new ArrayList<>(Arrays.asList(2, 3, 20)));
        inputAS1.add(new ArrayList<>(Arrays.asList(2, 5, 25)));
        ArrayList<Integer> outputAS1 = beggarsOutsideTemple(5, inputAS1);
        System.out.print("AS1 - Beggars Outside Temple :");
        outputAS1.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println("");
        
        //AS4 > Special Subsequences "AG"
        String inputAS4 = "GUGPUAGAFQBMPYAGGAAOALAELGGGAOGLGEGZ";
        // String inputAS4 = "ABCGAG";
        int outputAS4 = specialSequencesAG(inputAS4);
        System.out.println("AS4 - Special Subsequences \"AG\" :" + outputAS4);
    }

    /**
     * AS1 > Beggars Outside Temple [Technique - prefix sum at end]
     * Input: N = 5, D = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
     * Return: [10, 55, 45, 25, 25]
     * Explanation:
     * => First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]
     * => Second devotee donated 20 coins to beggars ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]
     * => Third devotee donated 25 coins to beggars ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]
     * @param A
     * @param B
     * @return
     */
    private ArrayList<Integer> beggarsOutsideTemple(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> finalResult = new ArrayList<>();
        Integer[] result = new Integer[A];
        for (int i = 0; i < A; i++) {
            result[i] = 0;
        }
        for (int query = 0; query <= B.size()-1; query++) {
            result[B.get(query).get(0) - 1] = (result[B.get(query).get(0) - 1] != null ? result[B.get(query).get(0) - 1] : 0) + B.get(query).get(2);
            if (B.get(query).get(1) < A) {
                result[(B.get(query).get(1))] = (result[(B.get(query).get(1))] != null ? result[(B.get(query).get(1))] : 0) + (-B.get(query).get(2));
            }
        }
        for (int i = 0; i < A; i++) {
            if (i == 0) {
                finalResult.add(result[i]);
            } else {
                finalResult.add(finalResult.get(i - 1) + (result[i] != null ? result[i] : 0));
            }
        }
        return finalResult;
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
