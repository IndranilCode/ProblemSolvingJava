package com.tutorial.AdvancedDSA.M10_LinkList;

public class Day58_LinkList1 {
    public void execute() {
        //CW1 > Array to List
        int[] inputCW1 = new int[] { 1, 2, 3, 4, 5, 6};
        System.out.println("CW1 > Array to Link list nodes => ");
        NodeLList resultCW1 = this.arrayToLinkList(inputCW1);
        this.printList(resultCW1);
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
}
