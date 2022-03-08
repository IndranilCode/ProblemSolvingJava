package com.tutorial.AdvancedDSA.M5_Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day45_Sorting1 {
    //1. Selection sort - O(n2)
    //2. Bubble sort - O(n2)
    //3. Insertion sort - O(n2)

    public void execute() {
        System.out.println("------------SORTING 1------------");
        System.out.println("------------CLASSWORK------------");
        //CW1 > 2nd largest number
        ArrayList<Integer> inputCW1 = new ArrayList<>(Arrays.asList(5, 2, 7, 12, 99, 6, 1));
        System.out.println("CW1 > 2nd largest number (Normal) [5, 2, 7, 12, 99, 6, 1] => " + this.secondLargestElement(inputCW1));

        //CW2 > Selection Sort
        ArrayList<Integer> inputCW2 = new ArrayList<>(Arrays.asList(5, 2, 7, 12, 99, 6, 1));
        ArrayList<Integer> resultCW2 = this.selectionSort(inputCW2);
        System.out.print("CW2 > Selection sort [5, 2, 7, 12, 99, 6, 1] => ");
        resultCW2.forEach(e -> System.out.print(e + ", "));
        System.out.println("");

        //CW2.1 > Kth max with Selection sort
        System.out.println("    > Kth (6th) max Selection sort [5, 2, 7, 12, 99, 6, 1] => " +  this.kThMax_selectionSort(inputCW2, 6));
        System.out.println("    > Kth (3rd) max Selection sort [5, 2, 7, 12, 99, 6, 1] => " +  this.kThMax_selectionSort(inputCW2, 3));

        //CW3 > Bubble Sort
        ArrayList<Integer> inputCW3 = new ArrayList<>(Arrays.asList(5, 2, 7, 12, 99, 6, 1));
        ArrayList<Integer> resultCW3 = this.bubbleSort(inputCW3);
        System.out.print("CW3 > Bubble sort [5, 2, 7, 12, 99, 6, 1] => ");
        resultCW3.forEach(e -> System.out.print(e + ", "));
        System.out.println("");

        //CW3.1 > Kth max with Selection sort
        System.out.println("    > Kth (6th) max Bubble sort [5, 2, 7, 12, 99, 6, 1] => " +  this.kThMax_bubbleSort(inputCW3, 6));
        System.out.println("    > Kth (3rd) max Bubble sort [5, 2, 7, 12, 99, 6, 1] => " +  this.kThMax_bubbleSort(inputCW3, 3));

        //CW4 > Insertion Sort
        ArrayList<Integer> inputCW4 = new ArrayList<>(Arrays.asList(5, 2, 7, 12, 99, 6, 1));
        ArrayList<Integer> resultCW4 = this.insertionSort(inputCW3);
        System.out.print("CW4 > Insertion sort [5, 2, 7, 12, 99, 6, 1] => ");
        resultCW3.forEach(e -> System.out.print(e + ", "));
        System.out.println("");

        /*------------ASSIGNMENTS------------*/

        System.out.println("------------ASSIGNMENTS------------");

        //AS1 > Merge Two Sorted Arrays
        ArrayList<Integer> inputAS1a = new ArrayList<>(Arrays.asList(2, 8 , 9, 10, 15));
        ArrayList<Integer> inputAS1b = new ArrayList<>(Arrays.asList(1, 3, 4, 5, 7));
        ArrayList<Integer> resultAS1 = this.merge2SortedLists(inputAS1a, inputAS1b);
        System.out.print("AS1 > Merge Two Sorted Arrays [2, 8, 9, 10, 15] & [1, 3, 4, 5, 7] => ");
        resultAS1.forEach(e -> System.out.print(e + ", "));
        System.out.println("");

        //AS2 > Kth smallest element (using SelectionSort)
        ArrayList<Integer> inputAS2 = new ArrayList<>(Arrays.asList(5, 2, 7, 12, 99, 6, 1));
        System.out.println("AS2 > Kth (2nd) smallest element (using SelectionSort) [5, 2, 7, 12, 99, 6, 1] => " + this.kThSmallestElement(inputAS2, 2));
        System.out.println("    > Kth (3rd) smallest element (using SelectionSort) [5, 2, 7, 12, 99, 6, 1] => " + this.kThSmallestElement(inputAS2, 3));
        System.out.println("    > Kth (5th) smallest element (using SelectionSort) [5, 2, 7, 12, 99, 6, 1] => " + this.kThSmallestElement(inputAS2, 5));
        ArrayList<Integer> inputAS2b = new ArrayList<>(Arrays.asList(94, 87, 100, 11, 23, 98, 17, 35, 43, 66, 34, 53, 72, 80, 5, 34, 64, 71, 9, 16, 41, 66, 96));
        System.out.println("    > Kth (5th) smallest element (using SelectionSort) [94, 87, 100, 11, 23, 98, 17, 35, 43, 66, 34, 53, 72, 80, 5, 34, 64, 71, 9, 16, 41, 66, 96] => " + this.kThSmallestElement(inputAS2b, 19));
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
     * CW2 > Selection Sort (N2)
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
     * CW3 > Bubble sort (N2)
     * TC = O(N2)
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

    /**
     * CW4 > Insertion sort (N2)
     * @param a
     * @return
     */
    private ArrayList<Integer> insertionSort(ArrayList<Integer> a) {
        int temp, current, indexToInsert=0;
        for (int i = 1; i < a.size(); i++) {
            temp = a.get(i);
            for (int j = i-1; j >= 0; j--) {
                current = a.get(j);
                if (current > temp) {
                    a.set(j+1, current);
                } else {
                    indexToInsert = j;
                    break;
                }
            }
            a.set(indexToInsert + 1, temp);
        }
        return a;
    }


    /*------------ASSIGNMENTS------------*/

    /**
     * AS1 > Merge Two Sorted Arrays
     * @param A
     * @param B
     * @return
     */
    private ArrayList<Integer> merge2SortedLists(List<Integer> A, List<Integer> B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int listASize = A.size();
        int listBSize = B.size();
        int i = 0;
        int j = 0;
        while ((i < listASize) && (j < listBSize)) {
            if (A.get(i) <= B.get(j)) {
                result.add(A.get(i));
                i++;
            } else {
                result.add(B.get(j));
                j++;
            }
        }
        if (i < listASize) {
            while (i != listASize) {
                result.add(A.get(i));
                i++;
            }
        } else if (j < listBSize) {
            while (j != listBSize) {
                result.add(B.get(j));
                j++;
            }
        }

        return result;
    }

    /**
     * AS2 > Kth smallest element (using SelectionSort)
     * Users should try to solve it in <= B swaps. --- indicates selection sort
     * @param A
     * @param B
     * @return
     */
    private int kThSmallestElement(final List<Integer> A, int B) {
        int n = A.size(); //Total size
        int currentNo; //Current index val
        int lowestInRun; //Lowest no in each run
        int lowestInRunIndex; //Index of lowest no in each run
        int temp;
        for (int end = n-1; end >= (n - B); end--) {
            lowestInRun = Integer.MAX_VALUE;
            lowestInRunIndex = -1;
            for (int i = 0; i <= end; i++) {
                currentNo = A.get(i);
                if (currentNo < lowestInRun) {
                    lowestInRun = currentNo;
                    lowestInRunIndex = i;
                }
            }
            //Once lowest is found - swap with last
            temp = A.get(lowestInRunIndex);
            A.set(lowestInRunIndex, A.get(end));
            A.set(end, temp);
        }
        return A.get(n - B);
        }
}
