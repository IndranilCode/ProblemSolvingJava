package main.tutorial.IntermediateDSA.Recursions;

/**
* AS => DONE; HW => 2 left
 */
public class Day24_Recursion2 {
    public void execute() {
        System.out.println("-----------Intermediate : Day 24: Recursion 2--------------");
        System.out.println("------------------------ASSIGNMENT-------------------------");

        //AS1 > Power Function
        //        int inputAS1a = 2;
        //        int inputAS1b = 3;
        //        int inputAS1d = 3;
        int inputAS1a = 71045970;
        int inputAS1b = 41535484;
        int inputAS1d = 64735492;
        int outputAS1 = powerFunction(inputAS1a, inputAS1b, inputAS1d);
        if (outputAS1 < 0) {
            outputAS1 = outputAS1 + inputAS1d;
        }
        System.out.println(String.format("AS1 > Power Function (%d ^ %d) : %d", inputAS1a, inputAS1b,  outputAS1));

        //AS2 > Sum of digits
        System.out.println("AS2 > Sum of digits (4610) : " + this.sumOfDigits(4610));

        //AS3 - Is it magic number
        int inputAS3 = 83557;
        int outputAS3 = isMagicNumber(inputAS3);
        System.out.println("AS3 - Is magic number : " + (outputAS3 == 1 ? 1 : 0));
    }

    /**
     * AS1 > Implement Power Function [PRACTICE]
     * @param A
     * @param N
     * @param D
     * @return
     */
    private int powerFunction(int A, int N, int D) {
        if (A == 0) {
            return 0;
        }
        if (N == 0) {
            return 1;
        }
        // int halfPower = powerFunction(A, N/2, D) % D; [WRONG]
        long halfPower = powerFunction(A, N/2, D) % D;
        long doublePower = ((long)((halfPower % D) * (halfPower % D))) % D;
        if (N % 2 == 0) {
            return (int)doublePower;
        } else {
            return (int)((doublePower * A) % D);
        }
    }

    /**
     * AS2 > (*) Sum of Digits [EASY]
     * Example => Sum of digits of 46 = 4 + 6 = 10
     * @param A
     * @return
     */
    private int sumOfDigits(int A) {
        if (A < 10) {
            return A;
        }
        return (A % 10) + sumOfDigits(A/10);
    }

    /**
     * AS3 > Is magic number
     * @param A
     * @return
     */
    private int isMagicNumber(int A) {
        if (A < 10) {
            return A;
        } else {
            return isMagicNumber((A % 10) + isMagicNumber(A/10));
        }
    }
}
