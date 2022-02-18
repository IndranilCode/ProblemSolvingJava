package com.tutorial.AdvancedDSA.Maths;

import java.util.ArrayList;
import java.util.Arrays;

public class Day38_PrimeNumbers {
    public void execute() {
        /*------------CLASSWORK------------*/

        //CW1 > Count of factors
        System.out.println("CW1 > Count of factors (4): " + this.countOfFactors(4));
        System.out.println("CW1 > Count of factors (100): " + this.countOfFactors(100));

        //CW2 > Is prime
        System.out.println("CW2 > Is prime (1): " + this.isPrime(1));
        System.out.println("CW2 > Is prime (4): " + this.isPrime(4));
        System.out.println("CW2 > Is prime (9): " + this.isPrime(4));
        System.out.println("CW2 > Is prime (9): " + this.isPrime(16));
        System.out.println("CW2 > Is prime (11): " + this.isPrime(11));

        //CW3 > Print all primes from (1 - n) (Brute Force)
        System.out.print("CW3 > Print all primes from (1 - n) (Brute Force)             : ");
        ArrayList<Integer> resultCS3 = this.printAllPrimesTillN_BruteForce(100);
        resultCS3.forEach(e -> System.out.print(e + ", "));
        System.out.println();

        //CW4 > Print all primes from 1 - n (Sieve of Eros)
        System.out.print("CW4 > Print all primes from 1 - n (Sieve of Eros)             : ");
        ArrayList<Integer> resultCS4 = this.printAllPrimesTillN_SieveOfErosthenes(100);
        resultCS4.forEach(e -> System.out.print(e + ", "));
        System.out.println();

        //CW5 > Print all primes from 1 - n (Sieve of Eros) - Optimized
        System.out.print("CW5 > Print all primes from 1 - n (Sieve of Eros) - Optimized : ");
        ArrayList<Integer> resultCS5 = this.printAllPrimesTillN_SieveOfErosthenes_Optimized(100);
        resultCS5.forEach(e -> System.out.print(e + ", "));
        System.out.println();

        //CW6> Count of all divisors (Sieve algo)
        System.out.print("CW6 > Count of all divisors (Sieve algo) : ");
        ArrayList<Integer> resultCS6 = this.countOfAllDivisorsTillN(10);
        resultCS6.forEach(e -> System.out.print(e + ", "));
        System.out.println();

        /*------------ASSIGNMENTS------------*/

        //AS1 > Count of divisors (BF &Sieve algo)
        System.out.print("AS1 > Count of divisors (BF &Sieve algo) [2, 3, 4, 5] : ");
        ArrayList<Integer> inputAS1 = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
        ArrayList<Integer> resultAS1 = this.countOfDivisors(inputAS1);
        resultAS1.forEach(e -> System.out.print(e + ", "));
        System.out.println();

        //AS2 > Prime Sum (BF & Sieve algo)
        System.out.print("AS2 > Prime Sum (BF & Sieve algo) 18 : ");
        ArrayList<Integer> resultAS2 = this.primeSum(18);
        resultAS2.forEach(e -> System.out.print(e + ", "));
        System.out.println();

        //AS3 > Lucky Number
        System.out.println("AS3 > Lucky Number (12) : " + this.luckyNumber(12));
    }

    /*------------CLASSWORK------------*/

    /**
     * CW1 > Count of factors
     * @param a
     * @return
     */
    private int countOfFactors(int a) {
        //Approach 1: Brute force (1-n)
        //        int factorCount = 0;
        //        for (int i = a; i >= 1; i--) {
        //            if (a % i == 0) factorCount++;
        //        }
        //        return factorCount;

        //Approach 2: Optimized brute force (i- root n)
        int factorCount = 0;
        for (int i = 1; i * i <= a; i++) {
            //Factors occur in pairs (i) & n/i
            if (a % i == 0) {
                factorCount++;
                if (a/i != i) {
                    factorCount++; //if equal then the number is whole square root eg 16 - 4 - count once
                }
            }
        }
        return factorCount;
    }

