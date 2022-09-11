package main.tutorial.AdvancedDSA.M5_Sorting;

import java.util.*;

public class Day45_Sorting1 {
    //1. Selection sort - O(n2)
    //2. Bubble sort - O(n2)
    //3. Insertion sort - O(n2)

    public void execute() {
        System.out.println("------------SORTING 1------------");
        System.out.println("------------CLASSWORK------------");

        /*------------CLASSWORK------------*/

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

        //CW3.1 > Kth max with Bubble sort
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

        //AS3 > Array with consecutive elements
        ArrayList<Integer> inputAS3a = new ArrayList<>(Arrays.asList(3, 2, 1, 4, 5));
        System.out.println("AS3 > Array with consecutive elements [3, 2, 1, 4, 5] => " + this.isArrayWithConsecutiveElements(inputAS3a));
        ArrayList<Integer> inputAS3b = new ArrayList<>(Arrays.asList(1, 3, 2, 5));
        System.out.println("    > Array with consecutive elements [3, 2, 1, 4, 5] => " + this.isArrayWithConsecutiveElements(inputAS3b));

        //AS4 > MaxMod
        //        ArrayList<Integer> inputAS4a = new ArrayList<>(Arrays.asList(1, 2, 44, 3));
        //        System.out.println("AS4 > MaxMod [1, 2, 44, 3] => " + this.maxMod(inputAS4a));
        //        ArrayList<Integer> inputAS4b = new ArrayList<>(Arrays.asList(2, 6, 4));
        //        System.out.println("    > MaxMod [2, 6, 4] => " + this.maxMod(inputAS4b));
        //        ArrayList<Integer> inputAS4c = new ArrayList<>(Arrays.asList(6, 6, 4 ,2));
        //        System.out.println("    > MaxMod [6, 6, 4 ,2] => " + this.maxMod(inputAS4c));
        //        ArrayList<Integer> inputAS4d = new ArrayList<>(Arrays.asList(6, 6, 4 ,2));
        //        System.out.println("    > MaxMod [4, 2, 6, 6] => " + this.maxMod(inputAS4d));
                ArrayList<Integer> inputAS4e = new ArrayList<>(Arrays.asList(1, 2, 3, 3));
                System.out.println("    > MaxMod [1, 2, 3, 3] => " + this.maxMod(inputAS4e));
        //        ArrayList<Integer> inputAS4f = new ArrayList<>(Arrays.asList(5, 5, 5, 5, 5));
        //        System.out.println("    > MaxMod [5, 5, 5, 5, 5] => " + this.maxMod(inputAS4f));

        /*------------HOMEWORK------------*/
        System.out.println("------------HOMEWORK------------");



    }

    /*------------CLASSWORK------------*/

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

    /**
     * AS3 > Array with consecutive elements
     * Eg A = [3, 2, 1, 4, 5] => Consecutive (1)
     * A = [1, 3, 2, 5] => Non-consecutive (0)
     * @param a
     * @return
     */
    private int isArrayWithConsecutiveElements(ArrayList<Integer> a) {
        int result = 1;

        //1. Find the min number - O(n)
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) < min) {
                min = a.get(i);
            }
        }

        //2. Range must be from min to idealMax(min + n - 1).
        //a> Check if all elements are from min-max
        //b> Check if all frequency is 1
        //Both needed to qualify for consecutive
        int idealMax = min + a.size() - 1;
        int currentNumber, currentFreq;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            currentNumber = a.get(i);
            currentFreq = 0;
            if (a.get(i) >= min && a.get(i) <= idealMax) {
                //Within range - OK - but add to hashmap for frequency
                if (freq.containsKey(currentNumber)) {
                    currentFreq = freq.get(currentNumber);
                }
                currentFreq++;
                freq.put(currentNumber, currentFreq);
            } else {
                //Not in range - surely not consecutive
                result = 0;
                break;
            }
        }
        //3. If still result = 1, check for frequency OR better check length of freq. must be = n
        if (result == 1) {
            if (freq.size() != a.size()) {
                result = 0;
            }
        }
        return result;
    }

    /**
     * AS4 > MaxMod
     * A[i] % A[j] is maximum among all possible pairs of (i, j).
     * Eg => A = [1, 2, 44, 3] => i = 3, j = 2  A[i] % A[j] = 3 % 44 = 3.
     * A = [2, 6, 4] => i = 2, j = 1  A[i] % A[j] = 4 % 6 = 4.
     * @param A
     * @return
     */
    private int maxMod(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, temp;
        if (A.size() > 1) {
            if (A.get(0) == A.get(1)) {
                max = A.get(0);
            } else if (A.get(0) > A.get(1)) {
                max = A.get(0);
                max2 = A.get(1);
            } else {
                max = A.get(1);
                max2 = A.get(0);
            }
            for (int i = 2; i < A.size(); i++) {
                if (A.get(i) <= max2) {
                    continue;
                } else if (A.get(i) > max) {
                    temp = max;
                    max = A.get(i);
                    max2 = temp;
                } else if (A.get(i) == max) {
                    continue;
                }
                else {
                    max2 = A.get(i);
                }
            }
        }

        //If there is no 2nd minimum then return 0
        if (max2 == Integer.MIN_VALUE) {
            max2 = 0;
        }

        return max2;
    }

    /*------------HOMEWORK------------*/

    /**
     * HW1 > Chocolate Distribution [WRONG]
     *
     * @param A
     * @param B
     * @return
     */
    private int chocolateDistributionProblem(ArrayList<Integer> A, int B) {
        this.mergeSort_CP(A, 0, A.size() - 1);
        // System.out.println(A);
        int lowest = A.get(0);
        int bThLowest = A.get(B-1);
        return bThLowest-lowest;
    }
    private void mergeSort_CP(ArrayList<Integer> arr, int start, int end) {
        if (start == end) return;
        int mid = (start + end) / 2;
        this.mergeSort_CP(arr, start, mid);
        this.mergeSort_CP(arr, mid+1, end);
        this.merge_CP(arr, start, mid, end);
    }
    private void merge_CP(ArrayList<Integer> arr, int start, int mid, int end) {
        ArrayList<Integer> arr1 = new ArrayList();
        ArrayList<Integer> arr2 = new ArrayList();

        //Fill left array - arr1
        for (int k = start; k <= mid; k++) {
            arr1.add(arr.get(k));
        }
        //Fill right array - arr2
        for (int k = mid+1; k <= end; k++) {
            arr2.add(arr.get(k));
        }

        //Compare arr1 start element with arr2 end element and keep filling
        int i = 0; //arr1 pointer
        int j = 0; //arr2 pointer
        int index = start;
        int arr1Len = arr1.size();
        int arr2Len = arr2.size();
        while (i < arr1Len && j < arr2Len) {
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
        //Copy leftovers
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
    }

    /**
     * HW1 > Chocolate Distribution [CORRECT]
     * @param A
     * @param B
     * @return
     */
    public int chocolateDistributionProblem_Correct(ArrayList<Integer> A, int B) {
        int minDifference = Integer.MAX_VALUE;
        if (B > 0 && A.size() > 0) {
            Collections.sort(A);

            int startIndex = 0;
            int endIndex = A.size() - B;
            for (int i = startIndex; i <= endIndex; i++){
                int startVal = A.get(i);
                int endVal = A.get(i + B - 1);
                int thisDifference = endVal - startVal;
                if (thisDifference < minDifference) {
                    minDifference = thisDifference;
                }
            }
        } else {
            minDifference = 0;
        }

        return minDifference;
    }
}
