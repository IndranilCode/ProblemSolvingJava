package com.tutorial.AdvancedDSA.Maths;

public class Day39_Combinatorics {
    public void execute() {
        //AS1 > Compute nCr % m (Recursion) - Takes long time
        System.out.println("AS1 > Compute 6c2 % 13 : " + this.combinatorics_recursion(6, 2,13));
        //System.out.println("AS1 > Compute 41c27 % 143 : " + this.combinatorics_recursion(41, 27,143)); // TLE Received [WONT WORK]

        //Attempt 2 => Principle : NcR = (N-R)cR //TLE Received [WONT WORK]
        //        int inputAS1n = 41;
        //        int inputAS1r = 27;
        //        int nMinusr = inputAS1n - inputAS1r;
        //        inputAS1r =  nMinusr < inputAS1r ?  nMinusr : inputAS1r;
        //        System.out.println("AS1 > Compute 41c27 % 143 : " + this.combinatorics_recursion(inputAS1n, nMinusr,143));

        //[WORKING] NcR % M => Optimized + Non-recursive (using 2D array to store values)
        System.out.println("AS1 > NcR % M => Optimized + Non-recursive => 6c2 % 13 : " + this.nCr_optimized_nonRecursion(41, 27,143));
    }

    /**
     * AS1 > Compute nCr % m [WONT WORK FOR HIGH N OR R]
     * @param n
     * @param r
     * @param m
     * @return
     */
    private int combinatorics_recursion(int n, int r, int m) {
        if (r == 1) return n % m;
        if (r == 0 || n == r) return 1;  //nc0 = 1 ; ncn = 1

        int x1 = combinatorics_recursion(n-1, r-1, m) % m;
        int x2 = combinatorics_recursion(n-1, r, m) % m;
        return ((x1 + x2) % m);
    }

    /**
     * AS1 > NcR % M => Optimized + Non-recursive
     * @param n
     * @param r
     * @param m
     * @return
     */
    private int nCr_optimized_nonRecursion(int n, int r, int m) {
        int[][] ncrValues = new int[n + 1][r + 1];
        //Nc0 = 1 (Store directly)
        for (int i = 0; i <=n; i++) {
            ncrValues[i][0] = 1;
        }

        //NcR = (N-1)c(R-1) + (N-1)c(R)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= r; j++) {
                if (i == j || j == 0) { //NcN = 1 ; Nc0 = 1
                    ncrValues[i][j] = 1;
                } else if (j == 1) { //Nc1 = N
                    ncrValues[i][1] = i % m;
                }
                ncrValues[i][j] = ((ncrValues[i-1][j-1] % m) + (ncrValues[i-1][j] % m)) % m;
            }
        }

        return ncrValues[n][r] % m;
    }

}
