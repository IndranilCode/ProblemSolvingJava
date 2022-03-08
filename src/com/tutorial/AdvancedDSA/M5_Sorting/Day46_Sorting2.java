package com.tutorial.AdvancedDSA.M5_Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class Day46_Sorting2 {
    public void execute() {
        System.out.println("------------SORTING 2------------");
        System.out.println("------------CLASSWORK------------");
        ArrayList<Integer> inputCW1 = new ArrayList<>(Arrays.asList(5, 2, 7, 12, 99, 6, 1));
        //        ArrayList<Integer> resultCW1 = this.mergeSort(inputCW1, 0, inputCW1.size()-1);
        this.mergeSort(inputCW1, 0, inputCW1.size()-1);
        System.out.print("CW1 > Merge sort [5, 2, 7, 12, 99, 6, 1] => ");
        inputCW1.forEach(e -> System.out.print(e + ", "));
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
}
