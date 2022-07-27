package com.tutorial.AdvancedDSA.M10_LinkList;

public class Day59_71_LinkList2 {
    public void execute() {
        System.out.println("--------------Linked List 2--------------");
        System.out.println("----------------ASSIGNMENT---------------");

        //AS1 > List Cycle
        NodeLList inputAS1_n3 = new NodeLList(3);
        NodeLList inputAS1_n4 = new NodeLList(4); inputAS1_n4.next = inputAS1_n3;
        inputAS1_n3.next = inputAS1_n4;
        NodeLList inputAS1_n2 = new NodeLList(2); inputAS1_n2.next = inputAS1_n3;
        NodeLList inputAS1_n1 = new NodeLList(1); inputAS1_n1.next = inputAS1_n2;
        NodeLList resultAS1 = this.detectCycle(inputAS1_n1);
        System.out.println("AS1 > List Cycle [ 1 -> 2 -> 3 -> 4 (loop to 3)] => " + (resultAS1 == null ? "NULL" : resultAS1.value));

        NodeLList inputAS1_2_n4 = new NodeLList(4);
        NodeLList inputAS1_2_n10 = new NodeLList(10); inputAS1_2_n10.next = inputAS1_2_n4;
        NodeLList inputAS1_2_n9 = new NodeLList(9); inputAS1_2_n9.next = inputAS1_2_n10;
        NodeLList inputAS1_2_n8 = new NodeLList(8); inputAS1_2_n8.next = inputAS1_2_n9;
        NodeLList inputAS1_2_n7 = new NodeLList(7); inputAS1_2_n7.next = inputAS1_2_n8;
        NodeLList inputAS1_2_n6 = new NodeLList(6); inputAS1_2_n6.next = inputAS1_2_n7;
        NodeLList inputAS1_2_n5 = new NodeLList(5); inputAS1_2_n5.next = inputAS1_2_n6;
        inputAS1_2_n4.next = inputAS1_2_n5;
        NodeLList inputAS1_2_n3 = new NodeLList(3); inputAS1_2_n3.next = inputAS1_2_n4;
        NodeLList inputAS1_2_n2 = new NodeLList(2); inputAS1_2_n2.next = inputAS1_2_n3;
        NodeLList inputAS1_2_n1 = new NodeLList(1); inputAS1_2_n1.next = inputAS1_2_n2;
        NodeLList resultAS1_2 = this.detectCycle(inputAS1_2_n1);
        System.out.println("    > List Cycle [ 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 (loop to 4)] => "+ (resultAS1_2 == null ? "NULL" : resultAS1_2.value));

        NodeLList inputAS1_3_n5 = new NodeLList(5);
        NodeLList inputAS1_3_n4 = new NodeLList(4); inputAS1_3_n4.next = inputAS1_3_n5;
        NodeLList inputAS1_3_n3 = new NodeLList(3); inputAS1_3_n3.next = inputAS1_3_n4;
        NodeLList inputAS1_3_n2 = new NodeLList(2); inputAS1_3_n2.next = inputAS1_3_n3;
        NodeLList inputAS1_3_n1 = new NodeLList(1); inputAS1_3_n1.next = inputAS1_3_n2;
        NodeLList resultAS1_3 = this.detectCycle(inputAS1_3_n1);
        System.out.println("    > List Cycle [ 1 -> 2 -> 3 -> 4 -> 5 -> null] => "+ (resultAS1_3 == null ? "NULL" : resultAS1_3.value));

        //AS2 > Remove Loop from Linked List [Floyd's cycle detection algo]
        NodeLList inputAS2_n3 = new NodeLList(4);
        NodeLList inputAS2_n5 = new NodeLList(6); inputAS2_n5.next = inputAS2_n3;
        NodeLList inputAS2_n4 = new NodeLList(5); inputAS2_n4.next = inputAS2_n5;
        inputAS2_n3.next = inputAS2_n4;
        NodeLList inputAS2_n2 = new NodeLList(2); inputAS2_n2.next = inputAS2_n3;
        NodeLList inputAS2_n1 = new NodeLList(3); inputAS2_n1.next = inputAS2_n2;
        NodeLList resultAS2 = this.removeLoopFromLinkedList(inputAS2_n1);
        System.out.print("AS2 > Remove Loop from Linked List [Floyd's cycle detection algo] [3 -> 2 -> 4 -> 5 -> 6 -> .....4 (loop) ] => ");
        this.printList(resultAS2);

        //AS3 > Reorder List
        NodeLList inputAS3_a1_n7 = new NodeLList(7);
        NodeLList inputAS3_a1_n6 = new NodeLList(6); inputAS3_a1_n6.next = inputAS3_a1_n7;
        NodeLList inputAS3_a1_n5 = new NodeLList(5); inputAS3_a1_n5.next = inputAS3_a1_n6;
        NodeLList inputAS3_a1_n4 = new NodeLList(4); inputAS3_a1_n4.next = inputAS3_a1_n5;
        NodeLList inputAS3_a1_n3 = new NodeLList(3); inputAS3_a1_n3.next = inputAS3_a1_n4;
        NodeLList inputAS3_a1_n2 = new NodeLList(2); inputAS3_a1_n2.next = inputAS3_a1_n3;
        NodeLList inputAS3_a1_n1 = new NodeLList(1); inputAS3_a1_n1.next = inputAS3_a1_n2;
        NodeLList resultAS3_1 = this.reorderList(inputAS3_a1_n1);
        System.out.print("AS3 > Reorder List [1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7] => ");
        this.printList(resultAS3_1);

        System.out.println("-----------------HOMEWORK----------------");

        NodeLList inputHW1_1_n7 = new NodeLList(4);
        NodeLList inputHW1_1_n6 = new NodeLList(5); inputHW1_1_n6.next = inputHW1_1_n7;
        NodeLList inputHW1_1_n5 = new NodeLList(2); inputHW1_1_n5.next = inputHW1_1_n6;
        NodeLList inputHW1_1_n4 = new NodeLList(6); inputHW1_1_n4.next = inputHW1_1_n5;
        NodeLList inputHW1_1_n3 = new NodeLList(7); inputHW1_1_n3.next = inputHW1_1_n4;
        NodeLList inputHW1_1_n2 = new NodeLList(1); inputHW1_1_n2.next = inputHW1_1_n3;
        NodeLList inputHW1_1_n1 = new NodeLList(3); inputHW1_1_n1.next = inputHW1_1_n2;
        NodeLList resultHW1_newHead = this.sortList_mergeSort(inputHW1_1_n1);
        System.out.print("HW1 > Sort List [3 -> 1 -> 7 -> 6 -> 2 -> 5 -> 4] => ");
        this.printList(resultHW1_newHead);

        //HW2 > Merge Two Sorted Lists
        NodeLList inputHW2_a1_n7 = new NodeLList(27);
        NodeLList inputHW2_a1_n6 = new NodeLList(26); inputHW2_a1_n6.next = inputHW2_a1_n7;
        NodeLList inputHW2_a1_n5 = new NodeLList(23); inputHW2_a1_n5.next = inputHW2_a1_n6;
        NodeLList inputHW2_a1_n4 = new NodeLList(10); inputHW2_a1_n4.next = inputHW2_a1_n5;
        NodeLList inputHW2_a1_n3 = new NodeLList(8); inputHW2_a1_n3.next = inputHW2_a1_n4;
        NodeLList inputHW2_a1_n2 = new NodeLList(3); inputHW2_a1_n2.next = inputHW2_a1_n3;
        NodeLList inputHW2_a1_n1 = new NodeLList(2); inputHW2_a1_n1.next = inputHW2_a1_n2;
        NodeLList inputHW2_b1_n3 = new NodeLList(15);
        NodeLList inputHW2_b1_n2 = new NodeLList(6); inputHW2_b1_n2.next = inputHW2_b1_n3;
        NodeLList inputHW2_b1_n1 = new NodeLList(5); inputHW2_b1_n1.next = inputHW2_b1_n2;
        NodeLList resultHW2_1 = this.mergeSortedArrays(inputHW2_a1_n1, inputHW2_b1_n1);
        System.out.print("HW2 > Merge Two Sorted Lists [2,3,8,10,23] [5,6,15] => ");
        this.printList(resultHW2_1);
    }


