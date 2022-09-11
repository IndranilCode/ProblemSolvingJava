package main.tutorial.IntermediateDSA.M3_Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Day33_Arrays1 {
    public void execute() {
//        System.out.println("HW1 > Add One To Number (1, 2, 3) => " + this.plusOne(new ArrayList<>(Arrays.asList(1, 2, 3))));
//        System.out.println("    > Add One To Number (0, 0, 9, 8, 7, 0) => " + this.plusOne(new ArrayList<>(Arrays.asList(0, 0, 9, 8, 7, 0))));
//        System.out.println("    > Add One To Number (1, 0, 0, 0, 0, 0) => " + this.plusOne(new ArrayList<>(Arrays.asList(1, 0, 0, 0, 0, 0))));
//        System.out.println("    > Add One To Number (0) => " + this.plusOne(new ArrayList<>(Arrays.asList(0))));
        System.out.println("    > Add One To Number (6, 4, 7, 7, 8, 9) => " + this.plusOne(new ArrayList<>(Arrays.asList(6, 4, 7, 7, 8, 9))));
    }

    private ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        ArrayList<Integer> trimA = new ArrayList<>();
        int currentDigit;
        Boolean isLeadingZero = true;
        for (int i = 0; i < A.size(); i++) {
            currentDigit = A.get(i);
            if (currentDigit != 0) {
                isLeadingZero = false;
            }
            if (currentDigit == 0 && isLeadingZero) {
                continue;
            }
            trimA.add(currentDigit);
        }
        if (trimA.size() == 0) {
            trimA.add(0);
        }

        ArrayList<Integer> reverseResult = new ArrayList<>();
        int carryValue = 0;
        int length = trimA.size();
        for (int i = length - 1; i >= 0; i--) {
            currentDigit = trimA.get(i);
            if (i == length - 1) { //Last digit - add 1
                currentDigit = currentDigit + 1;
            }
            currentDigit = currentDigit + carryValue;
            if (i != 0) {
                if (currentDigit > 9) {
                    //Add LSB Digit and carry MSB
                    reverseResult.add(currentDigit % 10);
                    carryValue = currentDigit / 10;
                } else {
                    reverseResult.add(currentDigit);
                    carryValue = 0;
                }
            } else {
                if (currentDigit > 9) {
                    //Add LSB first then MSB
                    reverseResult.add(currentDigit % 10);
                    reverseResult.add(currentDigit / 10);
                } else {
                    reverseResult.add(currentDigit);
                    carryValue = 0;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = reverseResult.size() - 1; i >= 0; i--) {
            result.add(reverseResult.get(i));
        }
        return result;
    }
}
