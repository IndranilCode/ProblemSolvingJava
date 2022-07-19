package com.tutorial.AdvancedDSA.M10_LinkList;

import java.util.HashSet;

public class Day58_70_LinkList1 {
    public void execute() {
        System.out.println("--------------Linked List 1--------------");
        System.out.println("-----------------ASSIGNMENT--------------");

        //CW1 > Array to List
        int[] inputCW1 = new int[] { 1, 2, 3, 4, 5};
        System.out.print("CW1 > Array to Link list nodes => ");
        NodeLList resultCW1_head = this.arrayToLinkList(inputCW1);
        this.printList(resultCW1_head);

        //CW2a > Operations - Search
        System.out.println("CW2a > Search (5) => " + this.searchInLinkList(6, resultCW1_head));
        System.out.println("     > Search (6) => " + this.searchInLinkList(7, resultCW1_head));
        //CW2b > Operation - Insert beginning
        System.out.print("CW2b > Operation - Insert beginning => ");
        NodeLList resultCW2b_head = this.insertAtBeginning(resultCW1_head, 20);
        this.printList(resultCW2b_head);
        //CW2c > Operation - Insert end
        System.out.print("CW2c > Operation - Insert end => ");
        NodeLList resultCW2c_head = this.insertAtEnd(resultCW2b_head, 21);
        this.printList(resultCW2c_head);
        //CW2d > Operation - Insert at kth position from start
        System.out.print("CW2d > Insert at kth position from start (k = 4) => ");
        NodeLList resultCW2d_head = this.insertAtKthPositionFromStart(resultCW2c_head, 4, 22);
        this.printList(resultCW2d_head);
        System.out.print("CW2d > Insert at kth position from start (k = 9) => ");
        NodeLList resultCW2d2_head = this.insertAtKthPositionFromStart(resultCW2d_head, 9, 23); //9 is last position
        this.printList(resultCW2d2_head);
        System.out.print("CW2d > Insert at kth position from start (k = 11) => ");
        NodeLList resultCW2d3_head = this.insertAtKthPositionFromStart(resultCW2d_head, 11, 24); //beyond boundary
        System.out.println("");

        //CW3 > Reverse a link list
        System.out.print("CW3 > Reverse a link list => ");
        NodeLList resultCW3_head = this.reverseLinkList(resultCW2d3_head);
        this.printList(resultCW3_head);

        /*---------------ASSIGNMENT--------------*/

        System.out.println("----------------ASSIGNMENTS-----------------");

        //AS1 > Delete middle node of a Linked List
        NodeLList as1_odd_n7 = new NodeLList(7);
        NodeLList as1_odd_n6 = new NodeLList(6); as1_odd_n6.next = as1_odd_n7;
        NodeLList as1_odd_n5 = new NodeLList(5); as1_odd_n5.next = as1_odd_n6;
        NodeLList as1_odd_n4 = new NodeLList(4); as1_odd_n4.next = as1_odd_n5;
        NodeLList as1_odd_n3 = new NodeLList(3); as1_odd_n3.next = as1_odd_n4;
        NodeLList as1_odd_n2 = new NodeLList(2); as1_odd_n2.next = as1_odd_n3;
        NodeLList as1_odd_n1 = new NodeLList(1); as1_odd_n1.next = as1_odd_n2;
        NodeLList resultAS1_a = this.deleteMiddleElementOfList(as1_odd_n1);
        System.out.print("AS1 > Delete middle node of a Linked List [1,2,3,4,5,6,7] => ");
        this.printList(resultAS1_a);

        NodeLList as1_even_n8 = new NodeLList(8);
        NodeLList as1_even_n7 = new NodeLList(7); as1_even_n7.next = as1_even_n8;
        NodeLList as1_even_n6 = new NodeLList(6); as1_even_n6.next = as1_even_n7;
        NodeLList as1_even_n5 = new NodeLList(5); as1_even_n5.next = as1_even_n6;
        NodeLList as1_even_n4 = new NodeLList(4); as1_even_n4.next = as1_even_n5;
        NodeLList as1_even_n3 = new NodeLList(3); as1_even_n3.next = as1_even_n4;
        NodeLList as1_even_n2 = new NodeLList(2); as1_even_n2.next = as1_even_n3;
        NodeLList as1_even_n1 = new NodeLList(1); as1_even_n1.next = as1_even_n2;
        NodeLList resultAS1_b = this.deleteMiddleElementOfList(as1_even_n1);
        System.out.print("    > Delete middle node of a Linked List [1,2,3,4,5,6,7,8] => ");
        this.printList(resultAS1_b);

        NodeLList as1_small = new NodeLList(8);
        NodeLList resultAS1_c = this.deleteMiddleElementOfList(as1_small);
        System.out.print("    > Delete middle node of a Linked List [8] => ");
        this.printList(resultAS1_c);

        //AS3 > Middle element of linked list
        NodeLList as3_odd_n7 = new NodeLList(7);
        NodeLList as3_odd_n6 = new NodeLList(6); as3_odd_n6.next = as3_odd_n7;
        NodeLList as3_odd_n5 = new NodeLList(5); as3_odd_n5.next = as3_odd_n6;
        NodeLList as3_odd_n4 = new NodeLList(4); as3_odd_n4.next = as3_odd_n5;
        NodeLList as3_odd_n3 = new NodeLList(3); as3_odd_n3.next = as3_odd_n4;
        NodeLList as3_odd_n2 = new NodeLList(2); as3_odd_n2.next = as3_odd_n3;
        NodeLList as3_odd_n1 = new NodeLList(1); as3_odd_n1.next = as3_odd_n2;
        NodeLList as3_even_n8 = new NodeLList(8);
        NodeLList as3_even_n7 = new NodeLList(7); as3_even_n7.next = as3_even_n8;
        NodeLList as3_even_n6 = new NodeLList(6); as3_even_n6.next = as3_even_n7;
        NodeLList as3_even_n5 = new NodeLList(5); as3_even_n5.next = as3_even_n6;
        NodeLList as3_even_n4 = new NodeLList(4); as3_even_n4.next = as3_even_n5;
        NodeLList as3_even_n3 = new NodeLList(3); as3_even_n3.next = as3_even_n4;
        NodeLList as3_even_n2 = new NodeLList(2); as3_even_n2.next = as3_even_n3;
        NodeLList as3_even_n1 = new NodeLList(1); as3_even_n1.next = as3_even_n2;
        System.out.println("AS3 > Middle element of linked list [1,2,3,4,5,6,7] => " + this.middleElementOfList(as3_odd_n1));
        System.out.println("    > Middle element of linked list [1,2,3,4,5,6,7,8] => " + this.middleElementOfList(as3_even_n1));

        //AS4 > Reverse Link List II
        NodeLList as4_a_n9 = new NodeLList(9);
        NodeLList as4_a_n8 = new NodeLList(8); as4_a_n8.next = as4_a_n9;
        NodeLList as4_a_n7 = new NodeLList(7); as4_a_n7.next = as4_a_n8;
        NodeLList as4_a_n6 = new NodeLList(6); as4_a_n6.next = as4_a_n7;
        NodeLList as4_a_n5 = new NodeLList(5); as4_a_n5.next = as4_a_n6;
        NodeLList as4_a_n4 = new NodeLList(4); as4_a_n4.next = as4_a_n5;
        NodeLList as4_a_n3 = new NodeLList(3); as4_a_n3.next = as4_a_n4;
        NodeLList as4_a_n2 = new NodeLList(2); as4_a_n2.next = as4_a_n3;
        NodeLList as4_a_n1 = new NodeLList(1); as4_a_n1.next = as4_a_n2;
        System.out.print("AS4 > Reverse Link List II [1,2,3,4,5,6,7,8,9] => ");
        NodeLList resultAS4a = this.reverseBetween2Nodes(as4_a_n1, 3, 7);
        this.printList(resultAS4a);
        System.out.print("    > Reverse Link List II [1,2,7,6,5,4,3,8,9] => ");
        NodeLList resultAS4b = this.reverseBetween2Nodes(resultAS4a, 1, 3);
        this.printList(resultAS4b);

        //AS5 > Reverse Linked List
        NodeLList as5_odd_n7 = new NodeLList(7);
        NodeLList as5_odd_n6 = new NodeLList(6); as5_odd_n6.next = as5_odd_n7;
        NodeLList as5_odd_n5 = new NodeLList(5); as5_odd_n5.next = as5_odd_n6;
        NodeLList as5_odd_n4 = new NodeLList(4); as5_odd_n4.next = as5_odd_n5;
        NodeLList as5_odd_n3 = new NodeLList(3); as5_odd_n3.next = as5_odd_n4;
        NodeLList as5_odd_n2 = new NodeLList(2); as5_odd_n2.next = as5_odd_n3;
        NodeLList as5_odd_n1 = new NodeLList(1); as5_odd_n1.next = as5_odd_n2;
        System.out.print("AS5 > Reverse Linked List => ");
        NodeLList newHead = this.reverseFirstKNodes(as5_odd_n1, 10);
        this.printList(newHead);

        //AS6 > Link list operation

        /*---------------HOMEWORK--------------*/

        System.out.println("----------------HOMEWORK-----------------");
        //HW1 > Remove Nth Node from List End
        NodeLList hw1_n7 = new NodeLList(7);
        NodeLList hw1_n6 = new NodeLList(6); hw1_n6.next = hw1_n7;
        NodeLList hw1_n5 = new NodeLList(5); hw1_n5.next = hw1_n6;
        NodeLList hw1_n4 = new NodeLList(4); hw1_n4.next = hw1_n5;
        NodeLList hw1_n3 = new NodeLList(3); hw1_n3.next = hw1_n4;
        NodeLList hw1_n2 = new NodeLList(2); hw1_n2.next = hw1_n3;
        NodeLList hw1_n1 = new NodeLList(1); hw1_n1.next = hw1_n2;
        System.out.print("HW1 > Remove Nth Node from List End [1,2,3,4,5,6,7] => ");
        NodeLList resultHW1a = this.deleteNthNodeFromEnd(hw1_n1, 2);
        this.printList(resultHW1a);
        System.out.print("    > Remove Nth Node from List End [1,2,3,4,5,7] => ");
        NodeLList resultHW1b = this.deleteNthNodeFromEnd(hw1_n1, 6);
        this.printList(resultHW1b);

        //HW2 > Remove Duplicates from Sorted List
        NodeLList hw2_n7 = new NodeLList(4);
        NodeLList hw2_n6 = new NodeLList(3); hw2_n6.next = hw2_n7;
        NodeLList hw2_n5 = new NodeLList(2); hw2_n5.next = hw2_n6;
        NodeLList hw2_n4 = new NodeLList(2); hw2_n4.next = hw2_n5;
        NodeLList hw2_n3 = new NodeLList(2); hw2_n3.next = hw2_n4;
        NodeLList hw2_n2 = new NodeLList(1); hw2_n2.next = hw2_n3;
        NodeLList hw2_n1 = new NodeLList(1); hw2_n1.next = hw2_n2;
        System.out.print("HW2 > Remove Duplicates from Sorted List [1,1,2,2,2,3,4] => ");
        NodeLList resultHW2a = this.deleteDuplicates(hw2_n1);
        this.printList(resultHW2a);

        NodeLList hw2_n7_2 = new NodeLList(1);
        NodeLList hw2_n6_2 = new NodeLList(1); hw2_n6_2.next = hw2_n7_2;
        NodeLList hw2_n5_2 = new NodeLList(1); hw2_n5_2.next = hw2_n6_2;
        NodeLList hw2_n4_2 = new NodeLList(1); hw2_n4_2.next = hw2_n5_2;
        NodeLList hw2_n3_2 = new NodeLList(1); hw2_n3_2.next = hw2_n4_2;
        NodeLList hw2_n2_2 = new NodeLList(1); hw2_n2_2.next = hw2_n3_2;
        NodeLList hw2_n1_2 = new NodeLList(1); hw2_n1_2.next = hw2_n2_2;
        System.out.print("    > Remove Duplicates from Sorted List [1,1,1,1,1,1,1] => ");
        NodeLList resultHW2b = this.deleteDuplicates(hw2_n1_2);
        this.printList(resultHW2b);

        NodeLList hw2_n2_3 = new NodeLList(1);
        NodeLList hw2_n1_3 = new NodeLList(1); hw2_n1_3.next = hw2_n2_3;
        System.out.print("    > Remove Duplicates from Sorted List [1,1] => ");
        NodeLList resultHW2c = this.deleteDuplicates(hw2_n1_3);
        this.printList(resultHW2c);
    }

