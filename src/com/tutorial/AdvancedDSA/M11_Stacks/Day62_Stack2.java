package com.tutorial.AdvancedDSA.M11_Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Day62_Stack2 {
    public void execute() {
        System.out.println("------------ Day62_Stacks 2-----------------");
        System.out.println("---------------CLASSWORK--------------------");

        //CW1 > Nearest smaller integer - Left (Brute Force)
        ArrayList<Integer> inputCW1 = new ArrayList<>(Arrays.asList(4, 5, 2, 10, 8, 2));
        System.out.print("CW1 > Nearest smaller integer - Left (Brute Force) [4, 5, 2, 10, 8, 2] => [ ");
        ArrayList<Integer> resultCW1_nearestSmallerInteger_LeftBF = this.nearestSmallestIntegerLeft_BruteForce(inputCW1);
        resultCW1_nearestSmallerInteger_LeftBF.forEach(e -> System.out.print(e + ", "));
        System.out.println(" ]");

        System.out.print("CW2 > Nearest smaller integer - Left (Stack) [4, 5, 2, 10, 8, 2] => [ ");
        ArrayList<Integer> resultCW1_nearestSmallerInteger_Left = this.nearestSmallestIntegerLeft_Stacks(inputCW1);
        resultCW1_nearestSmallerInteger_Left.forEach(e -> System.out.print(e + ", "));
        System.out.println(" ]");

        System.out.println("---------------ASSIGNMENT-------------------");

        //AS1 > Evaluate Expression (Reverse Polish Notation - Postfix)
        ArrayList<String> inputAS3 = new ArrayList<>(Arrays.asList("4", "13", "5", "/", "+"));
        System.out.println("AS3 > Evaluate Expression (Reverse Polish Notation / Postfix) [4, 13, 5, /, +] => " + this.evaluateReversePolishNotation_Postfix(inputAS3));

        //AS2 >
    }

    //---------------CLASSWORK--------------------

    /**
     * CW1 > Nearest smaller integer - Left (Brute Force)
     * @param A
     * @return
     */
    private ArrayList<Integer> nearestSmallestIntegerLeft_BruteForce(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1); //For 0th element
        //From 2nd number to last
        for (int i = 1; i < A.size(); i++) {
            int minElement = -1;
            int currentElement = A.get(i);
            for (int j = i-1; j >= 0; j--) {
                if (A.get(j) < currentElement) {
                    minElement = A.get(j);
                    break;
                }
            }
            result.add(minElement);
        }
        return result;
    }

    /**
     * CW2 > Nearest smaller integer - Left (Stack)
     * @param A
     * @return
     */
    private ArrayList<Integer> nearestSmallestIntegerLeft_Stacks(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        result.add(-1); //For 0th element
        s.add(A.get(0));

        for (int i = 1; i < A.size(); i++) {
            int currentElement = A.get(i);
            int ans = -1;
            if (currentElement > s.peek()) {
                //Current element > top of stack => ans = peek + push element
                ans = s.peek();
                s.push(currentElement);
            } else {
                //Current element <= top of stack => Pop all >= elements (un-required in future) , whatever left on stack top is ans + push element
                while (!s.isEmpty() && s.peek() >= currentElement) {
                    s.pop();
                }
                if (!s.isEmpty()) {
                    ans = s.peek();
                }
                s.push(currentElement);
            }
            result.add(ans);
        }
        return result;
    }

    //---------------ASSIGNMENT-------------------

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
