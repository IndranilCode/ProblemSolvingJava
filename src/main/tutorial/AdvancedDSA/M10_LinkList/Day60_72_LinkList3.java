package main.tutorial.AdvancedDSA.M10_LinkList;

import java.util.ArrayList;
import java.util.Arrays;

public class Day60_72_LinkList3 {
    private class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    public void execute() {
        System.out.println("--------------Linked List 3--------------");
        System.out.println("----------------ASSIGNMENT---------------");

        //AS1 > Copy List (Deep copy)
        RandomListNode inputAS1_n4 = new RandomListNode(18);
        RandomListNode inputAS1_n3 = new RandomListNode(42); inputAS1_n3.next = inputAS1_n4;
        RandomListNode inputAS1_n2 = new RandomListNode(36); inputAS1_n2.next = inputAS1_n3;
        RandomListNode inputAS1_n1 = new RandomListNode(24); inputAS1_n1.next = inputAS1_n2;
        inputAS1_n1.random = inputAS1_n3;
        inputAS1_n2.random = inputAS1_n1;
        inputAS1_n4.random = inputAS1_n3;
        System.out.print("AS1 > Copy List (Deep copy) [Original : "); this.printRandomList(inputAS1_n1);
        System.out.print("] => ");
        RandomListNode resultAS1 = this.copyRandomList(inputAS1_n1);
        this.printRandomList(resultAS1); System.out.println();


        System.out.println("----------------HOMEWORK-----------------");

        //HW1 > Palindrome List
        NodeLList inputHW1_1_n4 = new NodeLList(1);
        NodeLList inputHW1_1_n3 = new NodeLList(2); inputHW1_1_n3.next = inputHW1_1_n4;
        NodeLList inputHW1_1_n2 = new NodeLList(2); inputHW1_1_n2.next = inputHW1_1_n3;
        NodeLList inputHW1_1_n1 = new NodeLList(1); inputHW1_1_n1.next = inputHW1_1_n2;
        System.out.print("HW1 > Palindrome List [ "); this.printList(inputHW1_1_n1); System.out.println("] => " + this.isPalindromeList(inputHW1_1_n1));
        NodeLList inputHW1_2_n3 = new NodeLList(2);
        NodeLList inputHW1_2_n2 = new NodeLList(2); inputHW1_2_n2.next = inputHW1_2_n3;
        NodeLList inputHW1_2_n1 = new NodeLList(1); inputHW1_2_n1.next = inputHW1_2_n2;
        System.out.print("    > Palindrome List [ "); this.printList(inputHW1_2_n1); System.out.println("] => " + this.isPalindromeList(inputHW1_2_n1));
        NodeLList inputHW1_3_n5 = new NodeLList(1);
        NodeLList inputHW1_3_n4 = new NodeLList(2); inputHW1_3_n4.next = inputHW1_3_n5;
        NodeLList inputHW1_3_n3 = new NodeLList(3); inputHW1_3_n3.next = inputHW1_3_n4;
        NodeLList inputHW1_3_n2 = new NodeLList(2); inputHW1_3_n2.next = inputHW1_3_n3;
        NodeLList inputHW1_3_n1 = new NodeLList(1); inputHW1_3_n1.next = inputHW1_3_n2;
        System.out.print("    > Palindrome List [ "); this.printList(inputHW1_3_n1); System.out.println("] => " + this.isPalindromeList(inputHW1_3_n1));

        //HW2 > Add Two Numbers as Lists
        NodeLList inputHW2_A_n3 = new NodeLList(9);
        NodeLList inputHW2_A_n2 = new NodeLList(4); inputHW2_A_n2.next = inputHW2_A_n3;
        NodeLList inputHW2_A_n1 = new NodeLList(2); inputHW2_A_n1.next = inputHW2_A_n2;
        NodeLList inputHW2_B_n3 = new NodeLList(4);
        NodeLList inputHW2_B_n2 = new NodeLList(6); inputHW2_B_n2.next = inputHW2_B_n3;
        NodeLList inputHW2_B_n1 = new NodeLList(5); inputHW2_B_n1.next = inputHW2_B_n2;
        NodeLList resultHW2 = this.addTwoNumbersAsList(inputHW2_A_n1, inputHW2_B_n1);
        System.out.print("HW2 > Add Two Numbers as Lists [A : "); this.printList(inputHW2_A_n1);
        System.out.print(" ] [B : "); this.printList(inputHW2_B_n1);
        System.out.print(" ] => "); this.printList(resultHW2);
        System.out.println();

