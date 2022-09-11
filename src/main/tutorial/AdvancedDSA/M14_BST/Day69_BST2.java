package main.tutorial.AdvancedDSA.M14_BST;

import main.tutorial.AdvancedDSA.M13_Trees.TreeNode;

import java.util.ArrayList;

public class Day69_BST2 {
    ArrayList<Integer> path = new ArrayList<>();

    public void execute() {
        System.out.println("---------------Day69_BST2----------------");
        System.out.println("---------------ASSIGNMENTS---------------");

        //AS1 > Recover Binary Search Tree
        TreeNode inputAS1_A_n1 = new TreeNode(3);
        TreeNode inputAS1_A_n2 = new TreeNode(13);
        TreeNode inputAS1_A_n3 = new TreeNode(5); inputAS1_A_n3.left = inputAS1_A_n1; inputAS1_A_n3.right = inputAS1_A_n2;
        TreeNode inputAS1_A_n4 = new TreeNode(7);
        TreeNode inputAS1_A_n5 = new TreeNode(15); inputAS1_A_n5.left = inputAS1_A_n4;
        TreeNode inputAS1_A_n6 = new TreeNode(10); inputAS1_A_n6.left = inputAS1_A_n3; inputAS1_A_n6.right = inputAS1_A_n5;
        ArrayList<Integer> resultAS1 = this.recoverBST_from2SwappedBSTNodes(inputAS1_A_n6);
        System.out.println("AS1 > Recover Binary Search Tree => [ " + resultAS1.get(0) + ", " + resultAS1.get(1) + " ]");

        //AS2 > Kth Smallest Element In BST
        TreeNode inputAS2_A_n1 = new TreeNode(9);
        TreeNode inputAS2_A_n2 = new TreeNode(15); inputAS2_A_n2.left = inputAS2_A_n1;
        TreeNode inputAS2_A_n3 = new TreeNode(8); inputAS2_A_n3.right = inputAS2_A_n2;
        TreeNode inputAS2_A_n4 = new TreeNode(3);
        TreeNode inputAS2_A_n5 = new TreeNode(2); inputAS2_A_n5.right = inputAS2_A_n4;
        TreeNode inputAS2_A_n6 = new TreeNode(5); inputAS2_A_n6.left = inputAS2_A_n5; inputAS2_A_n6.right = inputAS2_A_n3;
        System.out.println("AS2 > Kth Smallest Element In BST [9, 15, 8 ,3, 2, 5] (k=3) => " + kTthMin_BST_inorder(inputAS2_A_n6, 3));


        //---------------HOMEWORK--------------
        System.out.println("---------------HOMEWORK------------------");

        //HW1 > Distance between Nodes of BST
        TreeNode inputHW1_A_n1 = new TreeNode(1);
        TreeNode inputHW1_A_n2 = new TreeNode(4);
        TreeNode inputHW1_A_n3 = new TreeNode(2); inputHW1_A_n3.left = inputHW1_A_n1; inputHW1_A_n3.right = inputHW1_A_n2;
        TreeNode inputHW1_A_n4 = new TreeNode(6);
        TreeNode inputHW1_A_n5 = new TreeNode(11);
        TreeNode inputHW1_A_n6 = new TreeNode(8); inputHW1_A_n6.left = inputHW1_A_n4; inputHW1_A_n6.right = inputHW1_A_n5;
        TreeNode inputHW1_A_n7 = new TreeNode(5); inputHW1_A_n7.left = inputHW1_A_n3; inputHW1_A_n7.right = inputHW1_A_n6;
        System.out.println("HW1 > Distance between Nodes of BST (4,6) => " + this.distanceBetween2Nodes(inputHW1_A_n7, 4, 6));

        //HW2 > Two Sum BST
        System.out.println("HW2 > Two Sum BST (17 : 10, 7) (Tree as HW1) => " + this.twoSumBst(inputHW1_A_n7, 5));



    }

