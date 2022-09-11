package main.tutorial.AdvancedDSA.M12_Queue;

import java.util.*;

public class Day63_75_Queues1 {
    public void execute() {
        System.out.println("----------Day 63 : Queues 1------------");
        System.out.println("---------------ASSIGNMENT--------------");

        /*---------------ASSIGNMENT--------------*/

        //AS1 > Perfect Numbers
        System.out.println("AS1 > Perfect Numbers (A = 4) => " + this.aThPerfectNumber(3));

        //AS2 > N integers containing only 1, 2 & 3
        ArrayList<Integer> resultAS2 = this.nthIntegerWith123(7);
        System.out.print("AS2 > N integers containing only 1, 2 & 3 (A=7) => ");
        resultAS2.forEach(e -> System.out.print(e + ", "));
        System.out.println("");

        //AS3 > Task Scheduling
        ArrayList<Integer> inputAS3_a = new ArrayList<>(Arrays.asList(2, 3, 1, 5, 4));
        ArrayList<Integer> inputAS3_b = new ArrayList<>(Arrays.asList(1, 3, 5, 4, 2));
        System.out.println("AS3 > Task Scheduling A=[2, 3, 1, 5, 4] B=[1, 3, 5, 4, 2] => " + this.taskScheduling(inputAS3_a, inputAS3_b));

        System.out.println("---------------HOMEWORK--------------");
        /*---------------HOMEWORK--------------*/

        //HW1 > Reversing Elements Of Queue
        ArrayList<Integer> inputHW1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> resultHW1 = this.reverseElementsOfQueue(inputHW1, 3);
        System.out.print("HW1 > Reversing Elements Of Queue [1,2,3,4,5] 3 => ");
        resultHW1.forEach(e -> System.out.print(e + ", "));
        System.out.println("");
    }

    /*---------------ASSIGNMENT--------------*/

    /**
     * AS1 > Perfect Numbers
     * Given an integer A, you have to find the Ath Perfect Number.
     * A Perfect Number has the following properties:
     * It comprises only 1 and 2.
     * The number of digits in a Perfect number is even.
     * It is a palindrome number.
     * @param A
     * @return
     */
    private String aThPerfectNumber(int A) {
        if (A >= 1 && A <= 2) {
            return A + "" + A;
        }
        Queue<Integer> generationQ = new PriorityQueue<>();
        generationQ.add(1);
        generationQ.add(2);
        int count = 2;
        int currentNo, currentGenNo;
        String currentGenAns = "";
        while (count < A) {
            currentNo = generationQ.remove();
            for (int i = 1; i <= 2; i++) {
                currentGenAns = "";
                currentGenNo = (10 * currentNo) + i;
                generationQ.add(currentGenNo);
                count++;
                if (count == A) {
                    return currentGenAns = currentGenNo + "" + (new StringBuilder(currentGenNo + "")).reverse();
                }
            }
        }
        return currentGenAns;
    }

    /**
     * AS2 > N integers containing only 1, 2 & 3
     * Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
     * @param A
     * @return
     */
    private ArrayList<Integer> nthIntegerWith123(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        //Number till 3
        if (A >= 1 && A <= 3) {
            for (int i = 1; i <= A; i++) {
                result.add(i);
            }
            return result;
        } else {
            //Number > 3
            Queue<Integer> generationQ = new PriorityQueue<>();
            result.add(1); generationQ.add(1);
            result.add(2); generationQ.add(2);
            result.add(3); generationQ.add(3);

            int count = 3;
            while (count < A) {
                Integer extractedNo = generationQ.remove();
                for (int i = 1; i <= 3; i++) {
                    Integer currentNumber = (10 * extractedNo) + i;
                    result.add(currentNumber);
                    generationQ.add(currentNumber);
                    count++;
                    if (count == A) {
                        break;
                    }
                }
            }
        }

        return result;
    }

    /**
     * AS3 > Task Scheduling
     *
     * @param A
     * @param B
     * @return
     */
    private int taskScheduling(ArrayList<Integer> A, ArrayList<Integer> B) {
        Queue<Integer> taskOrder = new LinkedList<>();
        for (int i = 0; i < A.size(); i++) {
            taskOrder.add(A.get(i));
        }
        int taskDurationCount = 0;
        int currentTaskToExecute;
        for (int j = 0; j < B.size(); j++) {
            currentTaskToExecute = B.get(j);

            while (currentTaskToExecute != taskOrder.peek()) {
                taskOrder.add(taskOrder.remove());
                taskDurationCount++;
            }
            if (taskOrder.peek() == currentTaskToExecute) {
                taskOrder.remove();
                taskDurationCount++;
            }
        }

        return taskDurationCount;
    }

    /*---------------HOMEWORK--------------*/

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
