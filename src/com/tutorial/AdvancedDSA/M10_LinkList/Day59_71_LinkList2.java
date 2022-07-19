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

        System.out.println("-----------------HOMEWORK----------------");

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

//    private NodeLList reorderLinkList(NodeLList head) {
//        //Split LL to 2 parts
//        NodeLList slow = head;
//        NodeLList fast = head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//    }


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
