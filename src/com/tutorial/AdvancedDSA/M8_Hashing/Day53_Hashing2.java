package com.tutorial.AdvancedDSA.M8_Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Day53_Hashing2 {
    public void execute() {
        System.out.println("--------------HASHING 1------------------");
        System.out.println("------------ASSIGNMENTS------------------");

        //AS2 > Count Right Triangles
        ArrayList<Integer> inputAS2_x = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3));
        ArrayList<Integer> inputAS2_y = new ArrayList<>(Arrays.asList(1, 2, 1, 2, 1));
        System.out.println("AS2 > Count Right Triangles x=[1, 1, 2, 3, 3], y=[1, 2, 1, 2, 1] => " + this.countRightTriangles(inputAS2_x, inputAS2_y));
    }

    /*------------ASSIGNMENTS------------*/

    /**
     * AS2 > Count Right Triangles
     * Given 2 integer arrays A, B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y)
     * Find number of triangles (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) form right-angled triangle
     * with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.
     * NOTE: The answer may be large so return the answer modulo (109 + 7)
     * @param A
     * @param B
     * @return
     */
    private int countRightTriangles(ArrayList<Integer> A, ArrayList<Integer> B) {
        //TC = O(N) , SC =O(N)
        HashMap<Integer, Integer> xFreq = new HashMap<>();
        HashMap<Integer, Integer> yFreq = new HashMap<>();
        int currentX, currentY;

        //Build freq map of X, Y
        for (int i = 0; i < A.size(); i++) {
            currentX = A.get(i);
            currentY = B.get(i);
            xFreq.put(currentX, xFreq.containsKey(currentX) ? (xFreq.get(currentX) + 1) : 1);
            yFreq.put(currentY, yFreq.containsKey(currentY) ? (yFreq.get(currentY) + 1) : 1);
        }

        long count = 0;
        int mod = 1000000007;
        int pointsInSameX, pointsInSameY;
        for (int i = 0; i < A.size(); i++) {
            //Point x[i] , y[i]
            currentX = A.get(i);
            pointsInSameX = xFreq.get(currentX);
            currentY = B.get(i);
            pointsInSameY = yFreq.get(currentY);

            count = count + (pointsInSameX-1) * (pointsInSameY-1);
        }
        return (int)(count % mod);
    }

}
