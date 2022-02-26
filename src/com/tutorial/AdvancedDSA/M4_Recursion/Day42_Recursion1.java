package com.tutorial.AdvancedDSA.M4_Recursion;

public class Day42_Recursion1 {
    public void execute() {
        System.out.println("AS1 > Sum of Digits (21057) => " + this.sumOfDigits(21057));
        System.out.println("AS2 > Is magic (83557) => " + this.recursiveSumOfDigits(83557));
    }

    /**
     * AS1 > Sum of Digits
     * Given a number A, we need to find sum of its digits using recursion
     * @param a
     * @return
     */
    private int sumOfDigits(int a) {
        if (a < 10) return a;
        return (a % 10) + sumOfDigits(a/10);
    }

    /**
     * AS2 > Is magic
     * Given a number A, check if it is a magic number
     * Magic number, if the sum of its digits are calculated till a single digit recursively by adding the sum of the digits after every addition
     * @param a
     * @return
     */
    private int recursiveSumOfDigits(int a) {
        if (a < 10) return a;
        return recursiveSumOfDigits((a % 10) + recursiveSumOfDigits(a / 10));
    }
}
