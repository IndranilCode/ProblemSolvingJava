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

        //CW3 > Build prefix sum matrix
        ArrayList<ArrayList<Integer>> inputCW3 = new ArrayList<>();
        inputCW3.add(new ArrayList<>(Arrays.asList(1, 5, 2, 3, 4)));
        inputCW3.add(new ArrayList<>(Arrays.asList(7, 2 ,3 ,4, 2)));
        inputCW3.add(new ArrayList<>(Arrays.asList(3, 4 ,2 ,5, 3)));
        inputCW3.add(new ArrayList<>(Arrays.asList(8, 4 ,2 ,3, 1)));
        this.buildPrefixSumMatrix(inputCW3);
    }

    /**
     * CW1 > Sum of elemets of submatrix - Brute Force
     * TC [square matrix n * n] = O(n2) => For q queries = O(qn2)
     * TC [rect matrix n * m]   = O(nm) => For q queries = O(nmq)
     * SC = O(1)
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
     * TC [square matrix n * n] = O(n2) [PS generation] + O(n) [Sum]  => For q queries = O(qn2) + O(qn)
     * TC [rect matrix n * m]   = O(nm) [PS generation] + O(N) [Sum]  => For q queries = O(nmq) + O(qn)
     * SC = o(nm)
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

    /**
     * Prefix sum matrix creation
     * @param A
     */
    private void buildPrefixSumMatrix(ArrayList<ArrayList<Integer>> A) {
        int rows = A.size();
        int cols = A.get(0).size();
        Integer[][] prefixMatrix = new Integer[rows][cols];

        //Building prefix sum matrix
        //0th row
        int runningSum = 0;
        for (int i = 0; i < cols; i++) {
            runningSum = runningSum + A.get(0).get(i);
            prefixMatrix[0][i] = runningSum;
        }

        //0th column
        runningSum = A.get(0).get(0);
        for (int j = 1; j < rows; j++) {
            runningSum = runningSum + A.get(j).get(0);
            prefixMatrix[j][0] = runningSum;
        }

        //All other row/cols
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                prefixMatrix[i][j] = prefixMatrix[i-1][j] + prefixMatrix[i][j-1] - prefixMatrix[i-1][j-1] + A.get(i).get(j);
            }
        }

        //Display
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(prefixMatrix[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
