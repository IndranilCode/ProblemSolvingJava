package com.tutorial;

import java.util.ArrayList;
import java.util.Arrays;

public class Day20IntermediateStrings {
    public void executeIntermediateStrings() {
        //AS1 > reverseTheString()
        String inputAS1 = "the sky is blue";
        String outputAS1 = reverseTheString(inputAS1);
        System.out.println("AS1 - reverseTheString :" + outputAS1);

        //AS2 > simpleReverse()
        String inputAS2 = "the sky is blue";
        String outputAS2 = simpleReverse(inputAS2);
        System.out.println("AS2 - simpleReverse :" + outputAS2);

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

        //AS5 > isAlnum()
        ArrayList<Character> inputAS5 = new ArrayList<>(Arrays.asList('S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'));
        int outputAS5 = isalnum(inputAS5);
        System.out.println("AS5 - isalnum :" + outputAS5);

        //AS6 > Isalpha()
        ArrayList<Character> inputAS6 = new ArrayList<>(Arrays.asList('S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'));
        int outputAS6 = isalpha(inputAS6);
        System.out.println("AS6 - isalpha :" + outputAS6);




        //HW1 > Amazing Subarrays
        String inputHW1 = "ABEC";
        int outputHW1 = amazingSubarrays(inputHW1);
        System.out.println("HW1 - Amazing Subarrays :" + outputHW1);

        //HW2 > Count Occurrences - bob
        String inputHW2 = "bobob";
        int outputHW2 = countOccurrences(inputHW2);
        System.out.println("HW2 - Count Occurrences - bob :" + outputHW2);

        //HW4 > String operations
        String inputHW4 = "AbcaZeoB";
        String outputHW4 = stringOperations(inputHW4);
        System.out.println("HW4 - String operations :" + outputHW4);

        //HW5 > Longest Common Prefix
        ArrayList<String> inputHW5 = new ArrayList<>(Arrays.asList("abcdefgh", "aefghijk", "abcefgh"));
        String outputHW5 = longestCommonPrefix(inputHW5);
        System.out.println("HW5 - Longest Common Prefix :" + outputHW5);
    }


    /**
     * AS1 > Reverse the String [CONCEPT]- Double reverse
     * Given a string A of size N. Return the string A after reversing the string word by word.
     * Example => A = "the sky is blue" => o/p => "blue is sky the"
     * @param A
     * @return
     */
    private String reverseTheString(String A) {
        String totalReversedString = reverseAnyString(A);
        totalReversedString = totalReversedString + " ";
        StringBuilder builder = new StringBuilder();
        StringBuilder currentWordBuilder = new StringBuilder();
        for (int i = 0; i < totalReversedString.length(); i++) {
            if (totalReversedString.charAt(i) == ' ') {
                String unreversedWord = reverseAnyString(currentWordBuilder.toString());
                builder.append(unreversedWord);
                builder.append(" ");
                currentWordBuilder = new StringBuilder();
            } else {
                currentWordBuilder.append(totalReversedString.charAt(i));
            }
        }
        return builder.toString().trim();
    }

    private String reverseAnyString(String originalString) {
        StringBuilder builder = new StringBuilder();
        for (int i = originalString.length() - 1; i >= 0; i--) {
            Character currentChar = originalString.charAt(i);
            builder.append(currentChar);
        }
        return builder.toString();
    }

    /**
     * AS2 > Simple Reverse [EASY]
     * Given a string A, you are asked to reverse the string and return the reversed string.
     * Example => A = "scaler" => o/p => "relacs"
     * @param A
     * @return
     */
    private String simpleReverse(String A) {
        StringBuilder builder = new StringBuilder();
        for (int i = A.length() - 1; i >= 0; i--) {
            builder.append(A.charAt(i));
        }
        return builder.toString();
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

    /**
     * AS5 > Isalnum() [EASY]
     * Character array A. Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z and 0-9), else return 0.
     * Example => A = ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0'] => 1
     * A = ['S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'] => 0
     * @param A
     * @return
     */
    private int isalnum(ArrayList<Character> A) {
        int isAlnum = 1;
        for (int i = 0; i < A.size(); i++) {
            Character eachChar = A.get(i);
            if (!((eachChar >= 'A' && eachChar <= 'Z') || (eachChar >= 'a' && eachChar <= 'z') || (eachChar >= '0' && eachChar <= '9'))) {
                isAlnum = 0;
                break;
            }
        }
        return isAlnum;
    }

    /**
     * AS6 > Isalpha() [EASY]
     * Character array A. Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z), else return 0.
     * @param A
     * @return
     */
    private int isalpha(ArrayList<Character> A) {
        int isAlpha = 1;
        for (int i = 0; i < A.size(); i++) {
            Character eachChar = A.get(i);
            if (!((eachChar >= 'A' && eachChar <= 'Z') || (eachChar >= 'a' && eachChar <= 'z'))) {
                isAlpha = 0;
                break;
            }
        }
        return isAlpha;
    }




    /**
     * HW1 > Amazing Subarrays [EASY]
     * Given a string S, and you have to find all the amazing substrings of S. Return a single integer X mod 10003.
     * Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
     * @param A
     * @return
     */
    private int amazingSubarrays(String A) {
        int rollingCount = 0;
        int combinations = 0;
        for (int i = A.length() - 1; i >= 0; i--) {
            Character currentChar = A.charAt(i);
            rollingCount++;
            if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u'
                || currentChar == 'A' || currentChar == 'E' || currentChar == 'I' || currentChar == 'O' || currentChar == 'U') {
                combinations = combinations + rollingCount;
            }
        }
        return combinations % 10003;
    }

