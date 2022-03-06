package com.tutorial.AdvancedDSA.M4_Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Day42_Recursion1 {
    public void execute() {
        /*------------CLASSWORK------------*/
        System.out.println("CW1 > Tower of Hanoi [Steps only - no disk - total count] (n=3)");
        int resultCW1 = this.towerOfHanoiCW_StepsAndCount(3, 'A', 'C', 'B');
        System.out.println("Count = " +resultCW1);

        System.out.println("CW2 > Tower of Hanoi [Steps - disk - total count] (n=3)");
        int resultCW2 = this.towerOfHanoiCW_StepsDiskAndCount(3, "A", 'A', 'C', 'B');
        System.out.println("Count = " +resultCW2);

        /*------------ASSIGNMENTS------------*/
        System.out.println("AS1 > Sum of Digits (21057) => " + this.sumOfDigits(21057));
        System.out.println("AS2 > Is magic (83557) => " + this.recursiveSumOfDigits(83557));
        System.out.println("AS3 > Implement Power Function (pow(2,3) % 3) => " + this.powerFunction(2, 3, 3));

        System.out.println("AS4 > Tower of Hanoi => (n = 3) ");
        ArrayList<ArrayList<Integer>> resultAS4 = this.towerOfHanoi(3);
        resultAS4.forEach(row -> {
            System.out.print("[ ");
            row.forEach(item -> {
                System.out.print(item + ",");
            });
            System.out.println("]");
        });
        System.out.println("");

        /*------------HOMEWORK------------*/
        System.out.println("HW1 > Find Fibonacci (9) => " + this.fibonacci(9));
        System.out.println("HW2 > Sum of Digits (21057) => " + this.sumOfAllDigits(21057));
        System.out.println("HW3 > Find Factorial (6) => " + this.factorial(6));
        System.out.println("HW4 > Print reverse string (indranilbasu) => " + this.reverseString("indranilbasu"));
        System.out.println("HW5 > Another sequence problem (3) => " + this.sequence(3));
    }

    /*------------CLASSWORK------------*/

    /**
     * CW1 > Tower of Hanoi [Steps only - no disk - total count]
     * @param n
     * @param source
     * @param destination
     * @param intermediate
     * @return
     */
    private int towerOfHanoiCW_StepsAndCount(int n, char source, char destination, char intermediate) {
        if (n == 1) {
            System.out.println("D" + n + " => Source : " + source + " , Destination : " + destination);
            return 1;
        }
        int step1 = towerOfHanoiCW_StepsAndCount(n-1, source, intermediate, destination); //A - B via C
        int step2 = towerOfHanoiCW_StepsAndCount(1, source, destination, intermediate); //A - C via B
        int step3 = towerOfHanoiCW_StepsAndCount(n-1, intermediate, destination, source); //B-C via A
        return step1 + step2 + step3;
    }

    /**
     * CW2 > Tower of Hanoi [Steps - disk - total count]
     * @param n
     * @param disk
     * @param source
     * @param destination
     * @param intermediate
     * @return
     */
    private int towerOfHanoiCW_StepsDiskAndCount(Integer n, String disk, char source, char destination, char intermediate) {
        if (n == 1) {
            System.out.println("D" + disk + " => Source :" + source + " ,Destination : " + destination);
            return 1;
        }

        Integer nMinus = n-1;
        int step1 = towerOfHanoiCW_StepsDiskAndCount(n-1, nMinus.toString(), source, intermediate, destination);
        int step2 = towerOfHanoiCW_StepsDiskAndCount(1, n.toString(), source, destination, intermediate);
        int step3 = towerOfHanoiCW_StepsDiskAndCount(n-1, nMinus.toString(), intermediate, destination, source);
        return step1 + step2 + step3;
    }

    /*------------ASSIGNMENTS------------*/

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

    /**
     * AS3 > Implement Power Function
     * pow(x, n) % d.
     * @param x
     * @param n
     * @param d
     * @return
     */
    private int powerFunction(int x, int n, int d) {
        if (n == 0) return 1;
        return ((x * this.powerFunction(x, n-1, d)) % d);
    }

    /**
     * AS4 > Tower of Hanoi
     * @param a
     * @return
     */
    private ArrayList<ArrayList<Integer>> towerOfHanoi(int a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        return this.toh(a, a, 1, 3, 2, result);
    }
    private ArrayList<ArrayList<Integer>> toh(int n, int disk, int source, int destination, int intermediate, ArrayList<ArrayList<Integer>> result) {
        if (n == 1) {
            result.add(new ArrayList<>(Arrays.asList(disk, source, destination))); //D1 => Source 1 - Destination 3
            return result;
        }

        ArrayList<ArrayList<Integer>> step1 = toh(n-1, n-1, source, intermediate, destination, result);
        ArrayList<ArrayList<Integer>> step2 = toh(1, n, source, destination, intermediate, step1);
        ArrayList<ArrayList<Integer>> step3 = toh(n-1, n-1, intermediate, destination, source, step2);
        return step3;
    }

    /*------------HOMEWORK------------*/

    /**
     * HW1 > Find Fibonacci - II
     * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144,
     * @param a
     * @return
     */
    private int fibonacci(int a) {
        if (a == 1) return 1;
        if (a == 0) return 0;
        return fibonacci(a-1) + fibonacci(a-2);
    }

    /**
     * HW2 > Sum of Digits
     * Given a number A, we need to find sum of its digits using recursion
     * @param a
     * @return
     */
    private int sumOfAllDigits(int a) {
        if (a < 10) return a;
        return (a % 10) + sumOfAllDigits(a/10);
    }

    /**
     * HW3 > Find Factorial
     * Find the factorial of the given number A
     * @param a
     * @return
     */
    private int factorial(int a) {
        if (a == 1) return 1;
        return a * this.factorial(a - 1);
    }

    /**
     * MH4 > Print reverse string
     * @param a
     * @return
     */
    private String reverseString(String a) {
        if (a.length() == 1) return a;
        return a.charAt(a.length() - 1) + reverseString(a.substring(0, a.length() - 1));
    }

    /**
     * HW5 > Another sequence problem
     * f(A) = f(A-1) + f(A-2) + f(A-3) + A
     * @param a
     * @return
     */
    private int sequence(int a) {
        if (a == 0) return 1;
        if (a == 1) return 1;
        if (a == 2) return 2;
        return this.sequence(a-1) + this.sequence(a-2) + this.sequence(a-3) + a;
    }
}