    /**
     * CW2 > Is prime
     * CW2 > Is prime
     * @param a
     * @return
     */
    private boolean isPrime(int a) {
        //Approach 1 - Counting all factors [TC = O(sqrt n)]
        //        int factorCount = 0;
        //        for (int i = 1; i * i <= a; i++) {
        //            //Factors occur in pairs (i) & n/i
        //            if (a % i == 0) {
        //                factorCount++;
        //                if (a/i != i) {
        //                    factorCount++; //if equal then the number is whole square root eg 16 - 4 - count once
        //                }
        //            }
        //        }
        //        return factorCount == 2 ? true : false;

        //Approach 2 - Optimized [TC = O(sqrt n)]
        if (a == 1) return false;
        for (int i = 2; i*i <= a; i++) {
            if (a % i == 0) return false;
        }
        return true;
    }

    /**
     * CW3 > Print all primes from 1 - n (Brute Force)
     * Approach 1 - Iterate from 1 - n & evaluate isPrime => TC =O(n root n)
     * @param a
     * @return
     */
    private ArrayList<Integer> printAllPrimesTillN_BruteForce(int a) {
        //Approach 1 - Iterate from 1 - n & evaluate isPrime
        ArrayList<Integer> allPrimes = new ArrayList<>();
        for (int i = 1; i <= a; i++) {
            if (isPrime(i)) {
                allPrimes.add(i);
            }
        }
        return allPrimes;
    }

    /**
     * CW4 > Print all primes from 1 - n (Sieve of Eros)
     * @param a
     * @return
     */
    private ArrayList<Integer> printAllPrimesTillN_SieveOfErosthenes(int a) {
        //Approach 2 - Sieve of Eratosthenes
        boolean[] isPrime = new boolean[a + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = 2; i <= a; i++) {
            if (isPrime[i]) {
                for (int j = 2*i; j <= a; j=j+i) {
                    isPrime[j] = false;
                }
            }
        }

        //Just build list of primes
        ArrayList<Integer> allPrimes = new ArrayList<>();
        for (int i = 1; i <= a; i++) {
            if (isPrime[i]) {
                allPrimes.add(i);
            }
        }
        return allPrimes;
    }

    /**
     * CW5 > Print all primes from 1 - n (Sieve of Eros) - Optimized
     * @param a
     * @return
     */
    private ArrayList<Integer> printAllPrimesTillN_SieveOfErosthenes_Optimized(int a) {
        //Approach 2 - Sieve of Eratosthenes - optimized
        boolean[] isPrime = new boolean[a + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = 2; i*i <= a; i++) { //Optimization1: by i*i all the numbers get traced
            if (isPrime[i]) {
                for (int j = i * i; j <= a; j=j+i) {  //Optimization2: Start from i*i => as i*2, i*3 would be already taken care by 2*2 , 2*3 etc
                    isPrime[j] = false;
                }
            }
        }

        //Just build list of primes
        ArrayList<Integer> allPrimes = new ArrayList<>();
        for (int i = 1; i <= a; i++) {
            if (isPrime[i]) {
                allPrimes.add(i);
            }
        }
        return allPrimes;
    }

    /**
     * CW6 > Count of all divisors (Sieve algo)
     * CW6 > Count of all divisors (Sieve algo)
     * @param a
     * @return
     */
    private ArrayList<Integer> countOfAllDivisorsTillN(int a) {
        int[] divisorCount = new int[a + 1];
        Arrays.fill(divisorCount, 2);
        divisorCount[1] = 1;
        for (int i = 2; i <= a; i++) {
            for (int j = i*2; j<= a; j=j+i) {
                divisorCount[j]++;
            }
        }

        //Building the arraylist of count from 1-n
        ArrayList<Integer> factorCount = new ArrayList<>();
        for (int i = 1; i<= a; i++) {
            factorCount.add(divisorCount[i]);
        }
        return factorCount;
    }