    private void printList(NodeLList head) {
        NodeLList temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("");
    }

    /*---------------ASSIGNMENT--------------*/

    /**
     * AS1 > List Cycle (Floyd's cycle detection algorithm)
     * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     * Try solving it using constant additional space.
     * @param head
     * @return
     */
    private NodeLList detectCycle(NodeLList head) {
        //Floyd's cycle detection algorithm
        NodeLList slow = head;
        NodeLList fast = head.next;

        //Find the position - where fast & slow meet
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        //No loop - return null
        if (fast.next == null || fast.next.next == null) {
            return null;
        }

        //Loop exists - run 2nd part of Floyd's cycle detection algorithm
        //Re-align slow to head
        //Both slow and fast will now run 1 at a time (Same speed)
        slow = head;
        while (fast.next != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * AS2 > Remove Loop from Linked List (Floyd's cycle detection algorithm)
     * @param head
     * @return
     */
    private NodeLList removeLoopFromLinkedList(NodeLList head) {
        //Floyd's cycle detection algorithm
        NodeLList slow = head;
        NodeLList fast = head.next;

        //Go on till the slow and fast meet
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Once met, reset slow to head & traverse 1 for each
        slow = head;
        while (fast.next != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = null;
        return head;
    }

    /**
     * AS3 > Reorder List
     * Given a singly linked list A
     *  A0 → A1 → … → An-1 → An
     * reorder it to:
     *  A0 → An → A1 → An-1 → A2 → An-2 → …
     * You must do this in-place without altering the nodes' values.
     * @param head
     * @return
     */
    private NodeLList reorderList(NodeLList head) {
        NodeLList fast = head;
        NodeLList slow = head;

        if (fast == null || fast.next == null || fast.next.next == null) {
            return head;
        }
        //Find the mid of the LL (even : 1st mid, odd: normal)
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Split the list into 2 halves at mid
        NodeLList head2 = slow.next;
        slow.next = null;

        //Reverse the 2nd list
        NodeLList h1 = head2;
        NodeLList h2 = head2.next;
        h1.next = null;
        while (h2 != null) {
            NodeLList temp = h2.next;
            h2.next = h1;
            h1 = h2;
            h2 = temp;
        }
        //h1 is new head
        head2 = h1;

        //Merge the 2 list alternately
        int runner = 0;
        h1 = head;
        h2 = head2;
        NodeLList t1 = h1.next;
        NodeLList t2 = h2.next;
        while (h1 != null && h2 != null) {
            if (runner % 2 == 0) {
                h1.next = h2;
                h1 = t1;
                if (t1 != null) {
                    t1 = t1.next;
                }
            } else {
                h2.next = h1;
                h2 = t2;
                if (t2 != null) {
                    t2 = t2.next;
                }
            }
            runner++;
        }
        return head;
    }

    /*---------------HOMEWORK--------------*/

    /**
     * HW1 > Sort List (Linked List Merge Sort)
     * Sort a linked list, A in O(n log n) time using constant space complexity.
     * @param head
     * @return
     */
    private NodeLList sortList_mergeSort(NodeLList head) {
        //Base case
        if (head == null || head.next == null) {
            return head;
        }

        //Find the mid & split the list (head-mid) (head2-end)
        NodeLList slow = head;
        NodeLList fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast= fast.next.next;
        }
        NodeLList head2 = slow.next;
        slow.next = null;

        //Call mergesort for Left list & Right list
        head = this.sortList_mergeSort(head);
        head2 = this.sortList_mergeSort(head2);

        //Merge left & right sorted list
        return this.merge(head, head2);
    }
    private NodeLList merge(NodeLList head1, NodeLList head2) {
        NodeLList newHead = null;
        NodeLList newTemp = null;
        NodeLList temp1 = head1;
        NodeLList temp2 = head2;
        if (temp1.value < temp2.value) {
            newHead = temp1;
            temp1 = temp1.next;
        } else {
            newHead = temp2;
            temp2 = temp2.next;
        }
        newTemp = newHead;

        while (temp1 != null && temp2 != null) {
            if (temp1.value < temp2.value) {
                newTemp.next = temp1;
                temp1 = temp1.next;
            } else {
                newTemp.next = temp2;
                temp2 = temp2.next;
            }
            newTemp = newTemp.next;
        }
        if (temp1 == null) {
            newTemp.next = temp2;
        } else {
            newTemp.next = temp1;
        }
        return newHead;
    }

    /**
     * HW2 > Merge Two Sorted Lists
     * @param head1
     * @param head2
     * @return
     */
    private NodeLList mergeSortedArrays(NodeLList head1, NodeLList head2) {
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
