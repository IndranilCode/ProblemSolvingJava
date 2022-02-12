package com.tutorial.Advanced.Maths;

import java.util.ArrayList;
import java.util.Arrays;

public class Day38_PrimeNumbers {
    public void execute() {
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
        System.out.print("CW3 > Print all primes from (1 - n) (Brute Force) : ");
        ArrayList<Integer> resultCS3 = this.printAllPrimesTillN_BruteForce(100);
        resultCS3.forEach(e -> System.out.print(e + ", "));
        System.out.println();

        //CW4 > Print all primes from 1 - n (Sieve of Eros)
        System.out.print("CW4 > Print all primes from 1 - n (Sieve of Eros) : ");
        ArrayList<Integer> resultCS4 = this.printAllPrimesTillN_SieveOfErosthenes(100);
        resultCS4.forEach(e -> System.out.print(e + ", "));
        System.out.println();
    }

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
     * CW2> Is prime
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
            for (int j = 2*i; j <= a; j=j+i) {
                isPrime[j] = false;
            }
        }

        ArrayList<Integer> allPrimes = new ArrayList<>();
        for (int i = 1; i <= a; i++) {
            if (isPrime[i]) {
                allPrimes.add(i);
            }
        }
        return allPrimes;
    }
}
