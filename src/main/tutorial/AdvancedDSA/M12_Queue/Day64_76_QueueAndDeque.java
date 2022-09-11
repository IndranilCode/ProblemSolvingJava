package main.tutorial.AdvancedDSA.M12_Queue;

import java.util.*;

public class Day64_76_QueueAndDeque {
    //AS3 > Min Stack
    int minValue = Integer.MAX_VALUE;
    Stack<Integer> mimicStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void execute() {
        System.out.println("--------------Day 64(76) Queue & Deque--------------");

        //CW1 > Sliding Window Maximum
        ArrayList<Integer> inputCW1 = new ArrayList<>(Arrays.asList(3, 2, 3 ,4 ,5, 3, 4 ,5 ,2, 6));
        ArrayList<Integer> resultCW1 = this.slidingWindowMaximum(inputCW1, 4);
        System.out.print("CW1 > Sliding Window Maximum [3, 2, 3 ,4 ,5, 3, 4 ,5 ,2, 6] ; Window = 4=> [");
        resultCW1.forEach(e -> System.out.print(e + ", "));
        System.out.println("]");

        System.out.println("-----------------------ASSIGNMENT-------------------");

        //AS1 > First non-repeating character
//        System.out.println("AS1 > First non-repeating character (abadbc) => " + this.firstNonRepeatingCharacterString("abadbc"));
//        System.out.println("    > First non-repeating character (abcabc) => " + this.firstNonRepeatingCharacterString("abcabc"));
        System.out.println("AS1 > First non-repeating character (jyhrcwuengcbnuchctluxjgtxqtfvrebveewgasluuwooupcyxwgl) => " + this.firstNonRepeatingCharacterString("jyhrcwuengcbnuchctluxjgtxqtfvrebveewgasluuwooupcyxwgl"));



        //AS2 > Sliding Window Maximum
        System.out.println("AS2 > Sliding Window Maximum => (Refer CW1)");

        System.out.println("-----------------------HOMEWORK---------------------");

        //HW1 > Sum of min and max
        ArrayList<Integer> inputHW1 = new ArrayList<>(Arrays.asList(2, 5, -1, 7, -3, -1, -2));
        System.out.println("HW1 > Sum of min and max [2, 5, -1, 7, -3, -1, -2] Window : 4 => " + this.sum_MinAndMax_slidingWindow(inputHW1, 4));

    }

    //-----------------CLASSWORK---------------------

    /**
     * CW1 > Sliding Window Maximum
     * Eg: [3, 2, 3 ,4 ,5, 3, 4 ,5 ,2, 6] window = 4
     * [4, 5, 5, 5, 5, 5 ,6]
     * @param list
     * @param windowSize
     * @return
     */
    private ArrayList<Integer> slidingWindowMaximum(ArrayList<Integer> list, int windowSize) {
        Deque<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> slidWindowMax = new ArrayList<>();

        //1st Sliding window
        //PROCESS => while parsing each element if currentElement is > existing elements in q from end - remove lesser elements from end
        // Eg list = [3, 2, 3, 4] (window size  = 4)
        // currElem = 3 ; [3] ->
        // currElem = 2 ; [3, 2] (insert 2 @end as 2 < 3(peek) , 2 can be max for some window later) ->
        // currElem = 3 ; [3, 3] (remove 2 @end as 3 < 2(peek) , 2 can no longer be max for later window) ->
        // currElem = 4 ; [4] (remove 3, 3@end as 4 > 3(peek) , 3 or 3 cannot be max for later window)
        // max = q[front]
        for (int i = 0; i < windowSize; i++) {
            int currentElement = list.get(i);
            while (!q.isEmpty() && currentElement > q.peekLast()) {
                q.removeLast();
            }
            q.addLast(currentElement);
        }
        slidWindowMax.add(q.peek());

        //Process further Sliding windows
        //1st SW = [0 - (k-1)]
        //2nd SW = [1 - (k)]
        int left = 1, right = windowSize;
        while (right < list.size()) {
            int elementGoingOut = list.get(left - 1);
            int elementComingIn = list.get(right);

            //If elementGoingOut = q's front element => remove it (else that might count as max for this window as well)
            if (elementGoingOut == q.peek()) {
                q.removeFirst();
            }
            //If elementComingIn > elements @q from end => remove lesser elements from end
            while (!q.isEmpty() && elementComingIn > q.peekLast()) {
                q.removeLast();
            }
            q.addLast(elementComingIn);

            //Max of this window = front of q
            slidWindowMax.add(q.peek());

            //Increment windows
            left++;
            right++;
        }
        return slidWindowMax;
    }

    //-----------------ASSIGNMENTS-------------------

