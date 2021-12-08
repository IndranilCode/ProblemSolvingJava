package com.tutorial.recursion;

public class Day23Recursion1 {
    public void execute() {
        //AS1 - Check Palindrome
        String inputAS1 = "MALAYALAM";
        int outputAS1 = checkPalindrome(inputAS1);
        System.out.println("AS1 - Check Palindrome : " + outputAS1);

        //AS1 - Check Palindrome
        int inputAS2 = 5;
        int outputAS2 = findAthFibonacci(inputAS2);
        System.out.println("AS2 - Find Fibonacci : " + outputAS2);

    }

    /**
     * AS1 > Check Palindrome
     * @param A
     * @return
     */
    private int checkPalindrome(String A) {
        return isPalindrome(A, 0, A.length()-1);
    }

    private int isPalindrome(String s, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return 1;
        } else {
            if (s.charAt(startIndex) == s.charAt(endIndex)) {
                return isPalindrome(s, startIndex+1, endIndex-1);
            }
        }
        return 0;
    }

    /**
     * AS2 > Find Fibonacci
     * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
     * @param A
     * @return
     */
    private int findAthFibonacci(int A) {
        //        returnFibonacci(5)
        //        returnFibonacci(4)                         + returnFibonacci(3)
        //        returnFibonacci(3) + returnFibonacci(2) + returnFibonacci(2) + returnFibonacci(1)
        //        returnFibonacci(2) returnFibonacci(1) + returnFibonacci(2) + returnFibonacci(2) + returnFibonacci(1)
        //            1 + 1+1+1+1+

        if (A == 0) {
            return 0;
        }
        if (A == 2 || A == 1) {
            return 1;
        } else {
            return findAthFibonacci(A - 1) + findAthFibonacci(A - 2);
        }
    }

    /**
     * AS3 > Find Factorial
     * @param A
     * @return
     */
    private int findFactorial(int A) {
        return 0;
    }

    private void printReverseString() {

    }
}

