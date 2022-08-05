package com.tutorial.AdvancedDSA.M13_Trees;

import java.util.*;

public class Day71_83_ProblemOnTrees {
    private class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public void execute() {
        System.out.println("-------Day 71: Problems on Trees---------");
        System.out.println("----------------ASSIGNMENT---------------");

        //AS1 > Next Pointer Binary Tree
        System.out.println("AS1 > Next Pointer Binary Tree => Solution provided in code");

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


        System.out.println("----------------HOMEWORK-----------------");

        //HW1 > Deserialize Binary Tree
        ArrayList<Integer> inputHW1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1));
        TreeNode resultHW1_root = this.deserializeBinaryTree(inputHW1);
        System.out.print("HW1 > Deserialize Binary Tree => Root : " + resultHW1_root.val + " ; Inorder Traversal => ");
        this.inOrderRecursion(resultHW1_root);
        System.out.println();

        //HW2 > Serialize Binary Tree
        //            1
        //          /   \
        //         2     3
        //        / \     \
        //       4   5     6
        TreeNode inputHW2_t6 = new TreeNode(6);
        TreeNode inputHW2_t5 = new TreeNode(5);
        TreeNode inputHW2_t4 = new TreeNode(4);
        TreeNode inputHW2_t3 = new TreeNode(3); inputHW2_t3.right = inputHW2_t6;
        TreeNode inputHW2_t2 = new TreeNode(2); inputHW2_t2.left = inputHW2_t4; inputHW2_t2.right = inputHW2_t5;
        TreeNode inputHW2_t1 = new TreeNode(1); inputHW2_t1.left = inputHW2_t2; inputHW2_t1.right = inputHW2_t3;
        ArrayList<Integer> resultHW2 = this.serializeBinaryTree(inputHW2_t1);
        System.out.print("HW2 > Serialize Binary Tree => : [");
        resultHW2.forEach(e -> System.out.print(e.toString() + ", "));
        System.out.println("]");


        //HW3 > Odd and Even Levels
        TreeNode inputHW3_t7 = new TreeNode(7);
        TreeNode inputHW3_t6 = new TreeNode(6); inputHW3_t6.right = inputHW3_t7;
        TreeNode inputHW3_t5 = new TreeNode(5); inputHW3_t5.left = inputHW3_t6;
        TreeNode inputHW3_t4 = new TreeNode(4);
        TreeNode inputHW3_t3 = new TreeNode(3);
        TreeNode inputHW3_t2 = new TreeNode(2); inputHW3_t2.left = inputHW3_t4; inputHW3_t2.right = inputHW3_t5;
        TreeNode inputHW3_t1 = new TreeNode(1); inputHW3_t1.left = inputHW3_t2; inputHW3_t1.right = inputHW3_t3;
        System.out.println("HW3 > Odd and Even Levels => " + this.oddEvenLevelDifference(inputHW3_t1));

        //HW4 > Equal Tree Partition
        //                5
        //               /  \
        //              3    7
        //             / \  / \
        //            4  6  5  6
        TreeNode inputHW4_t7 = new TreeNode(6);
        TreeNode inputHW4_t6 = new TreeNode(5);
        TreeNode inputHW4_t5 = new TreeNode(6);
        TreeNode inputHW4_t4 = new TreeNode(4);
        TreeNode inputHW4_t3 = new TreeNode(7); inputHW4_t3.left = inputHW4_t6; inputHW4_t3.right = inputHW4_t7;
        TreeNode inputHW4_t2 = new TreeNode(3); inputHW4_t2.left = inputHW4_t4; inputHW4_t2.right = inputHW4_t5;
        TreeNode inputHW4_t1 = new TreeNode(5); inputHW4_t1.left = inputHW4_t2; inputHW4_t1.right = inputHW4_t3;
        System.out.println("HW4 > Equal Tree Partition => " + this.equalTreePartition(inputHW4_t1));
    }

    private void inOrderRecursion(TreeNode root) {
        if (root == null) return;
        inOrderRecursion(root.left);
        System.out.print(root.val + " ");
        inOrderRecursion(root.right);
    }

    /**
     * AS1 > Next Pointer Binary Tree
     * Given a binary tree,
     * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
     * Initially, all next pointers are set to NULL.
     * Input =>
     *          1
     *        /  \
     *       2    5
     *      / \  / \
     *     3  4  6  7
     *
     * Output =>
     *          1 -> NULL
     *        /  \
     *       2 -> 5 -> NULL
     *      / \  / \
     *     3->4->6->7 -> NULL
     * Assume perfect binary tree and try to solve this in constant extra space.
     * @param root
     */
    private void connect_nextPointerBinaryTree(TreeLinkNode root) {
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int nodesInLevel = q.size();

            //At-least 1 node exists - Assign 0th node as prev & add its children to Q
            TreeLinkNode prev = q.remove();
            if (prev.left != null) {
                q.add(prev.left);
            }
            if (prev.right != null) {
                q.add(prev.right);
            }

            if (nodesInLevel > 1) {
                for (int i = 1; i < nodesInLevel; i++) {
                    TreeLinkNode current = q.remove();
                    if (current.left != null) {
                        q.add(current.left);
                    }
                    if (current.right != null) {
                        q.add(current.right);
                    }
                    prev.next = current;
                    prev = current;
                }
            }
        }
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

    /*---------------HOMEWORK--------------*/

    /**
     * HW1 > Deserialize Binary Tree
     * @param A
     * @return
     */
    private TreeNode deserializeBinaryTree(ArrayList<Integer> A) {
        TreeNode root = new TreeNode(A.get(0));
        int i = 1;
        Queue<TreeNode> q = new LinkedList<>(); q.add(root);
        while (i < A.size()) {
            TreeNode poppedNode = q.remove();
            int leftVal = A.get(i);
            i = i + 1;
            if (leftVal != -1) {
                poppedNode.left = new TreeNode(leftVal);
                q.add(poppedNode.left);
            }
            int rightVal = A.get(i);
            i = i + 1;
            if (rightVal != -1) {
                poppedNode.right = new TreeNode(rightVal);
                q.add(poppedNode.right);
            }
        }
        return root;
    }

    /**
     * HW2 > Serialize Binary Tree
     * @param root
     * @return
     */
    private ArrayList<Integer> serializeBinaryTree(TreeNode root) {
        Queue<TreeNode> levelQ = new LinkedList<>();
        ArrayList<Integer> serializedBt = new ArrayList<>();
        if (root != null) {
            levelQ.add(root);
        }

        while (!levelQ.isEmpty()) {
            TreeNode poppedNode = levelQ.remove();
            if (poppedNode != null) {
                serializedBt.add(poppedNode.val);
                levelQ.add(poppedNode.left);
                levelQ.add(poppedNode.right);
            } else {
                serializedBt.add(-1);
            }
        }
        return serializedBt;
    }

    /**
     * HW3 > Odd and Even Levels
     * @param root
     * @return
     */
    private int oddEvenLevelDifference(TreeNode root) {
        Queue<TreeNode> horizontalLevelTraversalQ = new LinkedList<>();
        int difference = 0;
        int currentLevel = 1;
        horizontalLevelTraversalQ.add(root);
        while (!horizontalLevelTraversalQ.isEmpty()) {
            int totalNodesToPop =  horizontalLevelTraversalQ.size();
            for (int i = 0; i < totalNodesToPop; i++) {
                //Pop the node
                TreeNode poppedNode = horizontalLevelTraversalQ.remove();
                if (currentLevel % 2 == 0) { //Even level
                    difference = difference - poppedNode.val;
                } else { //Odd level
                    difference = difference + poppedNode.val;
                }

                //Add children to the Q + Increment level by 1
                if (poppedNode.left != null) {
                    horizontalLevelTraversalQ.add(poppedNode.left);
                }
                if (poppedNode.right != null) {
                    horizontalLevelTraversalQ.add(poppedNode.right);
                }
            }
            currentLevel ++;
        }
        return difference;
    }

    /**
     * HW4 > Equal Tree Partition
     * Given a binary tree A.
     * Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.
     * Eg:
     *                 5
     *                /  \
     *               3    7
     *              / \  / \
     *             4  6  5  6
     *
     *  Remove edge between 5(root node) and 7:
     *         Tree 1 =                                               Tree 2 =
     *                         5                                                     7
     *                        /                                                     / \
     *                       3                                                     5   6
     *                      / \
     *                     4   6
     *         Sum of Tree 1 = Sum of Tree 2 = 18
     * @param root
     * @return
     */
    private int equalTreePartition(TreeNode root) {
        HashSet<Integer> nodeSums = new HashSet<>();
        int totalSumOfTree = this.treeSum(root, nodeSums);
        if (totalSumOfTree % 2 == 0) {
            //Even sum - check for half sum in hashset
            int halfSum = totalSumOfTree / 2;
            return nodeSums.contains(halfSum) ? 1 : 0;
        }
        return 0;
    }
    private int treeSum(TreeNode root, HashSet<Integer> nodeSums) {
        if (root == null) {
            return 0;
        }
        int leftSum = this.treeSum(root.left, nodeSums);
        int rightSum = this.treeSum(root.right, nodeSums);
        int currentSum = root.val + leftSum + rightSum;
        nodeSums.add(currentSum);
        return currentSum;
    }
}
