package com.tutorial.AdvancedDSA.M7_2Pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class Day51_2Pointer {
    public void execute() {
        System.out.println("--------------2 POINTERS---------------");
        System.out.println("------------CLASSWORK------------------");
        //CW1 > Sorted array (Sum) => Find pair (i,j) => A[i] + A[j] = k
        ArrayList<Integer> inputCW1 = new ArrayList<>(Arrays.asList(1, 3, 5, 10, 20, 23, 30));
        ArrayList<Integer> resultCW1 = this.sumIJEqualsK(inputCW1, 23);
        System.out.print("CW1 > Sorted array => Find pair (i,j) => A[i] + A[j] = 23;  [1, 3, 5, 10, 20, 23, 30] => [");
        resultCW1.forEach(e -> System.out.print(e + ","));
        System.out.println("]");

        //CW2 > Sorted array (Diff) => Find pair (i,j) => A[j] - A[i] = k
        ArrayList<Integer> inputCW2 = new ArrayList<>(Arrays.asList(1, 3, 5, 10, 20, 23, 30));
        ArrayList<Integer> resultCW2 = this.differenceIJEqualsK(inputCW2, 15);
        System.out.print("CW2 > Sorted array (Diff) => Find pair (i,j) => A[i] - A[j] = 15;  [1, 3, 5, 10, 20, 23, 30] => [");
        resultCW2.forEach(e -> System.out.print(e + ","));
        System.out.println("]");
        ArrayList<Integer> resultCW2_2 = this.differenceIJEqualsK(inputCW2, -15);
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
    }

    /**
     * CW1 > Sorted array (Sum) => Find pair (i,j) => A[i] + A[j] = k
     * Sorted array of size N and integer k, find pair (i,j) such that A[i] + A[j] = k
     * TC = O(N)
     * @param numbers
     * @param k
     * @return
     */
    private ArrayList<Integer> sumIJEqualsK(ArrayList<Integer> numbers, int k) {
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
    private ArrayList<Integer> differenceIJEqualsK(ArrayList<Integer> numbers, int k) {
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
                    result.add(i);
                    result.add(mid);
                    return result;
                } else if (numbers.get(mid) > requiredDiffToFind) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return result;
    }
}
