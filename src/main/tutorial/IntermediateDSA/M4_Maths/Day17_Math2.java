package main.tutorial.IntermediateDSA.M4_Maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day17_Math2 {
    public void execute() {
        System.out.println("------------Intermediate : Day 17: Maths 2-----------------");
        System.out.println("-------------------------ASSIGNMENT------------------------");

        //AS3 > Majority Element (Moore's voting algorithm)
        ArrayList<Integer> inputAS3 = new ArrayList<>(Arrays.asList(1, 6 ,1, 1, 2, 1));
        System.out.println("AS3 > Majority Element (Moore's voting algorithm) [1, 6 ,1, 1, 2, 1] => " + this.majorityElement(inputAS3));
        ArrayList<Integer> inputAS3_2 = new ArrayList<>(Arrays.asList(1, 2, 1, 2, 1, 2));
        System.out.println("    > Majority Element (Moore's voting algorithm) [1, 2, 1, 2, 1, 2] => " + this.majorityElement(inputAS3_2));

        //AS4 > N/3 Repeat Number
        ArrayList<Integer> inputAS4 = new ArrayList<>(Arrays.asList(1, 2, 3, 1, 1));
        System.out.println("AS3 > N/3 Repeat Number (Moore's voting algorithm) [1, 2, 3, 1, 1] => " + this.nBy3_majorityElement(inputAS4));
        ArrayList<Integer> inputAS4_2 = new ArrayList<>(Arrays.asList(1000441, 1000441, 10009941));
        System.out.println("    > N/3 Repeat Number (Moore's voting algorithm) [1000441, 1000441, 1000994] => " + this.nBy3_majorityElement(inputAS4_2));

        //AS5 > Find nth Magic Number
        System.out.println("AS5 > Find nth Magic Number (n = 3) => " + this.nThMagicNumber(3));
        System.out.println("    > Find nth Magic Number (n = 10) => " + this.nThMagicNumber(10));
    }

    /**
     * AS3 > Majority Element (Moore's voting algorithm)
     * Given an array of size N, find the majority element. The majority element is the element that appears more than floor(n/2) times.
     * You may assume that the array is non-empty and the majority element always exists in the array.
     * @param A
     * @return
     */
    private int majorityElement(List<Integer> A) {
        //Solution Approach: Moore's voting algorithm
        // 1. Assume 1st element as ME => ME = A[0] , count = 1
        // 2. If next element matches => count++ , ME = same
        // 3. If next doesn't match => count--
        //       a> if count == 0 , set ME to null
        // 4. Continue with loop till end
        // NOTE: Works when ME is sure to exist

        Integer majorityElement = null;
        int majorityElementCount = 0;
        for (int i = 0; i < A.size(); i++) {
            int currentElement = A.get(i);
            if (majorityElement == null) {
                majorityElement = currentElement;
                majorityElementCount = 1;
            } else if (majorityElement != null && majorityElement == currentElement) {
                // ME is not null + matches A[i]
                majorityElementCount++;
            } else {
                //ME is not null + doesn't match A[i]
                majorityElementCount--;
                if (majorityElementCount == 0) {
                    majorityElement = null;
                }
            }
        }
        return majorityElement != null ? majorityElement : Integer.MIN_VALUE;
    }

    /**
     * AS4 > N/3 Repeat Number (Moore's voting algorithm)
     * Given array of N integers. Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
     * If so, return the integer. If not, return -1.
     * If there are multiple solutions, return any one.
     * @param A
     * @return
     */
    private int nBy3_majorityElement(final List<Integer> A) {
        Integer m1 = null;
        int c1 = 0;
        Integer m2 = null;
        int c2 = 0;

        // M1       =>  null     !null      !null      null       null     !null     !null    !null     !null
        // M2       =>  null     null       null       !null      !null    !null     !null    !null     !null
        //                       A[i]!=M1   A[i]=M1    A[i]!=M2   A[i]=M2  A[i]=m1   A[i]=m1  A[i]=m2   A[i]!=m1 + A[i]!=m2
        //assign    =>  M1=A[i]  M2=A[i]    c1++       M1=A[i]    c2++     c1++      c1++     c2++      c1-- ; c2--

        for (int i = 0; i < A.size(); i++) {
            int currentNumber = A.get(i);

            if (m1 == null && m2 == null) {
                //both m1=m2=null => assign m1 = current ; c1++
                m1 = currentNumber;
                c1++;
            } else if (m1 != null && m2 == null) {
                // Only 1 null ; other has
                // [m1 (!null) + m2 (null) ] + current (!= m1) => m2 = current ; c2++
                // [m1 (!null) + m2 (null) ] + current (m1) => c1++
                if (currentNumber != m1) {
                    m2 = currentNumber;
                    c2++;
                } else {
                    c1++;
                }
            } else if (m1 == null && m2 != null) {
                // Only 1 null ; other has
                // [m1 (null) + m2 (!null) ] + current (!= m2) => m2 = current ; c1++
                // [m1 (null) + m2 (!null) ] + current (m2) => c2++
                if (currentNumber != m2) {
                    m1 = currentNumber;
                    c1++;
                } else {
                    c2++;
                }
            } else {
                //Both not null
                //current = m1
                //current = m2
                //current != m1 + current != m2
                if (currentNumber == m1) {
                    c1++;
                } else if (currentNumber == m2) {
                    c2++;
                } else {
                    //current != m1 OR m2
                    c1--;
                    c2--;
                    if (c1 == 0) m1 = null;
                    if (c2 == 0) m2 = null;
                }
            }
        }

        //Clarify if m1 AND/OR m2 freq is > n/3
        if (m1 != null || m2 != null) {
            int requiredMajority = A.size() / 3;
            int realCount = 0;

            //1. Check m1 majority
            if (m1 != null) {
                for (int i = 0; i < A.size(); i++) {
                    if (A.get(i).equals(m1)) {
                        realCount++;
                    }
                }
                if (realCount > requiredMajority) {
                    return m1;
                }
            }

            //2. Check m2 majority
            realCount = 0;
            if (m2 != null) {
                for (int i = 0; i < A.size(); i++) {
                    if (A.get(i).equals(m2)) {
                        realCount++;
                    }
                }
                if (realCount > requiredMajority) {
                    return m2;
                }
            }

            //Both not majority
            return -1;
        } else {
            return -1;
        }
    }

    /**
     * AS5 > Find nth Magic Number
     * Given an integer A, find and return the Ath magic number.
     * A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.
     * First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
     * @param n
     * @return
     */
    private int nThMagicNumber(int n) {
        // 0110 = 5
        // n = 0 => 0110 & 1 => 0
        // n = 1 =>  011 & 1 => 5^2 = 25
        // n = 3 =>   01 & 1 => 5^3 = 125
        //                           ----- Total = 150

        int i = 0;
        int total = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                total = total + this.power(5, (i + 1));
            }
            n = n >> 1;
            i++;
        }
        return total;
    }
    private int power(int n, int i) {
        int ans = 1;
        for (int j = 0; j < i; j++) {
            ans = ans * n;
        }
        return ans;
    }
}
