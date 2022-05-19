package com.tutorial.AdvancedDSA.M13_Trees;

import java.util.*;

public class Day66_Trees2 {
    public void execute() {
        System.out.println("---------------Day66_Trees2--------------");
        System.out.println("---------------ASSIGNMENTS---------------");
        //AS1 (OLD) > Level Order (Top-Bottom , Left-Right)
        TreeNode input_AS1_n5 = new TreeNode(7);
        TreeNode input_AS1_n4 = new TreeNode(15);
        TreeNode input_AS1_n3 = new TreeNode(20); input_AS1_n3.left = input_AS1_n4; input_AS1_n3.right = input_AS1_n5;
        TreeNode input_AS1_n2 = new TreeNode(9);
        TreeNode input_AS1_n1 = new TreeNode(3); input_AS1_n1.left = input_AS1_n2; input_AS1_n1.right = input_AS1_n3;
        ArrayList<ArrayList<Integer>> resultAS1 = this.levelOrder(input_AS1_n1);
        System.out.print("AS1 (OLD) > Level Order (Top-Bottom , Left-Right) => ");
        System.out.print("[ ");
        resultAS1.forEach(level -> {
            System.out.print(" [");
            level.forEach(e -> System.out.print(e + ","));
            System.out.print("] ");
        });
        System.out.println("]");

        //AS1 (NEW) > Vertical Order Traversal
        TreeNode input_AS1_new_n12 = new TreeNode(14);
        TreeNode input_AS1_new_n11 = new TreeNode(7); input_AS1_new_n11.right = input_AS1_new_n12;
        TreeNode input_AS1_new_n9 = new TreeNode(5);
        TreeNode input_AS1_new_n10 = new TreeNode(2); input_AS1_new_n10.left = input_AS1_new_n11; input_AS1_new_n10.right = input_AS1_new_n9;
        TreeNode input_AS1_new_n7 = new TreeNode(11);
        TreeNode input_AS1_new_n8 = new TreeNode(3); input_AS1_new_n8.left = input_AS1_new_n7;
        TreeNode input_AS1_new_n6 = new TreeNode(6); input_AS1_new_n6.left = input_AS1_new_n10; input_AS1_new_n6.right = input_AS1_new_n8;
        TreeNode input_AS1_new_n5 = new TreeNode(12);
        TreeNode input_AS1_new_n4 = new TreeNode(1); input_AS1_new_n4.left = input_AS1_new_n5;
        TreeNode input_AS1_new_n2 = new TreeNode(8);
        TreeNode input_AS1_new_n3 = new TreeNode(4); input_AS1_new_n3.left = input_AS1_new_n2; input_AS1_new_n3.right = input_AS1_new_n4;
        TreeNode input_AS1_new_n1 = new TreeNode(9); input_AS1_new_n1.left = input_AS1_new_n6; input_AS1_new_n1.right = input_AS1_new_n3;
        ArrayList<ArrayList<Integer>> verticalOrderResult = this.verticalOrderTraversal2(input_AS1_new_n1);
        System.out.print("AS1 (NEW) - [NON RECURSIVE - RIGHT] > Vertical Order traversal => [ ");
        verticalOrderResult.forEach(eachLevel -> {
            System.out.print("[");
            eachLevel.forEach(e -> System.out.print(e + ","));
            System.out.print("]");
        });
        System.out.println("");

        //AS2 (NEW) > Right View of Binary tree
        System.out.print("AS4 > Right View of Binary tree => [ ");
        ArrayList<Integer> resultAS4 = this.rightViewOfBinaryTree(input_AS1_n1);
        resultAS4.forEach(e -> System.out.print(e + ","));
        System.out.println(" ]");

        //AS3 (NEW) > Top View of Binary Tree
        System.out.print("AS3 (NEW) > Top View of Binary Tree (Input as AS1 (NEW)) => [ ");
        ArrayList<Integer> topViewOfBT = this.topViewOfBinaryTree(input_AS1_new_n1);
        topViewOfBT.forEach(e -> System.out.print(e + ","));
        System.out.println(" ]" );

        //AS4 (NEW) > Balanced Binary Tree
        //System.out.println(this.heightOfBT(input_AS1_new_n1));

        //---------------HOMEWORK--------------
        System.out.println("---------------HOMEWORK------------------");

        //HW1 > ZigZag Level Order Traversal BT
        System.out.print("HW1 > ZigZag Level Order Traversal BT => [ ");
        ArrayList<ArrayList<Integer>> resultHW1 = this.zigZagHorizontalLevelOrderTraversal(input_AS1_new_n1);
        resultHW1.forEach(eachLevel -> {
            System.out.print("[");
            eachLevel.forEach(e -> System.out.print(e + ","));
            System.out.print("]");
        });
        System.out.println("");

        //HW2 > Left View of Binary tree
        System.out.print("HW2 > Left View of Binary tree => [ ");
        ArrayList<Integer> resultAS3 = this.leftViewOfBinaryTree(input_AS1_n1);
        resultAS3.forEach(e -> System.out.print(e + ","));
        System.out.println(" ]");

        //HW3 (NEW) > Odd and Even Levels difference
        TreeNode input_HW3_new_n8 = new TreeNode(8);
        TreeNode input_HW3_new_n7 = new TreeNode(4); input_HW3_new_n7.left = input_HW3_new_n8;
        TreeNode input_HW3_new_n6 = new TreeNode(5);
        TreeNode input_HW3_new_n5 = new TreeNode(2); input_HW3_new_n5.left = input_HW3_new_n7; input_HW3_new_n5.right = input_HW3_new_n6;
        TreeNode input_HW3_new_n4 = new TreeNode(6);
        TreeNode input_HW3_new_n3 = new TreeNode(7);
        TreeNode input_HW3_new_n2 = new TreeNode(3); input_HW3_new_n2.left = input_HW3_new_n4; input_HW3_new_n2.right = input_HW3_new_n3;
        TreeNode input_HW3_new_n1 = new TreeNode(1); input_HW3_new_n1.left = input_HW3_new_n5; input_HW3_new_n1.right = input_HW3_new_n2;
        System.out.println("HW3 (NEW) > Odd and Even Levels difference => " + this.sumDifferenceBetweenOddEvenLevels(input_HW3_new_n1));
    }

