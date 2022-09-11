package main.tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * COMPLETED
 */
public class Day12ArrayPrefixSumAndCarryForwardPart1 {
    public void executeArrayPrefixSumAndCarryForwardPart1() {
        //AS1 > Beggars Outside Temple
        ArrayList<ArrayList<Integer>> inputAS1 = new ArrayList<>();
        inputAS1.add(new ArrayList<>(Arrays.asList(1, 2, 10)));
        inputAS1.add(new ArrayList<>(Arrays.asList(2, 3, 20)));
        inputAS1.add(new ArrayList<>(Arrays.asList(2, 5, 25)));
        ArrayList<Integer> outputAS1 = beggarsOutsideTemple(5, inputAS1);
        System.out.print("AS1 - Beggars Outside Temple :");
        outputAS1.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println("");

        //AS2 > Sum of All Subarrays
        ArrayList<Integer> inputAS2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        //ArrayList<Integer> inputAS2 = new ArrayList<Integer>(Arrays.asList(8454, 3670, 4704, 7827, 5096));
        Long outputAS2 = sumOfAllSubarrays(inputAS2);
        System.out.println("AS4 - Sum of All Subarrays :" + outputAS2);

        //AS3 > Closest MinMax
        // ArrayList<Integer> inputAS3 = new ArrayList<Integer>(Arrays.asList(1, 3, 1, 5, 8, 1, 2, 8, 5));  // => 2
        // ArrayList<Integer> inputAS3 = new ArrayList<Integer>(Arrays.asList(834, 563, 606, 221, 165)); => 5
        ArrayList<Integer> inputAS3 = new ArrayList<Integer>(Arrays.asList(4, 4, 4, 4, 4));
        int outputAS3 = closestMinMax(inputAS3);
        System.out.println("AS4 - Closest MinMax :" + outputAS3);
        
        //AS4 > Special Subsequences "AG"
        String inputAS4 = "GUGPUAGAFQBMPYAGGAAOALAELGGGAOGLGEGZ";
        // String inputAS4 = "ABCGAG";
        int outputAS4 = specialSequencesAG(inputAS4);
        System.out.println("AS4 - Special Subsequences \"AG\" :" + outputAS4);

        //-------------------------------------------------------------------------------------------

        //HW1 > Pattern Printing -2
        int inputHW1 = 4;
        ArrayList<ArrayList<Integer>> outputHW1 = patternPrinting2(inputHW1);
        System.out.println("HW1 - Pattern Printing -2 :");
        outputHW1.forEach(eachRow -> {
            eachRow.forEach(eachNumber -> {
                System.out.print(eachNumber + " ");
            });
            System.out.println("");
        });

        //HW2 > Pattern Printing -1
        int inputHW2 = 4;
        ArrayList<ArrayList<Integer>> outputHW2 = patternPrinting1(inputHW2);
        System.out.println("HW2 - Pattern Printing -1 :");
        outputHW2.forEach(eachRow -> {
            eachRow.forEach(eachNumber -> {
                System.out.print(eachNumber + " ");
            });
            System.out.println("");
        });

        //HW3 > Arithmetic Progression
        ArrayList<Integer> inputHW3 = new ArrayList<Integer>(Arrays.asList(3, 5, 1));
        int outputHW3 = arithmeticProgression(inputHW3);
        System.out.println("HW3 - Arithmetic Progression :" + outputHW3);
        //        String inputHW3 = "GUGPUAGAFQBMPYAGGAAOALAELGGGAOGLGEGZ";
        //        // String inputAS4 = "ABCGAG";
        //        int outputAS4 = specialSequencesAG(inputAS4);
        //        System.out.println("AS4 - Special Subsequences \"AG\" :" + outputAS4);

        //HW4 > Equilibrium index of an array
        ArrayList<Integer> inputHW4 = new ArrayList<Integer>(Arrays.asList(-7, 1, 5, 2, -4, 3, 0));
        int outputHW4 = equilibriumIndexOfArray(inputHW4);
        System.out.println("HW4 - Equilibrium index of an array :" + outputHW4);
    }

