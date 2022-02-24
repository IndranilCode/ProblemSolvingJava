package com.tutorial.AdvancedDSA.M1_Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Day34_Arrays2 {
    public void execute() {
        /*------------CLASSWORK------------*/

        //CW1 > Sum of elements of sub-matrix - Brute Force
        ArrayList<ArrayList<Integer>> inputCW1 = new ArrayList<>();
        inputCW1.add(new ArrayList<>(Arrays.asList(1, 5, 2, 3)));
        inputCW1.add(new ArrayList<>(Arrays.asList(7, 2 ,3 ,4)));
        inputCW1.add(new ArrayList<>(Arrays.asList(3, 4 ,2 ,5)));
        inputCW1.add(new ArrayList<>(Arrays.asList(8, 4 ,2 ,3)));
        int outputCW1 = this.sumOf1SubMatrix_BruteForce(inputCW1, 1, 1 ,2, 3);
        System.out.println("CW1 > Sum of elements of sub-matrix - Brute Force: " + outputCW1);

        //CW2 > Sum of elements of sub-matrix - Brute Force - Optimization 1 - with PS per row
        ArrayList<ArrayList<Integer>> inputCW2 = new ArrayList<>();
        inputCW2.add(new ArrayList<>(Arrays.asList(1, 5, 2, 3, 4)));
        inputCW2.add(new ArrayList<>(Arrays.asList(7, 2 ,3 ,4, 2)));
        inputCW2.add(new ArrayList<>(Arrays.asList(3, 4 ,2 ,5, 3)));
        inputCW2.add(new ArrayList<>(Arrays.asList(8, 4 ,2 ,3, 1)));
        int outputCW2 = this.sumOfSubMatrix_BruteForce_PrefixSumRow(inputCW2, 1, 1 ,2, 3);
        System.out.println("CW2 > Sum of elements of sub-matrix - Brute Force - Optimization 1 - with PS per row: " + outputCW2);

        //CW3 > Build prefix sum-matrix
        ArrayList<ArrayList<Integer>> inputCW3 = new ArrayList<>();
        inputCW3.add(new ArrayList<>(Arrays.asList(1, 5, 2, 3, 4)));
        inputCW3.add(new ArrayList<>(Arrays.asList(7, 2 ,3 ,4, 2)));
        inputCW3.add(new ArrayList<>(Arrays.asList(3, 4 ,2 ,5, 3)));
        inputCW3.add(new ArrayList<>(Arrays.asList(8, 4 ,2 ,3, 1)));
        System.out.println("CW3 > Build prefix sum-matrix: " + outputCW2);
        this.buildPrefixSumMatrix(inputCW3);

        ArrayList<ArrayList<Integer>> inputCW33 = new ArrayList<>();
        inputCW33.add(new ArrayList<>(Arrays.asList(1,2,3)));
        inputCW33.add(new ArrayList<>(Arrays.asList(4,5,6)));
        inputCW33.add(new ArrayList<>(Arrays.asList(7,8,9)));
        this.buildPrefixSumMatrix(inputCW33);

        //CW4 > Sum of elements of sub-matrix - Prefix Matrix approach (Optimized)
        ArrayList<ArrayList<Integer>> inputCW4 = new ArrayList<>();
        inputCW4.add(new ArrayList<>(Arrays.asList(1, 5, 2, 3, 4)));
        inputCW4.add(new ArrayList<>(Arrays.asList(7, 2 ,3 ,4, 2)));
        inputCW4.add(new ArrayList<>(Arrays.asList(3, 4 ,2 ,5, 3)));
        inputCW4.add(new ArrayList<>(Arrays.asList(8, 4 ,2 ,3, 1)));
        int outputCW4 = this.sumOfSubMatrix_PrefixMatrix_Optimized(inputCW4, 1, 1 ,2, 3);
        System.out.println("CW4 > Sum of elements of sub-matrix - Prefix Matrix approach (Optimized): " + outputCW4);

        /*------------ASSIGNMENTS------------*/

        //AS1 > Sub-matrix Sum Queries
        ArrayList<ArrayList<Integer>> inputAS1a = new ArrayList<>();
        inputAS1a.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        inputAS1a.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        inputAS1a.add(new ArrayList<>(Arrays.asList(7, 8, 9)));
        ArrayList<Integer> inputAS1b = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> inputAS1c = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> inputAS1d = new ArrayList<>(Arrays.asList(2, 3));
        ArrayList<Integer> inputAS1e = new ArrayList<>(Arrays.asList(2, 3));
        System.out.print("AS1 > Sub-matrix Sum Queries: ");
        ArrayList<Integer> resultAS1 = this.submatrixSumQueries(inputAS1a, inputAS1b, inputAS1c, inputAS1d, inputAS1e);
        resultAS1.forEach(e -> {
            System.out.print(e + ",");
        });
        System.out.println();

        //AS2 > Sum of all Sub-matrices (Contribution Technique)
        ArrayList<ArrayList<Integer>> inputAS2 = new ArrayList<>();
        inputAS2.add(new ArrayList<>(Arrays.asList(9, 6)));
        inputAS2.add(new ArrayList<>(Arrays.asList(5, 4)));
        System.out.println("AS2 > Sum of all Sub-matrices (Contribution Technique): " + this.sumOfAllSubmatrices(inputAS2));

        //AS3 > Maximum Sum Square SubMatrix
        ArrayList<ArrayList<Integer>> inputAS3 = new ArrayList<>();
        inputAS3.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1)));
        inputAS3.add(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2)));
        inputAS3.add(new ArrayList<>(Arrays.asList(3, 8, 6, 7, 3)));
        inputAS3.add(new ArrayList<>(Arrays.asList(4, 4, 4, 4, 4)));
        inputAS3.add(new ArrayList<>(Arrays.asList(5, 5, 5, 5, 5)));
        System.out.println("AS3 > Maximum Sum Square SubMatrix: " + this.maximumSumSquareMatrix(inputAS3, 3));

        //AS4 > Search in a row wise and column wise sorted matrix
        ArrayList<ArrayList<Integer>> inputAS4 = new ArrayList<>();
        //        inputAS4.add(new ArrayList<>(Arrays.asList(2, 8, 8, 8)));
        //        inputAS4.add(new ArrayList<>(Arrays.asList(2, 8, 8, 8)));
        //        inputAS4.add(new ArrayList<>(Arrays.asList(2, 8, 8, 8)));
        inputAS4.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        inputAS4.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        inputAS4.add(new ArrayList<>(Arrays.asList(7, 8, 9)));
        inputAS4.add(new ArrayList<>(Arrays.asList(10, 11, 12)));
        System.out.println("AS4 > Search in a row wise and column wise sorted matrix (Staircase search): " + this.searchInMatrixStaircaseSearch(inputAS4, 1));
        //System.out.println("AS4 > Search in a row wise and column wise sorted matrix (Staircase search): " + this.searchInMatrixStaircaseSearch(inputAS4, 80));

    }

    /*------------CLASSWORK------------*/

    /**
     * CW1 > Sum of elements of submatrix - Brute Force
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
    private int sumOf1SubMatrix_BruteForce(ArrayList<ArrayList<Integer>> A, int r1, int c1, int r2, int c2) {
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
    private int sumOfSubMatrix_BruteForce_PrefixSumRow(ArrayList<ArrayList<Integer>> A, int r1, int c1, int r2, int c2) {
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
     * CW3> Prefix sum matrix creation
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

    /**
     * CW4> Sum of elements of submatrix - Prefix Submatrix
     * @param A
     * @param r1
     * @param c1
     * @param r2
     * @param c2
     * @return
     */
    private int sumOfSubMatrix_PrefixMatrix_Optimized(ArrayList<ArrayList<Integer>> A, int r1, int c1, int r2, int c2) {
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

        //Getting sum of prefix sum array
        int startR1 = (r1-1) > 0 ? (r1-1) : 0;
        int startC1 = (c1-1) > 0 ? (c1-1) : 0;
        return prefixMatrix[r2][c2] - prefixMatrix[startR1][c2] - prefixMatrix[r2][startC1] + prefixMatrix[startR1][startC1];
    }

    /*------------ASSIGNMENTS------------*/

    /**
     * AS1 > Sub-matrix Sum Queries
     * Given a matrix of integers A of size N x M and multiple queries Q, for each query find and return the submatrix sum.
     * Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.
     * Sum may be large so return the answer mod 10pow9 + 7.
     * @param A
     * @param B
     * @param C
     * @param D
     * @param E
     * @return
     */
    private ArrayList<Integer> submatrixSumQueries(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D, ArrayList<Integer> E) {
        int rows = A.size();
        int cols = A.get(0).size();
        long[][] prefixMatrix = new long[rows][cols];
        long mod = 1000000007;

        //Building prefix sum matrix
        //0th row
        long runningSum = 0;
        for (int i = 0; i < cols; i++) {
            runningSum = (runningSum + A.get(0).get(i)) % mod;
            prefixMatrix[0][i] = runningSum;
        }

        //0th column
        runningSum = A.get(0).get(0);
        for (int j = 1; j < rows; j++) {
            runningSum = (runningSum + A.get(j).get(0)) % mod;
            prefixMatrix[j][0] = runningSum;
        }

        //All other row/cols
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                prefixMatrix[i][j] = (prefixMatrix[i-1][j] + prefixMatrix[i][j-1] - prefixMatrix[i-1][j-1] + A.get(i).get(j)) % mod ;
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < B.size(); i++) {
            int startR1 = (B.get(i)-2);
            int startC1 = (C.get(i)-2);
            long res = (prefixMatrix[D.get(i)-1][E.get(i)-1] -
                    (startR1 >= 0 ? prefixMatrix[startR1][E.get(i)-1] : 0) -
                    (startC1 >= 0 ? prefixMatrix[D.get(i)-1][startC1] : 0) +
                    ((startR1 >= 0 && startC1 >= 0) ? prefixMatrix[startR1][startC1] : 0)) % mod;
            if (res < 0) {
                res = res + mod;
            }

            result.add((int)(res)) ;
        }

        return result;
    }

    /**
     * AS2> Sum of all Submatrices
     * Given a 2D Matrix A of dimensions N*N, we need to return sum of all possible submatrices.
     * Process - Contribution Technique => (i+1)*(j+1)*(n-i)*(m-j)*A[i][j]
     * @param A
     * @return
     */
    private int sumOfAllSubmatrices(ArrayList<ArrayList<Integer>> A) {
        int sum = 0;
        int n = A.size();
        int m = A.get(0).size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum = sum + ((i + 1) * (j + 1) * (n - i) * (m - j) * A.get(i).get(j));
            }
        }
        return sum;
    }

    /**
     * AS3 > Maximum Sum Square SubMatrix
     * Given a 2D integer matrix A of size N x N find a B x B submatrix where B<= N and B>= 1,
     * such that sum of all the elements in submatrix is maximum.
     * @param A
     * @param B
     * @return
     */
    private int maximumSumSquareMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int row = A.size();
        int col = A.get(0).size();
        int[][] prefixSumMatrix = new int[row][col];

        //Set all PS for row 0
        int rollingSum = 0;
        for (int i = 0; i < col; i++) {
            rollingSum = rollingSum + A.get(0).get(i);
            prefixSumMatrix[0][i] = rollingSum;
        }
        //Set all PS for col 0
        rollingSum = A.get(0).get(0);
        for (int i = 1; i < row; i++) {
            rollingSum = rollingSum + A.get(i).get(0);
            prefixSumMatrix[i][0] = rollingSum;
        }

        int currentVal = 0;
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                currentVal = prefixSumMatrix[i-1][j] + prefixSumMatrix[i][j-1] - prefixSumMatrix[i-1][j-1] + A.get(i).get(j);
                prefixSumMatrix[i][j] = currentVal;
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int currentSum = Integer.MIN_VALUE;

        for (int i = 0; i <= (row - B); i++) {
            for (int j = 0; j <= (col - B); j++) {
                if (i > 0 && j > 0) {
                    currentSum = prefixSumMatrix[i+B-1][j+B-1] - prefixSumMatrix[i-1][j+B-1] - prefixSumMatrix[i+B-1][j-1] + prefixSumMatrix[i-1][j-1];
                } else if (i > 0 && j <= 0) {
                    currentSum = prefixSumMatrix[i+B-1][j+B-1] - prefixSumMatrix[i-1][j+B-1];
                } else if (j > 0 && i <= 0) {
                    currentSum = prefixSumMatrix[i+B-1][j+B-1] - prefixSumMatrix[i+B-1][j-1];
                } else if (i <= 0 && j <= 0) {
                    currentSum = prefixSumMatrix[i+B-1][j+B-1];
                }
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }

        return maxSum;
    }

    /**
     * AS4 > Search in a row wise and column wise sorted matrix
     * If A[i][j] = B then return (i * 1009 + j) ; else return -1.
     * @param A
     * @param B
     * @return
     */
    private int searchInMatrixStaircaseSearch(ArrayList<ArrayList<Integer>> A, int B) {
        int n = A.size();
        int m = A.get(0).size();
        int result = -1;
        int minResult = Integer.MAX_VALUE;
        int i = 0;
        int j = m-1;
        while (i < n && j >= 0) {
            if (A.get(i).get(j) == B) {
                result = ((i+1) * 1009) + (j+1);
                if (result < minResult) {
                    minResult = result;
                }
                j--;
            } else if (B < A.get(i).get(j)) {
                //Go left
                j--;
            } else if (B > A.get(i).get(j)) {
                i++;
            }
        }
        return minResult == Integer.MAX_VALUE ? -1 : minResult;
    }
}
