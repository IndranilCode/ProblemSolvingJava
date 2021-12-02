package com.tutorial;

import java.util.ArrayList;
import java.util.Arrays;

public class Day20IntermediateStrings {
    public void executeIntermediateStrings() {
        //AS3 > tolower()
        ArrayList<Character> inputAS3 = new ArrayList<>(Arrays.asList('S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y'));
        ArrayList<Character> outputAS3 = to_lower(inputAS3);
        System.out.print("AS3 - tolower :");
        outputAS3.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println("");

        //AS4 > toupper()
        ArrayList<Character> inputAS4 = new ArrayList<>(Arrays.asList('S', 'c', 'a', 'L', 'e', 'R', '#', '2', '0', '2', '0'));
        ArrayList<Character> outputAS4 = to_upper(inputAS3);
        System.out.print("AS4 - to_upper :");
        outputAS4.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println("");
    }

    /**
     * AS3 > tolower() [EASY]
     * Convert each charater of A into lowercase character if it exists. If the lowercase of a character does not exist, it remains unmodified.
     * The uppercase letters from A to Z is converted to lowercase letters from a to z respectively.
     * Example => A = ['S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y']
     * Output => ['s', 'c', 'a', 'l', 'e', 'r', 'a', 'c', 'a', 'd', 'e', 'm', 'y']
     * @param A
     * @return
     */
    private ArrayList<Character> to_lower(ArrayList<Character> A) {
        ArrayList<Character> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) >= 'A' && A.get(i) <= 'Z') {
                result.add((char)(A.get(i) + 32));
            } else {
                result.add(A.get(i));
            }
        }
        return result;
    }

    /**
     * AS4 > toupper() [EASY]
     * Convert each charater of A into Uppercase character if it exists. If the Uppercase of a character does not exist, it remains unmodified.
     * The lowercase letters from a to z is converted to uppercase letters from A to Z respectively.
     * Example => A = ['S', 'c', 'a', 'L', 'e', 'R', '#', '2', '0', '2', '0']
     * Output => ['S', 'C', 'A', 'L', 'E', 'R', '#', '2', '0', '2', '0']
     * @param A
     * @return
     */
    private ArrayList<Character> to_upper(ArrayList<Character> A) {
        ArrayList<Character> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) >= 'a' && A.get(i) <= 'z') {
                result.add((char)(A.get(i) - 32));
            } else {
                result.add(A.get(i));
            }
        }
        return result;
    }
}
