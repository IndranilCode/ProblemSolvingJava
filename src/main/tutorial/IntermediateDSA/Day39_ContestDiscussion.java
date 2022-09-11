package main.tutorial.IntermediateDSA;

import java.util.ArrayList;
import java.util.Arrays;

public class Day39_ContestDiscussion {
    public void execute() {
        System.out.println("--------------Day (39) Contest Discussion--------------");
        System.out.println("-----------------------ASSIGNMENT----------------------");

        //AS3 > Fantastic Four
        ArrayList<Integer> inputAS3 = new ArrayList<>(Arrays.asList(1, 3, 4, 4, 2, 2));
        System.out.println("AS3 > Fantastic Four [1, 3, 4, 4, 2, 2] => " + this.isArrayFantastic(inputAS3));

        //AS5 > Travelling Businessman
        ArrayList<Integer> resultAS5 = this.travellingBusinessman(4);
        System.out.print("AS5 > Travelling Businessman (4) => [");
        resultAS5.forEach(e -> System.out.print(e + ","));
        System.out.println("]");
    }

    /**
     * AS3 > Fantastic Four
     * An array is fantastic if all of its elements are divisible by 4.
     * Given an array A of N integers, return the minimum number of operations to make the array fantastic.
     * In one operation, you can remove any two array elements from the array, sum them up and append this sum to the end of the array A.
     * Return -1 if it is not possible to make the array "fantastic".
     * @param A
     * @return
     */
    private int isArrayFantastic(ArrayList<Integer> A) {
        // [1, 3, 4, 4, 2, 2, 1, 7, 6, 3, 5, 5]
        // g0 = [4, 4]
        // g1 = [1, 1, 5, 5,]
        // g2 = [2, 2, 6]
        // g3 = [7, 3, 3]

        //Step 1 => Try div each number by 4
        //If rem 1 -> go ; rem 2 -> g2 ; rem 3 -> g3 ; div by 4 is ignored - now deal with the rest
        int g1 = 0, g2 = 0, g3 = 0;
        for (int i = 0; i <A.size(); i++) {
            int currentElementModRem = A.get(i) % 4;
            if (currentElementModRem == 1){
                g1++;
            } else if (currentElementModRem == 2) {
                g2++;
            } else if (currentElementModRem == 3) {
                g3++;
            }
        }

        int stepCount = 0;

        //Step 2 => equal parts of g1 & g3 can be combined to get 0 rem
        int min_g1_g3 = g1 > g3 ? g3 : g1;
        stepCount = stepCount + min_g1_g3; //each pair is 1 operation
        //Leftover from any bucket [either g1 = 0 OR g3 = 0] - 2 (1 pair) can be combined to get a g2
        int left_g1_g3 = (g1 - min_g1_g3) == 0 ? (g3 - min_g1_g3) : (g1 - min_g1_g3);
        stepCount = stepCount + (left_g1_g3 / 2);
        //If leftover is not div by 2 - cant be added to
        if (left_g1_g3 % 2 != 0) {
            return -1;
        }

        //Step 3 => Either of this is 0 (1 pair of g1 or g3 is a g2)
        g2 = g2 + (left_g1_g3 / 2);
        //pair of g2 is div by 4
        stepCount = stepCount + (g2 / 2);
        int left_g2 = g2 % 2;
        //if any g2 is left - not fantastic
        if (left_g2 > 0) {
            return -1;
        }

        return stepCount;
    }

    /**
     * AS5 > Travelling Businessman
     * The Car rental company showed him A cars parked in a row
     * Considering all ways to rent the cars; for each car, find the number of ways to rent it.
     * Eg = 4
     * You can assume any car array. for example A = [Car 1, Car 2, Car 3, Car 4]
     * subarray that contains 'Car 1' are [1], [1, 2], [1, 2, 3], [1, 2, 3, 4]
     * subarray that contains 'Car 2' are [1, 2], [1, 2, 3], [1, 2, 3, 4], [2, 3], [2, 3, 4], [2]
     * @param A
     * @return
     */
    private ArrayList<Integer> travellingBusinessman(int A) {
        ArrayList<Integer> count_total_subArray_incl = new ArrayList<>();

        // [1, 2, 3, 4, 5]
        // 1 in subArray => [1]   *   [] / [2] / [2, 3] / [2, 3, 4] / [2, 3, 4, 5] => 1 * 5 = 5
        // 2 in subArray => [1, 2] / [2]    *    [] / [3] / [3, 4] / [3, 4, 5] => 2 * 4

        for (int i = 0; i < A; i++) {
            int combinations = (i + 1) * (A - i);
            count_total_subArray_incl.add(combinations);
        }
        return count_total_subArray_incl;
    }
}