        //HW3 > Flatten a linked list
        NodeLList2Dim inputHW3_1_n4 = new NodeLList2Dim(8);
        NodeLList2Dim inputHW3_1_n3 = new NodeLList2Dim(7); inputHW3_1_n3.down = inputHW3_1_n4;
        NodeLList2Dim inputHW3_1_n2 = new NodeLList2Dim(7); inputHW3_1_n2.down = inputHW3_1_n3;
        NodeLList2Dim inputHW3_1_n1 = new NodeLList2Dim(3); inputHW3_1_n1.down = inputHW3_1_n2;
        NodeLList2Dim inputHW3_2_n2 = new NodeLList2Dim(11);
        NodeLList2Dim inputHW3_2_n1 = new NodeLList2Dim(4); inputHW3_2_n1.down = inputHW3_2_n2;
        NodeLList2Dim inputHW3_3_n2 = new NodeLList2Dim(22);
        NodeLList2Dim inputHW3_3_n1 = new NodeLList2Dim(20); inputHW3_3_n1.down = inputHW3_3_n2;
        NodeLList2Dim inputHW3_4_n4 = new NodeLList2Dim(39);
        NodeLList2Dim inputHW3_4_n3 = new NodeLList2Dim(28); inputHW3_4_n3.down = inputHW3_4_n4;
        NodeLList2Dim inputHW3_4_n2 = new NodeLList2Dim(20); inputHW3_4_n2.down = inputHW3_4_n3;
        NodeLList2Dim inputHW3_4_n1 = new NodeLList2Dim(20); inputHW3_4_n1.down = inputHW3_4_n2;
        NodeLList2Dim inputHW3_5_n3 = new NodeLList2Dim(39);
        NodeLList2Dim inputHW3_5_n2 = new NodeLList2Dim(31); inputHW3_5_n2.down = inputHW3_5_n3;
        NodeLList2Dim inputHW3_5_n1 = new NodeLList2Dim(30); inputHW3_5_n1.down = inputHW3_5_n2;
        inputHW3_4_n1.right = inputHW3_5_n1;
        inputHW3_3_n1.right = inputHW3_4_n1;
        inputHW3_2_n1.right = inputHW3_3_n1;
        inputHW3_1_n1.right = inputHW3_2_n1;
        NodeLList2Dim resultHW3 = flattenMergeLinkList(inputHW3_1_n1);
        System.out.print("HW3 > Flatten a linked list => "); this.print2DilFlatList(resultHW3);
        System.out.println();

        //HW4 > Swap List Nodes in pairs
        NodeLList inputHW4_1_n5 = new NodeLList(5);
        NodeLList inputHW4_1_n4 = new NodeLList(4); inputHW4_1_n4.next = inputHW4_1_n5;
        NodeLList inputHW4_1_n3 = new NodeLList(3); inputHW4_1_n3.next = inputHW4_1_n4;
        NodeLList inputHW4_1_n2 = new NodeLList(2); inputHW4_1_n2.next = inputHW4_1_n3;
        NodeLList inputHW4_1_n1 = new NodeLList(1); inputHW4_1_n1.next = inputHW4_1_n2;
        NodeLList resultHW4_1 = this.swapPairs(inputHW4_1_n1);
        System.out.print("HW4 > Swap List Nodes in pairs ["); this.printList(inputHW4_1_n1);
        System.out.print("] => "); this.printList(resultHW4_1);
        System.out.println();

