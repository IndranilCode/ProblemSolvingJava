package com.tutorial.AdvancedDSA.M7_2Pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class Day51_2Pointer {
    public void execute() {
        System.out.println("--------------2 POINTERS---------------");
        System.out.println("------------CLASSWORK------------------");
        //CW1 > Sorted array (Sum) => Find pair (i,j) => A[i] + A[j] = k
        ArrayList<Integer> inputCW1 = new ArrayList<>(Arrays.asList(1, 3, 5, 10, 20, 23, 30));
        ArrayList<Integer> resultCW1 = this.sumIJEqualsK_2Pointer(inputCW1, 23);
        System.out.print("CW1 > Sorted array => Find pair (i,j) => A[i] + A[j] = 23;  [1, 3, 5, 10, 20, 23, 30] => [");
        resultCW1.forEach(e -> System.out.print(e + ","));
        System.out.println("]");

        //CW2 > Sorted array (Diff) => Find pair (i,j) => A[j] - A[i] = k
        ArrayList<Integer> inputCW2 = new ArrayList<>(Arrays.asList(1, 3, 5, 10, 20, 23, 30));
        ArrayList<Integer> resultCW2 = this.differenceIJEqualsK_2Pointer(inputCW2, 15);
        System.out.print("CW2 > Sorted array (Diff) => Find pair (i,j) => A[i] - A[j] = 15;  [1, 3, 5, 10, 20, 23, 30] => [");
        resultCW2.forEach(e -> System.out.print(e + ","));
        System.out.println("]");
        ArrayList<Integer> resultCW2_2 = this.differenceIJEqualsK_2Pointer(inputCW2, -15);
        System.out.print("    > Sorted array (Diff) => Find pair (i,j) => A[i] - A[j] = -15;  [1, 3, 5, 10, 20, 23, 30] => [");
        resultCW2_2.forEach(e -> System.out.print(e + ","));
        System.out.println("]");

        //CW2_2 > Sorted array (Diff) [BS Method] => Find pair (i,j) => A[j] - A[i] = k
        ArrayList<Integer> inputCW2b = new ArrayList<>(Arrays.asList(1, 3, 5, 10, 20, 23, 30));
        ArrayList<Integer> resultCW2b = this.differenceIJEqualsK_BS(inputCW2b, 15);
        System.out.print("CW2_2 > Sorted array (Diff) [BS Method] => Find pair (i,j) => A[i] - A[j] = 15;  [1, 3, 5, 10, 20, 23, 30] => [");
        resultCW2b.forEach(e -> System.out.print(e + ","));
        System.out.println("]");
        ArrayList<Integer> resultCW2_2b = this.differenceIJEqualsK_BS(inputCW2, -15);
        System.out.print("      > Sorted array (Diff) [BS Method] => Find pair (i,j) => A[i] - A[j] = -15;  [1, 3, 5, 10, 20, 23, 30] => [");
        resultCW2_2b.forEach(e -> System.out.print(e + ","));
        System.out.println("]");

//        ArrayList<Integer> inputCW2c = new ArrayList<>(Arrays.asList(1, 3, 3, 5, 10, 20, 23, 30));
//        ArrayList<Integer> resultCW2c = this.differenceIJEqualsK_BS(inputCW2c, 0);
//        System.out.print("CW2_2 > Sorted array (Diff) [BS Method] => Find pair (i,j) => A[i] - A[j] = 0;  [1, 3, 3, 5, 10, 20, 23, 30] => [");
//        resultCW2c.forEach(e -> System.out.print(e + ","));
//        System.out.println("]");

        //CW3 > Sorted array (Triplet Sum) => Find pair (i,j,k) => A[j]+A[i]+A[k] = X
        ArrayList<Integer> inputCW3a = new ArrayList<>(Arrays.asList(1, 3, 5, 10, 20, 23));
        ArrayList<Integer> resultCW3a = this.tripletSumEqualsK_2Pointer(inputCW3a, 38);
        System.out.print("CW3 > Sorted array (Triplet Sum) => Find pair (i,j,k) => A[j]+A[i]+A[k] = 38;  [1, 3, 5, 10, 20, 23, 30] => [");
        resultCW3a.forEach(e -> System.out.print(e + ","));
        System.out.println("]");
        ArrayList<Integer> resultCW3b = this.tripletSumEqualsK_2Pointer(inputCW3a, 37);
        System.out.print("    > Sorted array (Triplet Sum) => Find pair (i,j,k) => A[j]+A[i]+A[k] = 37;  [1, 3, 5, 10, 20, 23, 30] => [");
        resultCW3b.forEach(e -> System.out.print(e + ","));
        System.out.println("]");

        //CW3_2 > Sorted array (Triplet Sum) [BS Method] => Find pair (i,j,k) => A[j]+A[i]+A[k] = X
        ArrayList<Integer> inputCW3_2a = new ArrayList<>(Arrays.asList(1, 3, 5, 10, 20, 23));
        ArrayList<Integer> resultCW3_2a = this.tripletSumEqualsK_BS(inputCW3_2a, 38);
        System.out.print("CW3_2 > Sorted array (Triplet Sum) [BS Method] => Find pair (i,j,k) => A[j]+A[i]+A[k] = 38;  [1, 3, 5, 10, 20, 23, 30] => [");
        resultCW3_2a.forEach(e -> System.out.print(e + ","));
        System.out.println("]");
        ArrayList<Integer> inputCW3_2b = this.tripletSumEqualsK_BS(inputCW3_2a, 37);
        System.out.print("      > Sorted array (Triplet Sum) [BS Method] => Find pair (i,j,k) => A[j]+A[i]+A[k] = 37;  [1, 3, 5, 10, 20, 23, 30] => [");
        inputCW3_2b.forEach(e -> System.out.print(e + ","));
        System.out.println("]");
    }

    /**
     * CW1 > Sorted array (Sum) => Find pair (i,j) => A[i] + A[j] = k
     * Sorted array of size N and integer k, find pair (i,j) such that A[i] + A[j] = k
     * TC = O(N)
     * @param numbers
     * @param k
     * @return
     */
    private ArrayList<Integer> sumIJEqualsK_2Pointer(ArrayList<Integer> numbers, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = numbers.size() - 1;
        int currentSum;
        while (i < j) {
            currentSum = numbers.get(i) + numbers.get(j);
            if (currentSum == k) {
                result.add(i);
                result.add(j);
                break;
            } else if (currentSum > k) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }

    /**
     * CW2 > Sorted array (Diff) => Find pair (i,j) => A[j] - A[i] = k
     * Sorted array of size N and integer k, find pair (i,j) such that A[i] - A[j] = k
     * TC = O(N)
     * @param numbers
     * @param k
     * @return
     */
    private ArrayList<Integer> differenceIJEqualsK_2Pointer(ArrayList<Integer> numbers, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int currentDiff;
        int n = numbers.size() - 1;
        while (i <= n && j <= n) {
            currentDiff = numbers.get(j) - numbers.get(i);
            if (currentDiff == k) {
                result.add(i);
                result.add(j);
                break;
            } else if (currentDiff < k) {
                j++;
            } else {
                i++;
            }
        }
        return result;
    }

    /**
     * CW2_2 > Sorted array (Diff) [BS Method] => Find pair (i,j) => A[j] - A[i] = k
     * TC = O(n log n)
     * @param numbers
     * @param k
     * @return
     */
    private ArrayList<Integer> differenceIJEqualsK_BS(ArrayList<Integer> numbers, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int requiredDiffToFind;
        int low;
        int high;
        int mid;
        for (int i = 0; i < numbers.size(); i++) {
            requiredDiffToFind = k + numbers.get(i); // A[j] - A[i] = k , A[j] = k = A[i]
            //Search for this requiredDiffToFind in the array
            low = 0;
            high = numbers.size() - 1;
            while (low <= high) {
                mid = (low + high) / 2;
                if (numbers.get(mid) == requiredDiffToFind) {
                    if (i == mid) { //if same number
                        mid++;
                    } else {
                        result.add(i);
                        result.add(mid);
                        return result;
                    }
                } else if (numbers.get(mid) > requiredDiffToFind) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return result;
    }

    /**
     * CW3 > Triplet sum = X ( A[i] + A[j] + A[k] = X)
     * A = [1, 3, 5, 10, 20, 23], X=38 ==> (2, 3, 5)
     * @param numbers
     * @param k
     * @return
     */
    private ArrayList<Integer> tripletSumEqualsK_2Pointer(ArrayList<Integer> numbers, int k) {
        //A[i] + A[j] + A[k] = X
        //A[j] + A[k] = X - A[i]
        //Fix i and then find A[j] + A[k] = CalcVal by 2 pointers
        ArrayList<Integer> result = new ArrayList<>();
        int requiredSumToFind;
        int x; //2 pointer var
        int y; //2 pointer var
        int runningSum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            requiredSumToFind = k - numbers.get(i);
            //Now with 2 pointer find A[j] + A[k] = requiredSumToFind
            x = 0;
            y = numbers.size() - 1;
            while (x < y) {
                runningSum = numbers.get(x) + numbers.get(y);
                if (runningSum == requiredSumToFind) {
                    result.add(i);
                    result.add(x);
                    result.add(y);
                    return result;
                } else if (runningSum < requiredSumToFind) {
                    x++;
                } else {
                    y--;
                }
            }
        }
        return result;
    }

    /**
     * CW3 > Triplet sum [BS] = X ( A[i] + A[j] + A[k] = X)
     * A = [1, 3, 5, 10, 20, 23], X=38 ==> (2, 3, 5)
     * TC = O (n2 log n)
     * @param numbers
     * @param k
     * @return
     */
    private ArrayList<Integer> tripletSumEqualsK_BS(ArrayList<Integer> numbers, int k) {
        //A[i] + A[j] + A[k] = X
        //A[k] = X - A[i] - A[j]
        //Fix i & j and then find k
        ArrayList<Integer> result = new ArrayList<>();
        int requiredNumberToFind;
        int low, high, mid;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i+1; j < numbers.size(); j++) {
                requiredNumberToFind = k - numbers.get(i) - numbers.get(j);

                low = 0;
                high = numbers.size() - 1;
                while (low <= high) {
                    mid = (low + high) / 2;
                    if (numbers.get(mid) == requiredNumberToFind) {
                        result.add(i);
                        result.add(j);
                        result.add(mid);
                        return result;
                    } else if (numbers.get(mid) > requiredNumberToFind) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        return result;
    }
}