    /**
     * AS1 > Beggars Outside Temple [Technique - prefix sum at end]
     * Input: N = 5, D = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
     * Return: [10, 55, 45, 25, 25]
     * Explanation:
     * => First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]
     * => Second devotee donated 20 coins to beggars ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]
     * => Third devotee donated 25 coins to beggars ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]
     * @param A
     * @param B
     * @return
     */
    private ArrayList<Integer> beggarsOutsideTemple(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> finalResult = new ArrayList<>();
        Integer[] result = new Integer[A];
        for (int i = 0; i < A; i++) {
            result[i] = 0;
        }
        for (int query = 0; query <= B.size()-1; query++) {
            result[B.get(query).get(0) - 1] = (result[B.get(query).get(0) - 1] != null ? result[B.get(query).get(0) - 1] : 0) + B.get(query).get(2);
            if (B.get(query).get(1) < A) {
                result[(B.get(query).get(1))] = (result[(B.get(query).get(1))] != null ? result[(B.get(query).get(1))] : 0) + (-B.get(query).get(2));
            }
        }
        for (int i = 0; i < A; i++) {
            if (i == 0) {
                finalResult.add(result[i]);
            } else {
                finalResult.add(finalResult.get(i - 1) + (result[i] != null ? result[i] : 0));
            }
        }
        return finalResult;
    }

    /**
     * AS2 > Sum of All Subarrays
     * Given an integer array A of length N, find the sum of all subarray sums of A.
     * A subarray sum denotes the sum of all the elements of that subarray.
     * Explanation:
     * A = [1, 2, 3] , Output => 20
     * @param A
     * @return
     */
    private Long sumOfAllSubarrays(ArrayList<Integer> A) {
        //        ArrayList<Integer> finalResult = new ArrayList<>();
        //        Integer[] result = new Integer[A];
        //        for (int i = 0; i < A; i++) {
        //            result[i] = 0;
        //        }
        //        for (int query = 0; query <= B.size()-1; query++) {
        //            result[B.get(query).get(0) - 1] = (result[B.get(query).get(0) - 1] != null ? result[B.get(query).get(0) - 1] : 0) + B.get(query).get(2);
        //            if (B.get(query).get(1) < A) {
        //                result[(B.get(query).get(1))] = (result[(B.get(query).get(1))] != null ? result[(B.get(query).get(1))] : 0) + (-B.get(query).get(2));
        //            }
        //        }
        //        for (int i = 0; i < A; i++) {
        //            if (i == 0) {
        //                finalResult.add(result[i]);
        //            } else {
        //                finalResult.add(finalResult.get(i - 1) + (result[i] != null ? result[i] : 0));
        //            }
        //        }
        //        return finalResult;

        Long totalSum = 0L;
        for (int i = 0; i < A.size(); i++) {
            Long currentVal = Long.valueOf(A.get(i));
            //totalSum = totalSum + ((i + 1) * (A.size() - i) * currentVal); //Issue with long inputs as int * int * long
            // => if (i + 1) * (A.size() - i) yields long then since both were int it casts to int itself having garbage values and then multiplies with long
            // => result wrong value
            totalSum = totalSum + (currentVal* (i + 1) * (A.size() - i)); //long * int * int => this is correct
        }
        return totalSum;
    }