        //HW5 > Merge K Sorted Lists
        NodeLList inputHW5_l0_n3 = new NodeLList(20);
        NodeLList inputHW5_l0_n2 = new NodeLList(10); inputHW5_l0_n2.next = inputHW5_l0_n3;
        NodeLList inputHW5_l0_n1 = new NodeLList(1); inputHW5_l0_n1.next = inputHW5_l0_n2;
        NodeLList inputHW5_l1_n3 = new NodeLList(13);
        NodeLList inputHW5_l1_n2 = new NodeLList(11); inputHW5_l1_n2.next = inputHW5_l1_n3;
        NodeLList inputHW5_l1_n1 = new NodeLList(4); inputHW5_l1_n1.next = inputHW5_l1_n2;
        NodeLList inputHW5_l2_n3 = new NodeLList(9);
        NodeLList inputHW5_l2_n2 = new NodeLList(8); inputHW5_l2_n2.next = inputHW5_l2_n3;
        NodeLList inputHW5_l2_n1 = new NodeLList(3); inputHW5_l2_n1.next = inputHW5_l2_n2;
        ArrayList<NodeLList> inputHW5_nodeList = new ArrayList<>(Arrays.asList(inputHW5_l0_n1, inputHW5_l1_n1, inputHW5_l2_n1));
        NodeLList resultHW5 = this.mergeKSortedLists(inputHW5_nodeList);
        System.out.print("HW5 > Merge K Sorted Lists (not with heaps) => "); this.printList(resultHW5);

    }

    private void printList(NodeLList head) {
        NodeLList temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
    }

    /*---------------ASSIGNMENT--------------*/

    /**
     * AS1 > Copy List (Deep copy)
     * A linked list A is given such that each node contains an additional random pointer which could point to any node in the list or NULL.
     * Return a deep copy of the list.
     * @param head
     * @return
     */
    private RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode temp = head;

        //Create node copy's after each original node
        while (temp != null){
            RandomListNode newCopy = new RandomListNode(temp.label);
            newCopy.next = temp.next;
            temp.next = newCopy;
            temp = temp.next.next;
        }

        //Point the random pointers
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        //Remove the original nodes
        temp = head;
        RandomListNode newHead = temp.next;
        temp = newHead;
        while (temp != null) {
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return newHead;
    }
    private void printRandomList(RandomListNode head) {
        RandomListNode temp = head;
        while (temp != null) {
            System.out.print(temp.label + " -> ");
            temp = temp.next;
        }
    }

    private class LRUCache {
        private int capacity;

        private LRUCache(int capacity) {
            this.capacity = capacity;
        }


    }

    /*---------------HOMEWORK----------------*/

    /**
     * HW1 > Palindrome List
     * Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.
     * A = [1, 2, 2, 1] => O/P 1
     * A = [1, 3, 2] => O/P 0
     * @param head
     * @return
     */
    private int isPalindromeList(NodeLList head) {
        //Single node
        if (head.next == null) {
            return 1;
        }
        //Double node
        if (head.next.next == null) {
            if (head.value == head.next.value){
                return 1;
            } else {
                return 0;
            }
        }

        NodeLList slow = head;
        NodeLList fast = head.next;
        NodeLList head2 = null; //2nd list head

        //Split list into 2 halved (even - equal half, odd - equal half except middle)
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next == null) { //Even list
            head2 = slow.next;
            slow.next = null;
        } else { //Odd list
            head2 = slow.next.next;
            slow.next = null; //ignore the middle most element
        }

        //Reverse list2
        NodeLList h1 = head2;
        NodeLList h2 = head2.next;
        h1.next = null;
        while (h2 != null) {
            NodeLList temp = h2.next;
            h2.next = h1;
            h1 = h2;
            h2 = temp;
        }
        head2 = h1; //head of 2nd list = h1

