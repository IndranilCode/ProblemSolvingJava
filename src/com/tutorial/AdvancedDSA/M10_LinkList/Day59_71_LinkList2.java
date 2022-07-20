package com.tutorial.AdvancedDSA.M10_LinkList;

public class Day59_71_LinkList2 {
    public void execute() {
        System.out.println("--------------Linked List 2--------------");
        System.out.println("----------------ASSIGNMENT---------------");

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