    /**
     * AS1 > First non-repeating character
     * Given a string A denoting a stream of lowercase alphabets, you have to make a new string B.
     * B is formed such that we have to find the first non-repeating character each time a character is inserted to the stream and append it at the end to B.
     * If no non-repeating character is found, append '#' at the end of B.
     * Eg:
     * A = "abadbc" ; o/p => "aabbdd"
     * A = "abcabc" ; o/p => "aaabc#"
     * @param A
     * @return
     */
    private String firstNonRepeatingCharacterString(String A) {
        HashMap<Character, Integer> charFreq = new HashMap();
        Queue<Character> q = new LinkedList<>();
        StringBuilder finalConvertedString = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            Character currentChar = A.charAt(i);

            //Maintain freq of chars
            int existingFreq = charFreq.containsKey(currentChar) ? charFreq.get(currentChar) : 0;
            charFreq.put(currentChar, ++existingFreq);

            //Push to q
            q.add(currentChar);

            //Form front of q peek and check
            //NOTE: q contains only unique chars
            while (!q.isEmpty() && charFreq.get(q.peek()) > 1) {
                q.remove();
            }

            Character currentNonRepeatChar = !q.isEmpty() ? q.peek() : '#';
            finalConvertedString.append(currentNonRepeatChar);
        }
        return finalConvertedString.toString();
    }

    /**
     * AS2 > Sliding Window Maximum (Same as CW1)
     */

    /**
     * AS3 > Min Stack
     * Design a stack that supports push, pop, top, and retrieve the minimum element in constant time.
     * push(x) -- Push element x onto stack.
     * pop() -- Removes the element on top of the stack.
     * top() -- Get the top element.
     * getMin() -- Retrieve the minimum element in the stack.
     * NOTE:
     * All the operations have to be constant time operations.
     * getMin() should return -1 if the stack is empty.
     * pop() should return nothing if the stack is empty.
     * top() should return -1 if the stack is empty.
     */
    private void push(int x) {
        if (x < minValue) {
            minValue = x;
        }
        this.mimicStack.push(x);
        this.minStack.push(minValue);
    }
    public void pop() {
        if (this.mimicStack.size() > 0) {
            this.mimicStack.pop();
            this.minStack.pop();
        }
        if (minStack.size() == 0) {
            this.minValue = Integer.MAX_VALUE;
        } else {
            this.minValue = minStack.peek();
        }
    }
    public int top() {
        int top;
        if (this.mimicStack.size() > 0) {
            top = this.mimicStack.peek();
        } else {
            top = -1;
        }
        return top;
    }
    public int getMin() {
        if (this.minStack.size() > 0) {
            return this.minStack.peek();
        } else {
            return -1;
        }
    }

    //-----------------HOMEWORK----------------------

    /**
     * HW1 > Sum of min and max
     * Given an array A of both positive and negative integers.
     * Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
     * NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.
     * Example : A = [2, 5, -1, 7, -3, -1, -2]
     * Subarrays of size 4 are :
     *     [2, 5, -1, 7],   min + max = -1 + 7 = 6
     *     [5, -1, 7, -3],  min + max = -3 + 7 = 4
     *     [-1, 7, -3, -1], min + max = -3 + 7 = 4
     *     [7, -3, -1, -2], min + max = -3 + 7 = 4
     *     Sum of all min & max = 6 + 4 + 4 + 4 = 18
     * @param list
     * @param windowSize
     * @return
     */
    private int sum_MinAndMax_slidingWindow(ArrayList<Integer> list, int windowSize) {
        Deque<Integer> maxQ = new ArrayDeque<>();
        Deque<Integer> minQ = new ArrayDeque<>();

        Integer minMaxSum = 0;
        int mod = 1000000007;

        //1st Sliding window
        //PROCESS =>
        //Max: while parsing each element if currentElement is > existing elements in q from end - remove lesser elements from end
        //Min: while parsing each element if currentElement is < existing elements in q from end - remove greater elements from end
        for (int i = 0; i < windowSize; i++) {
            int currentElement = list.get(i);

            //MaxQ
            while (!maxQ.isEmpty() && currentElement > maxQ.peekLast()) {
                maxQ.removeLast();
            }
            maxQ.addLast(currentElement);

            //MinQ
            while (!minQ.isEmpty() && currentElement < minQ.peekLast()) {
                minQ.removeLast();
            }
            minQ.addLast(currentElement);
        }
        minMaxSum = (maxQ.peekFirst() + minQ.peekFirst()) % mod;

        //Process further Sliding windows
        // 1st SW = [0 - (k-1)]
        // 2nd SW = [1 - (k)]
        int i = 1, j = windowSize;
        while (j < list.size()) {
            int elementGoingOut = list.get(i - 1);
            int elementComingIn = list.get(j);

            //If elementGoingOut = q's front element => remove it (else that might count as max/min for this window as well)
            if (elementGoingOut == maxQ.peekFirst()) {
                maxQ.removeFirst();
            }
            if (elementGoingOut == minQ.peekFirst()) {
                minQ.removeFirst();
            }

            //Handle max window
            while (!maxQ.isEmpty() && elementComingIn > maxQ.peekLast()) {
                maxQ.removeLast();
            }
            maxQ.addLast(elementComingIn);

            //Handle min window
            while (!minQ.isEmpty() && elementComingIn < minQ.peekLast()) {
                minQ.removeLast();
            }
            minQ.addLast(elementComingIn);

            //Get min & max sum for this SW
            minMaxSum = (minMaxSum + (maxQ.peekFirst() + minQ.peekFirst()) % mod) % mod;
            i++;
            j++;
        }
        return minMaxSum;
    }
}