        //Compare each node of list1 & reversed list2 [definitely same size]
        NodeLList temp1 = head;
        NodeLList temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.value != temp2.value) {
                return 0;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return 1;
    }

    /**
     * HW2 > Add Two Numbers as Lists
     * You are given two linked lists, A and B, representing two non-negative numbers.
     * The digits are stored in reverse order, and each of their nodes contains a single digit.
     * Add the two numbers and return it as a linked list.
     * A = [2, 4, 3]
     * B = [5, 6, 4]
     * o/p => [7, 0, 8]
     *
     * A = [9, 9]
     * B = [1]
     * o/p => [0, 0, 1]
     * @param head1
     * @param head2
     * @return
     */
    private NodeLList addTwoNumbersAsList(NodeLList head1, NodeLList head2) {
        NodeLList temp1 = head1;
        NodeLList temp2 = head2;
        int val1, val2, carry = 0, runningTotal = 0;
        NodeLList head3 = null, temp3 = null;
        if (temp1 != null || temp2 != null) {
            val1 = temp1 != null ? temp1.value : 0;
            val2 = temp2 != null ? temp2.value : 0;
            runningTotal = val1 + val2;
            temp3 = new NodeLList( runningTotal % 10);
            carry = runningTotal / 10;

            temp1 = temp1.next;
            temp2 = temp2.next;
            head3 = temp3;
        }

        while (temp1 != null || temp2 != null) {
            val1 = temp1 != null ? temp1.value : 0;
            val2 = temp2 != null ? temp2.value : 0;
            runningTotal = val1 + val2 + carry;
            temp3.next = new NodeLList(runningTotal % 10);
            carry = runningTotal / 10;

            if (temp1 != null) {
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                temp2 = temp2.next;
            }
            temp3 = temp3.next;
        }
        if (carry > 0) {
            temp3.next = new NodeLList(carry);
        }

        return head3;
    }

    /**
     * HW3 > Flatten a linked list
     * @param root
     * @return
     */
    private NodeLList2Dim flattenMergeLinkList(NodeLList2Dim root) {
        //Base condition
        if (root == null || root.right == null) {
            return root;
        }

        //Split the list to 2 halves (vertically)
        NodeLList2Dim root2 = this.split2DimList(root);

        root = this.flattenMergeLinkList(root);
        root2 = this.flattenMergeLinkList(root2);
        return this.merge2Lists(root, root2);
    }
    private NodeLList2Dim split2DimList(NodeLList2Dim root) {
        NodeLList2Dim slow = root;
        NodeLList2Dim fast = root;
        while (fast.right != null && fast.right.right != null) {
            slow = slow.right;
            fast = fast.right.right;
        }
        NodeLList2Dim root2 = slow.right;
        slow.right = null;
        return root2;
    }
    private NodeLList2Dim merge2Lists(NodeLList2Dim root, NodeLList2Dim root2) {
        NodeLList2Dim temp1 = root;
        NodeLList2Dim temp2 = root2;
        NodeLList2Dim resultHead = null, resultTemp = null;
        if (temp1.value < temp2.value) {
            resultHead = temp1;
            temp1 = temp1.down;
        } else {
            resultHead = temp2;
            temp2 = temp2.down;
        }
        resultTemp = resultHead;

        while (temp1 != null && temp2 != null) {
            if (temp1.value < temp2.value) {
                resultTemp.down = temp1;
                temp1 = temp1.down;
            } else {
                resultTemp.down = temp2;
                temp2 = temp2.down;
            }
            resultTemp = resultTemp.down;
        }
        if (temp1 == null) {
            resultTemp.down = temp2;
        } else {
            resultTemp.down = temp1;
        }
        return resultHead;
    }
    private void print2DilFlatList(NodeLList2Dim root) {
        NodeLList2Dim temp = root;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.down;
        }
    }

    /**
     * HW4 > Swap List Nodes in pairs
     * @param head
     * @return
     */
    private NodeLList swapPairs(NodeLList head) {
        if (head == null || head.next == null) {
            return head;
        }
        NodeLList t1 = head;
        NodeLList t2 = t1.next;
        NodeLList t3 = t2.next;

        t2.next = t1;
        t1.next = this.swapPairs(t3);
        return t2;
    }

    /**
     * HW5 > Clone a Linked List (Same as AS1)
     */

    /**
     * HW6 > Merge K Sorted Lists (Not with heaps)
     * @param a
     * @return
     */
    private NodeLList mergeKSortedLists(ArrayList<NodeLList> a) {
        NodeLList initialList = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            initialList = this.mergeSortedLists(initialList, a.get(i));
        }
        return initialList;
    }
    private NodeLList mergeSortedLists(NodeLList head1, NodeLList head2) {
        NodeLList head = null, temp = null;
        NodeLList temp1 = head1;
        NodeLList temp2 = head2;
        if (head1.value < head2.value) {
            head = head1;
            temp1 = temp1.next;
        } else {
            head = head2;
            temp2 = temp2.next;
        }
        temp = head;

        while (temp1 != null && temp2 != null) {
            if (temp1.value < temp2.value) {
                temp.next = temp1;
                temp1 = temp1.next;
                temp = temp.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
                temp = temp.next;
            }
        }

        if (temp1 == null) {
            temp.next = temp2;
        } else {
            temp.next = temp1;
        }
        return head;
    }
}
