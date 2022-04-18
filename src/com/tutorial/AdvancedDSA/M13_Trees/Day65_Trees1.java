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
}
