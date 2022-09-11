package main.tutorial.IntermediateDSA.M_LinkedList;

import java.util.ArrayList;
import java.util.Arrays;

public class Day25_30_LinkedListBasics {
    public void execute() {
        System.out.println("------------Intermediate : Linked List Basics--------------");
        System.out.println("-------------------------ASSIGNMENT------------------------");

        //AS2 > Design Linked list [4 operations]
        ArrayList<ArrayList<Integer>> inputAS2 = new ArrayList<>();
        inputAS2.add(new ArrayList<>(Arrays.asList(0, 1, -1)));
        inputAS2.add(new ArrayList<>(Arrays.asList(1, 2, -1)));
        inputAS2.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        inputAS2.add(new ArrayList<>(Arrays.asList(0, 4, -1)));
        inputAS2.add(new ArrayList<>(Arrays.asList(3, 1, -1)));
        inputAS2.add(new ArrayList<>(Arrays.asList(3, 2, -1)));
        ListNode resultAS2 = this.designLinkedList(inputAS2);
        System.out.print("AS2 > Design Linked list [4 operations] => ");
        this.print_ll(resultAS2);
    }

    /**
     * Output each element followed by a space
     */
    private void print_ll(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    /**
     * AS2 > Design Linked list [4 operations]
     * 0 x -1: Add a node of value x before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     * 1 x -1: Append a node of value x to the last element of the linked list.
     * 2 x index: Add a node of value x before the indexth node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     * 3 index -1: Delete the indexth node in the linked list, if the index is valid.
     * A[i][0] represents the type of operation.
     * @param A
     * @return
     */
    private ListNode designLinkedList(ArrayList<ArrayList<Integer>> A) {
        ListNode head = null;

        for (int i = 0; i < A.size(); i++) {
            int operation = A.get(i).get(0);
            int value = A.get(i).get(1);
            int reference = A.get(i).get(2);

            if (operation == 0) {
                //Insert at head
                head = this.insertBeginning(value, head);
            } else if (operation == 1) {
                head = this.insertEnd(value, head);
            } else if (operation == 2) {
                head = this.addBeforePosition(value, reference, head);
            } else {
                head = this.deleteNodeAtPosition(value, head);
            }
        }

        return head;
    }
    private ListNode insertBeginning(int newVal, ListNode head) { //Operation 0
        ListNode newNode = new ListNode(newVal);
        newNode.next = head;
        return newNode;
    }
    private ListNode insertEnd(int newVal, ListNode head) { //Operation 1
        ListNode newNode = new ListNode(newVal);
        //If list is already empty
        if (head == null) {
            return newNode;
        }

        //If list has nodes
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }
    private ListNode addBeforePosition(int newVal, int referenceNode, ListNode head) {
        int pos = 0;
        ListNode newNode = new ListNode(newVal);
        if (referenceNode == 0) {
            newNode.next = head;
            return newNode;
        }

        ListNode temp = head;
        while (temp != null && pos != (referenceNode-1)) {
            temp = temp.next;
            pos++;
        }
        if (temp != null) {
            newNode.next = temp.next;
            temp.next = newNode;
        }
        return head;
    }
    private ListNode deleteNodeAtPosition(int position, ListNode head) {
        if (head == null) {
            return null;
        }
        if (position == 0) {
            return head.next;
        }

        ListNode temp = head;
        int runningPos = 0;
        while (temp != null && runningPos != (position-1)) {
            temp = temp.next;
            runningPos++;
        }
        if (temp != null && temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
    }
}
