package main.tutorial.AdvancedDSA.M14_BST;

import main.tutorial.AdvancedDSA.M13_Trees.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class Day68_BST1 {
    public void execute() {
        System.out.println("---------------Day68_BST1----------------");
        System.out.println("---------------ASSIGNMENTS---------------");

        //AS1 > Sorted Array To Balanced BST
        ArrayList<Integer> inputAS1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        TreeNode resultAS1_root = this.sortedArrayToBalancedBST(inputAS1);
        System.out.print("AS1 > Sorted Array To Balanced BST [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] => Root : " + resultAS1_root.val + " Inorder Traversed Tree => ");
        this.inorderTraversalDisplay(resultAS1_root);
        System.out.println("");

        //AS2 > Valid Binary Search Tree
        System.out.println("AS2 > Valid Binary Search Tree [previous example BT] => isValidBST : " + this.isValidBST(resultAS1_root));
        resultAS1_root.right.right.left = new TreeNode(400);
        System.out.println("    > Valid Binary Search Tree [] => isValidBST : " + this.isValidBST(resultAS1_root));

        //AS3 > Floor and Ceil in BST
        ArrayList<Integer> inputAS3_B = new ArrayList<>(Arrays.asList(3, 13, 400, 403));
        ArrayList<ArrayList<Integer>> resultAS3 = this.floorAndCeilingBST(resultAS1_root, inputAS3_B);
        System.out.print("AS3 > Floor and Ceil in BST [previous example BT] , [3, 13, 400, 403] => : [ ");
        resultAS3.forEach(eachItem -> {
            System.out.print("[");
            eachItem.forEach(e -> System.out.print(e + ","));
            System.out.print("] ,");
        });
        System.out.println(" ]");

        //---------------HOMEWORK--------------
        System.out.println("---------------HOMEWORK------------------");

        //HW1 > Check for BST with One Child
        ArrayList<Integer> inputHW1_1 = new ArrayList<>(Arrays.asList(4, 10, 5 ,8));
        System.out.println("HW1 > Check for BST with One Child [4, 10, 5 ,8] => : " + this.checkForBSTWith1ChildEach(inputHW1_1));
        ArrayList<Integer> inputHW1_2 = new ArrayList<>(Arrays.asList(1, 5, 6, 4));
        System.out.println("    > Check for BST with One Child [1, 5, 6, 4] => : " + this.checkForBSTWith1ChildEach(inputHW1_2));

        //HW2 > Common Nodes in Two BST
        TreeNode inputHW2_A_n1 = new TreeNode(9);
        TreeNode inputHW2_A_n2 = new TreeNode(15); inputHW2_A_n2.left = inputHW2_A_n1;
        TreeNode inputHW2_A_n3 = new TreeNode(8); inputHW2_A_n3.right = inputHW2_A_n2;
        TreeNode inputHW2_A_n4 = new TreeNode(3);
        TreeNode inputHW2_A_n5 = new TreeNode(2); inputHW2_A_n5.right = inputHW2_A_n4;
        TreeNode inputHW2_A_n6 = new TreeNode(5); inputHW2_A_n6.left = inputHW2_A_n5; inputHW2_A_n6.right = inputHW2_A_n3;
        TreeNode inputHW2_B_n1 = new TreeNode(11);
        TreeNode inputHW2_B_n2 = new TreeNode(15); inputHW2_B_n2.left = inputHW2_B_n1;
        TreeNode inputHW2_B_n3 = new TreeNode(10); inputHW2_B_n3.right = inputHW2_B_n2;
        TreeNode inputHW2_B_n4 = new TreeNode(2);
        TreeNode inputHW2_B_n5 = new TreeNode(1); inputHW2_B_n5.right = inputHW2_B_n4;
        TreeNode inputHW2_B_n6 = new TreeNode(7); inputHW2_B_n6.left = inputHW2_B_n5; inputHW2_B_n6.right = inputHW2_B_n3;
        System.out.println("HW2 > Common Nodes in Two BST => : " + this.commonNodesIn2BST_sum(inputHW2_A_n6, inputHW2_B_n6));

        //HW3 > BST nodes in range
        TreeNode inputHW3_A_n1 = new TreeNode(2);
        TreeNode inputHW3_A_n2 = new TreeNode(1); inputHW3_A_n2.right = inputHW3_A_n1;
        TreeNode inputHW3_A_n3 = new TreeNode(7);
        TreeNode inputHW3_A_n4 = new TreeNode(6); inputHW3_A_n4.left = inputHW3_A_n2; inputHW3_A_n4.right = inputHW3_A_n3;
        TreeNode inputHW3_A_n5 = new TreeNode(13);
        TreeNode inputHW3_A_n6 = new TreeNode(21); inputHW3_A_n6.left = inputHW3_A_n5;
        TreeNode inputHW3_A_n7 = new TreeNode(8); inputHW3_A_n7.left = inputHW3_A_n4; inputHW3_A_n7.right = inputHW3_A_n6;
        System.out.println("HW3 > BST nodes in range [2-20] => : " + this.bstNodesInRange(inputHW3_A_n7, 2, 20));
    }

    private void inorderTraversalDisplay(TreeNode root) {
        if (root == null) return;
        this.inorderTraversalDisplay(root.left);
        System.out.print(root.val + " -> ");
        this.inorderTraversalDisplay(root.right);
    }

    /**
     * AS1 > Sorted Array To Balanced BST
     * @param sortedList
     * @return
     */
    private TreeNode sortedArrayToBalancedBST(ArrayList<Integer> sortedList) {
        int low = 0;
        int high = sortedList.size() - 1;
        return this.constructBalanceBST(sortedList, low, high);
    }
    private TreeNode constructBalanceBST(ArrayList<Integer> sortedList, int low, int high) {
        if (high < low) return null;
        int mid = (low + high) / 2 ;
        TreeNode root = new TreeNode(sortedList.get(mid));
        root.left = this.constructBalanceBST(sortedList, low, mid - 1);
        root.right = this.constructBalanceBST(sortedList, mid + 1, high);
        return root;
    }

    /**
     * AS2 > Valid Binary Search Tree
     * @param root
     * @return
     */
    private int isValidBST(TreeNode root) {
        return this.checkValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private int checkValidBST(TreeNode root, int low, int high) {
        if (root == null) return 1;
        if (root.val >= low && root.val <= high) {
            return 1 * this.checkValidBST(root.left, low, root.val-1) * this.checkValidBST(root.right, root.val+1, high);
        } else {
            return 0;
        }
    }

    /**
     * AS3 > Floor and Ceil in BST
     * Given a Binary Search Tree rooted at A.
     * Given an integer array B of size N. Find the floor and ceil of every element of the array B.
     * @param A
     * @param B
     * @return
     */
    private ArrayList<ArrayList<Integer>> floorAndCeilingBST(TreeNode A, ArrayList<Integer> B) {
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
        int elementToFind;
        ArrayList<Integer> individualResult;
        for (int i = 0; i < B.size(); i++) {
            elementToFind = B.get(i);
            individualResult = this.findFloorCeilingInBST(A, elementToFind);
            finalResult.add(individualResult);
        }
        return finalResult;
    }
    private ArrayList<Integer> findFloorCeilingInBST(TreeNode root, int n) {
        TreeNode temp = root;
        int ceiling = -1;
        int floor = -1;

        while (temp != null) {
            if (n == temp.val) {
                ceiling = temp.val;
                floor = temp.val;
                break;
            } else if (n < temp.val) {
                //Go left + ceiling=root.val
                ceiling = temp.val;
                temp = temp.left;
            } else {
                //Go right + floor=root.val
                floor = temp.val;
                temp = temp.right;
            }
        }
        ArrayList<Integer> individualResult = new ArrayList<>();
        individualResult.add(floor);
        individualResult.add(ceiling);
        return individualResult;
    }

    //---------------HOMEWORK--------------

    /**
     * HW1 > Check for BST with One Child
     * @param A
     * @return
     */
    private String checkForBSTWith1ChildEach(ArrayList<Integer> A) {
        String result = "YES";
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        int root = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            int currentVal = A.get(i);
            if (currentVal > root) {
                left = root;
            } else {
                right = root;
            }
            if (!(currentVal >= left && currentVal <= right)) { //Not in range [left-right]
                result = "NO";
                break;
            }
            root = A.get(i);
        }
        return result;
    }

    /**
     * HW2> Common Nodes in Two BST
     *       5           |         7
     *   2       8       |     1       10
     *     3       15    |       2       15
     *           9       |             11
     * @param A
     * @param B
     * @return
     */
    private int commonNodesIn2BST_sum(TreeNode A, TreeNode B) {
        ArrayList<Integer> inorderA = new ArrayList<>();
        ArrayList<Integer> inorderB = new ArrayList<>();
        this.buildInorderArray(A, inorderA);
        this.buildInorderArray(B, inorderB);
        //return 1;
        //NOTE: Inorder of BST is always sorted

        int aIndex = 0;
        int bIndex = 0;
        int sum = 0;

        while (aIndex < inorderA.size() && bIndex < inorderB.size()) {
            if (inorderA.get(aIndex) == inorderB.get(bIndex)) {
                sum = sum + inorderA.get(aIndex);
                aIndex++;
                bIndex++;
            } else if (inorderA.get(aIndex) < inorderB.get(bIndex)) {
                aIndex++;
            } else {
                bIndex++;
            }
        }
        return sum;
    }
    private void buildInorderArray(TreeNode root, ArrayList<Integer> inorderList) {
        if (root == null) return;
        this.buildInorderArray(root.left, inorderList);
        inorderList.add(root.val);
        this.buildInorderArray(root.right, inorderList);
    }

    /**
     * WH3 > BST nodes in a range
     * Given a binary search tree of integers. You are given a range B and C.
     * Return the count of the number of nodes that lie in the given range.
     * @param root
     * @param B
     * @param C
     * @return
     */
    private int bstNodesInRange(TreeNode root, int B, int C) {
        if (root == null) return 0;
        if (root.val >= B && root.val <= C) {
            return 1 + this.bstNodesInRange(root.left, B, C) + this.bstNodesInRange(root.right, B, C);
        }
        if (root.val < B) {
            //Go right - still possible to find nodes
            return this.bstNodesInRange(root.right, B, C);
        }
        if (root.val > C) {
            //Go left - still possible to find nodes
            return this.bstNodesInRange(root.left, B, C);
        }
        return 0;
    }


    private ArrayList<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return null;
        ArrayList<Integer> inorderResult = new ArrayList<>();
        inorderResult.addAll(this.inorderTraversal(root.left));
        inorderResult.add(root.val);
        inorderResult.addAll(this.inorderTraversal(root.right));
        return inorderResult;
    }
}