    /**
     * CW1 > Array to Link list nodes
     * @param a
     * @return
     */
    private NodeLList arrayToLinkList(int[] a) {
        NodeLList head = new NodeLList(a[0]); //head will the kept asis for traversals
        NodeLList temp = head; // head & temp -> a[0]
        for (int i = 1; i < a.length; i++) {
            temp.next = new NodeLList(a[i]);
            temp = temp.next;
        }
        return head;
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
     * CW2a > Operation - Search
     * @param k
     * @param head
     * @return
     */
    private Boolean searchInLinkList(int k, NodeLList head) {
        NodeLList temp = head;
        while (temp != null) {
            if (temp.value == k) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * CW2b > Operation - Insert beginning
     * @param head
     * @param k
     * @return
     */
    private NodeLList insertAtBeginning(NodeLList head, int k) {
        NodeLList temp = new NodeLList(k);
        temp.next = head;
        return temp;
    }

    /**
     * CW2c > Operation - Insert end
     * @param head
     * @param k
     * @return
     */
    private NodeLList insertAtEnd(NodeLList head, int k) {
        NodeLList temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new NodeLList(k);
        return head;
    }

    /**
     * CW2d > Operation - Insert at kth position from start
     * @param head
     * @param k
     * @param val
     * @return
     */
    private NodeLList insertAtKthPositionFromStart(NodeLList head, int k, int val) {
        NodeLList temp = head;
        //Find node k-1 & insert post that [1 based numbering]
        int i = 1;
        while (i < k-1) {
            if (temp != null) {
                temp = temp.next;
                i++;
            } else {
                System.out.print("Invalid position beyond limit !");
                return head;
            }
        }
        if (temp != null) {
            NodeLList newNode = new NodeLList(val);
            newNode.next = temp.next;
            temp.next = newNode;
        } else {
            System.out.print("Invalid position beyond limit !");
        }
        return head;
    }

    /**
     * CW3 > Reverse a link list
     * @param head
     * @return
     */
    private NodeLList reverseLinkList(NodeLList head) {
        NodeLList h1 = head;
        NodeLList h2 = h1.next;
        h1.next = null;
        while (h2 != null) {
            NodeLList temp = h2.next;
            h2.next = h1;
            h1 = h2;
            h2 = temp;
        }
        return h1;
    }

    /*---------------ASSIGNMENT--------------*/

    /**
     * AS1 > Delete middle node of a Linked List
     * @param head
     * @return
     */
    private NodeLList deleteMiddleElementOfList(NodeLList head) {
        NodeLList slowTemp = head;
        NodeLList fastTemp = head;
        while (fastTemp != null) {
            if (fastTemp.next != null && fastTemp.next.next != null && fastTemp.next.next.next != null) {
                fastTemp = fastTemp.next.next;
                slowTemp = slowTemp.next;
            } else {
                break;
            }
        }
        if (slowTemp.next != null) {
            slowTemp.next = slowTemp.next.next;
        } else {
            head = null; //Only 1 node then delete the
        }
        return head;
    }


    private NodeLList k_reverse_link_list_in_groups(NodeLList head, int k) {
        if (k == 1 || head == null) {
            return head;
        }
        NodeLList h1 = head;
        NodeLList h2 = h1.next;
        int counter = 1;
        while (counter <= (k -1) && h2 != null) {
            NodeLList temp = h2.next;
            h2.next = h1;
            h1 = h2;
            h2 = temp;
            counter++;
        }

        head.next = this.k_reverse_link_list_in_groups(h2, k);
        return h1;
    }

    /**
     * AS3 > Middle element of linked list
     * @param head
     * @return
     */
    private int middleElementOfList(NodeLList head) {
        NodeLList slowTemp = head;
        NodeLList fastTemp = head;
        while (fastTemp != null) {
            if(fastTemp.next != null && fastTemp.next.next != null) {
                fastTemp = fastTemp.next.next;
                slowTemp = slowTemp.next;

            } else if (fastTemp.next != null && fastTemp.next.next == null) {
                slowTemp = slowTemp.next;
                break;
            } else if (fastTemp.next == null){
                break;
            }
        }
        return slowTemp.value;
    }

    /**
     * AS4 > Reverse Link List II
     * Reverse a linked list A from position B to C.
     * @param head
     * @param b
     * @param c
     * @return
     */
    private NodeLList reverseBetween2Nodes(NodeLList head, int b, int c) {
        NodeLList low = head;
        NodeLList h1;
        NodeLList h2;
        int i = 1;
        if (b > 1) {
            while (i < (b-1)) {
                low = low.next;
                i++;
            }
            h1 = low.next;
            h2 = h1.next;
        } else {
            h1 = low;
            h2 = h1.next;
        }

        i = 1;
        NodeLList temp = null;
        while (i <= (c-b)) {
            temp = h2.next;
            h2.next = h1;
            h1 = h2;
            h2 = temp;
            i++;
        }
        if (b == 1) {
            low.next = h2;
        } else {
            low.next.next = h2;
            low.next = h1;
        }

        if (b == 1) {
            return h1;
        } else {
            return head;
        }
    }

    /**
     * AS5 > Reverse Linked List
     * @param head
     * @return
     */
    private NodeLList reverseFirstKNodes(NodeLList head, int k) {
        NodeLList h1 = head;
        NodeLList h2 = h1.next;
        int i = 1;
        while (i < k && h2 != null) {
            NodeLList temp = h2. next;
            h2.next = h1;
            h1 = h2;
            h2 = temp;
            i++;
        }
        head.next = h2;
        return h1; //h1 = new head
    }

    /**
     * AS6 > Linked List (Link list operation)
     */
    public static class LinkListOperations {
        static class Node {
            public int value;
            public Node next;

            public Node(int data) {
                this.value = data;
                this.next = null;
            }
        }

        static int count = 0;
        static Node head = null;

        public static void insert_node(int position, int value) {
            if (position > count + 1) {
                return;
            }

            if (position == 1) {
                Node newNode = new Node(value);
                newNode.next = head;
                head = newNode;
                count++;
            } else {
                int i = 1;
                Node temp = head;
                while (i < (position-1) && temp != null) {
                    temp = temp.next;
                    i++;
                }
                Node newNode = new Node(value);
                newNode.next = temp.next;
                temp.next = newNode;
                count++;
            }
        }

        public static void delete_node(int position) {
            if (position > count) return;

            if (position == 1) {
                head = head.next;
                count--;
            } else {
                int i = 1;
                Node temp = head;
                while (i < (position-1) && temp != null) {
                    temp = temp.next;
                    i++;
                }
                temp.next = temp.next.next;
                count--;
            }
        }
    }

    /*---------------HOMEWORK--------------*/

    /**
     * HW1 > Remove Nth Node from List End
     * Remove the B-th node from the end of the list and return its head.
     * If B is greater than the size of the list, remove the first node of the list.
     * @param head
     * @param n
     * @return
     */
    private NodeLList deleteNthNodeFromEnd(NodeLList head, int n) {
        int size = 0;
        NodeLList temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        int nodeToDeleteFromFront = (n > size) ? 1: (size - n + 1);

        temp = head;
        if (nodeToDeleteFromFront == 1) {
            head = head.next;
        } else {
            int i = 1;
            while (i < (nodeToDeleteFromFront - 1)) {
                temp = temp.next;
                i++;
            }
            temp.next = temp.next.next;
        }
        return head;
    }

    /**
     * HW2 > Remove Duplicates from Sorted List
     * Given a sorted linked list, delete all duplicates such that each element appears only once.
     * @param head
     * @return
     */
    private NodeLList deleteDuplicates(NodeLList head) {
        HashSet earlierNumbers = new HashSet();
        NodeLList prev = head;
        if (prev.next != null) {
            NodeLList temp = prev.next;
            earlierNumbers.add(prev.value);
            earlierNumbers.add(temp.value);

            if (prev.value == temp.value) {
                //prev & temp is same. so delete the 1st node
                prev = prev.next;
                if (temp.next != null) {
                    temp= temp.next;
                }
                head = head.next;
            } else {
                //prev & temp is different - go ahead
                prev = prev.next;
                temp = temp.next;
            }

            while (temp!= null) {
                if (earlierNumbers.contains(temp.value)) {
                    //duplicate number found
                    prev.next = temp.next;
                    temp = temp.next;
                } else {
                    earlierNumbers.add(temp.value);
                    prev = prev.next;
                    temp = temp.next;
                }
            }
        }
        return head;
    }
}
