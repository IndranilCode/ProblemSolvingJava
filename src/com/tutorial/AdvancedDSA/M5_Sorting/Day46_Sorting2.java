package com.tutorial.AdvancedDSA.M5_Sorting;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day46_Sorting2 {
    //1. Merge sort
    //2. Inversion count - Brute force / Merge sort method

    public void execute() {
        System.out.println("------------SORTING 2------------");
        System.out.println("------------CLASSWORK------------");

        //CW1 > Merge sort
        ArrayList<Integer> inputCW1 = new ArrayList<>(Arrays.asList(5, 2, 7, 12, 99, 6, 1));
        this.mergeSort(inputCW1, 0, inputCW1.size()-1);
        System.out.print("CW1 > Merge sort [5, 2, 7, 12, 99, 6, 1] => ");
        inputCW1.forEach(e -> System.out.print(e + ", "));
        System.out.println("");

        //CW2 > Inversion count of an array (Brute Force)
        ArrayList<Integer> inputCW2 = new ArrayList<>(Arrays.asList(4, 5, 1, 2, 6, 3));
        System.out.println("CW2 > Inversion count of an array (Brute Force) [4, 5, 1, 2, 6, 3] => " + this.inversionCount_bruteForce(inputCW2));

        //CW2.2 > Inversion count of an array (Merge sort)
        ArrayList<Integer> inputCW2_2 = new ArrayList<>(Arrays.asList(4, 5, 1, 2, 6, 3));
        int countResult = this.inversionCount_MergeSortTechnique(inputCW2_2, 0, inputCW2_2.size()-1, 0);
        System.out.print("    > Inversion count of an array (Merge sort) [4, 5, 1, 2, 6, 3] => " + countResult + "; Sorted Array => ");
        inputCW2_2.forEach(e -> System.out.print(e + ", "));
        System.out.println("");

        //CW3 > Lock-Key pair - Brute Force
        ArrayList<Integer> inputCW3_locks = new ArrayList<>(Arrays.asList(5, 3 ,1, 2, 7, 6, 11));
        ArrayList<Integer> inputCW3_keys = new ArrayList<>(Arrays.asList(1, 6, 5 , 7, 11, 3, 2));
        HashMap<Integer, Integer> resultCW3 = this.lockAndKeyIndexPair_bruteForce(inputCW3_locks, inputCW3_keys);
        System.out.print("CW3 > Lock-Key pair - Brute Force => [");
        for (Map.Entry<Integer, Integer> e : resultCW3.entrySet()) {
            System.out.print(e.getKey() + " : " + e.getValue() + " ,");
        }
        System.out.println("");
    }

    /**
     * CW1 > Merge sort
     * TC = O(nlog(n))
     * @param arr
     * @param start
     * @param end
     */
    private void mergeSort(ArrayList<Integer> arr, int start, int end) {
        if (start == end) return;
        int mid = (start +  end) / 2;
        this.mergeSort(arr, start, mid);
        this.mergeSort(arr, mid+1, end);
        this.merge(arr, start, mid, end);
    }
    private void merge(ArrayList<Integer> arr, int start, int mid, int end) {
        //Create 2 arrays arr1(left) & arr2(right) which are sorted by itself
        //Merge the sorted arrays arr1 & arr2
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        //Copy elements to arr1 => arr[start] - arr[mid]
        for (int k = start; k <= mid; k++) {
            arr1.add(arr.get(k));
        }
        //Copy elements to arr2 => arr[mid+1] - arr[end]
        for (int k = mid+1; k <= end; k++) {
            arr2.add(arr.get(k));
        }

        //Compare and put the elements to the original array (Arr) starting @index start (from sorted arr1 & arr2)
        int index = start; //index - start of the position where sorted elements to be written to original array
        int i = 0; //arr1 - start
        int j = 0; //arr2 - start
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                arr.set(index, arr1.get(i));
                index++;
                i++;
            } else {
                arr.set(index, arr2.get(j));
                index++;
                j++;
            }
        }
        //Copy the leftover
        while (i < arr1.size()) {
            arr.set(index, arr1.get(i));
            index++;
            i++;
        }
        while (j < arr2.size()) {
            arr.set(index, arr2.get(j));
            index++;
            j++;
        }

        return;
    }

    /**
     * CW2 > Inversion count of an array (Brute Force)
     * Total pairs (i,j) such that i<j && A[i] > A[j]
     * Eg numbers = [4, 5, 1, 2, 6, 3]
     *      index =  0  1  2  3  4  5
     *      i -> set of j index -> count
     *      0    2,3,5              3
     *      1    2,3,5              3
     *      2                       0
     *      3                       0
     *      4    5                  1
     * =====TOTAL ================> 7
     * TC = O(n2)
     * @param numbers
     * @return
     */
    private int inversionCount_bruteForce(ArrayList<Integer> numbers) {
        int count = 0;
        int pivot; //pivot is the ith element
        for (int i = 0; i <= numbers.size()-2; i++) {
            pivot = numbers.get(i);
            for (int j = i+1; j < numbers.size(); j++) {
                if (pivot > numbers.get(j)){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * CW2.2 > Inversion count of an array (Merge sort method)
     * @param arr
     * @param start
     * @param end
     * @param count
     * @return
     */
    private int inversionCount_MergeSortTechnique(ArrayList<Integer> arr, int start, int end, int count) {
        if (start == end) return 0;
        int mid = (start + end) / 2;
        int c1 = this.inversionCount_MergeSortTechnique(arr, start, mid, count);
        int c2 = this.inversionCount_MergeSortTechnique(arr, mid + 1, end, count);
        return c1 + c2 + this.mergeForInversionCount(arr, start, mid, end);
    }
    private int mergeForInversionCount(ArrayList<Integer> arr, int start, int mid, int end) {
        int count = 0;
        //Create 2 arrays arr1(left) & arr2(right) which are sorted by itself
        //Merge the sorted arrays arr1 & arr2
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        //Copy elements to arr1 => arr[start] - arr[mid]
        for (int k = start; k <= mid; k++) {
            arr1.add(arr.get(k));
        }
        //Copy elements to arr2 => arr[mid+1] - arr[end]
        for (int k = mid+1; k <= end; k++) {
            arr2.add(arr.get(k));
        }

        int arr1Len = arr1.size();
        int arr2Len = arr2.size();
        int i = 0, j = 0, index = start;
        while (i < arr1Len && j < arr2Len) {
            if (arr2.get(j) < arr1.get(i)) {
                count = count + (arr1Len - i);
                arr.set(index, arr2.get(j));
                index++;
                j++;
            } else {
                arr.set(index, arr1.get(i));
                index++;
                i++;
            }
        }
        //Copy the leftover
        while (i < arr1Len) {
            arr.set(index, arr1.get(i));
            index++;
            i++;
        }
        while (j < arr2Len) {
            arr.set(index, arr2.get(j));
            index++;
            j++;
        }
        return count;
    }

    /**
     * CW3 > Lock-Key pair - Brute Force
     * @param locks
     * @param keys
     * @return
     */
    private HashMap<Integer, Integer> lockAndKeyIndexPair_bruteForce(ArrayList<Integer> locks, ArrayList<Integer> keys) {
        HashMap<Integer, Integer> lockKeyRelation = new HashMap<>();
        int currentLock, currentKey;
        for (int i = 0; i < locks.size(); i++) {
            currentLock = locks.get(i);
            for (int j = 0; j < keys.size(); j++) {
                currentKey = keys.get(j);
                if (currentLock == currentKey) {
                    lockKeyRelation.put(i, j);
                }
            }
        }
        return lockKeyRelation;
    }
}
