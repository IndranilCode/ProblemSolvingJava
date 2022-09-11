package main.tutorial.AdvancedDSA.M7_2Pointers;

import java.util.*;

public class Day51_2Pointer {
    public void execute() {
        System.out.println("--------------2 POINTERS---------------");
        System.out.println("------------CLASSWORK------------------");
        //CW1 > Sorted array (Sum) => Find pair (i,j) => A[i] + A[j] = k
        ArrayList<Integer> inputCW1 = new ArrayList<>(Arrays.asList(1, 3, 5, 10, 20, 23, 30));
        ArrayList<Integer> resultCW1 = this.sumIJEqualsK_2Pointer(inputCW1, 23);
        System.out.print("CW1 > Sorted array => Find pair (i,j) => A[i] + A[j] = 23;  [1, 3, 5, 10, 20, 23, 30] => [");
        resultCW1.forEach(e -> System.out.print(e + ","));
        System.out.println("]");

        //CW2 > Sorted array (Diff) => Find pair (i,j) => A[j] - A[i] = k
        ArrayList<Integer> inputCW2 = new ArrayList<>(Arrays.asList(1, 3, 5, 10, 20, 23, 30));
        ArrayList<Integer> resultCW2 = this.differenceIJEqualsK_2Pointer(inputCW2, 15);
        System.out.print("CW2 > Sorted array (Diff) => Find pair (i,j) => A[i] - A[j] = 15;  [1, 3, 5, 10, 20, 23, 30] => [");
        resultCW2.forEach(e -> System.out.print(e + ","));
        System.out.println("]");

        ArrayList<Integer> resultCW2_2 = this.differenceIJEqualsK_2Pointer(inputCW2, -15);
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

//        ArrayList<Integer> inputCW2c = new ArrayList<>(Arrays.asList(1, 3, 3, 5, 10, 20, 23, 30));
//        ArrayList<Integer> resultCW2c = this.differenceIJEqualsK_BS(inputCW2c, 0);
//        System.out.print("CW2_2 > Sorted array (Diff) [BS Method] => Find pair (i,j) => A[i] - A[j] = 0;  [1, 3, 3, 5, 10, 20, 23, 30] => [");
//        resultCW2c.forEach(e -> System.out.print(e + ","));
//        System.out.println("]");

        //CW3 > Sorted array (Triplet Sum) => Find pair (i,j,k) => A[j]+A[i]+A[k] = X
        ArrayList<Integer> inputCW3a = new ArrayList<>(Arrays.asList(1, 3, 5, 10, 20, 23));
        ArrayList<Integer> resultCW3a = this.tripletSumEqualsK_2Pointer(inputCW3a, 38);
        System.out.print("CW3 > Sorted array (Triplet Sum) => Find pair (i,j,k) => A[j]+A[i]+A[k] = 38;  [1, 3, 5, 10, 20, 23, 30] => [");
        resultCW3a.forEach(e -> System.out.print(e + ","));
        System.out.println("]");

        ArrayList<Integer> resultCW3b = this.tripletSumEqualsK_2Pointer(inputCW3a, 37);
        System.out.print("    > Sorted array (Triplet Sum) => Find pair (i,j,k) => A[j]+A[i]+A[k] = 37;  [1, 3, 5, 10, 20, 23, 30] => [");
        resultCW3b.forEach(e -> System.out.print(e + ","));
        System.out.println("]");

        //CW3_2 > Sorted array (Triplet Sum) [BS Method] => Find pair (i,j,k) => A[j]+A[i]+A[k] = X
        ArrayList<Integer> inputCW3_2a = new ArrayList<>(Arrays.asList(1, 3, 5, 10, 20, 23));
        ArrayList<Integer> resultCW3_2a = this.tripletSumEqualsK_BS(inputCW3_2a, 38);
        System.out.print("CW3_2 > Sorted array (Triplet Sum) [BS Method] => Find pair (i,j,k) => A[j]+A[i]+A[k] = 38;  [1, 3, 5, 10, 20, 23, 30] => [");
        resultCW3_2a.forEach(e -> System.out.print(e + ","));
        System.out.println("]");

        ArrayList<Integer> inputCW3_2b = this.tripletSumEqualsK_BS(inputCW3_2a, 37);
        System.out.print("      > Sorted array (Triplet Sum) [BS Method] => Find pair (i,j,k) => A[j]+A[i]+A[k] = 37;  [1, 3, 5, 10, 20, 23, 30] => [");
        inputCW3_2b.forEach(e -> System.out.print(e + ","));
        System.out.println("]");

        //CW4
        ArrayList<Integer> inputCW4 = new ArrayList<>(Arrays.asList(1, 3, 15, 10, 20, 23, 3));
        ArrayList<Integer> resultCW4 = this.findSubarraySumEqualK_UsingPrefix(inputCW4, 48);
        System.out.print("CW4 > Subarray sum = 48 => [1, 3, 15, 10, 20, 23, 3] => [");
        resultCW4.forEach(e -> System.out.print(e + ","));
        System.out.println("]");

        ArrayList<Integer> resultCW4_a = this.findSubarraySumEqualK_UsingPrefix(inputCW4, 49);
        System.out.print("    > Subarray sum = 49 => [1, 3, 15, 10, 20, 23, 3] => [");
        resultCW4_a.forEach(e -> System.out.print(e + ","));
        System.out.println("]");

        ArrayList<Integer> resultCW4_b = this.findSubarraySumEqualK_UsingPrefix(inputCW4, 47);
        System.out.print("    > Subarray sum = 47 => [1, 3, 15, 10, 20, 23, 3] => [");
        resultCW4_b.forEach(e -> System.out.print(e + ","));
        System.out.println("]");

        /*------------ASSIGNMENTS------------*/
        System.out.println("------------ASSIGNMENTS------------");

        //AS1 > Subarray with given sum
        ArrayList<Integer> inputAS1 = new ArrayList<>(Arrays.asList(1, 2, 3 ,4, 5));
        ArrayList<Integer> resultAS1 = this.findSubarraySumEqualK(inputAS1, 5);
        System.out.print("AS1 > Subarray with given sum => [");
        resultAS1.forEach(e -> System.out.print(e + ","));
        System.out.println("]");

        ArrayList<Integer> inputAS1a = new ArrayList<>(Arrays.asList(5, 10, 20, 100, 105));
        ArrayList<Integer> resultAS1a = this.findSubarraySumEqualK(inputAS1a, 110);
        System.out.print("    > Subarray with given sum => [");
        resultAS1a.forEach(e -> System.out.print(e + ","));
        System.out.println("]");

        //AS2 > Pairs with Given Difference
        ArrayList<Integer> inputAS2 = new ArrayList<>(Arrays.asList(8, 12, 16, 4, 0, 20));
        System.out.println("AS2 > Pairs with Given Difference (4) [8, 12, 16, 4, 0, 20] => " + this.countPairsWithGivenDifference(inputAS2, 4));

        ArrayList<Integer> inputAS2a = new ArrayList<>(Arrays.asList(1, 2));
        System.out.println("    > Pairs with Given Difference (0) [1, 2] => " + this.countPairsWithGivenDifference(inputAS2a, 0));

        //AS4 > 3 Sum Zero
        ArrayList<Integer> inputAS4 = new ArrayList<>(Arrays.asList(-1, 0, 1, 2, -1, 4));
        ArrayList<ArrayList<Integer>> resultAS4 = this.tripletSum0(inputAS4);
        System.out.print("AS4 > 3 Sum Zero [-1, 0, 1, 2, -1, 4] => [");
        resultAS4.forEach(eachSet -> {
            System.out.print("  (");
            eachSet.forEach(e -> System.out.print(e + ","));
            System.out.print(")");
        });
        System.out.println("]");

        //AS5 > Pairs with given sum II
        ArrayList<Integer> inputAS5 = new ArrayList<>(Arrays.asList(1, 2, 2, 2, 3, 3, 4, 4, 5, 6));
        System.out.println("AS5 > Pairs with given sum II (6) [1, 2, 2, 2, 3, 3, 4, 4, 5, 6] => " + this.countPairsWithGivenSum_duplicatesInArray(inputAS5, 6));

        //AS6 > Count of pairs with the given sum
        ArrayList<Integer> inputAS6 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("AS6 > Count of pairs with the given sum (5) [1, 2, 3, 4, 5] => " + this.countPairsWithGivenSum(inputAS6, 5));
    }

