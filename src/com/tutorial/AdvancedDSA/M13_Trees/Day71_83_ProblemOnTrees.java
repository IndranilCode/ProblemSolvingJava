package com.tutorial.AdvancedDSA.M13_Trees;

public class Day71_83_ProblemOnTrees {
    public void execute() {
        System.out.println("-------Day 71: Problems on Trees---------");
        System.out.println("----------------ASSIGNMENT---------------");

        //AS2 > Path Sum
        //          5
        //         / \
        //        4   8
        //       /   / \
        //      11  13  4
        //     /  \      \
        //    7    2      1
        TreeNode inputAS2_t9 = new TreeNode(1);
        TreeNode inputAS2_t8 = new TreeNode(2);
        TreeNode inputAS2_t7 = new TreeNode(7);
        TreeNode inputAS2_t6 = new TreeNode(4); inputAS2_t6.right = inputAS2_t9;
        TreeNode inputAS2_t5 = new TreeNode(13);
        TreeNode inputAS2_t4 = new TreeNode(11); inputAS2_t4.left = inputAS2_t7; inputAS2_t4.right = inputAS2_t8;
        TreeNode inputAS2_t3 = new TreeNode(4); inputAS2_t3.left = inputAS2_t4;
        TreeNode inputAS2_t2 = new TreeNode(8); inputAS2_t2.left = inputAS2_t5; inputAS2_t2.right = inputAS2_t6;
        TreeNode inputAS2_t1 = new TreeNode(5); inputAS2_t1.left = inputAS2_t3; inputAS2_t1.right = inputAS2_t2;
        System.out.println("AS2 > Path Sum (Sum = 22) => " + this.hasPathSum(inputAS2_t1, 22));
    }

    /**
     * AS2 > Path Sum
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
     * @param root
     * @param sum
     * @return
     */
    private int hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        //Required sum to check OR pass below
        sum = sum - root.val;

        //If leaf node check if sum is met
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int leftResult = this.hasPathSum(root.left, sum);
        int rightResult = this.hasPathSum(root.right, sum);
        return (leftResult + rightResult > 0 ? 1 : 0);
    }
}
