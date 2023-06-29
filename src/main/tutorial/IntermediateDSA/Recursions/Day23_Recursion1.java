package main.tutorial.IntermediateDSA.Recursions;

/**
 * AS => DONE; HW => DONE
 */
public class Day23_Recursion1 {
    public void execute() {
        System.out.println("-----------Intermediate : Day 23: Recursion 1--------------");
        System.out.println("-------------------------CLASSWORK-------------------------");

        //CW1 > Sum of 1st N natural numbers
        System.out.println("CW1 > Sum(10) => " + this.sum(10));

        //CW2 > Factorial(n)
        System.out.println("CW2 > Factorial(5) => " + this.factorial(5));

        //CW3 > Nth fibonacci number
        System.out.println("CW3 > Fibonacci(7) => " + this.fibonacci(7));

        //CW4 > Decreasing print
        System.out.print("CW4 > Decreasing print (10) => ");
        this.printNSeries_Descreasing(10);
        System.out.println("");

        //CW5 > Increasing print
        System.out.print("CW5 > Increasing print (10) => ");
        this.printNSeries_Increasing(10);
        System.out.println("");

        //CW6 > IsPalindrome
        System.out.println("CW6 > IsPalindrome(malayalam) => " + this.isPalindromeString("malayalam", 0, 8));
        System.out.println("    > IsPalindrome(indranil) => " + this.isPalindromeString("indranil", 0, 7));

        System.out.println("-------------------------ASSIGNMENTS-----------------------");

        //AS1 > Check Palindrome
        System.out.println("AS1 > Check Palindrome : " + this.checkPalindrome("MALAYALAM"));

        //AS2 > Check Palindrome
        System.out.println("AS2 > Find Fibonacci (5) : " + this.findAthFibonacci(5));

        //AS3 - Find Factorial
        System.out.println("AS3 > Find Factorial : " + this.findFactorial(5));

        //AS4 - Print reverse string
        String inputAS4 = "HELLO";
        String outputAS4 = getReverseString(inputAS4, "");
        System.out.println("AS4 > Print reverse string : " + outputAS4);
        String outputAS4b = getReverseStringBetter(inputAS4);
        System.out.println("AS4 > Print reverse string (Better Approach) : " + outputAS4b);

        System.out.println("-------------------------HOMEWORK-------------------------");

        //HW1 - Sum of Digits
        int inputHW1 = 20534;
        int outputHW1a = sumOfDigits(inputHW1, 0);
        System.out.println("HW1 > Sum of Digits : " + outputHW1a);
        int outputHW1b = sumOfDigitsBetter(inputHW1);
        System.out.println("HW1 > Sum of Digits (Better Approach) : " + outputHW1b);
    }

    //----------------------CLASSWORK--------------------------

    /**
     * CW1 > Sum of 1st N natural numbers
     * @param n
     * @return
     */
    private int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + this.sum(n - 1);
    }

    /**
     * CW2 > Factorial(n)
     * @param n
     * @return
     */
    private int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * this.factorial(n - 1);
    }

    /**
     * CW3 > Nth fibonacci number
     * @param n
     * @return
     */
    private int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return this.fibonacci(n - 1) + this.fibonacci(n - 2);
    }

    /**
     * CW4 > 5, 4, 3, 2, 1 (Decreasing print)
     * @param n
     */
    private void printNSeries_Descreasing(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");

        this.printNSeries_Descreasing(n - 1);
    }

    /**
     * CW5 > 1, 2, 3, 4, 5 (Increasing print)
     * @param n
     */
    private void printNSeries_Increasing(int n) {
        if (n == 0) {
            return;
        }
        this.printNSeries_Increasing(n - 1);
        System.out.print(n + " ");
    }

    /**
     * CW6 > IsPalindrome
     * @param str
     * @param s
     * @param e
     * @return
     */
    private boolean isPalindromeString(String str, int s, int e) {
        if (s >= e) {
            return true;
        } else {
            if (str.charAt(s) == str.charAt(e)) {
                return this.isPalindromeString(str, s + 1, e - 1);
            }
        }
        return false;
    }

    //---------------------ASSIGNMENTS-------------------------

    /**
     * AS1 > (*) Check Palindrome [PRACTICE]
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
     * AS2 > (*) Find Fibonacci [PRACTICE]
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
     * AS4 > Print reverse string - recursion [PRACTICE - BETTER SOLN]
     * @param s
     * @return
     */
    private String getReverseStringBetter(String s) {
        if (s.length() == 0) {
            return "";
        } else {
            return s.charAt(s.length() - 1) + getReverseStringBetter(s.substring(0, s.length() - 1));
        }
    }

    //----------------------HOMEWORK------------------------

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

