package main.tutorial.IntermediateDSA.M_StacksQueues;

import java.util.Stack;

public class Day26_StacksQueues {
    public void execute() {

    }

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
}
