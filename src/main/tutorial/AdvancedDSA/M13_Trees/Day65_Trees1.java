package main.tutorial.AdvancedDSA.M13_Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

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

        //AS4 > Nodes Max
        System.out.println("AS4 > Nodes Max => " + this.nodeMax(inputAS1_t1));

        //AS5 > Postorder Traversal [Non-recursion]
        System.out.print("AS5 > Postorder Traversal [Non-recursion] => ");
        ArrayList<Integer> resultAS5 = this.postorderTraversal(inputAS1_t1);
        resultAS5.forEach(e -> System.out.print(e + ", "));
        System.out.println("");

        //AS6> Binary Tree From Inorder And Preorder
        ArrayList<Integer> inputAS6_preOrder = new ArrayList<>(Arrays.asList(1, 6, 2, 3));
        ArrayList<Integer> inputAS6_inOrder = new ArrayList<>(Arrays.asList(6, 1, 3, 2));
        TreeNode root = this.buildTreeFromPreorderInorder(inputAS6_preOrder, inputAS6_inOrder);
        System.out.println("AS6> Binary Tree From Inorder And Preorder => Root " + root.val);

        /*---------------HOMEWORK--------------*/
        System.out.println("---------------HOMEWORK--------------");

        //HW1 > Inorder Traversal
        ArrayList<Integer> resultHW1 = this.inorderTraversal(inputAS1_t1);
        System.out.print("HW1 > Inorder Traversal [Non-recursion] => ");
        resultHW1.forEach(e -> System.out.print(e + ", "));
        System.out.println("");

        //HW2 > Preorder Traversal
        ArrayList<Integer> resultHW2 = this.preorderTraversal(inputAS1_t1);
        System.out.print("HW2 > Preorder Traversal [Non-recursion] => ");
        resultHW2.forEach(e -> System.out.print(e + ", "));
        System.out.println("");

        //HW3 > Depth of Each Node
        TreeNodeDepth inputHW3_t4 = new TreeNodeDepth(2);
        TreeNodeDepth inputHW3_t3 = new TreeNodeDepth(3);
        TreeNodeDepth inputHW3_t2 = new TreeNodeDepth(4); inputHW3_t2.left = inputHW3_t4;
        TreeNodeDepth inputHW3_t1 = new TreeNodeDepth(1); inputHW3_t1.left = inputHW3_t2; inputHW3_t1.right = inputHW3_t3;
        System.out.print("HW3 > Depth of Each Node => ");
        this.depthFill(inputHW3_t1);
        this.printNodeWithDepthPreOrder(inputHW3_t1);
        System.out.println("");

        //HW4 > Odd and Even Levels
        TreeNode inputHW4_t7 = new TreeNode(7);
        TreeNode inputHW4_t6 = new TreeNode(6); inputHW4_t6.right = inputHW4_t7;
        TreeNode inputHW4_t5 = new TreeNode(5); inputHW4_t5.left = inputHW4_t6;
        TreeNode inputHW4_t4 = new TreeNode(4);
        TreeNode inputHW4_t3 = new TreeNode(3);
        TreeNode inputHW4_t2 = new TreeNode(2); inputHW4_t2.left = inputHW4_t4; inputHW4_t2.right = inputHW4_t5;
        TreeNode inputHW4_t1 = new TreeNode(1); inputHW4_t1.left = inputHW4_t2; inputHW4_t1.right = inputHW4_t3;
        System.out.println("HW4 > Odd and Even Levels => " + this.oddEvenLevelDifference(inputHW4_t1));

        //HW5 > Identical Binary Trees
        TreeNode inputHW5_t4_A = new TreeNode(2);
        TreeNode inputHW5_t3_A = new TreeNode(3);
        TreeNode inputHW5_t2_A = new TreeNode(4); inputHW5_t2_A.left = inputHW5_t4_A;
        TreeNode inputHW5_t1_A = new TreeNode(1); inputHW5_t1_A.left = inputHW5_t2_A; inputHW5_t1_A.right = inputHW5_t3_A;
        TreeNode inputHW5_t4_B = new TreeNode(2);
        TreeNode inputHW5_t3_B = new TreeNode(3);
        TreeNode inputHW5_t2_B = new TreeNode(4); inputHW5_t2_B.left = inputHW5_t4_B;
        TreeNode inputHW5_t1_B = new TreeNode(1); inputHW5_t1_B.left = inputHW5_t2_B; inputHW5_t1_B.right = inputHW5_t3_B;
        System.out.println("HW5 > Identical Binary Trees => " + this.isSameTree(inputHW5_t1_A, inputHW5_t1_B));

        //HW6 > Binary Tree From Inorder And Postorder
        ArrayList<Integer> inputHW6_preOrder = new ArrayList<>(Arrays.asList(6, 3, 2, 1));
        ArrayList<Integer> inputHW6_inOrder = new ArrayList<>(Arrays.asList(6, 1, 3, 2));
        TreeNode root_resultHW6 = this.buildTreeFromPostorderInorder(inputHW6_preOrder, inputHW6_inOrder);
        System.out.println("HW6 > Binary Tree From Inorder And Postorder => Root " + root_resultHW6.val);
    }

    //---------------ASSIGNMENT--------------

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

    /**
     * AS4 > Nodes Max
     * You have to find the max value of all node values of this tree.
     * @param root
     * @return
     */
    private int nodeMax(TreeNode root) {
        if (root == null) return 0;
        int leftMax = this.nodeMax(root.left);
        int rightMax = this.nodeMax(root.right);
        int selfVal = root.val;
        return this.tripleMax(leftMax, rightMax, selfVal);
    }
    private int tripleMax(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }

    /**
     * AS5 > Postorder Traversal [Non-recursion]
     * @param root
     * @return
     */
    private ArrayList<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode temp = s1.pop();
            s2.push(temp);
            if (temp.left != null) {
                s1.push(temp.left);
            }
            if (temp.right != null) {
                s1.push(temp.right);
            }
        }

        ArrayList<Integer> postOrderResult = new ArrayList();
        while (!s2.isEmpty()) {
            postOrderResult.add(s2.pop().val);
        }
        return postOrderResult;
    }

    /**
     * AS6 > Binary Tree From Inorder And Preorder
     * @param preOrder
     * @param inOrder
     * @return
     */
    private TreeNode buildTreeFromPreorderInorder(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        if (preOrder.size() == 0) {
            return null;
        }
        //PreOrder[0] is the root node
        int rootValue = preOrder.get(0);
        TreeNode root = new TreeNode(rootValue);

        //If array has 1 value then there is no left/right
        if (preOrder.size() > 1) {
            //Check index of currentNo in InOrder , left array -> Left subtree, right array -> right subtree
            int inOrderIndex = inOrder.indexOf(rootValue); // [0 - (inOrderIndex-1)] is Left subtree, [(inOrderIndex+1) - end] is Right subtree
            ArrayList<Integer> leftSubtreeInorder = this.getSubList(inOrder, 0, (inOrderIndex-1));
            ArrayList<Integer> rightSubtreeInorder = this.getSubList(inOrder, (inOrderIndex+1), (inOrder.size() - 1));
            int leftSubtreeSize = leftSubtreeInorder.size();
            int rightSubtreeSize = rightSubtreeInorder.size();
            //In Preorder after root , leftPreorder will come (size = leftSubtreeSize) then rightPreorder will come (size = rightSubtreeSize)
            ArrayList<Integer> leftSubtreePreorder = this.getSubList(preOrder, 1, leftSubtreeSize);
            ArrayList<Integer> rightSubtreePreorder = this.getSubList(preOrder, leftSubtreeSize+1, (preOrder.size() - 1));
            root.left = this.buildTreeFromPreorderInorder(leftSubtreePreorder, leftSubtreeInorder);
            root.right = this.buildTreeFromPreorderInorder(rightSubtreePreorder, rightSubtreeInorder);
        }
        return root;
    }
    private ArrayList<Integer> getSubList(ArrayList<Integer> superList, int startIndex, int endIndex) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (startIndex < superList.size() && endIndex < superList.size()) {
            for(int i = startIndex; i <= endIndex; i++) {
                resultList.add(superList.get(i));
            }
        }
        return resultList;
    }

    //---------------HOMEWORK--------------

    /**
     * HW1 > Inorder Traversal
     * @param root
     * @return
     */
    private ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while (root != null || !st.empty()) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.pop();
                results.add(root.val);
                if (root.right != null) {
                    root = root.right;
                } else {
                    root = null;
                }
            }
        }
        return results;
    }

    /**
     * HW2 > Preorder Traversal
     * @param root
     * @return
     */
    private ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> preorderResult = new ArrayList<>();
        Stack<TreeNode> preorderStack = new Stack<>();
        preorderStack.push(root);
        while (!preorderStack.isEmpty()) {
            TreeNode poppedNode = preorderStack.pop();
            preorderResult.add(poppedNode.val);
            if (poppedNode.right != null) {
                preorderStack.push(poppedNode.right);
            }
            if (poppedNode.left != null) {
                preorderStack.push(poppedNode.left);
            }
        }
        return preorderResult;
    }

    /**
     * HW3 > Depth of Each Node
     */
    private class TreeNodeDepth {
        private int val;
        private TreeNodeDepth left;
        private TreeNodeDepth right;
        private int depth;

        TreeNodeDepth(int value) {
            this.val = value;
        }
    }
    private void depthFill(TreeNodeDepth root) {
        this.depthOfEachNode(root, 0);
    }
    private void depthOfEachNode(TreeNodeDepth temp, int depth) {
        if (temp == null) return;
        temp.depth = depth;
        this.depthOfEachNode(temp.left, depth+1);
        this.depthOfEachNode(temp.right, depth+1);
    }
    private void printNodeWithDepthPreOrder(TreeNodeDepth root) {
        if (root == null) return;
        System.out.print(root.val + "(" + root.depth + ") -> ");
        this.printNodeWithDepthPreOrder(root.left);
        this.printNodeWithDepthPreOrder(root.right);
    }

    /**
     * HW4 > Odd and Even Levels
     * @param root
     * @return
     */
    private int oddEvenLevelDifference(TreeNode root) {
        return this.runningSumOddEvenDifference(root, 1, 0);
    }
    private int runningSumOddEvenDifference(TreeNode root, int level, int runningSum) {
        if (root == null) return 0;
        if ((level % 2) == 0) {
            runningSum = runningSum - root.val;
        } else {
            runningSum = runningSum + root.val;
        }
        return runningSum + this.runningSumOddEvenDifference(root.left, level+1, runningSum)
                + this.runningSumOddEvenDifference(root.right, level+1, runningSum);
    }

    /**
     * HW5 > Identical Binary Trees
     * @param A
     * @param B
     * @return
     */
    private int isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        } else if (A == null || B == null) {
            return 0;
        }
        int nodeAVal = A.val;
        int nodeBVal = B.val;

        if (nodeAVal == nodeBVal) {
            return 1 * this.isSameTree(A.left, B.left) * this.isSameTree(A.right, B.right);
        } else {
            return 0;
        }
    }

    /**
     * HW6 > Binary Tree From Inorder And Postorder
     * @param postOrder
     * @param inOrder
     * @return
     */
    private TreeNode buildTreeFromPostorderInorder(ArrayList<Integer> postOrder, ArrayList<Integer> inOrder) {
        int n = postOrder.size();
        TreeNode root = null;

        if (n >= 1) {
            //postOrder[n-1] th node is the root node
            root = new TreeNode(postOrder.get(n-1));

            if (n > 1) {
                //Split the Inorder @ root node to LNR -> L = left side, R = right side
                int rootIndexInorder = inOrder.indexOf(root.val);
                ArrayList<Integer> inOrderLeft = this.getSubList(inOrder, 0, rootIndexInorder-1);
                ArrayList<Integer> inOrderRight = this.getSubList(inOrder, rootIndexInorder+1, n-1);
                int rightSize = inOrderRight.size();
                ArrayList<Integer> postOrderLeft = this.getSubList(postOrder, 0, rootIndexInorder-1);
                ArrayList<Integer> postOrderRight = this.getSubList(postOrder, rootIndexInorder, rootIndexInorder+rightSize-1);
                root.left = this.buildTreeFromPostorderInorder(postOrderLeft, inOrderLeft);
                root.right = this.buildTreeFromPostorderInorder(postOrderRight, inOrderRight);
            }

        }
        return root;
    }
}
