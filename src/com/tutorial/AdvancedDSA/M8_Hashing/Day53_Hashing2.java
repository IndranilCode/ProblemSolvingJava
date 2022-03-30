package com.tutorial.AdvancedDSA.M8_Hashing;

import java.util.*;

public class Day53_Hashing2 {
    public void execute() {
        System.out.println("--------------HASHING 1------------------");
        System.out.println("------------ASSIGNMENTS------------------");

        //AS1 > Count Rectangles
        ArrayList<Integer> inputAS1_x = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3));
        ArrayList<Integer> inputAS1_y = new ArrayList<>(Arrays.asList(1, 2, 1, 2, 1, 2));
        System.out.println("AS1 > Count Rectangles x=[1, 1, 2, 2, 3, 3], y=[1, 2, 1, 2, 1, 2] => " + this.countRectangles(inputAS1_x, inputAS1_y));

        //AS2 > Count Right Triangles
        ArrayList<Integer> inputAS2_x = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3));
        ArrayList<Integer> inputAS2_y = new ArrayList<>(Arrays.asList(1, 2, 1, 2, 1));
        System.out.println("AS2 > Count Right Triangles x=[1, 1, 2, 3, 3], y=[1, 2, 1, 2, 1] => " + this.countRightTriangles(inputAS2_x, inputAS2_y));

        //AS3 > Is Replicating Substring
        System.out.println("AS3 > Is Replicating Substring (bbaabb , 2) => " + this.isReplicatingStrings(2, "bbaabb"));
        System.out.println("    > Is Replicating Substring (bbaabbb , 2) => " + this.isReplicatingStrings(2, "bbaabbb"));
    }

    /*------------ASSIGNMENTS------------*/

    /**
     * AS1 > Count Rectangles
     * Given 2 integer arrays A, B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y)
     * Find number of rectangles (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l])
     * form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.
     * @param A
     * @param B
     * @return
     */
    private int countRectangles(ArrayList<Integer> A, ArrayList<Integer> B) {
        Set<Map.Entry<Integer, Integer>> allPoints = new HashSet<>();
        for (int i = 0; i < A.size(); i++) {
            allPoints.add(new AbstractMap.SimpleEntry<>(A.get(i), B.get(i)));
        }

        //With 2 fixed points form the other 2 points and check if the hashset has both the points - if so rectangle exists
        int xi, xj, yi, yj; //Fixed points
        int xk, yk, xl, yl;  //Formed points
        Map.Entry<Integer, Integer> pointK, pointL;
        int count = 0;
        for (int i = 0 ; i < A.size(); i++) {
            for (int j = 0; j < A.size(); j++) { // i = 0, j = 0 as else we'll only check upper quadrant which migh not be full proof
                //Current pair => x[i],y[i] ; x[j],y[j]
                xi = A.get(i);
                xj = A.get(j);
                yi = B.get(i);
                yj = B.get(j);
                if (xi < xj && yi > yj) {
                    //Point k
                    xk = xi;
                    yk = yj;
                    pointK = new AbstractMap.SimpleEntry<>(xk, yk);

                    //Point l
                    xl = xj;
                    yl = yi;
                    pointL = new AbstractMap.SimpleEntry<>(xl, yl);

                    //Check if pointK & pointL are both present => then rectangle possible
                    if (allPoints.contains(pointK) && allPoints.contains(pointL)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

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

    /**
     * AS3 > Is Replicating Substring
     * Given string B, find if its possible to re-order the characters of B to represented as concatenation of A similar strings.
     * Eg: B = aabb and A = 2, then it is possible to re-arrange the string as "abab" which is a concatenation of 2 similar strings "ab".
     * If it is possible, return 1, else return -1.
     * @param A
     * @param B
     * @return
     */
    private int isReplicatingStrings(int A, String B) {
        HashMap<Character, Integer> charFreq = new HashMap<>();
        Character currentChar;

        //Build each char freq map
        for (int i = 0; i < B.length(); i++) {
            currentChar = B.charAt(i);
            charFreq.put(currentChar, charFreq.containsKey(currentChar) ? (charFreq.get(currentChar) + 1) : 1);
        }

        int result = 1;
        for (Integer freq: charFreq.values()) {
            if (freq % A != 0) {
                result = -1;
                break;
            }
        }
        return result;
    }
}
