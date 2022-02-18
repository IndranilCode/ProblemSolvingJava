package com.tutorial.AdvancedDSA.Maths;

import java.util.ArrayList;
import java.util.Arrays;

public class Day37_GCD {
    public void execute() {
        //CW1> GCD - Naive Method
        System.out.println("CW1> GCD - Naive Method (4,16): " + this.findGCD_NaiveMethod(4, 16));
        System.out.println("CW1> GCD - Naive Method (-4,16): " + this.findGCD_NaiveMethod(4, 16));
        System.out.println("CW1> GCD - Naive Method (15,16): " + this.findGCD_NaiveMethod(15, 16));
        System.out.println("CW1> GCD - Naive Method (-15,16): " + this.findGCD_NaiveMethod(15, 16));

        //CW2> GCD - Optimization 1 (sqrt(n) to 1 ; n/i sqrt pair traversal)
        System.out.println("CW2> GCD - Optimization 1 (sqrt(n) to 1 ; n/i sqrt pair traversal) (4,16): " + this.findGCD_Optimization1(4, 16));
        System.out.println("CW2> GCD - Optimization 1 (sqrt(n) to 1 ; n/i sqrt pair traversal) (-4,16): " + this.findGCD_Optimization1(4, 16));
        System.out.println("CW2> GCD - Optimization 1 (sqrt(n) to 1 ; n/i sqrt pair traversal) (15,16): " + this.findGCD_Optimization1(15, 16));
        System.out.println("CW2> GCD - Optimization 1 (sqrt(n) to 1 ; n/i sqrt pair traversal) (-15,16): " + this.findGCD_Optimization1(15, 16));

        //CW3> GCD - Optimization 1 (sqrt(n) to 1 ; n/i sqrt pair traversal)
        System.out.println("CW3> GCD - Recursive Euclid's pre-algo (4,16): " + this.findGCD_RecursionEuclidsAlgo(4, 16));
        System.out.println("CW3> GCD - Recursive Euclid's pre-algo (-4,16): " + this.findGCD_RecursionEuclidsAlgo(4, 16));
        System.out.println("CW3> GCD - Recursive Euclid's pre-algo (15,16): " + this.findGCD_RecursionEuclidsAlgo(15, 16));
        System.out.println("CW3> GCD - Recursive Euclid's pre-algo (-15,16): " + this.findGCD_RecursionEuclidsAlgo(15, 16));

        //CW4> GCD - Euclid's algo (Pure)
        System.out.println("CW4> GCD - Euclid's algo (Pure) (4,16): " + this.findGCD_EuclidsAlgoPure(4, 16));
        System.out.println("CW4> GCD - Euclid's algo (Pure) (-4,16): " + this.findGCD_EuclidsAlgoPure(4, 16));
        System.out.println("CW4> GCD - Euclid's algo (Pure) (15,16): " + this.findGCD_EuclidsAlgoPure(15, 16));
        System.out.println("CW4> GCD - Euclid's algo (Pure) (-15,16): " + this.findGCD_EuclidsAlgoPure(15, 16));

        //-------------Assessment-------------

        //AS1> Delete one
        ArrayList<Integer> inputAS1a = new ArrayList<>(Arrays.asList(12, 15, 18));
        System.out.println("AS1> Delete one Max GCD [12, 15, 18]: " + this.deleteOneEachTimeMaxGCD(inputAS1a));
        ArrayList<Integer> inputAS1b = new ArrayList<>(Arrays.asList(5, 15, 30));
        System.out.println("AS1> Delete one Max GCD [5, 15, 30]: " + this.deleteOneEachTimeMaxGCD(inputAS1b));

        //AS2> Enumerating GCD
        System.out.println("AS2> Enumerating GCD (5 - 9): " + this.enumeratingGCD("5", "9"));
        System.out.println("AS2> Enumerating GCD (3412 - 3412): " + this.enumeratingGCD("3412", "3412"));
        System.out.println("AS2> Enumerating GCD (678728391838182039102 - 678728391838182039103): " + this.enumeratingGCD("678728391838182039102", "678728391838182039103"));

        //AS3> Greatest Common Divisor
        System.out.println("AS3> Greatest Common Divisor (4,16): " + this.gcd(4, 16));

        //AS4> Pubg
        ArrayList<Integer> inputAS4a = new ArrayList<>(Arrays.asList(2, 3, 4));
        System.out.println("AS4> Pubg [2, 3, 4]: " + this.pubG(inputAS4a));
        ArrayList<Integer> inputAS4b = new ArrayList<>(Arrays.asList(6, 2, 12, 8));
        System.out.println("AS4> Pubg [6, 2, 12, 8]: " + this.pubG(inputAS4b));
        ArrayList<Integer> inputAS4c = new ArrayList<>(Arrays.asList(100));
        System.out.println("AS4> Pubg [100]: " + this.pubG(inputAS4c));
    }

    /*------------CLASSWORK------------*/

