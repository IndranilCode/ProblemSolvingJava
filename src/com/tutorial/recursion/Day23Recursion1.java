package com.tutorial.recursion;

public class Day23Recursion1 {
    public void execute() {
        //AS1 - Check Palindrome
        String inputAS1 = "MALAYALAM";
        int outputAS1 = checkPalindrome(inputAS1);
        System.out.println("AS1 - Check Palindrome : " + outputAS1);

        //AS2 - Check Palindrome
        int inputAS2 = 5;
        int outputAS2 = findAthFibonacci(inputAS2);
        System.out.println("AS2 - Find Fibonacci : " + outputAS2);

        //AS3 - Find Factorial
        int inputAS3 = 5;
        int outputAS3 = findFactorial(inputAS3);
        System.out.println("AS3 - Find Factorial : " + outputAS3);

        //AS4 - Print reverse string
        String inputAS4 = "HELLO";
        String outputAS4 = getReverseString(inputAS4, "");
        System.out.println("AS4 - Print reverse string : " + outputAS4);



        //HW1 - Sum of Digits
        int inputHW1 = 20534;
        int outputHW1a = sumOfDigits(inputHW1, 0);
        System.out.println("HW1 - Sum of Digits : " + outputHW1a);
        int outputHW1b = sumOfDigitsBetter(inputHW1);
        System.out.println("HW1 - Sum of Digits (Better Approach) : " + outputHW1b);
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
        if (A == 0) {
            return 1;
        }
        return A * findFactorial(A-1);
    }

    /**
     * AS4 > Print reverse string - recursion [PRACTICE]
     * @param s
     * @param workingString
     * @return
     */
    private String getReverseString(String s, String workingString) {
        if (s.length() == 0) {
            return workingString;
        }
        Character lastChar = s.charAt(s.length() - 1);
        workingString = workingString + lastChar;

        String remainingString = s.substring(0, s.length() - 1);
        return getReverseString(remainingString, workingString);
    }


    /**
     * HW1 > Sum of Digits
     * "236" -> 10
     * @param number
     * @param sum
     * @return
     */
    private int sumOfDigits(int number, int sum) {
        if (number == 0) {
            return sum;
        }
        int currentDigit = number % 10;
        sum = sum + currentDigit;
        //int numberForNextIteration = (number - currentDigit) / 10; //Not needed
        int numberForNextIteration = number / 10;
        return sumOfDigits(numberForNextIteration, sum);
    }

    /**
     * HW1 > Sum of Digits [BETTER SOLN]
     * "236" -> 10
     * @param number
     * @return
     */
    private int sumOfDigitsBetter(int number) {
        if (number == 0) {
            return 0;
        }
        return number % 10 + sumOfDigitsBetter(number / 10);
    }

}