    /*------------ASSIGNMENTS------------*/

    /**
     * AS1 > Count of divisors
     * Given an array of integers A, find and return the count of divisors of each element of the array.
     * @param A
     * @return
     */
    private ArrayList<Integer> countOfDivisors(ArrayList<Integer> A) {
        //Approach1 : Brute force
        //                ArrayList<Integer> counts = new ArrayList<>();
        //                for (int i = 0; i < A.size(); i++) {
        //                    int thisNumberDivisorCount = this.eachNumberDivisorCount(A.get(i));
        //                    counts.add(thisNumberDivisorCount);
        //                }
        //                return counts;

        //Approach2:
        int maxNumber = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > maxNumber) {
                maxNumber = A.get(i);
            }
        }

        int[] divisorCount = new int[maxNumber + 1];
        Arrays.fill(divisorCount, 2);
        divisorCount[1] = 1;
        for (int i = 2; i <= maxNumber; i++) {
            for (int j = 2*i; j <= maxNumber; j = j+i) {
                divisorCount[j]++;
            }
        }

        ArrayList<Integer> divisorCountResult = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            divisorCountResult.add(divisorCount[A.get(i)]);
        }
        return divisorCountResult;
    }
    private int eachNumberDivisorCount(int a) {
        int count = 0;
        for (int i = 1; i*i <= a; i++) {
            if (a % i == 0) {
                count++;
                if (i != a/i) {
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * AS2 > Prime Sum
     * Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
     * Eg => 4 - 2,2
     * @param A
     * @return
     */
    private ArrayList<Integer> primeSum(int A) {
        //Attempt 1: Find highest prime near A , A-x
        //TC = Find Prime for n = sqrt(n) - for n numbers TC = O(n sqrt(n))
        //        ArrayList<Integer> primes = new ArrayList<>();
        //        int higherPrime = 0;
        //        for (int i = A-2; i > 1; i--) { //Must be atleaset 2 lesser than the number as the other end must be atleast 2
        //            if (this.isPrimePrimeSum(i)) {
        //                higherPrime = i;
        //                break;
        //            }
        //        }
        //        primes.add(A - higherPrime);
        //        primes.add(higherPrime);
        //        return primes;

        //Attempt 2: Using sieve algo
        //TC = [Find Prime - O(nlogn)] + [loop to find prime O(n)] => O(n logn)
        boolean[] isPrime = new boolean[A + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = 2; i*i <= A; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= A; j=j+i) {
                    isPrime[j] = false;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        int higherPrime = 0;
        for (int i = A-2; i > 1; i--) {
            if (isPrime[i]) {
                higherPrime = i;
                int otherNumber = A-higherPrime;
                if (isPrime[otherNumber]) {
                    primes.add(otherNumber);
                    primes.add(higherPrime);
                    break;
                }
            }
        }
        return primes;
    }
    private boolean isPrimePrimeSum(int a) {
        for (int i = 2; i*i <= a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * AS3 > Lucky Number
     * A lucky number is a number which has exactly 2 distinct prime divisors.
     * You are given a number A and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).
     * @param A
     * @return
     */
    private int luckyNumber(int A) {
        //Attempt 2: Sieve of eros algo

        int[] primeFactorCounts = new int[A + 1]; //Array of all counts till N - init to 0
        Arrays.fill(primeFactorCounts, 0);

        boolean[] isPrimes = new boolean[A + 1]; //Array of boolean - isPrime
        Arrays.fill(isPrimes, true);
        isPrimes[1] = false;

        for (int i = 2; i <= A; i++) {
            if (isPrimes[i]) {
                for (int j = 2 * i; j <= A; j = j+i) {
                    isPrimes[j] = false;
                    primeFactorCounts[j]++; //Add the prime counts for all multiples of prime nos
                }
            }
        }

        int result = 0;
        for (int j = 2 ; j <= A; j++) {
            if (primeFactorCounts[j] == 2) {
                result++;
            }
        }
        return result;
    }

}
