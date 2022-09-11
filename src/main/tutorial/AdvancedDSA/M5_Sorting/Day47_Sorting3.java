package main.tutorial.AdvancedDSA.M5_Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Day47_Sorting3 {
    public void execute() {
        System.out.println("------------SORTING 3------------");
        System.out.println("------------CLASSWORK------------");

        ArrayList<Integer> inputCW1 = new ArrayList<>(Arrays.asList(1, 34, 10, 2, 1, 8));
        ArrayList<Integer> resultCW1 = this.quickSort_lastPivot(inputCW1);
        System.out.print("CW1   > Quicksort (Pivot : Last element) [1, 34, 10, 2, 1, 8] => [ ");
        resultCW1.forEach(e -> System.out.print(e + " ,"));
        System.out.println(" ]");

        ArrayList<Integer> inputCW1_2 = new ArrayList<>(Arrays.asList(1, 34, 10, 2, 1, 8));
        ArrayList<Integer> resultCW1_2 = this.quickSort_randomPivot(inputCW1_2);
        System.out.print("CW1.1 > Quicksort (Pivot : Random element) [1, 34, 10, 2, 1, 8] => [ ");
        resultCW1_2.forEach(e -> System.out.print(e + " ,"));
        System.out.println(" ]");

        System.out.println("------------ASSIGNMENTS------------");

        ArrayList<Integer> inputAS1 = new ArrayList<>(Arrays.asList(5, 4, 2));
        int resultAS1 = this.sumTheDifference(inputAS1);
        System.out.println(resultAS1);

    }

    /**
     * CW1 > Quicksort (Pivot : Last element)
     * @param A
     * @return
     */
    private ArrayList<Integer> quickSort_lastPivot(ArrayList<Integer> A) {
        this.quickSort_recursion_lastPivot(A, 0, A.size() - 1);
        return A;
    }
    private void quickSort_recursion_lastPivot(ArrayList<Integer> A, int start, int end) {
        if (start >= end) return;

        int pivotIndex = this.partition_lastElement(A, start, end);

        this.quickSort_recursion_lastPivot(A, start, pivotIndex - 1);
        this.quickSort_recursion_lastPivot(A, pivotIndex + 1, end);
    }
    private int partition_lastElement(ArrayList<Integer> A, int start, int end) {
        int pivotElement = A.get(end); //Last item is pivot

        int i = start - 1;

        //Swap lower numbers
        for (int k = start; k < end; k++) {
            int currentElement = A.get(k);
            if (currentElement < pivotElement) {
                i = i + 1;
                this.swap(A, i, k);
            }
        }
        //Swap pivot with just after lower numbers
        this.swap(A,i+1, end); // end = pivot
        return i + 1; //Final position of pivot
    }
    private void swap(ArrayList<Integer> A, int index1, int index2) {
        int temp = A.get(index1);
        A.set(index1, A.get(index2));
        A.set(index2, temp);
    }

    /**
     * CW1.1 > Quicksort (Pivot : Random element)
     * @param A
     * @return
     */
    private ArrayList<Integer> quickSort_randomPivot(ArrayList<Integer> A) {
        this.quickSort_recursion_randomPivot(A, 0, A.size() - 1);
        return A;
    }
    private void quickSort_recursion_randomPivot(ArrayList<Integer> A, int start, int end) {
        if (start >= end) return;

        int pivotIndex = this.partition_randomPivot(A, start, end);
        this.quickSort_recursion_randomPivot(A, start, pivotIndex - 1);
        this.quickSort_recursion_randomPivot(A, pivotIndex + 1, end);
    }
    private int partition_randomPivot(ArrayList<Integer> A, int start, int end) {
        Random r = new Random();
        int low = start;
        int high = end;
        int randomIndex = r.nextInt(high - low) + low;
        this.swap(A, end, randomIndex); // Swap the random index with last element

        int pivotElement = A.get(end); //Last item is pivot
        int i =  start - 1;
        //Swap lower numbers
        for (int k = start; k < end; k++) {
            int currentElement = A.get(k);
            if (currentElement < pivotElement) {
                i = i + 1;
                this.swap(A, i, k);
            }
        }
        //Swap pivot with just after lower numbers
        this.swap(A,i+1, end); // end = pivot
        return i + 1; //Final position of pivot
    }


    private int sumTheDifference(ArrayList<Integer> A) {
        Collections.sort(A);
        int totalMax = 0;
        int totalMin = 0;
        int n = A.size() - 1;

        for (int i = 0; i <= n; i++) {
            //            totalMax = (int) (totalMax + (A.get(i) * Math.pow(2, i)));
        }
        for (int i = n; i >= 0; i--) {
            totalMin = (int) (totalMin + (A.get(i) * Math.pow (2, n-i)));
        }
        return totalMax - totalMin;
    }
    private int power(int val, int p) {
        int result = 1;
        int mod = 1000000007;
        for (int i = 0; i < p; i++) {
            result = (result * val) % mod;
        }
        return result;
    }
}
