package com.tutorial.AdvancedDSA.M5_Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class Day45_Sorting1 {
    public void execute() {
        //CW1 > 2nd largest number
        ArrayList<Integer> inputCW1 = new ArrayList<>(Arrays.asList(5, 2, 7, 12, 99, 6, 1));
        System.out.println("CW1 > 2nd largest number [5, 2, 7, 12, 99, 6, 1] => " + this.secondLargestElement(inputCW1));

        //CW2 > Selection Sort

    }

    /**
     * CW1 > 2nd largest number
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
     * @param a
     * @return
     */
    private Integer[] selectionSort(ArrayList<Integer> a) {
        return null;
    }
}
