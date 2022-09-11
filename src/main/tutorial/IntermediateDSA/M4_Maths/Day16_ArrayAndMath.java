package main.tutorial.IntermediateDSA.M4_Maths;

import java.util.*;

public class Day16_ArrayAndMath {
    public void execute() {
        System.out.println("----------Day 16 Intermediate: Array & Math----------------------------");
        System.out.println("---------------------------------ASSIGNMENT----------------------------");

        //AS4 > Mod String (s % mod)
        //System.out.println("AS4 > Mod String (43535321 % 47) => " + this.modString("43535321", 47));
        System.out.println("AS4 > Mod String (842554936302263 % 41) => " + this.modString("842554936302263", 41));

        System.out.println("---------------------------------HOMEWORK------------------------------");

        //HW1 > Repeat and Missing Number Array
        ArrayList<Integer> inputHW1 = new ArrayList<>(Arrays.asList(3, 1, 2, 5, 3));
        ArrayList<Integer> resultHW1 = this.identify_RepeatAndMissingNumber(inputHW1);
        System.out.print("HW1 > Repeat and Missing Number Array [3, 1, 2, 5, 3] => [ ");
        resultHW1.forEach(e -> System.out.print(e + " ,"));
        System.out.println("]");

        //HW2 > Concatenate Three Numbers
        System.out.println("HW2 > Concatenate Three Numbers (49, 14, 66) => " + this.concatenateThreeNumbers(49, 14,66));
        System.out.println("    > Concatenate Three Numbers (20, 33, 20) => " + this.concatenateThreeNumbers(20, 33,20));

        //HW3 > Find if two rectangles overlap
        System.out.println("HW3 > Find if two rectangles overlap R1 : (0,0),(4,4) , R2 : (2,2),(6,6) => " + this.isTwoRectanglesOverlap(0, 0, 4, 4, 2, 2, 6, 6));

        //HW5 > Least Common Multiple
        System.out.println("HW5 > Least Common Multiple (9, 6) => " + this.leastCommonMultiple(9, 6));
    }

    /*---------------ASSIGNMENT--------------*/

    /**
     * AS1 > Excel Column Number
     * Given a column title as appears in an Excel sheet, return its corresponding column number.
     *  A -> 1
     *  B -> 2
     *  C -> 3
     *  ...
     *  Z -> 26
     *  AA -> 27
     *  AB -> 28
     * @param A
     * @return
     */
    private int excelColumnNumber(String A) {
        long result = 0;
        int inputLength = A.length();
        for (int i = 0; i < inputLength; i++) {
            int currentCharNumber = (int)(A.charAt(i)) - ('A' - 1);
            result = (int) (result + ((long)(Math.pow(26, (inputLength - 1 - i))) * currentCharNumber));
        }
        return (int)result;
    }

    /**
     * AS2 > A, B and Modulo
     * Given two integers A and B, find the greatest possible positive integer M, such that A % M = B % M.
     * Example 1 >> A = 1 ; B = 2 => 1 is the largest value of M such that A % M == B % M.
     * Example 2 >> A = 5 ; B = 10 => For M = 5, A % M = 0 and B % M = 0. No value greater than M = 5, satisfies the condition.
     * @param A
     * @param B
     * @return
     */
    private int abModuloEqual(int A, int B) {
        int result = 1 ;
        if (A == B) {
            result = A;
        } else {
            result = Math.abs(A -B);
        }
        return result;
    }

    /**
     * AS3 > Divisibility by 8
     * @param A
     * @return
     */
    private int isDivisibleBy8(String A) {
        String last3Digits = "";
        Integer last3DigitsInt = 0;
        if (A.length() > 3) {
            last3Digits =  A.substring(A.length() - 3, A.length());
        } else {
            last3Digits = A;
        }
        last3DigitsInt = Integer.parseInt(last3Digits);
        return last3DigitsInt % 8 == 0 ? 1 : 0;
    }

