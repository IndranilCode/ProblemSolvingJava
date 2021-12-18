package com.tutorial.Trees;

public class Day27_TreesBasic1 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int initVal) {
            this.val = initVal;
            left = null;
            right = null;
        }
    }


    public void execute() {
        //Sample Tree =>
        //      6
        //   3       5
        // 1   2   4
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        //AS4 > Tree Height
        int outputAS3 = treeHeight(root);
        System.out.println("AS3 - Tree Height : " + outputAS3);
    }

    /**
     * AS4 > (*) Tree Height
     * Given the root node of a binary tree A, find the height of the given tree.
     * Binary tree's height is number of nodes along the longest path from the root node down to the farthest leaf node.
     * @param A
     * @return
     */
    private int treeHeight(TreeNode A) {
        if (A == null) {
            return 0;
        }
        int leftHeight = treeHeight(A.left);
        int rightHeight = treeHeight(A.right);
        int maxHeight = leftHeight > rightHeight ? leftHeight : rightHeight;
        return maxHeight + 1;
    }
}
