package com.tutorial.AdvancedDSA.M19_Tries;

import java.util.ArrayList;
import java.util.Arrays;

public class Day72_84_Tries {
    public void execute() {
        System.out.println("--------------Day 72(84) Tries-------------------");
        System.out.println("--------------------ASSIGNMENT-------------------");

        //AS1 > Spelling Checker
        ArrayList<String> inputAS1_A = new ArrayList<>(Arrays.asList("hat", "cat", "rat"));
        ArrayList<String> inputAS1_B = new ArrayList<>(Arrays.asList("cat", "ball"));
        ArrayList<Integer> resultAS1 = this.spellingChecker(inputAS1_A, inputAS1_B);
        System.out.print("AS1 > Spelling Checker A : [hat, cat, rat] B : [cat, ball] => [");
        resultAS1.forEach(e -> System.out.print(e + ","));
        System.out.println("]");

        //AS3 > Shortest Unique Prefix
        ArrayList<String> inputAS3 = new ArrayList<>(Arrays.asList("zebra", "dog", "duck", "dove"));
        ArrayList<String> resultAS3 = this.shortestUniquePrefix(inputAS3);
        System.out.print("AS3 > Shortest Unique Prefix [zebra, dog, duck, dove] => [");
        resultAS3.forEach(e -> System.out.print(e + ","));
        System.out.println("]");

        ArrayList<Integer> inputAS4 = new ArrayList<>(Arrays.asList(5, 17, 100, 11));
        int resultAS4 = this.maximumXor(inputAS4);
        System.out.println("AS4 > Maximum XOR [5, 17, 100, 11] => " + resultAS4);

        System.out.println("--------------------HOMEWORK---------------------");

        ArrayList<Integer> inputHW1_A = new ArrayList<>(Arrays.asList(0, 0, 1, 1));
        ArrayList<String> inputHW1_B = new ArrayList<>(Arrays.asList("hack", "hacker", "hac", "hak"));
        ArrayList<Integer> resultHW1 = this.contactFinder(inputHW1_A, inputHW1_B);
        System.out.print("HW1 > Contact Finder A:[0, 0, 1, 1] B: [hack, hacker, hac, hak] => [");
        resultHW1.forEach(e -> System.out.print(e + ","));
        System.out.println("]");

    }

    /*---------------ASSIGNMENT--------------*/

