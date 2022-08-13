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
    }

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

}