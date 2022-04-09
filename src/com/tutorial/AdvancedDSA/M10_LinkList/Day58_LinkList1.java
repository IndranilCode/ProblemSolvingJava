package com.tutorial.AdvancedDSA.M10_LinkList;

public class Day58_LinkList1 {
    public void execute() {
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
        NodeLList odd_n7 = new NodeLList(7);
        NodeLList odd_n6 = new NodeLList(6); odd_n6.next = odd_n7;
        NodeLList odd_n5 = new NodeLList(5); odd_n5.next = odd_n6;
        NodeLList odd_n4 = new NodeLList(4); odd_n4.next = odd_n5;
        NodeLList odd_n3 = new NodeLList(3); odd_n3.next = odd_n4;
        NodeLList odd_n2 = new NodeLList(2); odd_n2.next = odd_n3;
        NodeLList odd_n1 = new NodeLList(1); odd_n1.next = odd_n2;
        System.out.print("AS  > Base Input LL (Odd LL) => "); this.printList(odd_n1);
        NodeLList even_n8 = new NodeLList(8);
        NodeLList even_n7 = new NodeLList(7); even_n7.next = even_n8;
        NodeLList even_n6 = new NodeLList(6); even_n6.next = even_n7;
        NodeLList even_n5 = new NodeLList(5); even_n5.next = even_n6;
        NodeLList even_n4 = new NodeLList(4); even_n4.next = even_n5;
        NodeLList even_n3 = new NodeLList(3); even_n3.next = even_n4;
        NodeLList even_n2 = new NodeLList(2); even_n2.next = even_n3;
        NodeLList even_n1 = new NodeLList(1); even_n1.next = even_n2;
        System.out.print("AS  > Base Input LL (Even LL) => "); this.printList(even_n1);

        //AS3 > Middle element of linked list
        System.out.println("AS3 > Middle element of linked list [1,2,3,4,5,6,7] => " + this.middleElementOfList(odd_n1));
        System.out.println("    > Middle element of linked list [1,2,3,4,5,6,7,8] => " + this.middleElementOfList(even_n1));

        //AS5 > Reverse Linked List
        System.out.print("AS5 > Reverse Linked List => ");
        NodeLList newHead = this.reverseFirstKNodes(odd_n1, 10);
        this.printList(newHead);

        //AS6 > Link list operation
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
     * AS6 > Link list operation
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
}
