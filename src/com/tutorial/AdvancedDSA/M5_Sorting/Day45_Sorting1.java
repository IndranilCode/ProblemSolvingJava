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
}