    /**
     * AS3 > Closest MinMax
     * Given array A, find the size of the smallest subarray such that it contains atleast one occurrence of the maximum & minimum value of the array.
     * Example => A = [1, 3] , o/p => 2
     * @param A
     * @return
     */
    private int closestMinMax(ArrayList<Integer> A) {
        int maxNumber = Integer.MIN_VALUE;
        int minNumber = Integer.MAX_VALUE;
        int minSize = A.size();
        int size = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) < minNumber) {
                minNumber = A.get(i);
            }
            if (A.get(i) > maxNumber) {
                maxNumber = A.get(i);
            }
        }
        int maxIndex = -1;
        int minIndex = -1;
        for (int i = A.size()-1; i >= 0; i--) {
            if (A.get(i) == maxNumber) {
                maxIndex = i;
            }
            if (A.get(i) == minNumber) {
                minIndex = i;
            }

            if (maxIndex != -1 & minIndex != -1 & (A.get(i) == maxNumber ||  A.get(i) == minNumber)) {
                size = Math.abs(maxIndex - minIndex) + 1;
                if (size < minSize) {
                    minSize = size;
                }
            }
        }
        return minSize;
    }

    /**
     * AS4 > Special Subsequences "AG"
     * You have given a string A having Uppercase English letters. You have to find that how many times subsequence "AG" is there in the given string.
     * Example => A = "ABCGAG" => O/P => 3
     * @param a
     * @return
     */
    private int specialSequencesAG(String a) {
        int result = 0;
        int flowingPrefixCount = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            char currentChar = a.charAt(i);
            switch (currentChar) {
                case 'G':
                    flowingPrefixCount++;
                    break;
                case 'A':
                    result = result + flowingPrefixCount;
                    break;
            }
        }
        return result;
    }

    //-------------------------------------------------------------------------------------------

    /**
     * HW1 > Pattern Printing -2
     * Print a Pattern According to The Given Value of A.
     * Example: For A = 3 pattern looks like:
     *     1
     *   2 1
     * 3 2 1
     * Working Example => A = 4
     * [
     *    [0, 0, 0, 1]
     *    [0, 0, 2, 1]
     *    [0, 3, 2, 1]
     *    [4, 3, 2, 1]
     *  ]
     * @param A
     * @return
     */
    private ArrayList<ArrayList<Integer>> patternPrinting2(int A) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        for (int row = A-1 ; row >= 0; row--) {
            ArrayList<Integer> singleRow = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                singleRow.add(0);
            }

            int remainingSpaces = A - row;
            //            for (int i = 1; i <= A-row; i++) {
            //                singleRow.add(i);
            //            }
            for (int i = A-row; i >= 1; i--) {
                singleRow.add(i);
            }
            output.add(singleRow);
        }
        return output;
    }

    /**
     * HW2 > Pattern Printing -1
     * Print a Pattern According to The Given Value of A.
     * Example: For A = 3 pattern looks like:
     * 1 0 0
     * 1 2 0
     * 1 2 3
     * @param A
     * @return
     */
    private ArrayList<ArrayList<Integer>> patternPrinting1(int A) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        for (int row = 1; row <= A; row++) {
            ArrayList<Integer> singleRow = new ArrayList<>();
            for (int i = 1; i <= row; i++) {
                singleRow.add(i);
            }
            int remainingSpace = A - row;
            for (int i = 0; i < remainingSpace; i++) {
                singleRow.add(0);
            }
            output.add(singleRow);
        }
        return output;
    }

    /**
     * HW3 > Arithmetic Progression
     * Given an integer array A of size N. Return 1 if the array can be rearranged to form an arithmetic progression, otherwise, return 0.
     * A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
     * Example => A = [3, 5, 1] => O/P = 1 =>
     * We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.
     * @param A
     * @return
     */
    private int arithmeticProgression(ArrayList<Integer> A) {
        int isAP = 1;
        Collections.sort(A);
        int apDiff = A.get(1) - A.get(0);
        for (int i = 1; i < A.size() - 1; i++) {
            if  (A.get(i+1) - A.get(i) != apDiff) {
                isAP = 0;
                break;
            }
        }
        return isAP;
    }

    /**
     * HW4 > Given array A of integers of size N, find the equilibrium index.
     * Equilibrium index is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
     * @param A
     * @return
     */
    private int equilibriumIndexOfArray(ArrayList<Integer> A) {
        int equilibriumIndex = -1;
        ArrayList<Integer> prefixSumArrayList = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (i == 0) {
                prefixSumArrayList.add(A.get(i));
            } else {
                prefixSumArrayList.add((prefixSumArrayList.get(i - 1) + A.get(i)));
            }
        }
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < A.size(); i++) {
            leftSum = prefixSumArrayList.get(i) - A.get(i);
            rightSum = prefixSumArrayList.get(A.size() - 1) - prefixSumArrayList.get(i);
            if (leftSum == rightSum) {
                equilibriumIndex = i;
                break;
            }
        }
        return equilibriumIndex;
    }
}