    /**
     * CW1> GCD - Naive Method
     * @param a
     * @param b
     * @return
     */
    private int findGCD_NaiveMethod(int a, int b) {
        int gcd = 0;
        for (int i = Math.min(a, b); i >= 1; i--) {
            if ((a % i == 0) && (b % i == 0)) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }

    /**
     * CW2> GCD - Optimization 1 (sqrt(n) to 1 ; n/i sqrt pair traversal)
     * @param a
     * @param b
     * @return
     */
    private int findGCD_Optimization1(int a, int b) {
        int n = Math.min(a, b);
        int maxFactor = 1;

        for (int i = (int)Math.sqrt(n); i >= 1; i--) {
            // Example => if n = 16, then sqrt(16) = 4, but factors occurs in pairs sp starting from 4 we get (4,4), (2,8), (1,16)
            if (n % i == 0) {
                //If i is a factor there will be n/i another pair
                if ((a % i) == 0 && (b % i) == 0) {
                    maxFactor = i > maxFactor ? i : maxFactor; // maxFactor = max(i, maxFactor)
                }
                int factor2 = n / i;
                if ((a % factor2) == 0 && (b % factor2) == 0) {
                    maxFactor = factor2 > maxFactor ? factor2 : maxFactor; // maxFactor = max(i, maxFactor)
                }
            }
        }
        return maxFactor;
    }

    /**
     * CW3> GCD - Recursive Euclid's pre-algo
     * @param a
     * @param b
     * @return
     */
    private int findGCD_RecursionEuclidsAlgo(int a, int b) {
        //Assuming 2nd no is smaller, SO if 1st no is small then swap a/b
        if (b > a) {
            int c = a;
            a = b;
            b = c;
        }

        if (b == 0) return a;
        return findGCD_RecursionEuclidsAlgo(a - b , b);
    }

    /**
     * CW3> GCD - Euclid's algo (Pure)
     * @param a
     * @param b
     * @return
     */
    private int findGCD_EuclidsAlgoPure(int a, int b) {
        //assuming a > b
        if (b == 0) return a;
        return findGCD_EuclidsAlgoPure(b, a%b);
    }

    /*------------ASSIGNMENTS------------*/

    /**
     * AS1> Delete one Max GCD
     * Integer array A of size N. Delete one element such that the GCD) of the remaining array is maximum.
     * Find the maximum value of GCD.
     * @param A
     * @return
     */
    private int deleteOneEachTimeMaxGCD(ArrayList<Integer> A) {
        Integer[] prefixGCD = new Integer[A.size()];
        Integer[] suffixGCD = new Integer[A.size()];

        //Build prefix GCD
        int prefixRunningGCD = A.get(0);
        prefixGCD[0] = prefixRunningGCD;
        for (int i = 1; i < A.size(); i++) {
            prefixRunningGCD = deleteGCDHelper(prefixRunningGCD, A.get(i));
            prefixGCD[i] = prefixRunningGCD;
        }

        //Build suffix GCD
        int suffixRunningGCD = A.get(A.size() - 1);
        suffixGCD[A.size() - 1] = suffixRunningGCD;
        for (int i = A.size() - 2; i >= 0; i--) {
            suffixRunningGCD = deleteGCDHelper(suffixRunningGCD, A.get(i));
            suffixGCD[i] = suffixRunningGCD;
        }

        int maxGCD = 1;
        int runningGCD = 1;
        for (int i = 0; i < A.size(); i++) {
            if (i == 0) {
                runningGCD = suffixGCD[i + 1];
            } else if (i == (A.size() - 1)) {
                runningGCD = prefixGCD[i - 1];
            } else {
                runningGCD = deleteGCDHelper(prefixGCD[i - 1], suffixGCD[i + 1]);
            }
            if (runningGCD > maxGCD) {
                maxGCD = runningGCD;
            }
        }
        return maxGCD;
    }
    private int deleteGCDHelper(int a, int b) {
        if (b == 0) return a;
        return deleteGCDHelper(b , a%b);
    }

    /**
     * AS2> Enumerating GCD
     * From 2 inputs A & B - enumerating GCD is the gcd of all consecutive numbers from a to b
     * @param A
     * @param B
     * @return
     */
    private String enumeratingGCD(String A, String B) {
        //if a == b then GCD = a OR b
        //if a is != b then its a consecutive sequence whose GCD will be 1

        //Approach 1 => Didn't work for large inputs eg 678728391838182039102
        //        long a = Long.parseLong(A);
        //        long b = Long.parseLong(B);
        //
        //        if (a == b) {
        //            return a + "";
        //        } else {
        //            return "1";
        //        }

        //Approach 2
        if (A.equals(B)) {
            return A;
        } else {
            return "1";
        }
    }

    /**
     * AS3> Greatest Common Divisor
     * Given 2 non negative integers A and B, find gcd(A, B)
     * @param a
     * @param b
     * @return
     */
    private int gcd(int a, int b) {
        //assuming a > b
        if (b == 0) return a;
        return gcd(b, a%b);
    }

    /**
     * AS4> Pubg
     * N players each with strength A[i]. when player i attack player j, player j strength reduces to max(0, A[j]-A[i])
     * @param A
     * @return
     */
    private int pubG(ArrayList<Integer> A) {
        int initNo = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            initNo = pubgGcd(initNo, A.get(i));
        }
        return initNo;
    }
    private int pubgGcd(int a, int b) {
        if (b == 0) return a;
        return pubgGcd(b, a%b);
    }
}
