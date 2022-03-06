package com.tutorial.AdvancedDSA.M5_Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class Day45_Sorting1 {
    public void execute() {
        //CW1 > 2nd largest number
        ArrayList<Integer> inputCW1 = new ArrayList<>(Arrays.asList(5, 2, 7, 12, 99, 6, 1));
        System.out.println("CW1 > 2nd largest number [5, 2, 7, 12, 99, 6, 1] => " + this.secondLargestElement(inputCW1));

        //CW2 > Selection Sort
        ArrayList<Integer> inputCW2 = new ArrayList<>(Arrays.asList(5, 2, 7, 12, 99, 6, 1));
        ArrayList<Integer> resultCW2 = this.selectionSort(inputCW2);
        System.out.print("CW2 > Selection sort [5, 2, 7, 12, 99, 6, 1] => ");
        resultCW2.forEach(e -> System.out.print(e + ", "));
        System.out.println("");

        //CW2.1 > Kth max with Selection sort
        System.out.println("    > Kth (6th) max Selection sort [5, 2, 7, 12, 99, 6, 1] => " +  this.kThMax_selectionSort(inputCW2, 6));
        System.out.println("    > Kth (3rd) max Selection sort [5, 2, 7, 12, 99, 6, 1] => " +  this.kThMax_selectionSort(inputCW2, 3));

        //CW2 > Selection Sort
        ArrayList<Integer> inputCW3 = new ArrayList<>(Arrays.asList(5, 2, 7, 12, 99, 6, 1));
        ArrayList<Integer> resultCW3 = this.bubbleSort(inputCW3);
        System.out.print("CW3 > Bubble sort [5, 2, 7, 12, 99, 6, 1] => ");
        resultCW3.forEach(e -> System.out.print(e + ", "));
        System.out.println("");

        //CW3.1 > Kth max with Selection sort
        System.out.println("    > Kth (6th) max Bubble sort [5, 2, 7, 12, 99, 6, 1] => " +  this.kThMax_bubbleSort(inputCW3, 6));
        System.out.println("    > Kth (3rd) max Bubble sort [5, 2, 7, 12, 99, 6, 1] => " +  this.kThMax_bubbleSort(inputCW3, 3));
    }

    /**
     * CW1 > 2nd largest number
     * TC = O(n) , SC = O(1)
     * @param numbers
     * @return
     */
    private int secondLargestElement(ArrayList<Integer> numbers) {
        int max1, max2; //max1 - largest , max2 - 2nd largest
        //max1 = max(numbers[0], numbers[1])
        //max2 = min(numbers[0], numbers[1])
        if (numbers.get(0) > numbers.get(1)) {
            max1 = numbers.get(0);
            max2 = numbers.get(1);
        } else {
            max1 = numbers.get(1);
            max2 = numbers.get(0);
        }
        for (int i = 2; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            //if numbers[i] < max2 => ignore
            //if numbers[i] > max1 => numbers[i] is max1 , max2 = max1 now
            //if numbers[i] > max2 &
            if (currentNumber <= max2) {
                continue;
            }
            if (currentNumber > max1) {
                max2 = max1;
                max1 = currentNumber;
            }
            if (currentNumber > max2 && currentNumber < max1) {
                max2 = currentNumber;
            }
        }
        return max2;
    }

    /**
     * CW2 > Selection Sort
     * TC = O(N2)
     * @param a
     * @return
     */
    private ArrayList<Integer> selectionSort(ArrayList<Integer> a) {
        int currentMax;
        int currentMaxIndex;
        int temp;
        for (int endOfActiveArr = a.size() - 1; endOfActiveArr >= 0; endOfActiveArr--) {
            currentMax = Integer.MIN_VALUE;
            currentMaxIndex = -1;
            for (int i = 0; i <= endOfActiveArr; i++) {
                if (a.get(i) > currentMax) {
                    currentMax = a.get(i);
                    currentMaxIndex = i;
                }
            }
            //Max found => Swap max element with last active index
            temp = a.get(endOfActiveArr);
            a.set(endOfActiveArr, currentMax); //Set lastElem = max
            a.set(currentMaxIndex, temp); //Set index@maxNumber = last element
        }
        return a;
    }

    /**
     * CW2.1 > Kth max with Selection sort
     * @param a
     * @param k
     * @return
     */
    private int kThMax_selectionSort(ArrayList<Integer> a, int k) {
        int currentMax;
        int currentMaxIndex;
        int temp;
        int n = a.size();
        for (int endOfActiveArr = n - 1; endOfActiveArr >= n - k; endOfActiveArr--) {
            currentMax = Integer.MIN_VALUE;
            currentMaxIndex = -1;
            for (int i = 0; i <= endOfActiveArr; i++) {
                if (a.get(i) > currentMax) {
                    currentMax = a.get(i);
                    currentMaxIndex = i;
                }
            }
            //Max found => Swap max element with last active index
            temp = a.get(endOfActiveArr);
            a.set(endOfActiveArr, currentMax); //Set lastElem = max
            a.set(currentMaxIndex, temp); //Set index@maxNumber = last element
        }
        return a.get(n-k);
    }

    /**
     * CW3 > Bubble sort
     * @param a
     * @return
     */
    private ArrayList<Integer> bubbleSort(ArrayList<Integer> a) {
        int temp;
        for (int end = a.size()-2; end >= 0; end--) {
            for (int i = 0; i <= end; i++) {
                if (a.get(i) > a.get(i+1)) {
                    //swap a[i]  a[i+1] => bubble up higher element
                    temp = a.get(i);
                    a.set(i, a.get(i+1));
                    a.set(i+1, temp);
                }
            }
        }
        return a;
    }

    /**
     * CW3.1 > Kth max with Bubble sort
     * @param a
     * @param k
     * @return
     */
    private int kThMax_bubbleSort(ArrayList<Integer> a, int k) {
        int temp;
        int n = a.size();
        for (int end = n-2; end >= n-k; end--) {
            for (int i = 0; i <= end; i++) {
                if (a.get(i) > a.get(i+1)) {
                    //swap a[i]  a[i+1] => bubble up higher element
                    temp = a.get(i);
                    a.set(i, a.get(i+1));
                    a.set(i+1, temp);
                }
            }
        }
        return a.get(n-k);
    }
}
