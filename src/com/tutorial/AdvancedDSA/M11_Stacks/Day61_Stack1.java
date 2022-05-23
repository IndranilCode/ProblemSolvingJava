package com.tutorial.AdvancedDSA.M11_Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Day61_Stack1 {
    public void execute() {
        System.out.println("------------ Day61_Stacks 1-----------------");
        System.out.println("---------------ASSIGNMENT-------------------");

        //AS1 > Balanced Paranthesis
        System.out.println("AS1 > Balanced Paranthesis {([])} => " + this.isBalancedParentheses("{([])}"));
        System.out.println("    > Balanced Paranthesis (){ => " + this.isBalancedParentheses("(){"));
        System.out.println("    > Balanced Paranthesis ()[] => " + this.isBalancedParentheses("()[]"));
        System.out.println("    > Balanced Paranthesis )))))))) => " + this.isBalancedParentheses("))))))))"));

        //AS3 > Evaluate Expression (Reverse Polish Notation / Postfix)
        ArrayList<String> inputAS3 = new ArrayList<>(Arrays.asList("4", "13", "5", "/", "+"));
        System.out.println("AS3 > Evaluate Expression (Reverse Polish Notation / Postfix) [4, 13, 5, /, +] => " + this.evaluateReversePolishNotation_Postfix(inputAS3));


        System.out.println("-----------------HOMEWORK-------------------");

        //HW1 > Passing game
        int inputHW1_A = 10;
        int inputHW2_B = 23;
        ArrayList<Integer> inputHW1_C = new ArrayList<>(Arrays.asList(86, 63, 60, 0, 47, 0, 99, 9, 0, 0));
        System.out.println("HW1 > Passing game - Last player => " + this.passingGame(inputHW1_A, inputHW2_B, inputHW1_C));
    }

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

//    private ArrayList<Integer> sortStackUsingAnotherStack(ArrayList<Integer> A) {
//        Stack<Integer> s1 = new Stack<>();
//        for (int i = 0; i < A.size(); i++) {
//            s1.add(A.get(i));
//        }
//
//        Stack<Integer> s2 = new Stack<>();
//        //        int singleExecutionElement =
//        while () {
//            if (s1.peek())
//        }
//    }

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
}
