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

}
