package com.tutorial.LinkList;

import org.w3c.dom.Node;

public class Day25_LinkListBasics {

    NodeLL head = null;
    int count = 0;

    public void execute() {
        //------CW--------
        // 5 -> 4 -> 3 -> 2 -> 1
        NodeLL n1 = new NodeLL(5);
        NodeLL n2 = new NodeLL(4);
        NodeLL n3 = new NodeLL(3);
        NodeLL n4 = new NodeLL(2);
        NodeLL n5 = new NodeLL(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        //CW1 > Length of LL (Without losing head)
        int outputCW1 = this.lengthOfLinkList(n1);
        System.out.println("CW1 > Length of LL :" + outputCW1);

        //CW2 > Printing LL
        System.out.print("CW2 > Printing LL : ");
        this.printLinkList(n1);

        //CW3 > Adding node to start of LL
        System.out.print("CW3 > Add node to start LL : ");
        NodeLL newHead = addNodeToStartOfLinkList(100, n1);
        this.printLinkList(newHead);

        //CW4 > Add node to end of LL
        System.out.print("CW3 > Add node to end of LL : ");
        addNodeToEndOfLinkList(101, n1);
        this.printLinkList(newHead);

        //CW5 > Insert value at K'th position
        System.out.print("CW4 > Insert value at K'th position : ");
        insertValueAtKthPosition(200, 3, newHead);
        this.printLinkList(newHead);

        //AS1 > Linked-List operations
        this.insert_node(1, 10);
        this.insert_node(2, 11);
        this.insert_node(3, 12);
        this.insert_node(2, 13);
        this.insert_node(3, 14);
        this.delete_node(4);
        this.print_ll();
    }

    //-------CW----------

    /**
     * CW1 > Length of LL (Without losing head)
     * TC = O(N)
     * @param head
     * @return
     */
    private int lengthOfLinkList(NodeLL head) {
        NodeLL temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        //System.out.println(head.value); //Head is not lost - prints 5
        return length;
    }

    /**
     * CW2 > Printing LL
     * TC = O(N)
     * @param head
     */
    private void printLinkList(NodeLL head) {
        NodeLL temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * CW3 > Add node to start
     * TC = O(1)
     * @param value
     * @param head
     */
    private NodeLL addNodeToStartOfLinkList(int value, NodeLL head) {
        NodeLL newNode = new NodeLL(value);
        newNode.next = head;
        head = newNode;
        return head;
    }

    /**
     * CW4 > Add node to end of LL
     * @param value
     * @param head
     */
    private void addNodeToEndOfLinkList(int value, NodeLL head) {
        NodeLL newNode = new NodeLL(value);
        NodeLL temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    /**
     * CW5 > Insert at K'th position
     * @param value
     * @param K
     * @param head
     */
    private void insertValueAtKthPosition(int value, int K, NodeLL head) {
        NodeLL newNode = new NodeLL(value);
        NodeLL temp = head;
        int runningCount = 1;
        while (runningCount < K - 1) {
            temp = temp.next;
            runningCount ++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }



    

    private void insert_node(int position, int value) {
        NodeLL newNode = new NodeLL(value);

        if (position > count + 1) {
            return;
        }

        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        } else {
            int runningIndex = 1;
            NodeLL temp = head;
            while (runningIndex < (position - 1) && temp.next != null) {
                temp = temp.next;
                runningIndex ++;
            }
            //            if (runningIndex == (position - 1) && temp.next.next != null) {
            //                newNode.next = temp.next;
            //                temp.next = newNode;
            //            }
            //            if (runningIndex == (position - 1) && temp.next != null) {
            //                newNode.next = temp.next;
            //                temp.next = newNode;
            //            }
            if (runningIndex == (position - 1)) {
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
    }

    private void delete_node(int position) {
        int runningIndex = 1;
        NodeLL temp = head;
        while (runningIndex < (position - 1) && temp.next != null) {
            temp = temp.next;
            runningIndex ++;
        }
        //        if (runningIndex == (position - 1) && temp.next.next != null) {
        //            temp.next = temp.next.next;
        //        }
        //        if (runningIndex == (position - 1) && temp.next != null) {
        //            temp.next = temp.next.next;
        //        }
        if (runningIndex == (position - 1)) {
            temp.next = temp.next.next;
        }
    }

    /**
     * Output each element followed by a space
     */
    private void print_ll() {
        NodeLL temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
}
