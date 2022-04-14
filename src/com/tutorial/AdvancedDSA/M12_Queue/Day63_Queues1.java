package com.tutorial.AdvancedDSA.M12_Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Day63_Queues1 {
    public void execute() {

        //HW1 > Reversing Elements Of Queue
        ArrayList<Integer> inputHW1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> resultHW1 = this.reverseElementsOfQueue(inputHW1, 3);
        System.out.print("HW1 > Reversing Elements Of Queue [1,2,3,4,5] 3 => ");
        resultHW1.forEach(e -> System.out.print(e + ", "));
        System.out.println("");
    }

    /**
     * HW1 > Reversing Elements Of Queue
     * Given array of integers A and integer B, reverse the order of the first B elements of the array,
     * leaving the other elements in the same relative order.
     * @param A
     * @param B
     * @return
     */
    private ArrayList<Integer> reverseElementsOfQueue(ArrayList<Integer> A, int B) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < B; i++) {
            stack.push(A.get(i));
        }
        ArrayList<Integer> result = new ArrayList<>();
        while(!stack.empty()) {
            result.add(stack.pop());
        }
        for (int i = B; i < A.size(); i++) {
            result.add(A.get(i));
        }
        return result;
    }
}
