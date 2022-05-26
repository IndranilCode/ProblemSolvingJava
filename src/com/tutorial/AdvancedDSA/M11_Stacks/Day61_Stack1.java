package com.tutorial.AdvancedDSA.M11_Stacks;

import java.util.*;

public class Day61_Stack1 {
    public void execute() {
        System.out.println("------------ Day61_Stacks 1-----------------");
        System.out.println("---------------ASSIGNMENT-------------------");

        //AS1 > Balanced Paranthesis
        System.out.println("AS1 > Balanced Paranthesis {([])} => " + this.isBalancedParentheses("{([])}"));
        System.out.println("    > Balanced Paranthesis (){ => " + this.isBalancedParentheses("(){"));
        System.out.println("    > Balanced Paranthesis ()[] => " + this.isBalancedParentheses("()[]"));
        System.out.println("    > Balanced Paranthesis )))))))) => " + this.isBalancedParentheses("))))))))"));

        //AS2 > Double Character Trouble
        System.out.println("AS2 > Double Character Trouble (abccbc) => " + this.doubleCharacterRemoval("abccbc"));
        System.out.println("    > Double Character Trouble (aaaaa) => " + this.doubleCharacterRemoval("aaaaa"));

        //AS3 > Evaluate Expression (Reverse Polish Notation / Postfix)
        ArrayList<String> inputAS3 = new ArrayList<>(Arrays.asList("4", "13", "5", "/", "+"));
        System.out.println("AS3 > Evaluate Expression (Reverse Polish Notation / Postfix) [4, 13, 5, /, +] => " + this.evaluateReversePolishNotation_Postfix(inputAS3));

        //AS4 > Sort stack using another stack
        ArrayList<Integer> inputAS4 = new ArrayList<>(Arrays.asList(10, 2, 7, 8, 5, 1, 12));
        ArrayList<Integer> resultAS4 = this.sortStackUsingAnotherStack(inputAS4);
        System.out.print("AS4 > Sort stack using another stack [10, 2, 7, 8, 5, 1, 12] => [ ");
        resultAS4.forEach(e -> System.out.print(e.toString() + ", "));
        System.out.println(" ]");

        System.out.println("-----------------HOMEWORK-------------------");

        //HW1 > Passing game
        int inputHW1_A = 10;
        int inputHW2_B = 23;
        ArrayList<Integer> inputHW1_C = new ArrayList<>(Arrays.asList(86, 63, 60, 0, 47, 0, 99, 9, 0, 0));
        System.out.println("HW1 > Passing game - Last player => " + this.passingGame(inputHW1_A, inputHW2_B, inputHW1_C));


        //HW3 > Find Redundant Braces in expression
        System.out.println("HW3 > Find Redundant Braces in expression ((a+b)) => " + this.findRedundantBracesInExpression("((a+b))"));
        System.out.println("    > Find Redundant Braces in expression (a+b) => " + this.findRedundantBracesInExpression("(a+b)"));
        System.out.println("    > Find Redundant Braces in expression (a+(a+b)) => " + this.findRedundantBracesInExpression("(a+(a+b))"));

        //HW7 > Maximum Frequency stack
        ArrayList<ArrayList<Integer>> inputHW7 = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 5)),
                new ArrayList<>(Arrays.asList(1, 7)),
                new ArrayList<>(Arrays.asList(1, 5)),
                new ArrayList<>(Arrays.asList(1, 7)),
                new ArrayList<>(Arrays.asList(1, 4)),
                new ArrayList<>(Arrays.asList(1, 5)),
                new ArrayList<>(Arrays.asList(2, 0)),
                new ArrayList<>(Arrays.asList(2, 0)),
                new ArrayList<>(Arrays.asList(2, 0)),
                new ArrayList<>(Arrays.asList(2, 0))
        ));
        ArrayList<Integer> resultHW7 = this.maximumFrequencyStack(inputHW7);
        System.out.print("HW7 > Maximum Frequency stack => [ ");
        resultHW7.forEach(e -> System.out.print(e + ", "));
        System.out.println(" ]");
    }

    //---------------ASSIGNMENT-------------------

    /**
     * AS1 > Balanced Paranthesis
     * Eg: {([])} => 1 ; (){ => 0 ; ()[] => 1
     * @param A
     * @return
     */
    private int isBalancedParentheses(String A) {
        Stack<Character> bracketStack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            Character currentChar = A.charAt(i);
            if (currentChar.equals('(') || currentChar.equals('{') || currentChar.equals('[')) {
                bracketStack.push(currentChar);
            } else {
                if (bracketStack.size() > 0) {
                    Character lastChar = bracketStack.peek();
                    if (currentChar.equals(')') && lastChar.equals('(')) {
                        bracketStack.pop();
                    } else if (currentChar.equals('}') && lastChar.equals('{')) {
                        bracketStack.pop();
                    } else if (currentChar.equals(']') && lastChar.equals('[')) {
                        bracketStack.pop();
                    }
                } else {
                    return 0;
                }
            }
        }
        return bracketStack.size() == 0 ? 1 : 0;
    }

    /**
     * AS2 > Double Character Trouble
     * Eg: abccbc => ac ; ab => ab
     * @param A
     * @return
     */
    private String doubleCharacterRemoval(String A) {
        Stack<Character> characterStack = new Stack<>();
        Character currentChar, topChar;
        for (int i = 0; i < A.length(); i++) {
            currentChar = A.charAt(i);
            if (characterStack.size() > 0) {
                topChar = characterStack.peek();
                if (topChar.equals(currentChar)) {
                    characterStack.pop();
                } else {
                    characterStack.push(currentChar);
                }
            } else {
                characterStack.push(currentChar);
            }
        }

        StringBuilder resultBuilder = new StringBuilder();
        int stackSize = characterStack.size();
        for (int i = 0; i < stackSize; i++) {
            resultBuilder.insert(0, characterStack.pop() + "");
        }
        return resultBuilder.toString();
    }

    /**
     * AS3 > Evaluate Expression (Reverse Polish Notation / Postfix)
     * An arithmetic expression is given by a character array A of size N.
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     * Valid operators are +, -, *, /. Each character may be an integer or an operator. POSTFIX EXP
     * @param A
     * @return
     */
    private int evaluateReversePolishNotation_Postfix(ArrayList<String> A) {
        Stack<Integer> postfixEval = new Stack<>();
        for (int i = 0; i < A.size(); i++) {
            String currentSting = A.get(i);
            if (currentSting.equals("/") || currentSting.equals("*") || currentSting.equals("+") || currentSting.equals("-")) {
                int b = postfixEval.pop();
                int a = postfixEval.pop();
                int tempRes;
                if (currentSting.equals("/")) {
                    tempRes = a / b;
                } else if (currentSting.equals("*")) {
                    tempRes = a * b;
                } else if (currentSting.equals("+")) {
                    tempRes = a + b;
                } else {
                    tempRes = a - b;
                }
                postfixEval.push(tempRes);
            } else {
                postfixEval.push(Integer.parseInt(currentSting));
            }
        }
        return postfixEval.pop();
    }

    /**
     * AS4 > Sort stack using another stack
     * Given a stack of integers A, sort it using another stack.
     * Return the array of integers after sorting the stack using another stack.
     * @param A
     * @return
     */
    private ArrayList<Integer> sortStackUsingAnotherStack(ArrayList<Integer> A) {
        Stack<Integer> s1 = new Stack<>();
        for (int i = 0; i < A.size(); i++) {
            s1.add(A.get(i));
        }

        Stack<Integer> s2 = new Stack<>();
        while (!s1.isEmpty()) {
            int poppedElementS1 = s1.pop();
            int poppedElementS2;
            if (!s2.isEmpty()) {
                while (!s2.isEmpty() && s2.peek() < poppedElementS1) {
                    poppedElementS2 = s2.pop();
                    s1.push(poppedElementS2);
                }
            }
            s2.push(poppedElementS1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!s2.isEmpty()) {
            result.add(s2.pop());
        }
        return result;
    }

    //-----------------HOMEWORK-------------------

    /**
     * HW1 > Passing game
     * @param A
     * @param B
     * @param C
     * @return
     */
    private int passingGame(int A, int B, ArrayList<Integer> C) {
        Stack<Integer> passingStack = new Stack<>();
        passingStack.push(B);
        for (int i = 0; i < A; i++) {
            int currentPassCode = C.get(i);
            if (currentPassCode > 0) {
                passingStack.push(currentPassCode);
            } else {
                passingStack.pop();
            }
        }
        return passingStack.peek();
    }


    /**
     * HW3 > Find Redundant Braces in expression
     * @param A
     * @return
     */
    private int findRedundantBracesInExpression(String A) {
        Stack<Character> bracketOperatorStack = new Stack<>();
        Character currentChar;
        for (int i = 0; i < A.length(); i++) {
            currentChar = A.charAt(i);
            if (currentChar.equals('(') || currentChar.equals('+') || currentChar.equals('-')
                    ||  currentChar.equals('*') || currentChar.equals('/')) {
                bracketOperatorStack.push(currentChar);
            }
            if (currentChar.equals(')')) {
                if (bracketOperatorStack.peek().equals('(')) {
                    return 1;
                } else {
                    while (!bracketOperatorStack.peek().equals('(')) {
                        bracketOperatorStack.pop();
                    }
                    bracketOperatorStack.pop(); //pop the (
                }
            }
        }
        return 0;
    }

    /**
     * HW7 > Maximum Frequency stack
     * @param A
     * @return
     */
    private ArrayList<Integer> maximumFrequencyStack(ArrayList<ArrayList<Integer>> A) {
        Stack<Integer> freqStack = new Stack<>();
        HashMap<Integer, Integer> numberFreq = new HashMap<>();

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            int operation = A.get(i).get(0);
            int numberToOperate = A.get(i).get(1);

            if (operation == 1) {
                //1 x: push an integer x onto the stack and return -1.
                int returnValue = this.pushMock(numberToOperate, freqStack, numberFreq);
                result.add(returnValue);
            } else {
                //2 remove and return the most frequent element in the stack.
                int returnValue = this.popTopHighestFreqElement(freqStack, numberFreq);
                result.add(returnValue);
            }
        }
        return result;
    }
    private int pushMock(Integer numberToOperate, Stack<Integer> freqStack, HashMap<Integer, Integer> numberFreq) {
        freqStack.push(numberToOperate); //Push to stack
        numberFreq.put(numberToOperate, numberFreq.containsKey(numberToOperate) ? (numberFreq.get(numberToOperate) + 1) : 1 ); //Update hashmap freq
        return -1;
    }
    private int popTopHighestFreqElement(Stack<Integer> freqStack, HashMap<Integer, Integer> numberFreq) {
        int returnPop;

        int highestFreq = Integer.MIN_VALUE;
        for (int value : numberFreq.values()) {
            if (value > highestFreq) {
                highestFreq = value;
            }
        }
        //Build list of keys with highest freq
        ArrayList<Integer> keysHighestFreq = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : numberFreq.entrySet()) {
            if (entry.getValue() == highestFreq) {
                keysHighestFreq.add(entry.getKey());
            }
        }
        //Pop the number of highest freq on top
        Stack<Integer> s2 = new Stack<>();
        while (!freqStack.isEmpty() && !keysHighestFreq.contains(freqStack.peek())) {
            s2.push(freqStack.pop());
        }
        //Pop highest freq number
        returnPop = freqStack.pop();
        while (!s2.isEmpty()) {
            freqStack.push(s2.pop());
        }
        //Decrement the highest freq row from freqList
        numberFreq.put(returnPop, numberFreq.get(returnPop) - 1);
        return returnPop;
    }
}