    /**
     * AS1 > Recover Binary Search Tree
     * Two elements of a binary search tree (BST), represented by root A are swapped by mistake.
     * Tell us the 2 values swapping which the tree will be restored.
     *           10
     *      5         15
     *    3   13    7
     * @param root
     * @return
     */
    private ArrayList<Integer> recoverBST_from2SwappedBSTNodes(TreeNode root) {
        ArrayList<Integer> inorderList = new ArrayList<>();
        this.getInorderTraversal(root, inorderList);

        //Find the inconsistent pairs
        int prev = -1;
        int curr = -1;
        int next = -1;
        for (int i = 0; i < inorderList.size()-1; i++) {
            int currentElement = inorderList.get(i);
            int nextElement = inorderList.get(i+1);
            if (currentElement > nextElement) {
                if (prev == -1) {
                    prev = currentElement;
                    curr = nextElement;
                } else {
                    next = nextElement;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        if (next != -1) {
            result.add(next);
            result.add(prev);
        } else {
            result.add(curr);
            result.add(prev);
        }

        return result;
    }
    private void getInorderTraversal(TreeNode root, ArrayList<Integer> inorderList) {
        if (root == null) return;
        this.getInorderTraversal(root.left, inorderList);
        inorderList.add(root.val);
        this.getInorderTraversal(root.right, inorderList);
    }

    /**
     * AS2 > Kth Smallest Element In BST
     * @param root
     * @param k
     * @return
     */
    private int kTthMin_BST_inorder(TreeNode root, int k) {
        ArrayList<Integer> inorderList = new ArrayList<>();
        this.buildInorderTraversal(root, inorderList, k);
        return inorderList.get(k-1);
    }
    private void buildInorderTraversal(TreeNode root, ArrayList<Integer> inorderList, int k) {
        if (root == null) return;
        this.buildInorderTraversal(root.left, inorderList, k);
        inorderList.add(root.val);
        if (inorderList.size() == k) return;
        this.buildInorderTraversal(root.right, inorderList, k);
    }


    //---------------HOMEWORK--------------

    /**
     * HW1 > Distance between Nodes of BST
     * Given a binary search tree.
     * Return the distance between two nodes with given two keys B and C. It may be assumed that both keys exist in BST.
     * @param root
     * @param b
     * @param c
     * @return
     */
    private int distanceBetween2Nodes(TreeNode root, int b, int c) {
        if (root == null) return 0;
        if (root.val > b && root.val > c) { //Go left
            return this.distanceBetween2Nodes(root.left, b, c);
        }
        if (root.val < b && root.val < c) { //Go right
            return this.distanceBetween2Nodes(root.right, b, c);
        }
        //LCA is reached => (root-b) + (root-c)
        return this.distanceFromLCAToNode(root, b) + this.distanceFromLCAToNode(root, c);
    }
    private int distanceFromLCAToNode(TreeNode root, int x) {
        if (root.val == x) {
            return 0;
        }
        if (root.val > x) { //Go left
            return 1 + this.distanceFromLCAToNode(root.left, x);
        }
        else { //Go left
            return 1 + this.distanceFromLCAToNode(root.right, x);
        }
    }

    /**
     * HW2 > Two Sum BST
     * Given a binary search tree A, where each node contains a positive integer,
     * and an integer B, you have to find whether or not there exist two different nodes X and Y such that X.value + Y.value = B.
     * Return 1 to denote that two such nodes exist. Return 0, otherwise.
     * @param root
     * @param b
     * @return
     */
    private int twoSumBst(TreeNode root, int b) {
        ArrayList<Integer> inorderTraversalList = new ArrayList<>();
        this.getInorderTraversal(root, inorderTraversalList);

        int result = 0;
        int left = 0;
        int right = inorderTraversalList.size() - 1;
        while (right > left) {
            int currentSum = inorderTraversalList.get(left) + inorderTraversalList.get(right);
            if (currentSum == b) {
                return 1;
            } else if (currentSum > b) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    private TreeNode bt_to_circularLL(TreeNode root) {
        ArrayList<Integer> inorderList = new ArrayList<>();
        this.getInorderTraversal(root, inorderList);

        ArrayList<TreeNode> inorderTreeList = new ArrayList<>();
        for (int i = 0; i < inorderList.size(); i++) {
            TreeNode currentNode = new TreeNode(inorderList.get(i));
            if (i > 0) {
                currentNode.left = inorderTreeList.get(i - 1);
            }
            inorderTreeList.add(currentNode);
        }
        for (int i = 0 ; i < inorderTreeList.size() - 1; i++) {
            inorderTreeList.get(i).right = inorderTreeList.get(i);
        }
        inorderTreeList.get(inorderTreeList.size() - 1).right = inorderTreeList.get(0);
        inorderTreeList.get(0).left = inorderTreeList.get(inorderTreeList.size() - 1);
        return inorderTreeList.get(0);
    }
}
