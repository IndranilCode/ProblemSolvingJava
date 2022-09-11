package main.tutorial.AdvancedDSA.M8_Hashing;

import java.util.*;
import java.math.BigInteger;

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

        /*------------HOMEWORK------------*/
        System.out.println("------------HOMEWORK------------------");

        //HW1 > Points on same line (Collinear)
        ArrayList<Integer> inputHW1_a = new ArrayList<>(Arrays.asList(-1, 0, 1, 2, 3, 3));
        ArrayList<Integer> inputHW1_b = new ArrayList<>(Arrays.asList(1, 0, 1, 2, 3, 4));
        System.out.println("HW1 > Points on same line (Collinear) x=[-1, 0, 1, 2, 3, 3], y=[1, 0, 1, 2, 3, 4] => " + this.numberOfCollinearPoints(inputHW1_a, inputHW1_b));

        //HW2 > Compare Sorted Subarrays
        ArrayList<Integer> inputHW2_a = new ArrayList<>(Arrays.asList(1, 7, 11, 8, 11, 7, 1));
        ArrayList<ArrayList<Integer>> inputHW2_queries = new ArrayList<>();
        inputHW2_queries.add(new ArrayList<>(Arrays.asList(0, 2, 4, 6)));
        ArrayList<Integer> resultHW2 = this.compareSortedSubArrays_qQueries(inputHW2_a, inputHW2_queries);
        System.out.print("HW2 > Compare Sorted Subarrays => [");
        resultHW2.forEach(e -> System.out.print(e + ", "));
        System.out.println("]");

        //HW3 > Common Elements
        ArrayList<Integer> inputHW3_a = new ArrayList<>(Arrays.asList(1, 2, 2, 1));
        ArrayList<Integer> inputHW3_b = new ArrayList<>(Arrays.asList(2, 3, 1, 2));
        ArrayList<Integer> resultHW3 = this.findCommonElements(inputHW3_a, inputHW3_b);
        System.out.print("HW3 > Common Elements a=[1, 2, 2, 1] b=[2, 3, 1, 2] => [");
        resultHW3.forEach(e -> System.out.print(e + ", "));
        System.out.println("]");
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

    /*------------HOMEWORK------------*/

    /**
     * HW1 > Points on same line (Collinear) [DIFFICULT CLASS APPROACH]
     * Given 2 integers arrays A and B - pair of (A[i], B[i]).
     * A[i] = x coordinates of the ith point, B[i] = y-coordinate of the ith point
     * Find maximum number of points that lie on the same line.
     * @param A
     * @param B
     * @return
     */
    private int numberOfCollinearPoints_old_bothM_C(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        HashMap<Map.Entry<Map.Entry<Integer, Integer>, Map.Entry<Integer, Integer>>, Integer> sameLineFreq = new HashMap<>();

        int y2, y1, x2, x1;
        int m1, m2, c1, c2;
        Map.Entry<Integer, Integer> m, c;
        Map.Entry<Map.Entry<Integer, Integer>, Map.Entry<Integer, Integer>> mc;
        BigInteger mGcd, cGcd;
        Integer mGcdInt, cGcdInt;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                //Evaluating line by points (xi,yi) ,(xj,yj)
                y2 = B.get(j);
                y1 = B.get(i);
                x2 = A.get(j);
                x1 = A.get(i);

                //Forming m (m1,m2) , c (c1,c2)
                m1 = y2-y1;
                m2 = x2-x1;
                c1 = (x2 * y1) - (x1 * y2);
                c2 = x2 - x1;

                mGcd = (new BigInteger(m1 + "")).gcd(new BigInteger(m2 + ""));
                cGcd = (new BigInteger(c1 + "")).gcd(new BigInteger(c2 + ""));
                mGcdInt = Integer.parseInt(mGcd + "");
                cGcdInt = Integer.parseInt(cGcd + "");

                //Form pair m & c & Pair<m,c>
                m = new AbstractMap.SimpleEntry<>(m1/mGcdInt, m2/mGcdInt);
                c = new AbstractMap.SimpleEntry<>(c1/cGcdInt, c2/cGcdInt);
                mc = new AbstractMap.SimpleEntry<>(m ,c);

                //Add tp freqMap
                sameLineFreq.put(mc, sameLineFreq.containsKey(mc) ? (sameLineFreq.get(mc) + 1) : 1);
            }
        }

        //Find line with highest freq
        Integer highestLineCount = Integer.MIN_VALUE;
        for (Integer freq: sameLineFreq.values()) {
            if (freq > highestLineCount) {
                highestLineCount = freq;
            }
        }

        double a = 1 + (Math.sqrt(1 + (8 * highestLineCount)) / 2);
        double b = 1 - (Math.sqrt(1 + (8 * highestLineCount)) / 2);
        System.out.println(a);
        System.out.println(b);

        //We know => nC2 = highestLineCount
        return highestLineCount;



    }

    /**
     * HW1 > Points on same line (Collinear)
     * Given 2 integers arrays A and B - pair of (A[i], B[i]).
     * A[i] = x coordinates of the ith point, B[i] = y-coordinate of the ith point
     * Find maximum number of points that lie on the same line.
     * @param A
     * @param B
     * @return
     */
    private int numberOfCollinearPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();

        Integer finalCount = Integer.MIN_VALUE;
        HashMap<Map.Entry<Integer, Integer>, Integer> sameLineFixedPointFreq;
        int y2, y1, x2, x1;
        int m1, m2;
        int duplicate;
        Map.Entry<Integer, Integer> m;
        BigInteger mGcd;
        Integer mGcdInt;
        for (int i = 0; i < n; i++) {
            Integer highestLineCount = Integer.MIN_VALUE;
            duplicate = 0;
            sameLineFixedPointFreq = new HashMap<>(); //Collect freq for every unique point set and other variable
            for (int j = 0; j < n; j++) {
                //Ignore same point ie AA ,BB etc
                if (i != j) {
                    //Evaluating line by points (xi,yi) ,(xj,yj)
                    y2 = B.get(j);
                    y1 = B.get(i);
                    x2 = A.get(j);
                    x1 = A.get(i);

                    //Check if some duplicate is there
                    if (y2 == y1 && x2 == x1) {
                        //Duplicate point
                        duplicate++;
                    } else {
                        //Different point - Forming m (m1,m2)
                        m1 = y2-y1;
                        m2 = x2-x1;
                        mGcd = (new BigInteger(m1 + "")).gcd(new BigInteger(m2 + ""));
                        mGcdInt = Integer.parseInt(mGcd + "");

                        //Form pair m (m1,m2)
                        m = new AbstractMap.SimpleEntry<>(m1/mGcdInt, m2/mGcdInt);

                        //Add to freqMap
                        sameLineFixedPointFreq.put(m, sameLineFixedPointFreq.containsKey(m) ? (sameLineFixedPointFreq.get(m) + 1) : 1);
                    }
                }
            }
            //Find the top freq which is the collinearity for this point A[i]
            for (Integer freq: sameLineFixedPointFreq.values()) {
                if (freq > highestLineCount) {
                    highestLineCount = freq;
                }
            }
            highestLineCount = highestLineCount + duplicate + 1;
            if (highestLineCount > finalCount) {
                finalCount = highestLineCount;
            }
        }
        return finalCount;
    }

    /**
     * HW2 > Compare Sorted Subarrays
     * Given an array A of length N. You have to answer Q queries.
     * Each query has four integers l1, r1, l2, and r2.
     * If sorted segment from [l1, r1] is the same as the sorted segment from [l2 r2], then the answer is 1 else 0.
     * @param A
     * @param B
     * @return
     */
    private ArrayList<Integer> compareSortedSubArrays_qQueries(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        //1. Prepare PSum of array A - containing hashes of each A[i]
        //2. Put the hashes in Hashmap for further consultation
        HashMap<Integer, Long> numberHashValues = new HashMap<>();
        ArrayList<Long> prefixSumA = new ArrayList<>();
        Random random = new Random();
        long sum = 0l;
        int currentNumber;
        long currentNumberHashVal;

        //Loop for all A[i] => prepare PS + put hash val in map
        for (int i = 0; i < A.size(); i++) {
            currentNumber = A.get(i);
            if (numberHashValues.containsKey(currentNumber)) {
                currentNumberHashVal = numberHashValues.get(currentNumber);
            } else {
                currentNumberHashVal = random.nextLong(); //Generate a random no as hash
                numberHashValues.put(currentNumber, currentNumberHashVal); //Add the new has to map numberHashValues
            }
            sum = sum + currentNumberHashVal;
            prefixSumA.add(sum);
        }

        ArrayList<Integer> result = new ArrayList<>();
        int l1, r1, l2, r2;
        long leftSubArraySum, rightSubArraySum;
        //For all queries in B
        for (int i = 0; i < B.size(); i++) {
            l1 = B.get(i).get(0);
            r1 = B.get(i).get(1);
            l2 = B.get(i).get(2);
            r2 = B.get(i).get(3);
            leftSubArraySum = prefixSumA.get(r1) - (l1 == 0 ? 0L : prefixSumA.get(l1 - 1) );
            rightSubArraySum = prefixSumA.get(r2) - (l2 == 0 ? 0L : prefixSumA.get(l2 - 1) );

            result.add(leftSubArraySum == rightSubArraySum ? 1 : 0);
        }
        return result;
    }

    /**
     * HW3 > Common Elements
     * Given two integer arrays, A and B of size N and M, respectively. Find common elements in both the array.
     * @param A
     * @param B
     * @return
     */
    private ArrayList<Integer> findCommonElements(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer, Integer> bFreqMap = new HashMap<>();
        //Create B's freq map
        int currentElement;
        for (int i = 0; i < B.size(); i++) {
            currentElement = B.get(i);
            bFreqMap.put(currentElement, bFreqMap.containsKey(currentElement) ? (bFreqMap.get(currentElement) + 1) : 1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        int newFreq;
        //Parse through A - consult bFreqMap and
        for (int i = 0; i < A.size(); i++) {
            currentElement = A.get(i);
            if (bFreqMap.containsKey(currentElement)) {
                //Add the existing element to result
                result.add(currentElement);
                //Modify the bFreqMap to reduce/remove the considered element
                newFreq = bFreqMap.get(currentElement) - 1;
                if (newFreq == 0) {
                    bFreqMap.remove(currentElement);
                } else {
                    bFreqMap.put(currentElement, newFreq);
                }
            }
        }
        return result;
    }
}
