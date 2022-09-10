package com.tutorial.IntermediateDSA.M3_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day10_ArraysDynamicArrays {
    public void execute() {
        System.out.println("-----Intermediate : Day 10: Arrays & Dynamic Arrays--------");
        System.out.println("-------------------------ASSIGNMENT------------------------");

        //AS1 > GoodPair [Easy]
        ArrayList<Integer> inputAS1 = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        System.out.println("AS1 > GoodPair (1,2,3,4) [Total = 7] => " + this.goodPair(inputAS1, 7));

        //AS2> FizzBuzz [Easy]
        ArrayList<String> outputAS2 = fizzBuzz(5);
        System.out.print("AS2 > FizzBuzz (5) => [");
        outputAS2.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println("]");

        //AS3 > TimeToEquality [Easy]
        ArrayList<Integer> inputAS3 = new ArrayList<Integer>(Arrays.asList(2, 4, 1, 3, 2));
        System.out.println("AS3 > TimeToEquality (2, 4, 1, 3, 2) => " + this.timeToEquality(inputAS3));

        //AS4 > Rotation Game [Easy]
        ArrayList<Integer> inputAS4 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> outputAS4 = rotationGame(inputAS4, 2);
        System.out.print("AS4 > Rotation Game (1, 2, 3, 4) [Rotation = 2] => [");
        outputAS4.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println("]");
        ArrayList<Integer> inputAS4b = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        ArrayList<Integer> outputAS4b = rotationGame(inputAS4b, 3);
        System.out.print("    > Rotation Game (1, 2, 3, 4, 5, 6, 7, 8) [Rotation = 3] => [");
        outputAS4b.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println("]");

        //AS5 > Leaders in an array [Easy]
        ArrayList<Integer> inputAS5 = new ArrayList<Integer>(Arrays.asList(16, 17, 4, 3, 5, 2));
        ArrayList<Integer> outputAS5 = leadersInTheArray(inputAS5);
        System.out.print("AS5 > Leaders in an array (16, 17, 4, 3, 5, 2) => [");
        outputAS5.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println("]");

        //AS6 > Max Sum Contiguous Subarray (Kadane's algo) [Medium]
        ArrayList<Integer> inputAS6 = new ArrayList<Integer>(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4));
        System.out.println("AS6 > Max Sum Contiguous Subarray (-2, 1, -3, 4, -1, 2, 1, -5, 4) [Kadane's algo] => " + this.maxSumContiguousSubarray(inputAS6));
        ArrayList<Integer> inputAS6_2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, -10));
        System.out.println("    > Max Sum Contiguous Subarray (1, 2, 3, 4, -10) [Kadane's algo] => " + this.maxSumContiguousSubarray(inputAS6_2));

        //AS7 > Multiple left rotations of the array [Easy]
        ArrayList<Integer> inputAS7 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> inputAS7b = new ArrayList<Integer>(Arrays.asList(2, 3, 7));
        ArrayList<ArrayList<Integer>> outputAS7 = multipleLeftRotateArray(inputAS7, inputAS7b);
        System.out.print("AS7 > Multiple left rotations of the array [1, 2, 3, 4, 5] Times = (2, 3, 7) => [ ");
        outputAS7.forEach(eachRow -> {
            System.out.print("[");
            eachRow.forEach(eachItem -> {
                System.out.print(eachItem + ",");
            });
            System.out.print("]");
        });
        System.out.println(" ]");

        //AS8 > Noble Integer [Medium]
        ArrayList<Integer> inputAS8 = new ArrayList<Integer>(Arrays.asList(3, 2, 1, 3));
        Integer outputAS8 = nobleInteger(inputAS8);
        System.out.println("AS8 > Noble Integer (3, 2, 1, 3) => " + outputAS8);

        //AS9 > Reverse the array [Easy]
        ArrayList<Integer> inputAS9 = new ArrayList<Integer>(Arrays.asList(1,2,3,2,1,9));
        ArrayList<Integer> outputAS9 = reverseArray(inputAS9);
        System.out.print("AS9 > Reverse the array (1,2,3,2,1,9) => [");
        outputAS9.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println("]");

        //AS10 > Subarray with least average [Easy]
        ArrayList<Integer> inputAS10 = new ArrayList<Integer>(Arrays.asList(20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11));
        System.out.println("AS10 > Subarray with least average [20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11] (K = 9) => " + this.subarrayWithLeastAverage(inputAS10, 9));

        System.out.println("-------------------------HOMEWORK--------------------------");

        //HW1 > Multiplication of previous and next
        ArrayList<Integer> inputHW1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> outputHW1 = multiplicationOfPreviousNext(inputHW1);
        System.out.print("HW1 > Multiplication of previous and next (1, 2, 3, 4, 5) => [");
        outputHW1.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println("]");

        //HW2 > Primal Power
        ArrayList<Integer> inputHW2 = new ArrayList<Integer>(Arrays.asList(-11, 7, 8, 9, 10, 11));
        System.out.println("HW2 > Primal Power (-11, 7, 8, 9, 10, 11) => " + this.primalPower(inputHW2));

        //HW3 > Copy the Array
        ArrayList<Integer> inputHW3 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 2, 1));
        ArrayList<Integer> outputHW3 = copyTheArray(inputHW3, 3);
        System.out.print("HW3 > Copy the Array (1, 2, 3, 2, 1) (k = 3) => [");
        outputHW3.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println("]");

        //HW4 > MAX - MIN
        ArrayList<Integer> inputHW4 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        int outputHW4 = maxMinBth(inputHW4, 2);
        System.out.println("HW4 > MAX - MIN (1, 2, 3, 4, 5) => " + outputHW4);

        //HW5 > Max Min
        ArrayList<Integer> inputHW5 = new ArrayList<Integer>(Arrays.asList(-2, 1, -4, 5, 3));
        int outputHW5 = maxMin(inputHW5);
        System.out.println("HW5 > Max Min (-2, 1, -4, 5, 3) => " + outputHW5);