    /**
     * AS4 > Mod String (s % mod)
     * @param largeNumber
     * @param mod
     * @return
     */
    private int modString(String largeNumber, int mod) {
        //Process
        //Expanding S = [ (Sn-1 * 10^n-1) + (Sn-2 * 10^n-1) + ...... (S1 * 10^1) + (S0 * 10^0)] % mod
        //            = [  [(Sn-1 * 10^n-1) % mod ] + [(Sn-2 * 10^n-2) % mod] + ...... [(S1 * 10^1) % mod] + [(S0 * 10^0) % mod]  ] % mod
        //            =    ------------------------(Focus this part)
        // (Sn-1 * 10^n-1) % mod = [ (Sn-1 % mod) * (10^n-1 % mod) ] % mod
        //                                          -------------- (Focus: Power-mod)

        //1. Computing power-mod each time
        //        int modResult = 0;
        //        int lengthLargeNumber = largeNumber.length();
        //        for (int i = lengthLargeNumber - 1 ; i >= 0; i--) {
        //            int currentNumber = Integer.parseInt(largeNumber.charAt(i) + "");
        //            modResult = modResult + ((currentNumber % mod) * this.powerMod(10, lengthLargeNumber - i - 1, mod)) % mod;
        //        }
        //        return modResult % mod;

        // 2. Caching power-mod for further steps
        long modResult = 0;
        int basePower = 1;
        int lengthLargeNumber = largeNumber.length();
        for (int i = lengthLargeNumber - 1 ; i >= 0; i--) {
            int currentNumber = largeNumber.charAt(i) - '0';
            long current = (currentNumber * basePower) % mod;
            //modResult = modResult + ((currentNumber % mod) * this.powerMod(10, lengthLargeNumber - i - 1, mod)) % mod;
            modResult = modResult + (current) % mod;
            basePower = (basePower * 10) % mod;
        }
        return (int)(modResult % mod);
    }
    private int powerMod(int a, int n, int mod) {
        // a^n % mod
        int result = 1;
        for (int i = 0; i < n; i++) {
            //result = (result * a) % mod; => [ (result % mod) * (a % mod) ] % mod;
            result = ( (result % mod) * (a % mod) ) % mod;
        }
        return result;
    }

    /*---------------HOMEWORK----------------*/

    /**
     * HW1 > Repeat and Missing Number Array (Semi Brute-Force & Improvement)
     * You are given a read only array of n integers from 1 to n.
     * Each integer appears exactly once except A which appears twice and B which is missing.
     * Return A and B.
     * @param A
     * @return
     */
    private ArrayList<Integer> identify_RepeatAndMissingNumber(List<Integer> A) {
        //Semi brute force => TC = O(n) , SC = O(n)
        int maxPossibleNumber = A.size();
        ArrayList<Integer> repeatAndMissingNumber = new ArrayList<>();
        HashSet<Integer> numberFreq = new HashSet<>();
        for (int i = 0; i < A.size(); i++) {
            Integer currentNumber = A.get(i);
            if (!numberFreq.contains(currentNumber)) {
                numberFreq.add(currentNumber);
            } else {
                repeatAndMissingNumber.add(currentNumber);
            }
        }
        for (int i = 1; i <= maxPossibleNumber; i++) {
            if (!numberFreq.contains(i)) {
                repeatAndMissingNumber.add(i);
            }
        }
        return repeatAndMissingNumber;

        //Refined approach => Maths approach TC = 0(n) ,  SC = O(1)
        //Eg A = [1, 2, 3, 4, 5, 6] ... ideally
        //   A = [1, 2, 3, 2, 5, 6] ... given (2 rep, 4 missing)
        // Step 1 : Sum of Ideal - Sum of given
        //        = [1 + 2 + 3 + 4 + 5 + 6] - [1 + 2 + 3 + 2 + 5 + 6]
        //        = every number cancels except 1 set
        //        = [1 - 1] + [2 - 2] + [3 - 3] + [4 - 2] + [5 - 5] + [6 - 6]
        //        = 2 => (mis - rep)
        // Step 2 : Sum of square of ideal - sum of square of repeat
        //        = [1^2 + 2^2 + 3^2 + 4^2 + 5^2 + 6^2] - [1^2 + 2^2 + 3^2 +2^2 + 5^2 + 6^2]
        //        = every number cancels except 1 set
        //        = 4^2 - 2^2 = 12
        //        = (mis^2 - rep^2)
        //        = (mis + rep) (mis - rep)
        // Now NOTE: Step1 = (mis - rep) ; Step 2 = (mis + rep) (mis - rep)
        // Step 3 :
        // So (mis + rep) = Step2 / Step1 = 12/2 = 6
        // So , mis = [(mis - rep) + (mis + rep)] / 2 => (Step 1 + Step 3) / 2 => (2 + 6) / 2 = 4
        //      rep = [(mis + rep) - (mis - rep)] / 2 => (Step 3 - Step 1) / 2 => (6 - 2) / 2 = 2
        // Found both mathematically
    }

