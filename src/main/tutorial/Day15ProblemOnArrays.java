package main.tutorial;

import java.util.ArrayList;

public class Day15ProblemOnArrays {
    public void execute() {

        //AS4 > Row with maximum number of ones

    }

    /**
     * AS4 > Row with maximum number of ones
     * @param A
     * @return
     */
    private int rowWithMax1(ArrayList<ArrayList<Integer>> A) {
        int row = -1;
        int maxCount = 0;
        for (int i = 0; i < A.size(); i++) {
            int thisRow1Count = 0;
            for (int j = 0; j < A.get(0).size(); j++) {
                if (A.get(i).get(j) == 1) {
                    thisRow1Count ++;
                }
                if (thisRow1Count > maxCount) {
                    maxCount = thisRow1Count;
                    row = i;
                }
            }
        }
        return row;
    }
}
