package com.tutorial.Trees;

public class Day28_TreesBasic2 {
    private TreeNode generateSampleTree() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        return root;
    }

    public void execute() {

        //CW1 > Search for number in Binary Tree
        TreeNode root = generateSampleTree();
        int numberToSearch = 2;
        boolean outputCW1 = searchForNumberInTree(numberToSearch, root);
        System.out.println("CW1 - Search for number in Binary Tree : " + outputCW1);
    }

    /**
     * CW1 > Search for number in Binary Tree
     * @param K
     * @param A
     * @return
     */
    public boolean searchForNumberInTree(int K, TreeNode A) {
        if (A == null) return false;
        if (A.val == K) return true;
        boolean leftSearch = searchForNumberInTree(K, A.left);
        if (leftSearch) {
            return true;
        }
        boolean rightSearch = searchForNumberInTree(K, A.right);
        return rightSearch;
    }


    /**
     * AS1 > Identical Binary Trees
     * Given two binary trees, check if they are equal or not.
     * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
     * @param A
     * @param B
     * @return
     */
    private int identicalBinaryTrees(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        }
        if ((A == null && B != null) || (A != null && B == null)) {
            return 0;
        }
        if (A.val == B.val) {
            return identicalBinaryTrees(A.left, B.left) * identicalBinaryTrees(A.right, B.right);
        } else {
            return 0;
        }
    }

    /**
     * AS2 > Symmetric Binary Tree
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     * @param A
     * @return
     */
    private int isSymmetric(TreeNode A) {
        return 0;
    }

    /**
     * AS3 > BST nodes in a range
     * Given a binary search tree of integers. You are given a range B and C.
     * Return the count of the number of nodes that lies in the given range.
     * @param A
     * @param B
     * @param C
     * @return
     */
    private int howManyNodesInRange(TreeNode A, int B, int C) {
        int count = 0;
        if (A == null) {
            return 0;
        }
        if (A.val >= B && A.val <= C) {
            count++;
        }
        return count + howManyNodesInRange(A.left, B, C) + howManyNodesInRange(A.right, B, C);
    }
}