    /**
     * CW1 > Sorted array (Sum) => Find pair (i,j) => A[i] + A[j] = k
     * Sorted array of size N and integer k, find pair (i,j) such that A[i] + A[j] = k
     * TC = O(N)
     * @param numbers
     * @param k
     * @return
     */
    private ArrayList<Integer> sumIJEqualsK_2Pointer(ArrayList<Integer> numbers, int k) {
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
    private ArrayList<Integer> differenceIJEqualsK_2Pointer(ArrayList<Integer> numbers, int k) {
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
                    if (i == mid) { //if same number
                        mid++;
                    } else {
                        result.add(i);
                        result.add(mid);
                        return result;
                    }
                } else if (numbers.get(mid) > requiredDiffToFind) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return result;
    }

    /**
     * CW3 > Triplet sum = X ( A[i] + A[j] + A[k] = X)
     * A = [1, 3, 5, 10, 20, 23], X=38 ==> (2, 3, 5)
     * TC = O(n2)
     * @param numbers
     * @param k
     * @return
     */
    private ArrayList<Integer> tripletSumEqualsK_2Pointer(ArrayList<Integer> numbers, int k) {
        //A[i] + A[j] + A[k] = X
        //A[j] + A[k] = X - A[i]
        //Fix i and then find A[j] + A[k] = CalcVal by 2 pointers
        ArrayList<Integer> result = new ArrayList<>();
        int requiredSumToFind;
        int x; //2 pointer var
        int y; //2 pointer var
        int runningSum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            requiredSumToFind = k - numbers.get(i);
            //Now with 2 pointer find A[j] + A[k] = requiredSumToFind
            x = 0;
            y = numbers.size() - 1;
            while (x < y) {
                runningSum = numbers.get(x) + numbers.get(y);
                if (runningSum == requiredSumToFind) {
                    result.add(i);
                    result.add(x);
                    result.add(y);
                    return result;
                } else if (runningSum < requiredSumToFind) {
                    x++;
                } else {
                    y--;
                }
            }
        }
        return result;
    }

    /**
     * CW3 > Triplet sum [BS] = X ( A[i] + A[j] + A[k] = X)
     * A = [1, 3, 5, 10, 20, 23], X=38 ==> (2, 3, 5)
     * TC = O (n2 log n)
     * @param numbers
     * @param k
     * @return
     */
    private ArrayList<Integer> tripletSumEqualsK_BS(ArrayList<Integer> numbers, int k) {
        //A[i] + A[j] + A[k] = X
        //A[k] = X - A[i] - A[j]
        //Fix i & j and then find k
        ArrayList<Integer> result = new ArrayList<>();
        int requiredNumberToFind;
        int low, high, mid;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i+1; j < numbers.size(); j++) {
                requiredNumberToFind = k - numbers.get(i) - numbers.get(j);

                low = 0;
                high = numbers.size() - 1;
                while (low <= high) {
                    mid = (low + high) / 2;
                    if (numbers.get(mid) == requiredNumberToFind) {
                        result.add(i);
                        result.add(j);
                        result.add(mid);
                        return result;
                    } else if (numbers.get(mid) > requiredNumberToFind) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        return result;
    }

    /**
     * CW4 > Array of +ve int (not in order) - find subarray that adds to k [Using prefix]
     * @param numbers
     * @param k
     * @return
     */
    private ArrayList<Integer> findSubarraySumEqualK_UsingPrefix(ArrayList<Integer> numbers, int k) {
        //PrefixSum[j] - PrefixSum[i] = k => already solved with A[j]-A[i]=k
        ArrayList<Integer> resultSubarray = new ArrayList<>();
        int sum = 0;
        ArrayList<Integer> prefixSumArray = new ArrayList<>();
        prefixSumArray.add(0);
        for (int i = 0; i < numbers.size(); i++) {
            sum = sum + numbers.get(i);
            prefixSumArray.add(sum);
        }
        int i = 0;
        int j = 0;
        int currentDiff;
        int prefixArrayEnd = prefixSumArray.size() - 1;
        while (i <= prefixArrayEnd && j <= prefixArrayEnd) {
            currentDiff = prefixSumArray.get(j) - prefixSumArray.get(i);
            if (currentDiff == k) {
                //Ans found - construct the subarray send back
                for (int index = i; index <= j-1; index++) {
                    resultSubarray.add(numbers.get(index));
                }
                break;
            } else if (currentDiff < k) {
                j++;
            } else {
                i++;
            }
        }
        return resultSubarray;
    }

    /*------------ASSIGNMENTS------------*/

    /**
     * AS1 > Subarray with given sum
     * @param A
     * @param B
     * @return
     */
    private ArrayList<Integer> findSubarraySumEqualK(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        int sum = 0;
        int lastPossibleIndex = A.size() - 1;
        sum = sum + A.get(0);
        while (i <= lastPossibleIndex && j <= lastPossibleIndex) {
            if (sum == B) {
                for (int index = i; index <= j; index++) {
                    result.add(A.get(index));
                }
                return result;
            } else if (sum < B) {
                j++;
                if (j > lastPossibleIndex) break;
                sum = sum + A.get(j);
            } else {
                i++;
                if (i > lastPossibleIndex) break;
                sum = sum - A.get(i-1);
            }
        }
        result.add(-1);
        return result;
    }

    /**
     * AS2 > Pairs with Given Difference
     * @param A
     * @param B
     * @return
     */
    private int countPairsWithGivenDifference(ArrayList<Integer> A, int B) {
        //Create hashmap of frequency
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int currentElement, currentFreq;
        for (int i = 0; i < A.size(); i++) {
            currentElement = A.get(i);
            currentFreq = 0;
            if (frequencyMap.containsKey(currentElement)) {
                currentFreq = frequencyMap.get(currentElement);
            }
            frequencyMap.put(currentElement, currentFreq + 1);
        }

        //For every unique key check if (B+diff) is available or not
        int count = 0;
        int elementToLookFor;
        for (Integer eachKey : frequencyMap.keySet()) {
            elementToLookFor = B + eachKey; //given A[j]-A[i] = B
            //Search for elementToLookFor in the map
            if (frequencyMap.containsKey(elementToLookFor)) {
                //If the same element is being looked out for then ignore the current element's freq of 1
                int foundFreq = frequencyMap.get(elementToLookFor);
                if (eachKey == elementToLookFor) { //Same element is being searched - only 1 distinct pair for same number
                    if ((foundFreq -1) > 0) {
                        count++;
                    }
                } else {
                    //Distinct pairs possible as  (x,y)
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * AS4 > 3 Sum Zero
     * @param A
     * @return
     */
    private ArrayList<ArrayList<Integer>> tripletSum0(ArrayList<Integer> A) {
        //a+b+c= 0 ; a + b = -c (figure a pair with sum -c)
        int elementC;
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Map<Integer, Integer> elemFreq = new HashMap<>();
        for (int k = 0; k < A.size(); k++) {
            elementC = A.get(k);

            int i = 0;
            int j = A.size() - 1;
            int runningSum = 0;
            while (i < j) {
                runningSum = A.get(i) + A.get(j);
                if (runningSum < -(elementC)) {
                    i++;
                } else if (runningSum > -(elementC)) {
                    j--;
                } else {
                    //runningSum == -(elementC)
                    int lowest = Integer.MAX_VALUE;
                    int highest = Integer.MIN_VALUE;
                    int mid;
                    if (i != j && j != k && i != k){
                        ArrayList<Integer> singleCombination = new ArrayList<>();
                        if (A.get(i) <= lowest) lowest = A.get(i);
                        if (A.get(j) <= lowest) lowest = A.get(j);
                        if (A.get(k) <= lowest) lowest = A.get(k);
                        if (A.get(i) > highest) highest = A.get(i);
                        if (A.get(j) >= highest) highest = A.get(j);
                        if (A.get(k) >= highest) highest = A.get(k);
                        mid = 0 - lowest - highest;
                        singleCombination.add(lowest);
                        singleCombination.add(mid);
                        singleCombination.add(highest);
                        if (!result.contains(singleCombination)) {
                            result.add(singleCombination);
                        }
                        i++;
                    } else {
                        i++;
                    }
                }
            }

        }
        return result;
    }

    /**
     * AS5 > Pairs with given sum II
     * @param A
     * @param B
     * @return
     */
    private int countPairsWithGivenSum_duplicatesInArray(ArrayList<Integer> A, int B) {
        //Build freq map
        Map<Integer,Integer> freqMap = new HashMap<>();
        int currentElement;
        for (int i = 0; i < A.size(); i++) {
            currentElement = A.get(i);
            if (freqMap.containsKey(currentElement)) {
                freqMap.replace(currentElement, freqMap.get(currentElement) + 1);
            } else {
                freqMap.put(currentElement, 1);
            }
        }

        int requiredPairValue;
        int count = 0;
        int partnerFreq;
        //Parse through each element - evaluate the other number and find presence
        for (int i = 0; i < A.size(); i++) {
            currentElement = A.get(i);
            requiredPairValue = B - currentElement;

            //Pair like (x,y)
            if (requiredPairValue != currentElement) {
                if (freqMap.containsKey(requiredPairValue)) {
                    partnerFreq = freqMap.get(requiredPairValue);
                    if (partnerFreq > 0) {
                        count = count + partnerFreq;
                    }
                }
            } else {
                //Pair like (x,x) - x can partner with other x's only
                partnerFreq = freqMap.get(requiredPairValue);
                count = count + (partnerFreq - 1);
            }
        }

        return count/2;
    }

    /**
     * AS6 > Count of pairs with the given sum
     * Given a sorted array of distinct integers A and an integer B,
     * find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
     * @param A
     * @param B
     * @return
     */
    private int countPairsWithGivenSum(ArrayList<Integer> A, int B) {
        int count = 0;
        int i = 0;
        int j = A.size() - 1;
        int currentSum;
        while (i < j) {
            currentSum = A.get(i) + A.get(j);
            if (currentSum == B) {
                count++;
                i++; //Increment the i so that it goes to find the next pair
            } else if (currentSum > B) {
                j--;
            } else {
                i++;
            }
        }
        return count;
    }

    /*------------HOMEWORK------------*/

    private ArrayList<Integer> sortColors(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == 0) count0++;
            if (A.get(i) == 1) count1++;
            if (A.get(i) == 2) count2++;
        }
        for (int i = 0; i < count0; i++) {
            result.add(0);
        }
        for (int i = 0; i < count1; i++) {
            result.add(1);
        }
        for (int i = 0; i < count2; i++) {
            result.add(2);
        }
        return result;
    }
}
