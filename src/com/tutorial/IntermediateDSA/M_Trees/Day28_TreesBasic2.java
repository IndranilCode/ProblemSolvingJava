package com.tutorial.IntermediateDSA.M_Trees;

import java.util.ArrayList;

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

    private void inOrderRecursion(TreeNode root) {
        if (root == null) return;
        inOrderRecursion(root.left);
        System.out.print(root.val + " ");
        inOrderRecursion(root.right);
    }

    public void execute() {
        System.out.println("----------Day 28(35) Intermediate: Trees Basic 2-----------------------");
        System.out.println("---------------------------------CLASSWORK-----------------------------");

        //CW1 > Search for number in Binary Tree
        TreeNode root = generateSampleTree();
        int numberToSearch = 2;
        boolean outputCW1 = searchForNumberInTree(numberToSearch, root);
        System.out.println("CW1 - Search for number in Binary Tree : " + outputCW1);

        System.out.println("---------------------------------ASSIGNMENT----------------------------");

        System.out.println("AS1 > Identical Binary Trees => Done");
        System.out.println("AS2 > Symmetric Binary Tree => Done");


        //AS3 > BST nodes in a range
        //            8
        //           / \
        //          6  21
        //         / \
        //        1   7
        TreeNode inputAS3_n5 = new TreeNode(7);
        TreeNode inputAS3_n4 = new TreeNode(1);
        TreeNode inputAS3_n3 = new TreeNode(6); inputAS3_n3.left = inputAS3_n4; inputAS3_n3.right = inputAS3_n5;
        TreeNode inputAS3_n2 = new TreeNode(21);
        TreeNode inputAS3_n1 = new TreeNode(8); inputAS3_n1.left = inputAS3_n3; inputAS3_n1.right = inputAS3_n2;
        System.out.println("AS3 > BST nodes in a range [2, 20] => " + this.howManyNodesInRange(inputAS3_n1, 2, 20));

        System.out.println("---------------------------------HOMEWORK------------------------------");

        //HW1 > Invert the Binary Tree (Mirror Image)
        TreeNode inputHW1_n7 = new TreeNode(7);
        TreeNode inputHW1_n6 = new TreeNode(6);
        TreeNode inputHW1_n5 = new TreeNode(5);
        TreeNode inputHW1_n4 = new TreeNode(4);
        TreeNode inputHW1_n3 = new TreeNode(3); inputHW1_n3.left = inputHW1_n6; inputHW1_n3.right = inputHW1_n7;
        TreeNode inputHW1_n2 = new TreeNode(2); inputHW1_n2.left = inputHW1_n4; inputHW1_n2.right = inputHW1_n5;
        TreeNode inputHW1_n1 = new TreeNode(1); inputHW1_n1.left = inputHW1_n2; inputHW1_n1.right = inputHW1_n3;
        System.out.print("HW1 > Invert the Binary Tree (Mirror Image) [I/P Tree Inorder : " );
        this.inOrderRecursion(inputHW1_n1);
        TreeNode resultHW1 = this.invertTree(inputHW1_n1);
        System.out.print("] Inverted tree Inorder => ");
        this.inOrderRecursion(resultHW1);
        System.out.println("");


        //HW2 > Path to Given Node
        TreeNode inputHW2_n7 = new TreeNode(7);
        TreeNode inputHW2_n6 = new TreeNode(6);
        TreeNode inputHW2_n5 = new TreeNode(5);
        TreeNode inputHW2_n4 = new TreeNode(4);
        TreeNode inputHW2_n3 = new TreeNode(3); inputHW2_n3.left = inputHW2_n6; inputHW2_n3.right = inputHW2_n7;
        TreeNode inputHW2_n2 = new TreeNode(2); inputHW2_n2.left = inputHW2_n4; inputHW2_n2.right = inputHW2_n5;
        TreeNode inputHW2_n1 = new TreeNode(1); inputHW2_n1.left = inputHW2_n2; inputHW2_n1.right = inputHW2_n3;
        System.out.print("HW2 > Path to Given Node (Source 1 - Destination 5) => [");
        ArrayList<Integer> resultHW2_1 = this.pathToNode(inputHW2_n1, 5);
        resultHW2_1.forEach(e -> System.out.print(e + "->"));
        System.out.println("]");
        System.out.print("    > Path to Given Node (Source 1 - Destination 7) => [");
        ArrayList<Integer> resultHW2_2 = this.pathToNode(inputHW2_n1, 7);
        resultHW2_2.forEach(e -> System.out.print(e + "->"));
        System.out.println("]");
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

    //---------------------ASSIGNMENT----------------------

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
     * @param root
     * @return
     */
    private int isSymmetric(TreeNode root) {
        return this.isLeftSameAsRight(root, root);
    }
    private int isLeftSameAsRight(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return 1;
        if (leftNode == null || rightNode == null) return 0;
        if (leftNode.val != rightNode.val) {
            return 0;
        } else {
            return this.isLeftSameAsRight(leftNode.left, rightNode.right) * this.isLeftSameAsRight(leftNode.right, rightNode.left);
        }
    }

    /**
     * AS3 > BST nodes in a range
     * Given a binary search tree of integers. You are given a range B and C.
     * Return the count of the number of nodes that lies in the given range.
     * @param root
     * @param B
     * @param C
     * @return
     */
    private int howManyNodesInRange(TreeNode root, int B, int C) {
        if (root == null) return 0;
        if (root.val >= B && root.val <= C) {
            return 1 + this.howManyNodesInRange(root.left, B, C) + this.howManyNodesInRange(root.right, B, C);
        }
        if (root.val < B) {
            //Go right - still possible to find nodes
            return this.howManyNodesInRange(root.right, B, C);
        }
        if (root.val > C) {
            //Go left - still possible to find nodes
            return this.howManyNodesInRange(root.left, B, C);
        }
        return 0;
    }

    //---------------------HOMEWORK------------------------

    /**
     * HW1 > Invert the Binary Tree (Mirror Image)
     * Given a binary tree A, invert the binary tree and return it.
     * Inverting refers to making the left child the right child and vice versa.
     * @param root
     * @return
     */
    private TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode convertedNode = new TreeNode(root.val);
        convertedNode.left = this.invertTree(root.right);
        convertedNode.right = this.invertTree(root.left);
        return convertedNode;
    }

    /**
     * HW2 > Path to Given Node
     * Given a Binary Tree A containing N nodes, you need to find the path from Root to a given node B.
     * NOTE:
     * No two nodes in the tree have the same data values.
     * You can assume that B is present in tree A and a path always exists.
     * @param root
     * @param destinationVal
     * @return
     */
    private ArrayList<Integer> pathToNode(TreeNode root, int destinationVal) {
        //Process: Build list from down to up.
        //Parse nodes - when destination found return Arraylist containing it.
        //All along the list returns keep adding the current node value to beginning of list
        return this.buildPath(root, destinationVal);
    }
    private ArrayList<Integer> buildPath(TreeNode node, int destinationVal) {
        if (node == null) return null;
        if (node.val == destinationVal) {
            ArrayList buildingPathList = new ArrayList();
            buildingPathList.add(node.val);
            return buildingPathList;
        }
        ArrayList leftList = this.buildPath(node.left, destinationVal);
        if (leftList != null) {
            //Node has been found somewhere below - add this node to beginning
            leftList.add(0, node.val);
            return leftList;
        } else {
            ArrayList rightList = this.buildPath(node.right, destinationVal);
            if (rightList != null) {
                rightList.add(0, node.val);
                return rightList;
            }
        }
        return null;
    }
}