    /**
     * AS1 > Spelling Checker
     * Given an array of words A (dictionary) and another array B (which contain some words).
     * Return the array (of length |B|) as the answer; 1 - the word is present in the dictionary ; 0 - it is not present.
     * Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if not.
     * @param A
     * @param B
     * @return
     */
    private ArrayList<Integer> spellingChecker(ArrayList<String> A, ArrayList<String> B) {
        TriesNode root = new TriesNode();

        //Add original list(A) into tries
        for (int i = 0; i < A.size(); i++) {
            this.insertToTries(root, A.get(i));
        }

        ArrayList<Integer> isWordPresent = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            isWordPresent.add(this.searchWordInTries(root, B.get(i)));
        }
        return isWordPresent;
    }
    private void insertToTries(TriesNode root, String word) {
        TriesNode current = root;
        for (int i = 0; i < word.length(); i++) {
            Character currentChar = word.charAt(i);
            if (!current.children.containsKey(currentChar)) {
                TriesNode newNode = new TriesNode(currentChar);
                current.children.put(currentChar, newNode);
            }
            current = current.children.get(currentChar);
        }
        current.isEnd = true;
    }
    private int searchWordInTries(TriesNode root, String word) {
        TriesNode current = root;
        for (int i = 0; i < word.length(); i++) {
            Character currentChar = word.charAt(i);
            if (!current.children.containsKey(currentChar)) {
                return 0;
            }
            current = current.children.get(currentChar);
        }
        return current.isEnd ? 1 : 0;
    }

    /**
     * AS3 > Shortest Unique Prefix
     * Given a list of N words, find the shortest unique prefix to represent each word in the list.
     * NOTE: Assume that no word is the prefix of another. In other words, the representation is always possible
     * I/P => A = ["zebra", "dog", "duck", "dove"]
     * O/P => ["z", "dog", "du", "dov"]
     * @param A
     * @return
     */
    private ArrayList<String> shortestUniquePrefix(ArrayList<String> A) {
        TriesNode root = new TriesNode();
        //Add the words to the tries
        for (int i = 0; i < A.size(); i++) {
            this.insertToTriesCount(root, A.get(i));
        }

        ArrayList<String> prefixes = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            prefixes.add(this.getPrefixFromTries(root, A.get(i)));
        }
        return prefixes;
    }
    private void insertToTriesCount(TriesNode root, String word) {
        TriesNode current = root;
        for (int i = 0; i < word.length(); i++) {
            Character currentChar = word.charAt(i);
            if (!current.children.containsKey(currentChar)) {
                //Child node doesn't exist
                TriesNode newNode = new TriesNode(currentChar);
                current.children.put(currentChar, newNode);
            } else {
                //Child node exists - find child-node + increase count
                TriesNode targetNode = current.children.get(currentChar);
                targetNode.count = targetNode.count + 1;
                current.children.put(currentChar, targetNode);
            }
            current = current.children.get(currentChar);
        }
        current.isEnd = true;
    }
    private String getPrefixFromTries(TriesNode root, String word) {
        TriesNode current = root;
        StringBuilder prefixBuilder = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            Character currentChar = word.charAt(i);
            TriesNode foundChild = current.children.get(currentChar);
            prefixBuilder.append(currentChar);
            if (foundChild.count == 1) {
                break;
            }
            current = current.children.get(currentChar);
        }
        return prefixBuilder.toString();
    }

    /**
     * AS4 > Maximum XOR
     * @param A
     * @return
     */
    private int maximumXor(ArrayList<Integer> A) {
        TriesNodeBit root = new TriesNodeBit();

        //Insert 1st number into tries
        this.insertNumberToTries(root, A.get(0));

        int maxAns = Integer.MIN_VALUE;
        for (int i = 1; i < A.size(); i++) {
            Integer currentNumber = A.get(i);
            int xorAnswer = this.findXor(root, currentNumber);
            if (xorAnswer > maxAns) {
                maxAns = xorAnswer;
            }
            this.insertNumberToTries(root, currentNumber);
        }
        return maxAns;
    }
    private void insertNumberToTries(TriesNodeBit root, int number) {
        //Add MST->LSB bits into tries
        TriesNodeBit current = root;

        for (int i = 31; i >= 0; i--) {
            int currentBitSetting = (1 << i) & number;
            int currentPositionBitValue = currentBitSetting > 0 ? 1 : 0;

            if (!current.children.containsKey(currentPositionBitValue)) {
                TriesNodeBit newNode = new TriesNodeBit(currentPositionBitValue);
                current.children.put(currentPositionBitValue, newNode);
            }
            current = current.children.get(currentPositionBitValue);
        }
        current.isEnd = true;
    }
    private int findXor(TriesNodeBit root, int number) {
        TriesNodeBit current = root;
        int answer = 0;

        for (int i = 31; i >= 0; i--) {
            int currentBitSetting = (1 << i) & number;
            int currentPositionBitValue = currentBitSetting > 0 ? 1 : 0;
            int oppositeBitValue = currentPositionBitValue ^ 1;
            if (current.children.containsKey(oppositeBitValue)) {
                answer = answer + (1 << i);
                current = current.children.get(oppositeBitValue);
            } else {
                current = current.children.get(currentPositionBitValue);
            }
        }
        return answer;
    }

    /*---------------HOMEWORK--------------*/

    /**
     * HW1 > Contact Finder
     * A = [0, 0, 1, 1]
     * B = ["hack", "hacker", "hac", "hak"]
     * o/p => [2, 0]
     *
     * A = [0, 1]
     * B = ["abcde", "abc"]
     * o/p => [1]
     * @param A
     * @param B
     * @return
     */
    private ArrayList<Integer> contactFinder(ArrayList<Integer> A, ArrayList<String> B) {
        int n = A.size();
        TriesNode root = new TriesNode();

        ArrayList<Integer> isSubContactAvailable = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int operation = A.get(i);
            String word = B.get(i);

            if (operation == 0) {
                //Add to tries
                this.addContactToTries(root, word);
            } else {
                //Find if word is present
                isSubContactAvailable.add(this.isSubWordInTries(root, word));
            }
        }
        return isSubContactAvailable;
    }
    private void addContactToTries(TriesNode root, String word) {
        TriesNode current = root;
        for (int i = 0; i < word.length(); i++) {
            Character currentChar = word.charAt(i);
            if (!current.children.containsKey(currentChar)) {
                TriesNode newNode = new TriesNode(currentChar);
                current.children.put(currentChar, newNode);
            } else {
                TriesNode foundNode = current.children.get(currentChar);
                foundNode.count = foundNode.count + 1;
                current.children.put(currentChar, foundNode);
            }
            current = current.children.get(currentChar);
        }
        current.isEnd = true;
    }
    private int isSubWordInTries(TriesNode root, String subWord) {
        TriesNode current = root;
        int numberOfWords = 0;
        for (int i = 0; i < subWord.length(); i++) {
            Character currentChar = subWord.charAt(i);
            if (current.children == null) {
                return 0;
            }
            if (!current.children.containsKey(currentChar)) {
                return 0;
            }
            if (i == (subWord.length() - 1)) {
                numberOfWords = current.children.get(currentChar).count;
            }
            current = current.children.get(currentChar);
        }
        return numberOfWords;
    }

//    private String modifiedSearch(ArrayList<String> A, ArrayList<String> B) {
//        TriesNode root = new TriesNode();
//
//        //Insert source words to tries
//        for (int i = 0; i < A.size(); i++) {
//            this.addToTriesLibrary_modifiedSearch(root, A.get(i));
//        }
//
//
//    }
//    private void addToTriesLibrary_modifiedSearch(TriesNode root, String word) {
//        TriesNode current = root;
//        for (int i = 0; i < word.length(); i++) {
//            Character currentChar = word.charAt(i);
//            if (!current.children.containsKey(currentChar)) {
//                TriesNode newNode = new TriesNode(currentChar);
//                current.children.put(currentChar, newNode);
//            }
//            current = current.children.get(currentChar);
//        }
//        current.isEnd = true;
//    }
//    private int isWordInTriesAfter1Change(TriesNode root, String word) {
//        boolean isChangeDone = false;
//        TriesNode current = root;
//        for (int i = 0; i < word.length(); i++) {
//            Character currentChar = word.charAt(i);
//
//            if (!isChangeDone && current.children.containsKey(currentChar)) {
//                //No change done yet + character found => Proceed
//                current = current.children.get(currentChar);
//            } else if (!isChangeDone && !current.children.containsKey(currentChar)){
//                //No change done yet + character not found => Mark isChangeDone & proceed
//            }
//        }
//    }
}
