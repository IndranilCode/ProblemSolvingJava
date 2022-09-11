package main.tutorial.AdvancedDSA.M5_Sorting;

import java.util.*;

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

        /*------------ASSIGNMENTS------------*/

        System.out.println("------------ASSIGNMENTS----------");

        //AS1 > Inversion count in an array
        System.out.println("AS1 > Inversion count in an array - Same as CW2.2");

        //AS2 > Largest Number
        ArrayList<Integer> inputAS2 = new ArrayList<>(Arrays.asList(3, 30, 34, 5, 9));
        System.out.println("AS2 > Largest Number [3, 30, 34, 5, 9] => " + this.largestPossibleNumber(inputAS2));
        ArrayList<Integer> inputAS2_2 = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        System.out.println("    > Largest Number [0, 0, 0, 0, 0] => " + this.largestPossibleNumber(inputAS2_2));

        /*------------HOMEWORK---------------*/

        System.out.println("------------HOMEWORK-------------");

        //HW1 > Unique Elements
        ArrayList<Integer> inputHW1 = new ArrayList<>(Arrays.asList(2, 4, 3, 4, 5, 3));
        System.out.println("HW1 > Unique Elements [2, 4, 3, 4, 5, 3] Changes req => " + this.uniqueElements(inputHW1));

        //HW2 > Reverse pairs
        ArrayList<Integer> inputHW2 = new ArrayList<>(Arrays.asList(1, 3, 2, 3, 1));
        System.out.println("HW2 > Reverse pairs [1, 3, 2, 3, 1] Changes req => " + this.reversePairCount(inputHW2));

        //HW3 > B Closest Points to Origin
        ArrayList<ArrayList<Integer>> inputHW3_points = new ArrayList<>();
        inputHW3_points.add(new ArrayList<>(Arrays.asList(1, 3)));
        inputHW3_points.add(new ArrayList<>(Arrays.asList(-2, 2)));
        this.b_ClosestPointToOrigin(inputHW3_points, 1);
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
                //Take from right
                count = count + (arr1Len - i);
                arr.set(index, arr2.get(j));
                index++;
                j++;
            } else {
                //Take from left
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

    /*------------ASSIGNMENTS------------*/

    /**
     * AS1 > Inversion count in an array - Same as CW2.2
     */

    /**
     * AS2 > Largest Number
     * @param A
     * @return
     */
    private String largestPossibleNumber(List<Integer> A) {
        Collections.sort(A, new NumberComparator());

        //Build answer + Remove leading 0's
        StringBuilder largestNumberBuilder = new StringBuilder();
        boolean isPrev0 = true;
        for (int i = 0; i < A.size(); i++) {
            int currentNumber = A.get(i);
            if (A.get(i) != 0) {
                largestNumberBuilder.append(currentNumber);
                isPrev0 = false;
            } else {
                //0 Case
                if (!isPrev0) {
                    largestNumberBuilder.append(currentNumber);
                }
            }
        }
        String result = largestNumberBuilder.toString();
        return result.equals("") ? "0" : result;
    }
    class NumberComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer n1, Integer n2) {
            String stringC1 = n1.toString() + n2.toString();
            String stringC2 = n2.toString() + n1.toString();
            Long c1 = Long.parseLong(stringC1);
            Long c2 = Long.parseLong(stringC2);
            return c1 >= c2 ? -1 : 1;
        }
    }

    /*------------HOMEWORK---------------*/

    /**
     * HW1 > Unique Elements
     * Given an array A of N elements. You have to make all elements unique. To do so, in one step you can increase any number by one.
     * Find the minimum number of steps.
     * @param A
     * @return
     */
    private int uniqueElements(ArrayList<Integer> A) {
        Collections.sort(A);

        int changesCount = 0;
        //Compare from 1st element to (n-1) element with previous and see if its unique
        //If not increment 2ns to make it unique
        //Eg [2, 4, 3, 4, 5, 3] => [2, 3, 3, 4, 4, 5]
        // [2, 3, 3, 4, 4, 5] = compare A[1] , A[0] => Distinct - move on
        // [2, 3, 3, 4, 4, 5] = compare A[2] , A[1] => 3==3 => increment A[2] to 4 => [2, 3, 4, 4, 4, 5]  count + 1
        // [2, 3, 4, 4, 4, 5] = compare A[3] , A[2] => 4==4 => increment A[3] to 5 => [2, 3, 4, 5, 4, 5]  count + 1
        // [2, 3, 4, 5, 4, 5] = compare A[4] , A[3] => 4 < 5 => increment A[4] to 6 => [2, 3, 4, 5, 6, 5] count + 2
        // [2, 3, 4, 5, 6, 5] = compare A[5] , A[4] => 5 < 6 => increment A[5] to 7 => [2, 3, 4, 5, 6, 7] count + 2
        for (int i = 1; i < A.size(); i++) {
            int prevElem = A.get(i-1);
            int currentElem = A.get(i);
            if (currentElem > prevElem) {
                //Elements distinct - move on
                continue;
            } else if (currentElem == prevElem) {
                //Element same => increase currentElement by 1
                changesCount = changesCount + 1;
                A.set(i, (A.get(i) + 1));
            } else {
                //currentElem < prevElem
                int changeReq = prevElem - currentElem + 1;
                changesCount = changesCount + changeReq;
                A.set(i, (A.get(i) + changeReq));
            }
        }
        return changesCount;
    }

    private int reversePairCount(ArrayList<Integer> A) {
        return this.reversePairCount_mergeSortTechnique(A, 0, A.size()-1);
    }
    private int reversePairCount_mergeSortTechnique(ArrayList<Integer> arr, int start, int end) {
        if (start == end) return 0;
        int mid = (start + end) / 2;
        int c1 = this.reversePairCount_mergeSortTechnique(arr, start, mid);
        int c2 = this.reversePairCount_mergeSortTechnique(arr, mid+1, end);
        return c1 + c2 + this.mergeReversePairCount(arr, start, mid, end);
    }
    private int mergeReversePairCount(ArrayList<Integer> arr, int start, int mid, int end) {
        int count = 0;

        //Create 2 arrays arr1(left) & arr2(right) which are sorted by itself
        //Merge the sorted arrays arr1 & arr2
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        //Copy elements to arr1 => arr[start] - arr[mid]
        for (int i = start; i <= mid; i++) {
            arr1.add(arr.get(i));
        }
        //Copy elements to arr2 => arr[mid+1] - arr[end]
        for (int i = mid+1; i <= end; i++) {
            arr2.add(arr.get(i));
        }

        int arr1Len = arr1.size();
        int arr2Len = arr2.size();

        int i = 0;
        int j = 0;
        int index = start;

        while (i < arr1Len && j < arr2Len) {
            if (2L * arr2.get(j) < arr1.get(i)) {
                count = count + (arr1Len - i);
                j++;
            } else {
                i++;
            }
        }

        i = 0;
        j = 0;

        while (i < arr1Len && j < arr2Len) {
            if (arr2.get(j) < arr1.get(i)) {
                //Take from right
                //Can't take counts here - as maybe this A[i] !> 2*A[j] but next 1 maybe
                // if (arr1.get(i) > (2 * arr2.get(j))) {
                //     count = count + (arr1Len - i);
                // }
                arr.set(index, arr2.get(j));
                j++;
                index++;
            } else {
                //Take from left
                arr.set(index, arr1.get(i));
                i++;
                index++;
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
     * HW3 > B Closest Points to Origin
     * @param A
     * @param B
     * @return
     */
    private ArrayList<ArrayList<Integer>> b_ClosestPointToOrigin(ArrayList<ArrayList<Integer>> A, int B) {
        int noOfPoints = A.size();
        SortedMap<Double, ArrayList<Integer>> mapDistanceIndex = new TreeMap<>();
        for (int i = 0; i < noOfPoints; i++) {
            double distToOrigin = this.distanceSquare(A.get(i), new ArrayList<>(Arrays.asList(0, 0)));
            if (mapDistanceIndex.containsKey(distToOrigin)) {
                ArrayList<Integer> pointsForThisDistance = mapDistanceIndex.get(distToOrigin);
                pointsForThisDistance.add(i);
                mapDistanceIndex.put(distToOrigin, pointsForThisDistance);
            } else {
                ArrayList<Integer> pointsForThisDistance = new ArrayList<>(Arrays.asList(i));
                mapDistanceIndex.put(distToOrigin, pointsForThisDistance);
            }
        }

        ArrayList<Integer> allIndexes = new ArrayList<>();
        int countsTaken = 0;
        for (Double key : mapDistanceIndex.keySet()) {
            int currentDistanceCount = mapDistanceIndex.get(key).size();
            if ((B -  countsTaken) >= currentDistanceCount) {
                allIndexes.addAll(mapDistanceIndex.get(key));
                countsTaken = countsTaken + currentDistanceCount;
            } else {
                int picksLeft = B - countsTaken;
                for (int j = 0; j < picksLeft; j++) {
                    allIndexes.add(mapDistanceIndex.get(key).get(j));
                }
            }
        }

        ArrayList<ArrayList<Integer>> allPoints = new ArrayList<>();
        for (int j = 0; j < allIndexes.size(); j++) {
            allPoints.add(A.get(allIndexes.get(j)));
        }

        return allPoints;
    }
    private double distanceSquare(ArrayList<Integer> pointA, ArrayList<Integer> pointB) {
        int x1 = pointA.get(0);
        int y1 = pointA.get(1);
        int x2 = pointB.get(0);
        int y2 = pointB.get(1);

        return Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2);
    }
}