    /**
     * HW2 > Concatenate Three Numbers
     * Given three 2-digit integers, A, B, and C, find out the minimum number obtained by concatenating them in any order.
     * Return the minimum result obtained.
     * @param A
     * @param B
     * @param C
     * @return
     */
    private int concatenateThreeNumbers(int A, int B, int C) {
        Integer lowest = Integer.MAX_VALUE;
        Integer highest = Integer.MIN_VALUE;

        if (A >= highest) {
            highest = A;
        }
        if (B >= highest) {
            highest = B;
        }
        if (C >= highest) {
            highest = C;
        }
        if (A <= lowest) {
            lowest = A;
        }
        if (B <= lowest) {
            lowest = B;
        }
        if (C <= lowest) {
            lowest = C;
        }

        //To find middle => xor all numbers (3 of them) XOR (highest ^ lowest) => middle will remain
        Integer middle = A ^ B ^ C ^ highest ^ lowest;
        return Integer.parseInt(lowest.toString() + middle.toString() + highest.toString());
    }

    /**
     * HW3 > Find if two rectangles overlap
     * Eight integers A, B, C, D, E, F, G, and H represent two rectangles in a 2D plane.
     * 1st Rect => bottom left corner is (A, B), and the top right corner is (C, D),
     * 2nd Rect => bottom left corner is (E, F), and the top right corner is (G, H).
     * Find and return whether the two rectangles overlap or not.
     * @param A
     * @param B
     * @param C
     * @param D
     * @param E
     * @param F
     * @param G
     * @param H
     * @return
     */
    private int isTwoRectanglesOverlap(int A, int B, int C, int D, int E, int F, int G, int H) {
        //Rectangle 1 : Left-Bottom = (A, B) ; Right-Top = (C, D)
        //Rectangle 2 : Left-Bottom = (E, F) ; Right-Top = (G, H)

        //Conditions when 2 rectangles overlap
        //1. R1 left of R2
        //2. R1 right of R2
        //3. R1 top of R2
        //4. R1 below R2
        if (E >= C || A >= G || B >= H || F >= D) {
            //Conditions where they don't overlap
            return 0;
        }
        return 1;
    }

    /**
     * HW4 > Leap year
     * Given an integer A representing a year, Return 1 if it is a leap year else, return 0.
     * A year is a leap year if the following conditions are satisfied:
     * 1. The year is multiple of 400.
     * 2. Else the year is multiple of 4 and not multiple of 100.
     * @param A
     * @return
     */
    private int isLeapYear(int A) {
        if (A % 400 == 0 || (A % 4 == 0 && A % 100 != 0)) {
            return 1;
        }
        return 0;
    }

    /**
     * HW5 > Least Common Multiple
     * @param a
     * @param b
     * @return
     */
    private int leastCommonMultiple(int a, int b) {
        int maxNo = a > b ? a : b;
        for (int i = maxNo; i < a * b; i = i + maxNo) {
            if (i % a == 0 && i % b == 0) {
                return i;
            }
        }
        return a * b;
    }
}