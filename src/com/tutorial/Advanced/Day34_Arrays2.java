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
    }

    /**
     * CW1 > Sum of elemets of submatrix - Brute Force
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
}
