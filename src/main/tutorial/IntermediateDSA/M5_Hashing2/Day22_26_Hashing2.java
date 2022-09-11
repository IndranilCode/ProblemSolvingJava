package main.tutorial.IntermediateDSA.M5_Hashing2;

import java.util.*;

public class Day22_26_Hashing2 {
    public void execute() {
        System.out.println("------------------Day 22(26) Intermediate: Hashing 2-------------------");
        System.out.println("---------------------------------ASSIGNMENT----------------------------");

        //AS1 > Subarray with given sum
        ArrayList<Integer> inputAS1_1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> resultAS1_1 = this.subArrayWithGivenSum(inputAS1_1, 5);
        System.out.print("AS1 > Subarray with given sum [1, 2, 3, 4, 5] sum = 5 => [");
        resultAS1_1.forEach(e -> System.out.print(e + ","));
        System.out.println("]");

        ArrayList<Integer> inputAS1_2 = new ArrayList<>(Arrays.asList(5, 10, 20, 100, 105));
        ArrayList<Integer> resultAS1_2 = this.subArrayWithGivenSum(inputAS1_2, 110);
        System.out.print("    > Subarray with given sum [5, 10, 20, 100, 105] sum = 110 => [");
        resultAS1_2.forEach(e -> System.out.print(e + ","));
        System.out.println("]");

        //AS2 > Diffk II
        ArrayList<Integer> inputAS2_A = new ArrayList<>(Arrays.asList(1, 5, 3));
        int inputAS2_B = 2;
        System.out.println("AS2 > Diffk II [1, 5, 3] , K = 2 => " + this.diffPossible(inputAS2_A, inputAS2_B));
        ArrayList<Integer> inputAS2_A_2 = new ArrayList<>(Arrays.asList(0));
        int inputAS2_B_2 = 0;
        System.out.println("    > Diffk II [0] , K = 0 => " + this.diffPossible(inputAS2_A_2, inputAS2_B_2));

        //AS3 > Longest Consecutive Sequence
        ArrayList<Integer> inputAS3 = new ArrayList<>(Arrays.asList(100, 4, 200, 1, 3, 2));
        System.out.println("AS3 > Longest Consecutive Sequence [100, 4, 200, 1, 3, 2] => " + this.longestConsecutive(inputAS3));

        //AS4 > Distinct Numbers in Window
        ArrayList<Integer> inputAS4 = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 3));
        ArrayList<Integer> resultAS4 = this.distinctNumbersInSlidingWindow(inputAS4, 3);
        System.out.print("AS4 > Distinct Numbers in Window [1, 2, 1, 3, 4, 3] windowSize = 3 => [");
        resultAS4.forEach(e -> System.out.print(e + ","));
        System.out.println("]");

        System.out.println("---------------------------------HOMEWORK------------------------------");

        //HW1 > Is Dictionary
        ArrayList<String> inputHW1_A1 = new ArrayList<>(Arrays.asList("hello", "scaler", "interviewbit"));
        String inputHW1_B1 = "adhbcfegskjlponmirqtxwuvzy";
        System.out.println("HW1 > Is Dictionary [hello, scaler, interviewbit] (Dictionary = adhbcfegskjlponmirqtxwuvzy) => " + this.isDictionarySorted(inputHW1_A1, inputHW1_B1));

        ArrayList<String> inputHW1_A2 = new ArrayList<>(Arrays.asList("fine", "none", "no"));
        String inputHW1_B2 = "qwertyuiopasdfghjklzxcvbnm";
        System.out.println("    > Is Dictionary [fine, none, no] (Dictionary = qwertyuiopasdfghjklzxcvbnm) => " + this.isDictionarySorted(inputHW1_A2, inputHW1_B2));

        ArrayList<String> inputHW1_A3 = new ArrayList<>(Arrays.asList("fine", "no", "none"));
        String inputHW1_B3 = "qwertyuiopasdfghjklzxcvbnm";
        System.out.println("    > Is Dictionary [fine, no, none] (Dictionary = qwertyuiopasdfghjklzxcvbnm) => " + this.isDictionarySorted(inputHW1_A3, inputHW1_B3));

        //HW2 > Pairs With Given Xor
        ArrayList<Integer> inputHW2 = new ArrayList<>(Arrays.asList(3, 6, 8, 10, 15, 50));
        System.out.println("HW2 > Pairs With Given Xor [3, 6, 8, 10, 15, 50] ; XorVal = 5 => " + this.pairWithGivenXor(inputHW2, 5));

        //HW3 > Valid Sudoku
        ArrayList<String> inputHW3 = new ArrayList<>(Arrays.asList("53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79")) ;
        System.out.println("HW3 > Valid Sudoku => " + this.isValidSudoku_bruteForce(inputHW3));
    }

    /*---------------ASSIGNMENT--------------*/

    /**
     * AS1 > Subarray with given sum
     * Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
     * If the answer does not exist return an array with a single element "-1".
     * First sub-array means the sub-array for which starting index in minimum.
     * The first argument given is the integer array A.
     * The second argument given is integer B.
     * Eg:
     * A = [1, 2, 3, 4, 5] ; B = 5
     * O/P => [2, 3]
     * @param A
     * @param B
     * @return
     */
    private ArrayList<Integer> subArrayWithGivenSum(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        int sum = 0;
        int lastPossibleIndex = A.size() - 1;
        sum = sum + A.get(0);
        while (i <= lastPossibleIndex && j <= lastPossibleIndex) {
            if (sum == B) {
                for (int index = i; index <= j; index++) {
                    result.add(A.get(index));
                }
                return result;
            } else if (sum < B) {
                j++;
                if (j > lastPossibleIndex) break;
                sum = sum + A.get(j);
            } else {
                i++;
                if (i > lastPossibleIndex) break;
                sum = sum - A.get(i-1);
            }
        }
        result.add(-1);
        return result;
    }

    /**
     * AS2 > Diffk II
     * Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
     * @param A
     * @param B
     * @return
     */
    private int diffPossible(final List<Integer> A, int B) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        //Build frequency map
        for (int i = 0; i < A.size(); i++) {
            int currentNumber = A.get(i);
            if (!frequencyMap.containsKey(currentNumber)) {
                frequencyMap.put(currentNumber, 1);
            } else {
                frequencyMap.put(currentNumber, (frequencyMap.get(currentNumber) + 1));
            }
        }

        int result = 0;
        //Process: Parse through list, pick each number , find alternate [a - b = k ; b = a - k ]
        //Search for b (alternate) in hashmap
        //If a == b, then
        for (int i = 0; i < A.size(); i++) {
            int currentNumber = A.get(i);
            int numberToSearch = currentNumber - B;

            if (currentNumber != numberToSearch) {
                // a != b ; just see if b is present in array
                if (frequencyMap.containsKey(numberToSearch)) {
                    return 1;
                }
            } else {
                // a == b; check frequency now so that same number isn't found again
                int numberToSearchFrequency = frequencyMap.get(numberToSearch);
                if (numberToSearchFrequency > 1) {
                    return 1;
                }
            }
        }
        return result;
    }

    /**
     * AS3 > Longest Consecutive Sequence
     * Given an unsorted integer array A of size N.
     * Find the length of the longest set of consecutive elements from array A.
     * Eg: A = [100, 4, 200, 1, 3, 2]
     * o/p = 4
     * @param A
     * @return
     */
    private int longestConsecutive(List<Integer> A) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < A.size(); i++) {
            numbers.add(A.get(i));
        }

        int currentNumber, nextNumber;
        int maxCount = 0, runningCount = 0;

        for (int no : numbers) {
            currentNumber = no;
            if (!numbers.contains(currentNumber-1)) {
                //Starting number of a consecutive sequence found (count current number as runningCount = 1)
                runningCount = 1;
                nextNumber = currentNumber + 1; //Build next number and continue searching for next number
                while (numbers.contains(nextNumber)) {
                    runningCount = runningCount + 1;
                    nextNumber = nextNumber + 1;
                }
                if (runningCount > maxCount) {
                    maxCount = runningCount;
                }
                runningCount = 0;
            } else {
                continue;
            }
        }
        return maxCount;
    }

    /**
     * AS4 > Distinct Numbers in Window
     * E.g
     * A = [1, 2, 1, 3, 4, 3] ; B = 3
     * o/p => [2, 3, 3, 2]
     * @param A
     * @param windowSize
     * @return
     */
    private ArrayList<Integer> distinctNumbersInSlidingWindow(ArrayList<Integer> A, int windowSize) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> frequencyInsideWindow = new HashMap<>();
        int currentNumber, currentFreq;

        //Build the 1st window and add the frequency
        for (int i = 0; i < windowSize; i++) {
            currentNumber = A.get(i);
            if (frequencyInsideWindow.containsKey(currentNumber)) {
                currentFreq = frequencyInsideWindow.get(currentNumber);
                frequencyInsideWindow.put(currentNumber, ++currentFreq);
            } else {
                frequencyInsideWindow.put(currentNumber, 1);
            }
        }
        result.add(frequencyInsideWindow.size());
        int numberToRemove, removalNumberFreq;

        for (int i = windowSize; i < A.size(); i++) {
            //To window => Add the current number & remove the 1st from older window
            currentNumber = A.get(i);
            //Add the new number to window
            if (frequencyInsideWindow.containsKey(currentNumber)) {
                currentFreq = frequencyInsideWindow.get(currentNumber);
                frequencyInsideWindow.put(currentNumber, ++currentFreq);
            } else {
                frequencyInsideWindow.put(currentNumber, 1);
            }
            //Remove older number from window
            numberToRemove = A.get(i - windowSize);
            removalNumberFreq = frequencyInsideWindow.get(numberToRemove);
            if (removalNumberFreq == 1) {
                frequencyInsideWindow.remove(numberToRemove);
            } else {
                frequencyInsideWindow.put(numberToRemove, --removalNumberFreq);
            }
            //Add unique size to result
            result.add(frequencyInsideWindow.size());
        }
        return result;
    }

    /*---------------HOMEWORK----------------*/

    /**
     * HW1 > Is Dictionary
     * Surprisingly, in an alien language, they also use English lowercase letters, but possibly in a different order.
     * The order of the alphabet is some permutation of lowercase letters.
     * Given an array of words A of size N written in the alien language, and the order of the alphabet denoted by string B of size 26,
     * return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.
     * @param A
     * @param dictionaryString
     * @return
     */
    private int isDictionarySorted(ArrayList<String> A, String dictionaryString) {
        //Build the dictionary hashmap of char - power
        HashMap<Character, Integer> dictionaryPowerMap = new HashMap<>();
        for (int i = 0; i < dictionaryString.length(); i++) {
            dictionaryPowerMap.put(dictionaryString.charAt(i), i);
        }

        for (int i = 0; i < A.size() - 1; i++) {
            String word1 = A.get(i);
            String word2 = A.get(i+1);
            Integer lenWord1 = word1.length();
            Integer lenWord2 = word2.length();
            Integer lengthToParse = lenWord1 > lenWord2 ? lenWord2 : lenWord1; //whichever is smaller size

            int positionIndex = 0;

            while (positionIndex < lengthToParse) {
                Character word1CurrentChar = word1.charAt(positionIndex);
                Character word2CurrentChar = word2.charAt(positionIndex);
                Integer word1CurrentCharPower = dictionaryPowerMap.get(word1CurrentChar);
                Integer word2CurrentCharPower = dictionaryPowerMap.get(word2CurrentChar);

                if (word1CurrentCharPower > word2CurrentCharPower) {
                    return 0;
                } else if (word1CurrentCharPower < word2CurrentCharPower) {
                    break; //break while loop
                } else {
                    //Power is ==
                    //If last position check if word2 is still left then OK else if word1 is left then sequence is incorrect
                    if (positionIndex == lengthToParse - 1) {
                        if (lenWord1 > lenWord2) {
                            return 0;
                        }
                    }

                    positionIndex++;
                }
            }
        }
        return 1;
    }

    /**
     * HW2 > Pairs With Given Xor
     * Given an integer array A containing N distinct integers.
     * Find the number of unique pairs of integers in the array whose XOR is equal to B.
     * NOTE:
     * Pair (a, b) and (b, a) is considered to be the same and should be counted once.
     * @param A
     * @param xorVal
     * @return
     */
    private int pairWithGivenXor(ArrayList<Integer> A, int xorVal) {
        //NOTE: 2 same nos xored = 0 ; a^a = 0
        //Observe => a ^ b = c ; a ^ c = b ; b ^ c = a
        int pairCount = 0;
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < A.size(); i++) {
            int noToFind = xorVal ^ A.get(i);
            if (set.contains(noToFind)) {
                pairCount++;
            }
            set.add(A.get(i));
        }
        return pairCount;
    }

    /**
     * HW3 > Valid Sudoku
     * Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx
     * @param A
     * @return
     */
    private int isValidSudoku_bruteForce(List<String> A) {
        //Each row validation
        for (int row = 0; row < A.size(); row++) {
            HashSet<Character> eachRowSet = new HashSet<>();
            for (int col = 0; col < A.get(row).length(); col++) {
                Character currentChar = A.get(row).charAt(col);
                if (currentChar >= '1'&& currentChar <= '9') {
                    if (eachRowSet.contains(currentChar)) {
                        return 0;
                    }
                    eachRowSet.add(A.get(row).charAt(col));
                }
            }
        }

        //Each column validation
        for (int col = 0; col < A.get(0).length(); col++) {
            HashSet<Character> eachColSet = new HashSet<>();
            for (int row = 0 ; row < A.size(); row++) {
                Character currentChar = A.get(row).charAt(col);
                if (currentChar >= '1'&& currentChar <= '9') {
                    if (eachColSet.contains(currentChar)) {
                        return 0;
                    }
                    eachColSet.add(A.get(row).charAt(col));
                }
            }
        }

        //Validate each box
        for (int rowBox = 0; rowBox < 3; rowBox++) {
            for (int colBox = 0; colBox < 3; colBox++) {
                HashSet<Character> eachBoxSet = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int row = 3 * rowBox + i;
                        int col = 3 * colBox + j;
                        Character currentChar = A.get(row).charAt(col);
                        if (currentChar >= '1'&& currentChar <= '9') {
                            if (eachBoxSet.contains(currentChar)) {
                                return 0;
                            }
                            eachBoxSet.add(currentChar);
                        }
                    }
                }
            }
        }
        return 1;
    }
}