    /**
     * HW2 > Count Occurrences [EASY]
     * Find number of occurrences of bob in the string A consisting of lowercase english alphabets.
     * @param A
     * @return
     */
    private int countOccurrences(String A) {
        String searchToString = "bob";
        int matchCount = 0;
        for (int i = 0; i < (A.length() - 2); i++) {
            Boolean isMatch = true;
            int subwordPosition = 0;
            while (subwordPosition < 3) {
                if (A.charAt(i + subwordPosition) != searchToString.charAt(subwordPosition)) {
                    isMatch = false;
                    break;
                }
                subwordPosition++;
            }
            if (isMatch) {
                matchCount++;
            }
        }
        return matchCount;
    }

    /**
     * HW3 > Change character
     * Given a string A of size N consisting of lowercase alphabets. You can change at most B characters in the given
     * string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.
     * Find the minimum number of distinct characters in the resulting string.
     * Example => A = "abcabbccd", B = 3 => o/p => 2 ; We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
     * So the minimum number of distinct character will be 2.
     * @param A
     * @param B
     * @return
     */
    private int changeCharacter(String A, int B) {
        return 0;
    }

    /**
     * HW4 > String operations [EASY]
     * Concatenate the string with itself -> Delete all the uppercase letters -> Replace each vowel with '#'.
     * Example => A="AbcaZeoB" => o/p "bc###bc###"
     * @param A
     * @return
     */
    private String stringOperations(String A) {
        StringBuilder doubleStringBuilder = new StringBuilder();
        doubleStringBuilder.append(A);
        doubleStringBuilder.append(A);

        String doubleString = doubleStringBuilder.toString();
        StringBuilder uppercaseRemovedBuilder = new StringBuilder();
        for (int i = 0; i < doubleString.length(); i++) {
            if (!(doubleString.charAt(i) >= 'A' && doubleString.charAt(i) <= 'Z')) {
                uppercaseRemovedBuilder.append(doubleString.charAt(i));
            }
        }

        String capsRemovedString = uppercaseRemovedBuilder.toString();
        StringBuilder finalStringBuilder = new StringBuilder();
        for (int i = 0; i < capsRemovedString.length(); i++) {
            if (capsRemovedString.charAt(i) == 'a' || capsRemovedString.charAt(i) == 'e' || capsRemovedString.charAt(i) == 'i' ||
                    capsRemovedString.charAt(i) == 'o' || capsRemovedString.charAt(i) == 'u') {
                finalStringBuilder.append('#');
            } else {
                finalStringBuilder.append(capsRemovedString.charAt(i));
            }
        }
        return finalStringBuilder.toString();
    }

    /**
     * HW5 > Longest Common Prefix [MEDIUM]
     * Given the array of strings A, you need to find the longest string S which is the prefix of ALL the strings in the array.
     * Example => A = ["abcdefgh", "aefghijk", "abcefgh"] o/p => "a"
     * @param A
     * @return
     */
    private String longestCommonPrefix(ArrayList<String> A) {
        int minStringLength = Integer.MAX_VALUE;
        String minLengthString = "";
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i).length() < minStringLength) {
                minStringLength = A.get(i).length();
                minLengthString = A.get(i);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < minStringLength; i++) {
            Character referenceChar = minLengthString.charAt(i);
            Boolean isAllMatch = true;
            for (int j = 0; j < A.size(); j++) {
                if (A.get(j).charAt(i) != referenceChar) {
                    isAllMatch = false;
                    break;
                }
            }
            if (isAllMatch) {
                result.append(referenceChar);
            } else {
                break;
            }
        }
        return result.toString();
    }
}
