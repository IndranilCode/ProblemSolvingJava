package com.tutorial.Trees;

import java.util.ArrayList;
import java.util.Stack;

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
        //Sample Tree =>
        //      6
        //   3       5
        // 1   2   4

        //AS1 > Inorder - Recursion
        System.out.print("AS1 - InOrder (Recursion) : ");
        TreeNode root = generateSampleTree();
        inOrderRecursion(root);
        System.out.println("");

        //AS1 > Inorder - Iteration
        //        root = generateSampleTree();
        //        ArrayList<Integer> outputAS1 = inOrderIterative(root);
        //        System.out.print("AS1 - Inorder (Iterative) : ");
        //        outputAS1.forEach(e -> {
        //            System.out.print(e + " ");
        //        });
        //        System.out.println("");

        //AS2 > PreOrder - Recursion
        System.out.print("AS2 - PreOrder (Recursion) : ");
        root = generateSampleTree();
        preOrderRecursion(root);
        System.out.println("");

        //AS2 > PreOrder - Iteration
        root = generateSampleTree();
        ArrayList<Integer> outputAS2 = preOrderIterative(root);
        System.out.print("AS2 - PreOrder (Iterative) : ");
        outputAS2.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println("");


        //AS3 > PostOrder - Recursion
        System.out.print("AS3 - PostOrder (Recursion) : ");
        root = generateSampleTree();
        postOrderRecursion(root);
        System.out.println("");

        //AS3 > PostOrder - Iteration
        root = generateSampleTree();
        ArrayList<Integer> outputAS3 = postOrderIterative(root);
        System.out.print("AS3 - PostOrder (Iterative) : ");
        outputAS3.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println("");

        //AS4 > Tree Height
        root = generateSampleTree();
        int outputAS4 = treeHeight(root);
        System.out.println("AS4 - Tree Height : " + outputAS4);
    }

    private void inOrderRecursion(TreeNode root) {
        if (root == null) return;
        inOrderRecursion(root.left);
        System.out.print(root.val + " ");
        inOrderRecursion(root.right);
    }

    private ArrayList<Integer> inOrderIterative(TreeNode root) {
        ArrayList<Integer> inOrderResult = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(root);

        TreeNode temp = root;
        while (!s1.empty()) {
            temp = temp.left;
            if (temp != null) {
                s1.push(temp);
                //temp = temp.left;
            } else {
                TreeNode foundNode = s1.pop();
                inOrderResult.add(foundNode.val);
                temp = temp.right;
            }
        }
        return inOrderResult;
    }

    /**
     * AS2 > (*) PreOrder - Recursion
     * @param root
     */
    private void preOrderRecursion(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrderRecursion(root.left);
        preOrderRecursion(root.right);
    }

    /**
     * AS2 > (*) PreOrder - Iterative
     * @param root
     * @return
     */
    private ArrayList<Integer> preOrderIterative(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(root);

        while (!s1.empty()) {
            TreeNode poppedNode = s1.pop();
            result.add(poppedNode.val);
            if (poppedNode.right != null) {
                s1.push(poppedNode.right);
            }
            if (poppedNode.left != null) {
                s1.push(poppedNode.left);
            }
        }
        return result;
    }

    private void postOrderRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderRecursion(root.left);
        postOrderRecursion(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * AS3 > (*) PostOrder - Iteration
     * @param root
     * @return
     */
    private ArrayList<Integer> postOrderIterative(TreeNode root) {
        ArrayList<Integer> postOrderResult = new ArrayList<>();
        if (root == null) return null;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.empty()) {
            TreeNode temp = s1.pop();
            s2.push(temp);
            if (temp.left != null) {
                s1.push(temp.left);
            }
            if (temp.right != null) {
                s1.push(temp.right);
            }
        }
        while (!s2.empty()) {
            postOrderResult.add(s2.pop().val);
        }
        return postOrderResult;
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