//        //AS6> GoodPair
//        ArrayList<Integer> inputHW2 = new ArrayList<Integer>(Arrays.asList(2, 4, 1, 3, 2));
//        System.out.println("AS6 - Array with consecutive elements :");
//        inputHW2.forEach(e -> {
//            System.out.print(3);
//            System.out.print(3);
//        });

    }

    //---------------------ASSIGNMENTS-------------------------

    /**
     * AS1 > Good Pair
     * Given an array A and a integer B. A pair(i,j) in the array is a good pair if i!=j and (A[i]+A[j]==B).
     * Check if any good pair exist or not.
     * Example =>
     * A = [1,2,3,4], B = 7 => o/p = 1
     * A = [1,2,4], B = 4 => o/p => 0
     * @param A
     * @param B
     * @return
     */
    private int goodPair(ArrayList<Integer> A, int B) {
        int doesPairExist = 0;
        for (int i = 0; i < A.size(); i++ ) {
            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(i) + A.get(j) == B) {
                    doesPairExist = 1;
                    break;
                }
            }
        }
        return doesPairExist;
    }

    /**
     * AS2 > FizzBuzz
     * Given a positive integer A, return an array of strings with all the integers from 1 to N.
     * But for multiples of 3 the array should have “Fizz” instead of the number.
     * For the multiples of 5, the array should have “Buzz” instead of the number.
     * For numbers which are multiple of 3 and 5 both, the array should have "FizzBuzz" instead of the number.
     * O/P => A = 5 => [1 2 Fizz 4 Buzz]
     * @param A
     * @return
     */
    private ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> fizzBuzzList = new ArrayList<String>();
        for (int i = 1; i <= A; i++) {
            String appendEach = "";
            if ((i % 3 == 0) || (i % 5 == 0)) {
                if (i % 3 == 0) {
                    appendEach = appendEach + "Fizz";
                }
                if (i % 5 == 0) {
                    appendEach = appendEach + "Buzz";
                }
            } else {
                appendEach = (new Integer(i)).toString();
            }
            fizzBuzzList.add(appendEach);
        }
        return fizzBuzzList;
    }

    /**
     * AS3 > Time to equality
     * Given an integer array A of size N. In one second you can increase the value of one element by 1.
     * Find the minimum time in seconds to make all elements of the array equal.
     * O/P => Return an integer denoting the minimum time to make all elements equal.
     * Example =>  [2, 4, 1, 3, 2] => We can change the array A = [4, 4, 4, 4, 4]. The time required will be 8 seconds. (O/p 8)
     * @param A
     * @return
     */
    private int timeToEquality(ArrayList<Integer> A) {
        int maxNumber = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > maxNumber) {
                maxNumber = A.get(i);
            }
        }

        int timeToEquality = 0;
        for (int i = 0; i < A.size(); i++) {
            timeToEquality = timeToEquality + (maxNumber - A.get(i));
        }
        return timeToEquality;
    }

    /**
     * AS4 > Rotation Game
     * You are given an integer array A and an integer B.
     * You have to print the same array after rotating it B times towards right.
     * Example => [1 2 3 4] , 2 times => [1,2,3,4] => [4,1,2,3] => [3,4,1,2]
     * @param A
     * @return
     */
    private ArrayList<Integer> rotationGame(ArrayList<Integer> A, int B) {
        Integer[] output = new Integer[A.size()];
        for (int i = 0; i < A.size(); i++) {
            int newIndex = (i + B) % A.size();
            output[newIndex] = A.get(i);
        }
        return new ArrayList<>(Arrays.asList(output));
    }

    /**
     * AS5 > Leaders in an array
     * Given an integer array A containing N distinct integers, you have to find all the leaders in the array A.
     * An element is leader if it is strictly greater than all the elements to its right side.
     * Example => [16, 17, 4, 3, 5, 2] => o/p : [17, 2, 5]
     * [1, 2] => o/p : [2]
     * @param A
     * @return
     */
    private ArrayList<Integer> leadersInTheArray(ArrayList<Integer> A) {
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {
            Boolean isAddElement = true;
            for (int j = i + 1; j < A.size(); j++ ) {
                if (A.get(i) <  A.get(j)) {
                    isAddElement = false;
                    break;
                }
            }
            if (isAddElement) {
                output.add(A.get(i));
            }
        }
        return output;

        //Better approach => Scan all the elements from right to left in an array and keep track of maximum till now.
        // When maximum changes its value, print it.
    }

    /**
     * AS6 > Max Sum Contiguous Subarray (Kadane's algo)
     * Find the contiguous subarray within an array, A of length N which has the largest sum.
     * O/P => Return an integer representing the maximum possible sum of the contiguous subarray.
     * Example => A = [1, 2, 3, 4, -10]  => 10 => The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
     * [-2, 1, -3, 4, -1, 2, 1, -5, 4] => 6 => The subarray [4,-1,2,1] has the maximum possible sum of 6.
     * @param A
     * @return
     */
    private int maxSumContiguousSubarray(ArrayList<Integer> A) {
        // Approach 1 => Brute Force 1 => Time Limit Exceeded => O(N^3)
        //        int maxSum = Integer.MIN_VALUE;
        //        for (int i = 0; i < A.size(); i++) {
        //            for (int j = i; j < A.size(); j++) {
        //                int sum = 0;
        //                for (int k = i; k <= j; k++) {
        //                    sum = sum + A.get(k);
        //                }
        //                if (sum > maxSum) {
        //                    maxSum = sum;
        //                }
        //            }
        //        }
        //        return maxSum;

        // Approach 2 (Kadane's algo) O(n)
        int maxSum = Integer.MIN_VALUE;
        int runningSum = 0;
        for (int i = 0; i < A.size(); i++) {
            runningSum = runningSum + A.get(i);
            if (runningSum > maxSum) {
                maxSum = runningSum;
            }
            if (runningSum < 0) {
                runningSum = 0;
            }
        }
        return maxSum;
    }

    /**
     * AS7 > Multiple left rotations of the array
     * Given an array of integers A and multiple values in B which represents number of times array A needs to be left rotated.
     * Find the rotated array for each value and return the result in the from of a matrix where i'th row
     * represents the rotated array for the i'th value in B.
     * Example => A = [1, 2, 3, 4, 5], B = [2, 3] =>
     * [ [3, 4, 5, 1, 2]
     * [4, 5, 1, 2, 3] ]
     * @param A
     * @param B
     * @return
     */
    private ArrayList<ArrayList<Integer>> multipleLeftRotateArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<ArrayList<Integer>> finalMultiLeftRotateResult = new ArrayList<>();
        for (int eachRow = 0; eachRow < B.size(); eachRow++) {
            Integer[] output = new Integer[A.size()];
            for (int i = 0; i < A.size(); i++) {
                int basicRotationNumber = B.get(eachRow) % A.size();
                int newIndex = i < basicRotationNumber ? (i + A.size() - basicRotationNumber)  : (i - basicRotationNumber);
                output[newIndex] = A.get(i);
            }
            finalMultiLeftRotateResult.add(new ArrayList<>(Arrays.asList(output)));
        }
        return finalMultiLeftRotateResult;
    }

    /**
     * AS8 > Noble Integer
     * Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p.
     * @param A
     * @return
     */
    private int nobleInteger(ArrayList<Integer> A) {
        //Approach 1 > Brute Force => Time Limit Exceeded
        //        int nobleInteger = -1;
        //        for (int i = 0; i < A.size(); i++) {
        //            int totalExcess = 0;
        //            for (int j = 0; j < A.size(); j++) {
        //                if (A.get(i) < A.get(j)) {
        //                    totalExcess++;
        //                }
        //            }
        //            if (A.get(i) == totalExcess) {
        //                nobleInteger = 1;
        //                break;
        //            }
        //            System.out.println(A.get(i) + " : " + totalExcess);
        //        }
        //        return nobleInteger;

        //Approach 2 >
        int nobleInteger = -1;
        Collections.sort(A);
        for (int i = 0; i < A.size() ; i++) {
            if (A.get(i) == (A.size() - i - 1)){
                nobleInteger = 1;
            }
        }
        return nobleInteger;
    }

    //Better approach => Scan all the elements from right to left in an array and keep track of maximum till now.
    // When maximum changes its value, print it.

    /**
     * AS9 > Reverse the Array
     * You are required to return another array which is the reversed form of input array.
     * Example: [1,1,10] => [10,1,1]
     * @param A
     * @return
     */
    private ArrayList<Integer> reverseArray(final List<Integer> A) {
        ArrayList<Integer> reverseArray = new ArrayList<>();
        for (int i = A.size() - 1 ; i >= 0; i--) {
            reverseArray.add(A.get(i));
        }
        return reverseArray;
    }

    /**
     * AS10 > Subarray with least average
     * Given an array of size N, Find the subarray with least average of size k.
     * Return the index of the first element of the subarray of size k that has least average. Array indexing starts from 0.
     * Example => A=[3, 7, 90, 20, 10, 50, 40] , B=3 => o/p 3 The subarray {20, 10, 50} has the least average of size 3
     * @param A
     * @param B
     * @return
     */
    private int subarrayWithLeastAverage(ArrayList<Integer> A, int B) {
        int startIndexOfSubarrayWithLeastAverage = 0;
        int leastTotal = Integer.MAX_VALUE;
        for (int i = 0; i < A.size() - B + 1; i++) {
            int total = 0;
            for (int j = 0; j < B; j++) {
                total = total + A.get(i + j);
            }
            if (total < leastTotal) {
                leastTotal = total;
                startIndexOfSubarrayWithLeastAverage = i;
            }
        }
        return startIndexOfSubarrayWithLeastAverage;
        //NOTE: Averaging is causing loss of precision on conversion to int - so did it with total itself.
    }

    //----------------------HOMEWORK------------------------

    /**
     * HW1 > Multiplication of previous and next [Easy]
     * Given an array of integers A, update every element with multiplication of previous and next elements with following exceptions.
     * a) First element is replaced by multiplication of first and second.
     * b) Last element is replaced by multiplication of last and second last.
     * Example => A = [1, 2, 3, 4, 5] => [2, 3, 8, 15, 20]
     * @param A
     * @return
     */
    private ArrayList<Integer> multiplicationOfPreviousNext(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A.size() > 1) {
            for (int i = 0; i< A.size(); i++) {
                int product = 0;
                if (i == 0) {
                    product = A.get(i) * A.get(i + 1);
                } else if (i == (A.size() - 1)) {
                    product = A.get(i) * A.get(i - 1);
                } else {
                    product = A.get(i - 1) * A.get(i + 1);
                }
                result.add(product);
            }
        } else {
            result = A;
        }
        return result;
    }

    /**
     * HW2 > Primal Power [Easy]
     * "Primal Power" of an array is defined as the count of prime numbers present in it.
     * Example => A = [-11, 7, 8, 9, 10, 11] => 7 and 11 are prime numbers. Hence, Primal Power = 2.
     * @param A
     * @return
     */
    private int primalPower(ArrayList<Integer> A) {
        int result = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > 1) {
                Boolean isDivisible = false;
                for (int j = 2; j*j <= A.get(i); j++) {
                    if ((A.get(i) % j) == 0) {
                        isDivisible = true;
                        break;
                    }
                }
                if (!isDivisible) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * HW3 > Copy the Array [Easy]
     * You are given a constant array A and an integer B. You are required to return another array where outArr[i] = A[i] + B.
     * Example => A = [1,2,3,2,1] , B = 3 => O/P [4,5,6,5,4]
     * @param A
     * @param B
     * @return
     */
    private ArrayList<Integer> copyTheArray(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {
            result.add(A.get(i) + B);
        }
        return result;
    }

    /**
     * HW 4 > MAX - MIN [Easy]
     * Given an array of integers A and an integer B, find and return the difference of B'th max element and B'th min element of the array A.
     * Example => A = [1, 2, 3, 4, 5] , B = 2  => 2   (4 - 2 = 2)
     * @param A
     * @param B
     * @return
     */
    private int maxMinBth(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        //        System.out.println(A);
        return A.get(A.size() - B) - A.get(B - 1);
    }

    /**
     * HW5 > Max Min [Easy]
     * Given an array A of size N. You need to find the sum of Maximum and Minimum element in the given array.
     * Example => A = [-2, 1, -4, 5, 3] , B = 3 => O/P 1
     * @param A
     * @return
     */
    private int maxMin(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > max) {
                max = A.get(i);
            } else if (A.get(i) < min) {
                min = A.get(i);
            }
        }
        return max + min;
    }
}
