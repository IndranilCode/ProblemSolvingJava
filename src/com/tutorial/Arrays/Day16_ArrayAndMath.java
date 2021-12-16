package com.tutorial.Arrays;

public class Day16_ArrayAndMath {
    public void execute() {

        //AS2 > (*) A, B and Modulo [CONCEPT]
        int inputAS2a = 5;
        int inputAS2b = 9;
        int outputAS2 = AModuloBModulo(inputAS2a, inputAS2b);
        System.out.println("AS2 - A, B and Modulo : " + outputAS2);

        //AS3 > (*) Divisibility by 8
        String inputAS3 = "85536";
        int outputAS3 = divisibilityBy8(inputAS3);
        System.out.println("AS3 - Divisibility by 8 : " + outputAS3);
    }

    /**
     * AS2 > A, B and Modulo [CONCEPT]
     * Given two integers A and B, find the greatest possible positive M, such that A % M = B % M.
     * @param A
     * @param B
     * @return
     */
    private int AModuloBModulo(int A, int B) {
        //Solution 1 => Time Limit Exceeded (A : 5825148, B : 9554107)
        //        int result = 1;
        //        int highest = A > B ? A : B;
        //        for (int i = highest; i > 1; i--) {
        //            int a = A % i;
        //            int b = B % i;
        //            if (a == b) {
        //                result = i;
        //                break;
        //            }
        //        }
        //        return result;

        //Solution 2 => TC = O(1) , SC = O(1)
        // A % M = B % M
        // Possibilities 1) A > B , 2) B > A , 3) A = B
        // 1> A = B - (B-A)    [Since B = B ]
        //    A % (B-A) = [B - (B-A)] % (B-A)
        //    A % (B-A) = [B % (B-A)] - [(B-A)%(B-A)]
        //    A % (B-A) = B % (B-A) - 0
        //  So =>  M = (B-A)
        //  Similarly with A = A , We get M = (A-B)
        // Therefore - Abs (A - B) is the answer OR A / B when A = B
        int result = 1 ;
        if (A == B) {
            result = A;
        } else {
            result = Math.abs(A -B);
        }
        return result;
    }

    /**
     * AS3 > Divisibility by 8 [CHECK]
     * NOTE: Last 3 numbers must be div by 8 - then 8 divisible
     * Output => 1 - divisible by 8 , 0 - not divisible by 8
     * @param A
     * @return
     */
    private int divisibilityBy8(String A) {
        String last3Digits = "";
        Integer last3DigitsInt = 0;
        if (A.length() > 3) {
            last3Digits =  A.substring(A.length()- 3, A.length());
        } else {
            last3Digits = A;
        }
        last3DigitsInt = Integer.parseInt(last3Digits);
        return last3DigitsInt % 8 == 0 ? 1 : 0;
    }
}
