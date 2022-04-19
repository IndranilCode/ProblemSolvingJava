package com.tutorial.AdvancedDSA.M13_Trees;

public class Day65_Trees1 {
    public void execute() {
        System.out.println("----------Day 65 : Trees 1-------------");
        /*---------------ASSIGNMENT--------------*/
        System.out.println("---------------ASSIGNMENT--------------");

        //AS1 > Nodes Count
        TreeNode inputAS1_t4 = new TreeNode(2);
        TreeNode inputAS1_t3 = new TreeNode(3);
        TreeNode inputAS1_t2 = new TreeNode(4); inputAS1_t2.left = inputAS1_t4;
        TreeNode inputAS1_t1 = new TreeNode(1); inputAS1_t1.left = inputAS1_t2; inputAS1_t1.right = inputAS1_t3;
        System.out.println("AS1 > Nodes Count => " + this.nodeCount(inputAS1_t1));

        //AS2 > Nodes Sum
        System.out.println("AS2 > Nodes Sum => " + this.nodeSum(inputAS1_t1));

        //AS3 > Tree Height
        System.out.println("AS3 > Tree Height => " + this.heightOfTree(inputAS1_t1));
    }

    /*---------------ASSIGNMENT--------------*/

    /**
     * AS1 > Nodes Count
     * You are given the root node of a binary tree A. You have to find the number of nodes in this tree.
     * @param root
     * @return
     */
    private int nodeCount(TreeNode root) {
        if (root == null) return 0;
        return (1 + this.nodeCount(root.left) + this.nodeCount(root.right));
    }

    /**
     * AS2 > Nodes Sum
     * You are given the root node of a binary tree A. You have to find the sum of node values of this tree.
     * @param root
     * @return
     */
    private int nodeSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + this.nodeSum(root.left) + this.nodeSum(root.right);
    }

    /**
     * AS3 > Tree Height
     * You are given the root node of a binary tree A. You have to find the height of the given tree.
     * @param root
     * @return
     */
    private int heightOfTree(TreeNode root) {
        if (root == null) return 0;
        int heightLeft = this.heightOfTree(root.left);
        int heightRight = this.heightOfTree(root.right);
        return 1 + this.max(heightLeft, heightRight);
    }
    private int max(int a, int b) {
        return a > b ? a : b;
    }
}
