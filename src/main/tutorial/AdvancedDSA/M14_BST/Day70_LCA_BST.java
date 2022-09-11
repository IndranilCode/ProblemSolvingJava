package main.tutorial.AdvancedDSA.M14_BST;

import main.tutorial.AdvancedDSA.M13_Trees.TreeNode;

public class Day70_LCA_BST {
    public void execute() {
        System.out.println("------------ Day68_LCA & BST----------------");
        System.out.println("-----------------CLASSWORK------------------");

        TreeNode input_cw1_n1 = new TreeNode(3);
        TreeNode input_cw1_n2 = new TreeNode(8);
        TreeNode input_cw1_n3 = new TreeNode(5); input_cw1_n3.left = input_cw1_n1; input_cw1_n3.right = input_cw1_n2;
        TreeNode input_cw1_n4 = new TreeNode(11);
        TreeNode input_cw1_n5 = new TreeNode(24); input_cw1_n5.left = input_cw1_n4;
        TreeNode input_cw1_n6 = new TreeNode(10); input_cw1_n6.left = input_cw1_n3; input_cw1_n6.right = input_cw1_n5;
        TreeNode input_cw1_n7 = new TreeNode(22);
        TreeNode input_cw1_n8 = new TreeNode(20); input_cw1_n8.right = input_cw1_n7;
        TreeNode input_cw1_n9 = new TreeNode(16);
        TreeNode input_cw1_n10 = new TreeNode(18); input_cw1_n10.left = input_cw1_n9; input_cw1_n10.right = input_cw1_n8;
        TreeNode input_cw1_n11 = new TreeNode(35);
        TreeNode input_cw1_n12 = new TreeNode(13); input_cw1_n12.left = input_cw1_n10; input_cw1_n12.right = input_cw1_n11;
        TreeNode input_cw1_n13 = new TreeNode(15); input_cw1_n13.left = input_cw1_n6; input_cw1_n13.right = input_cw1_n12;
        System.out.print("CW1 > Find LCA of BT [Both present] (8, 11)=> " + this.lca(input_cw1_n13, 8, 11));

    }

    public int lca(TreeNode root, int b ,int c) {
        TreeNode lcaNode = this.findLca(root, b, c);
        return lcaNode.val;
    }
    public TreeNode findLca(TreeNode root, int b, int c) {
        if (root == null) return null;
        if (root.val == b || root.val == c) return root;

        TreeNode leftLca = this.findLca(root.left, b, c);
        TreeNode rightLca = this.findLca(root.right, b, c);

        if (leftLca == null && rightLca == null) { //Both null => send null
            return null;
        } else if (leftLca == null && rightLca != null) { // Left null, right found => send right
            return rightLca;
        } else if (leftLca != null && rightLca == null) { // Right null, left found => send left
            return leftLca;
        } else { //Both not null => This node is LCA
            return root;
        }
    }
}