    /**
     * AS1 (OLD) > Level Order (Top-Bottom , Left-Right)
     * @param root
     * @return
     */
    private ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> allLevelResult = new ArrayList<>();
        Queue<TreeNode> levelQ = new LinkedList<>();
        levelQ.add(root);
        while (!levelQ.isEmpty()) {
            int queueSize = levelQ.size();
            ArrayList<Integer> levelData = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode poppedNode = levelQ.remove();
                levelData.add(poppedNode.val);
                if (poppedNode.left != null) {
                    levelQ.add(poppedNode.left);
                }
                if (poppedNode.right != null) {
                    levelQ.add(poppedNode.right);
                }
            }
            allLevelResult.add(levelData);
        }
        return allLevelResult;
    }

    //    /**
    //     * AS1 (NEW) - RECURSION APPROACH [PARTIAL TRUE] > Vertical Order traversal
    //     * NOTE: Order of each array should be each vertical level itself ordered by the vertical level (top-bottom)
    //     * NOTE: This solution doesn't orderize each vertical level. Each level is garbled as the top-bottom order isn;t followed
    //     * @param root
    //     * @return
    //     */
    //    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
    //        //HashMap<Integer, ArrayList<Integer>> verticalOrderTraversalMap = new HashMap<>();
    //        HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> verticalOrderTraversalMap = new HashMap<>();
    //        this.iterateTreeToPopulateVerticalOrder(root, 0, 0, verticalOrderTraversalMap);
    //        int lowestVLevel = Integer.MAX_VALUE;
    //        int highestVLevel = Integer.MIN_VALUE;
    //        for (Integer level : verticalOrderTraversalMap.keySet()) {
    //            if (level >= highestVLevel) highestVLevel = level;
    //            if (level <= lowestVLevel) lowestVLevel = level;
    //        }
    //
    //        ArrayList<ArrayList<Integer>> allLevelParseResult = new ArrayList<>();
    //        for (int i = lowestVLevel; i <= highestVLevel; i++) {
    //            int lowestHLevel = Integer.MAX_VALUE;
    //            int highestHLevel = Integer.MIN_VALUE;
    //            for (Integer hLevel : verticalOrderTraversalMap.get(i).keySet()) {
    //                if (hLevel >= highestHLevel) highestHLevel = hLevel;
    //                if (hLevel <= lowestHLevel) lowestHLevel = hLevel;
    //            }
    //            ArrayList<Integer> thisHLevelParseResult = new ArrayList<>();
    //            for (int j = lowestHLevel; j <= highestHLevel; j++) {
    //                if (verticalOrderTraversalMap.get(i).containsKey(j)) {
    //                    thisHLevelParseResult.add(verticalOrderTraversalMap.get(i).get(j).get(0));
    //                }
    //            }
    //
    //            allLevelParseResult.add(thisHLevelParseResult);
    //        }
    //        return allLevelParseResult;
    //    }
    //    private void iterateTreeToPopulateVerticalOrder(TreeNode root, int level, int horizontalLevel, HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> verticalOrderTraversalMap) {
    //        if (root == null) return;
    //        int currentLevel = level;
    //        int currentHorizontalLevel = horizontalLevel;
    //        if (!verticalOrderTraversalMap.containsKey(level)) {
    //            verticalOrderTraversalMap.put(currentLevel, new HashMap<Integer, ArrayList<Integer>>());
    //            if (!verticalOrderTraversalMap.get(level).containsKey(horizontalLevel)) {
    //                verticalOrderTraversalMap.get(level).put(currentHorizontalLevel, new ArrayList<>());
    //            }
    //        }
    //        verticalOrderTraversalMap.get(currentLevel).get(horizontalLevel).add(root.val);
    //        this.iterateTreeToPopulateVerticalOrder(root.left, currentLevel - 1, horizontalLevel + 1, verticalOrderTraversalMap);
    //        this.iterateTreeToPopulateVerticalOrder(root.right, currentLevel + 1, horizontalLevel + 1, verticalOrderTraversalMap);
    //    }

    /**
     * AS1 (NEW) - [NON RECURSIVE - RIGHT] > Vertical Order traversal
     * @param root
     * @return
     */
    private ArrayList<ArrayList<Integer>> verticalOrderTraversal2(TreeNode root) {
        Queue<HashMap<Integer, TreeNode>> traversalQ = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> verticalOrderMap = new HashMap<>();
        int horizontalLevel = 0;
        HashMap<Integer, TreeNode> rootData = new HashMap<>(); rootData.put(horizontalLevel, root);
        traversalQ.add(rootData);
        while (!traversalQ.isEmpty()) {
            int itemsToPop = traversalQ.size();
            for (int i = 0; i < itemsToPop; i++) {
                //Pop the elements of this vertical level
                HashMap<Integer, TreeNode> poppedNodeAndVerticalLevel = traversalQ.remove(); //Hashmap will always contain 1 element (vLevel, Node)
                //Put the Node.val to the hashmap of (vLevel, Node.val)
                Integer poppedNodeVLevel = poppedNodeAndVerticalLevel.keySet().stream().findFirst().get();
                TreeNode poppedNode = poppedNodeAndVerticalLevel.values().stream().findFirst().get();
                Integer poppedNodeValue = poppedNode.val;
                if (!verticalOrderMap.containsKey(poppedNodeVLevel)) {
                    verticalOrderMap.put(poppedNodeVLevel, new ArrayList<>());
                }
                verticalOrderMap.get(poppedNodeVLevel).add(poppedNodeValue);
                //Push the node.left (vLevel of extracted node - 1) & node.right (vLevel of extracted node + 1)
                if (poppedNode.left != null) {
                    HashMap<Integer, TreeNode> nodeAndVLevelToAddLeft = new HashMap<>();
                    nodeAndVLevelToAddLeft.put(poppedNodeVLevel - 1, poppedNode.left);
                    traversalQ.add(nodeAndVLevelToAddLeft);
                }
                if (poppedNode.right != null) {
                    HashMap<Integer, TreeNode> nodeAndVLevelToAddRight = new HashMap<>();
                    nodeAndVLevelToAddRight.put(poppedNodeVLevel + 1, poppedNode.right);
                    traversalQ.add(nodeAndVLevelToAddRight);
                }
            }
        }

        int lowestVLevel = Integer.MAX_VALUE;
        int highestVLevel = Integer.MIN_VALUE;
        for (Integer level : verticalOrderMap.keySet()) {
            if (level >= highestVLevel) highestVLevel = level;
            if (level <= lowestVLevel) lowestVLevel = level;
        }
        ArrayList<ArrayList<Integer>> allLevelParseResult = new ArrayList<>();
        for (int i = lowestVLevel; i <= highestVLevel; i++) {
            allLevelParseResult.add(verticalOrderMap.get(i));
        }
        return allLevelParseResult;
    }


    /**
     * AS2 (NEW) > Right View of Binary tree
     * @param root
     * @return
     */
    private ArrayList<Integer> rightViewOfBinaryTree(TreeNode root) {
        ArrayList<Integer> rightViewResult = new ArrayList<>();
        Queue<TreeNode> levelQ = new LinkedList<>();
        levelQ.add(root);
        while (!levelQ.isEmpty()) {
            int queueSize = levelQ.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode poppedNode = levelQ.remove();
                if (i == (queueSize-1)) rightViewResult.add(poppedNode.val);
                if (poppedNode.left != null) {
                    levelQ.add(poppedNode.left);
                }
                if (poppedNode.right != null) {
                    levelQ.add(poppedNode.right);
                }
            }
        }
        return rightViewResult;
    }

    /**
     * AS3 (NEW) > Top View of Binary Tree [UNORDERED RESULT]
     * @param root
     * @return
     */
    private ArrayList<Integer> topViewOfBinaryTree(TreeNode root) {
        HashMap<Integer, Integer> topViewElementMap = new HashMap<>();
        this.iterateTreeToPopulateTopView(root, 0, topViewElementMap);

        int lowestVLevel = Integer.MAX_VALUE;
        int highestVLevel = Integer.MIN_VALUE;
        for (Integer level : topViewElementMap.keySet()) {
            if (level >= highestVLevel) highestVLevel = level;
            if (level <= lowestVLevel) lowestVLevel = level;
        }
        ArrayList<Integer> topViewBTResult = new ArrayList<>();
        for (int i = lowestVLevel; i <= highestVLevel; i++) {
            topViewBTResult.add(topViewElementMap.get(i));
        }
        return topViewBTResult;
    }
    private void iterateTreeToPopulateTopView(TreeNode root, int level, HashMap<Integer, Integer> topViewElementMap) {
        if (root == null) return;
        if (!topViewElementMap.containsKey(level)) {
            topViewElementMap.put(level, root.val);
        }
        this.iterateTreeToPopulateTopView(root.left, level - 1, topViewElementMap);
        this.iterateTreeToPopulateTopView(root.right, level + 1, topViewElementMap);
    }

    /**
     * AS3 (NEW) > Top View of Binary Tree [ORDERED RESULT] [CORRECT]
     * @param root
     * @return
     */
    private ArrayList<Integer> topViewOfBinaryTree_withQueue(TreeNode root) {
        HashMap<Integer, ArrayList<Integer>> vertOrderTraversalMap = new HashMap<>();

        Queue<HashMap<Integer, TreeNode>> traversalQ = new LinkedList<>();
        int hLevel = 0;
        HashMap<Integer,TreeNode> rootLevel = new HashMap<>(); rootLevel.put(hLevel, root); traversalQ.add(rootLevel);
        while (!traversalQ.isEmpty()) {

            int qSize = traversalQ.size();
            for (int i = 0; i < qSize; i++) {
                HashMap<Integer,TreeNode> dequeuedNode = traversalQ.remove();
                int deqLevel = dequeuedNode.keySet().stream().findFirst().get();
                TreeNode deqNode = dequeuedNode.values().stream().findFirst().get();

                //Add the popped node to Hashmap with level
                if (!vertOrderTraversalMap.containsKey(deqLevel)) {
                    vertOrderTraversalMap.put(deqLevel, new ArrayList<>());
                }
                vertOrderTraversalMap.get(deqLevel).add(deqNode.val);

                //Add left n right nodes (if present)
                if (deqNode.left != null) {
                    HashMap<Integer, TreeNode> nodeAndVLevelToAddLeft = new HashMap<>();
                    nodeAndVLevelToAddLeft.put(deqLevel - 1, deqNode.left);
                    traversalQ.add(nodeAndVLevelToAddLeft);
                }
                if (deqNode.right != null) {
                    HashMap<Integer, TreeNode> nodeAndVLevelToAddRight = new HashMap<>();
                    nodeAndVLevelToAddRight.put(deqLevel + 1, deqNode.right);
                    traversalQ.add(nodeAndVLevelToAddRight);
                }
            }
        }

        int lowestVLevel = Integer.MAX_VALUE;
        int highestVLevel = Integer.MIN_VALUE;
        for (Integer level : vertOrderTraversalMap.keySet()) {
            if (level >= highestVLevel) highestVLevel = level;
            if (level <= lowestVLevel) lowestVLevel = level;
        }

        ArrayList<Integer> topLevelResult = new ArrayList<>();
        for (int i = lowestVLevel; i <= highestVLevel; i++) {
            topLevelResult.add(vertOrderTraversalMap.get(i).get(0));
        }
        return topLevelResult;
    }


    /**
     * AS4 (NEW) > Balanced Binary Tree
     * A height-balanced binary tree is defined as a binary tree in which the
     * depth of the two subtrees of every node never differ by more than 1.
     * @param root
     * @return
     */
    private int isBalancedBT(TreeNode root) {
        if (root == null) return 1;

        int leftHeight = this.heightOfBT(root.left);
        int rightHeight = this.heightOfBT(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return 0;
        } else {
            return 1 * this.isBalancedBT(root.left) * this.isBalancedBT(root.right);
        }
    }
    private int heightOfBT(TreeNode root) {
        if (root == null) return -1;
        int leftHeight = this.heightOfBT(root.left);
        int rightHeight = this.heightOfBT(root.right);
        return 1 + Integer.max(leftHeight, rightHeight);
    }

    //---------------HOMEWORK--------------

    /**
     * HW1 > ZigZag Level Order Traversal BT
     * Given a binary tree, return the zigzag level order traversal of its nodes values.
     * (ie, from left to right, then right to left for the next level and alternate between).
     * @param root
     * @return
     */
    private ArrayList<ArrayList<Integer>> zigZagHorizontalLevelOrderTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> zigZagLevelOrderTraversal = new ArrayList<>();
        Queue<TreeNode> traversalQ = new LinkedList<>();
        int currentLevel = 1;
        traversalQ.add(root);
        while (!traversalQ.isEmpty()) {
            int totalNodesToPop =  traversalQ.size();
            ArrayList<Integer> currentLevelNodes = new ArrayList<>();
            for (int i = 0; i < totalNodesToPop; i++) {
                //Pop the node
                TreeNode poppedNode = traversalQ.remove();
                currentLevelNodes.add(poppedNode.val);
                if (poppedNode.left != null) {
                    traversalQ.add(poppedNode.left);
                }
                if (poppedNode.right != null) {
                    traversalQ.add(poppedNode.right);
                }
            }
            if (currentLevel % 2 == 0) {
                //Even level - reverse the array currentLevelNodes
                currentLevelNodes = this.reverseArrayList(currentLevelNodes);
            }
            zigZagLevelOrderTraversal.add(currentLevelNodes);
            currentLevel++;
        }
        return zigZagLevelOrderTraversal;
    }
    private ArrayList<Integer> reverseArrayList(ArrayList<Integer> originalArrayList) {
        ArrayList<Integer> reverseList = new ArrayList<>();
        for (int i = originalArrayList.size() - 1; i >= 0; i--) {
            reverseList.add(originalArrayList.get(i));
        }
        return reverseList;
    }

    /**
     * HW2 (NEW) > Left View of Binary tree
     * @param root
     * @return
     */
    private ArrayList<Integer> leftViewOfBinaryTree(TreeNode root) {
        ArrayList<Integer> leftViewResult = new ArrayList<>();
        Queue<TreeNode> levelQ = new LinkedList<>();
        levelQ.add(root);
        while (!levelQ.isEmpty()) {
            int queueSize = levelQ.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode poppedNode = levelQ.remove();
                if (i == 0) leftViewResult.add(poppedNode.val);
                if (poppedNode.left != null) {
                    levelQ.add(poppedNode.left);
                }
                if (poppedNode.right != null) {
                    levelQ.add(poppedNode.right);
                }
            }
        }
        return leftViewResult;
    }

    /**
     * HW2 (OLD) > Reverse Level Order
     * @param root
     * @return
     */
    private ArrayList<Integer> reverseLevelOrder(TreeNode root) {
        ArrayList<Integer> reverseLevelOrder = new ArrayList<>();
        Queue<TreeNode> orderQueue = new LinkedList<>();
        Stack<Integer> orderStack = new Stack<>();
        orderQueue.add(root);
        while (!orderQueue.isEmpty()) {
            int qSize = orderQueue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode currentRemovedElement = orderQueue.remove();
                orderStack.add(currentRemovedElement.val);
                if (currentRemovedElement.right != null) {
                    orderQueue.add(currentRemovedElement.right);
                }
                if (currentRemovedElement.left != null) {
                    orderQueue.add(currentRemovedElement.left);
                }
            }
        }
        while (!orderStack.empty()) {
            reverseLevelOrder.add(orderStack.pop());
        }
        return reverseLevelOrder;
    }

    /**
     * HW3 (NEW) > Odd and Even Levels difference
     * Find the difference between the sum of nodes at odd level and sum of nodes at even level.
     * NOTE: Consider the level of root node as 1.
     * @param root
     * @return
     */
    private int sumDifferenceBetweenOddEvenLevels(TreeNode root) {
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


    //    private int isSumBinaryTree(TreeNode root) {
    //        if (root == null) return 0;
    //        int leftChildSum =
    //        int sumOfChildren =
    //    }

    /**
     * HW6 > Symmetric Binary Tree
     * @param root
     * @return
     */
    private int isBTSymmetric(TreeNode root) {
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
     * HW7 > Invert the Binary Tree
     * @param root
     * @return
     */
    private TreeNode laterallyInvertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode convertedNode = new TreeNode(root.val);
        convertedNode.left = this.laterallyInvertTree(root.right);
        convertedNode.right = this.laterallyInvertTree(root.left);
        return convertedNode;
    }
}
