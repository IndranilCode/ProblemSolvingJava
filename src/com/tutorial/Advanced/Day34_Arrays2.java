package com.tutorial.Advanced;

import java.util.ArrayList;
import java.util.Arrays;

public class Day34_Arrays2 {
    public void execute() {
        //CW1 > Sum of elemets of submatrix - Brute Force
        ArrayList<ArrayList<Integer>> inputCW1 = new ArrayList<>();
        inputCW1.add(new ArrayList<>(Arrays.asList(1, 5, 2, 3)));
        inputCW1.add(new ArrayList<>(Arrays.asList(7, 2 ,3 ,4)));
        inputCW1.add(new ArrayList<>(Arrays.asList(3, 4 ,2 ,5)));
        inputCW1.add(new ArrayList<>(Arrays.asList(8, 4 ,2 ,3)));
        int outputCW1 = this.sumOfSubMatrixBruteForce(inputCW1, 1, 1 ,2, 3);
        System.out.println("CW1 > Sum of elemets of submatrix - Brute Force: " + outputCW1);

        //CW2 > Sum of elemets of submatrix - Brute Force
        ArrayList<ArrayList<Integer>> inputCW2 = new ArrayList<>();
        inputCW2.add(new ArrayList<>(Arrays.asList(1, 5, 2, 3, 4)));
        inputCW2.add(new ArrayList<>(Arrays.asList(7, 2 ,3 ,4, 2)));
        inputCW2.add(new ArrayList<>(Arrays.asList(3, 4 ,2 ,5, 3)));
        inputCW2.add(new ArrayList<>(Arrays.asList(8, 4 ,2 ,3, 1)));
        int outputCW2 = this.sumOfSubMatrixBruteForcePrefixSumRow(inputCW2, 1, 1 ,2, 3);
        System.out.println("CW2 > Sum of elemets of submatrix - Brute Force - Optimization 1 - with PS per row: " + outputCW2);
    }

    /**
     * CW1 > Sum of elemets of submatrix - Brute Force
     * TC = O(n2) - square matrix (n * n)      => For q queries = O(qn2)
     * TC = O(nm) - rectangular matrix (n * m) => For q queries = O(nmq)
     * @param A
     * @param r1
     * @param c1
     * @param r2
     * @param c2
     * @return
     */
    private int sumOfSubMatrixBruteForce(ArrayList<ArrayList<Integer>> A, int r1, int c1, int r2, int c2) {
        int sum = 0;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                sum = sum + A.get(i).get(j);
            }
        }
        return sum;
    }

    /**
     * CW2 > Sum of elemets of submatrix - Brute Force - Optimization 1 - with PS per row
     * TC = O(n2) - square matrix (n * n)      => For q queries = O(qn2)
     * TC = O(nm) - rectangular matrix (n * m) => For q queries = O(nmq)
     * @param A
     * @param r1
     * @param c1
     * @param r2
     * @param c2
     * @return
     */
    private int sumOfSubMatrixBruteForcePrefixSumRow(ArrayList<ArrayList<Integer>> A, int r1, int c1, int r2, int c2) {
        ArrayList<ArrayList<Integer>> prefixSumRows = new ArrayList<>();

        //Create PS per row
        for (int i = 0; i < A.size(); i++) {
            int runningSum = 0;
            ArrayList<Integer> newRow = new ArrayList<>();
            for (int j = 0; j < A.get(0).size(); j++) {
                runningSum = runningSum + A.get(i).get(j);
                newRow.add(runningSum);
            }
            prefixSumRows.add(newRow);
        }

        int sum = 0;
        for (int i = r1; i <= r2; i++) {
            int startColPS = (c1 - 1) >= 0 ? prefixSumRows.get(i).get(c1 - 1) : 0;
            sum = sum + (prefixSumRows.get(i).get(c2) - startColPS);
        }
        return sum;
    }


}
