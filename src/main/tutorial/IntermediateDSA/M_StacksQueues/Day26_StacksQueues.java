package main.tutorial.IntermediateDSA.M_StacksQueues;

import java.util.Stack;

public class Day26_StacksQueues {
    public void execute() {
        System.out.println("-----------Intermediate : Day 26: Stacks Queues------------");
        System.out.println("-------------------------ASSIGNMENT------------------------");

        //AS1 > Min Stack
        System.out.println("AS1 > Min Stack => ");

        //AS2 > Balanced Parantheses
        System.out.println("AS2 > Balanced Parantheses (()()) => " + this.isBalancedParentheses("(()())"));
        System.out.println("    > Balanced Parantheses (() => " + this.isBalancedParentheses("(()"));

        System.out.println("--------------------------HOMEWORK-------------------------");

        //HW1 > Balanced Paranthesis
        System.out.println("HW1 > Balanced Paranthesis {([])} => " + this.allBalancedParenthesis("{([])}"));
        System.out.println("    > Balanced Paranthesis (){ => " + this.allBalancedParenthesis("(){"));
        System.out.println("    > Balanced Paranthesis ()[] => " + this.allBalancedParenthesis("()[]"));
    }

    //---------------------ASSIGNMENTS-------------------------

    /**
     * AS2 > Balanced Parantheses
     * Given a string A consisting only of '(' and ')'.
     * You need to find whether parentheses in A are balanced or not, if it is balanced then return 1 else return 0.
     * (()()) - 1
     * (() - 0
     * @param A
     * @return
     */
    private int isBalancedParentheses(String A) {
        Stack<Character> s = new Stack<>();
        int n = A.length();

        for (int i = 0; i < n; i++) {
            Character currentChar = A.charAt(i);
            if (currentChar.equals('(')) {
                s.push('(');
            } else {
                if (!s.isEmpty()) {
                    Character lastBraces = s.peek();
                    if (currentChar.equals(')') && lastBraces.equals('(')) {
                        s.pop();
                    }
                } else {
                    //End brace has come first - invalid
                    return 0;
                }
            }
        }
        return s.size() == 0 ? 1 : 0;
    }

    //----------------------HOMEWORK------------------------

    /**
     * HW1 > Balanced Paranthesis
     * Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
     * {([])} - 1
     * (){ - 0
     * ()[] - 1
     * @param A
     * @return
     */
    private int allBalancedParenthesis(String A) {
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
}
