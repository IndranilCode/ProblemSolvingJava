package com.tutorial.AdvancedDSA.M11_Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Day62_Stack2 {
    public void execute() {
        System.out.println("------------ Day62_Stacks 2-----------------");
        System.out.println("---------------ASSIGNMENT-------------------");

        //AS1 > Evaluate Expression (Reverse Polish Notation - Postfix)
        ArrayList<String> inputAS3 = new ArrayList<>(Arrays.asList("4", "13", "5", "/", "+"));
        System.out.println("AS3 > Evaluate Expression (Reverse Polish Notation / Postfix) [4, 13, 5, /, +] => " + this.evaluateReversePolishNotation_Postfix(inputAS3));

    }

    /**
     * AS1 > Evaluate Expression (Reverse Polish Notation - Postfix)
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
}
