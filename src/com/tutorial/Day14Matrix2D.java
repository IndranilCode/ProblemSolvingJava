package com.tutorial;

import java.util.ArrayList;
import java.util.Arrays;

public class Day14Matrix2D {
    public void executeMatrix2D() {
        //AS1 > Add the matrices
        ArrayList<ArrayList<Integer>> inputAS1a = new ArrayList<>();
        inputAS1a.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        inputAS1a.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        inputAS1a.add(new ArrayList<>(Arrays.asList(7, 8, 9)));
        ArrayList<ArrayList<Integer>> inputAS1b = new ArrayList<>();
        inputAS1b.add(new ArrayList<>(Arrays.asList(9, 8, 7)));
        inputAS1b.add(new ArrayList<>(Arrays.asList(6, 5, 4)));
        inputAS1b.add(new ArrayList<>(Arrays.asList(3, 2, 1)));
        ArrayList<ArrayList<Integer>> outputAS1 = addTheMetrices(inputAS1a, inputAS1b);
        System.out.println("AS1 - Add the matrices :");
        outputAS1.forEach(eachRow -> {
            eachRow.forEach(eachNumber -> System.out.print(eachNumber + " "));
            System.out.println("");
        });
        System.out.println("");

        //AS3 > Column Sum
        ArrayList<ArrayList<Integer>> inputAS3 = new ArrayList<>();
        inputAS3.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        inputAS3.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8)));
        inputAS3.add(new ArrayList<>(Arrays.asList(9, 2, 3, 4)));
        ArrayList<Integer> outputAS3 = columnSum(inputAS3);
        System.out.println("AS3 - Column Sum :");
        outputAS3.forEach(eachCol -> {
            System.out.print(eachCol + " ");
        });
        System.out.println("");

        //AS4 > Matrix Multiplication


        //AS5 > Matrix Subtraction
        ArrayList<ArrayList<Integer>> inputAS5a = new ArrayList<>();
        inputAS5a.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        inputAS5a.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        inputAS5a.add(new ArrayList<>(Arrays.asList(7, 8, 9)));
        ArrayList<ArrayList<Integer>> inputAS5b = new ArrayList<>();
        inputAS5b.add(new ArrayList<>(Arrays.asList(9, 8, 7)));
        inputAS5b.add(new ArrayList<>(Arrays.asList(6, 5, 4)));
        inputAS5b.add(new ArrayList<>(Arrays.asList(3, 2, 1)));
        ArrayList<ArrayList<Integer>> outputAS5 = matrixSubtraction(inputAS5a, inputAS5b);
        System.out.println("AS5 - Matrix Subtraction :");
        outputAS5.forEach(eachRow -> {
            eachRow.forEach(eachNumber -> System.out.print(eachNumber + " "));
            System.out.println("");
        });
        System.out.println("");

        //AS6 > Matrix Transpose
        ArrayList<ArrayList<Integer>> inputAS6 = new ArrayList<>();
        inputAS6.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        inputAS6.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        inputAS6.add(new ArrayList<>(Arrays.asList(7, 8, 9)));
        inputAS6.add(new ArrayList<>(Arrays.asList(10, 11, 12)));
        ArrayList<ArrayList<Integer>> outputAS6 = matrixTranspose(inputAS6);
        System.out.println("AS5 - Matrix Transpose :");
        outputAS6.forEach(eachRow -> {
            eachRow.forEach(eachNumber -> System.out.print(eachNumber + " "));
            System.out.println("");
        });
        System.out.println("");




        //HW1 > Are Matrices Same ?
        ArrayList<ArrayList<Integer>> inputHW1a = new ArrayList<>();
        inputHW1a.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        inputHW1a.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        inputHW1a.add(new ArrayList<>(Arrays.asList(7, 8, 9)));
        ArrayList<ArrayList<Integer>> inputHW1b = new ArrayList<>();
        inputHW1b.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        inputHW1b.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        inputHW1b.add(new ArrayList<>(Arrays.asList(7, 8, 9)));
        int outputHW1 = areMatricesSame(inputHW1a, inputHW1b);
        System.out.println("HW1 - Are Matrices Same :" + outputHW1);

        //HW2 > Matrix Scaler Product
        ArrayList<ArrayList<Integer>> inputHW2 = new ArrayList<>();
        inputHW2.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        inputHW2.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        inputHW2.add(new ArrayList<>(Arrays.asList(7, 8, 9)));
        ArrayList<ArrayList<Integer>> outputHW2 = matrixScalerProduct(inputHW2, 2);
        System.out.println("HW2 - Matrix Scaler Product:");
        outputHW2.forEach(eachRow -> {
            eachRow.forEach(eachNumber -> System.out.print(eachNumber + " "));
            System.out.println("");
        });
        System.out.println("");


    }

    /**
     * AS1 > Add the matrices [EASY]
     * You are given two matrices A & B of same size, you have to return another matrix which is the sum of A and B.
     * Example => A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]] , B = [[9, 8, 7],[6, 5, 4],[3, 2, 1]]
     * O/P = [[10, 10, 10], [10, 10, 10], [10, 10, 10]]
     * @param A
     * @param B
     * @return
     */
    private ArrayList<ArrayList<Integer>> addTheMetrices(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            ArrayList<Integer> eachRow = new ArrayList<>();
            for (int j = 0; j < A.get(0).size(); j++) {
                eachRow.add(A.get(i).get(j) + B.get(i).get(j));
            }
            result.add(eachRow);
        }
        return result;
    }

    /**
     * AS3 > Column Sum [EASY]
     * You are given a 2D integer matrix A, return a 1D integer vector containing column-wise sums of original matrix.
     * @param A
     * @return
     */
    private ArrayList<Integer> columnSum(ArrayList<ArrayList<Integer>> A) {
        //        [1,2,3,4]
        //        [5,6,7,8]
        //        [9,2,3,4]
        //
        //        0,0 + 1,0 + 2,0
        //        0,1 + 1,1 + 2,1
        //        0,2 + 1,2 + 2,2
        //        0,3 + 1,3 + 2,3
        ArrayList<Integer> columnSum = new ArrayList<>();
        for (int col = 0; col < A.get(0).size(); col++) {
            int colSum = 0;
            for (int row = 0; row < A.size(); row++) {
                colSum = colSum + A.get(row).get(col);
            }
            columnSum.add(colSum);
        }
        return columnSum;
    }

    /**
     * AS4 > Matrix Multiplication
     * 2 integer matrices A(having M X N size) and B(having N X P). Multiply matrix A with B and return the resultant matrix
     * Example =>
     *  A = [[1, 1]]            B = [[2],
     *                              [3]]
     * Output => [[5]]
     * @param A
     * @param B
     * @return
     */
    private ArrayList<ArrayList<Integer>> matrixMultiplication(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        // 1 2 3   *  1  2  3  4       => (1*1)+(2*5)+(3*9)  (1*2)+(2*6)+(3*10)  (1*3)+(2*7)+(3*11)  (1*4)+(2*8)+(3*12)
        // 4 5 6      5  6  7  8
        //            9 10 11 12
        //
        // (2 * 3) * (3 * 4) => 3 * 4
        // (0,0 * 0,0) + (0,1 * 1,0) + (0,2 * 2,0) ....
        ArrayList<ArrayList<Integer>> multipliedMatrix = new ArrayList<>();
        for (int col = 0; col < A.get(0).size(); col++) {
            ArrayList<Integer> resultRow = new ArrayList<>();
            int sum = 0;
            for (int row = 0; row < A.size(); row++) {
                sum = sum + (A.get(row).get(col) * B.get(col).get(row));
            }
            resultRow.add(sum);
        }
        return null;
    }

    /**
     * AS5 > Matrix Subtraction [EASY]
     * @param A
     * @param B
     * @return
     */
    private ArrayList<ArrayList<Integer>> matrixSubtraction(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int rows = A.size();
        int cols = A.get(0).size();

        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> newEachRow = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                newEachRow.add(A.get(i).get(j) - B.get(i).get(j));
            }
            result.add(newEachRow);
        }
        return result;
    }

    /**
     * AS6 > Matrix Transpose [EASY]
     * @param A
     * @return
     */
    private ArrayList<ArrayList<Integer>> matrixTranspose(ArrayList<ArrayList<Integer>> A) {
        // Input
        // 1, 2, 3
        // 4, 5, 6
        // 7, 8, 9
        //
        // Output
        // 1, 4, 7
        // 2, 5, 8
        // 3, 6, 9
        // 0,0 -> 0,0 ; 0,1 -> 1,0 ; 0,2 -> 2,0
        // 1,0 -> 0,1 ; 1,1 -> 1,1 ; 1,2 -> 2,1
        // 2,0 -> 0,2 ; 2,1 -> 1,2 ; 2,2 -> 2,2
        ArrayList<ArrayList<Integer>> transposedMatrix = new ArrayList<>();
        for (int col = 0; col < A.get(0).size(); col++) {
            ArrayList<Integer> newRow = new ArrayList<>();
            for (int row = 0; row < A.size(); row++) {
                newRow.add(A.get(row).get(col));
            }
            transposedMatrix.add(newRow);
        }
        return transposedMatrix;
    }


    /**
     * HW1 > Are Matrices Same ? [EASY]
     * 2 two matrices A & B of equal sizes and you have to check whether two matrices are equal or not.
     * NOTE: Both matrices are equal if A[i][j] == B[i][j] for all i and j in the given range. (1 OR 0)
     * Example => A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]] , B = [[1, 2, 3],[4, 5, 6],[7, 8, 9]] ; O/P = 1
     * @param A
     * @param B
     * @return
     */
    private int areMatricesSame(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        for (int row = 0; row < A.size(); row ++) {
            for (int col = 0; col < A.get(0).size(); col++) {
                if (A.get(row).get(col) != B.get(row).get(col)) {
                    return 0;
                }
            }
        }
        return 1;
    }

    /**
     * HW2 > Matrix Scaler Product [EASY]
     * You are given a matrix A and and an integer B, you have to perform scalar multiplication of matrix A with an integer B.
     * Example => A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]] , B = 2
     * O/p => [[2, 4, 6], [8, 10, 12], [14, 16, 18]]
     * @param A
     * @param B
     * @return
     */
    private ArrayList<ArrayList<Integer>> matrixScalerProduct(ArrayList<ArrayList<Integer>> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int row = 0; row < A.size(); row++) {
            ArrayList<Integer> eachRow = new ArrayList<>();
            for (int col = 0; col < A.get(0).size(); col++) {
                eachRow.add(B * A.get(row).get(col));
            }
            result.add(eachRow);
        }
        return result;
    }
}
