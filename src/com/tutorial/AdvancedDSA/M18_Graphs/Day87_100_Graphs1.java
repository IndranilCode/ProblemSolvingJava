package com.tutorial.AdvancedDSA.M18_Graphs;

import java.util.*;

public class Day87_100_Graphs1 {
    public void execute() {
        System.out.println("------------GRAPHS 1--------------");
        System.out.println("------------ASSIGNMENT------------");

        //AS1 > Path in Directed Graph [BFS]
        int inputAS1_A = 5;
        ArrayList<ArrayList<Integer>> inputAS1_B = new ArrayList<>();
        inputAS1_B.add(new ArrayList<>(Arrays.asList(1, 2)));
        inputAS1_B.add(new ArrayList<>(Arrays.asList(4, 1)));
        inputAS1_B.add(new ArrayList<>(Arrays.asList(2, 4)));
        inputAS1_B.add(new ArrayList<>(Arrays.asList(3, 4)));
        inputAS1_B.add(new ArrayList<>(Arrays.asList(5, 2)));
        inputAS1_B.add(new ArrayList<>(Arrays.asList(1, 3)));
        System.out.println("AS1 > Path in Directed Graph [BFS] => " + this.isPathAvailable_DirectedGraph(inputAS1_A, inputAS1_B));

        int inputAS1_A_2 = 5;
        ArrayList<ArrayList<Integer>> inputAS1_B_2 = new ArrayList<>();
        inputAS1_B_2.add(new ArrayList<>(Arrays.asList(1, 2)));
        inputAS1_B_2.add(new ArrayList<>(Arrays.asList(2, 3)));
        inputAS1_B_2.add(new ArrayList<>(Arrays.asList(3, 4)));
        inputAS1_B_2.add(new ArrayList<>(Arrays.asList(4, 5)));
        System.out.println("    > Path in Directed Graph [BFS] => " + this.isPathAvailable_DirectedGraph(inputAS1_A_2, inputAS1_B_2));

        int inputAS1_A_3 = 4;
        ArrayList<ArrayList<Integer>> inputAS1_B_3 = new ArrayList<>();
        inputAS1_B_3.add(new ArrayList<>(Arrays.asList(1, 2)));
        inputAS1_B_3.add(new ArrayList<>(Arrays.asList(2, 3)));
        inputAS1_B_3.add(new ArrayList<>(Arrays.asList(4, 3)));
        System.out.println("    > Path in Directed Graph [BFS] => " + this.isPathAvailable_DirectedGraph(inputAS1_A_3, inputAS1_B_3));

        //AS2 > First Depth First Search
        ArrayList<Integer> inputAS2_A = new ArrayList<>(Arrays.asList(1, 1, 2));
        int input_destination = 1;
        int input_source = 2;
        System.out.println("AS2 > First Depth First Search [DFS] [1, 1, 2] (Source :2 , Destination : 1) => " + this.isReachable_dfs(inputAS2_A, input_destination, input_source));

        ArrayList<Integer> inputAS2_A_2 = new ArrayList<>(Arrays.asList(1, 1, 2));
        int input_destination_2 = 2;
        int input_source_2 = 1;
        System.out.println("    > First Depth First Search [DFS] [1, 1, 2] (Source :1 , Destination : 2) => " + this.isReachable_dfs(inputAS2_A_2, input_destination_2, input_source_2));

        ArrayList<Integer> inputAS2_A_3 = new ArrayList<>(Arrays.asList(1, 1, 1, 3, 3, 4, 6, 5, 3, 3));
        int input_destination_3 = 10;
        int input_source_3 = 3;
        System.out.println("    > First Depth First Search [DFS] [1, 1, 1, 3, 3, 4, 6, 5, 3, 3] (Source :3 , Destination : 10) => " + this.isReachable_dfs(inputAS2_A_3, input_destination_3, input_source_3));

        //---------------HOMEWORK--------------
        System.out.println("---------------HOMEWORK------------------");

        ArrayList<ArrayList<Integer>> inputHW1 = new ArrayList<>();
        inputHW1.add(new ArrayList<>(Arrays.asList(1, 1, 0, 0, 0)));
        inputHW1.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 0)));
        inputHW1.add(new ArrayList<>(Arrays.asList(1, 0, 0, 1 ,1)));
        inputHW1.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0)));
        inputHW1.add(new ArrayList<>(Arrays.asList(1, 0, 1, 0 ,1)));
        System.out.println("HW1 > Number of islands => " + this.number_of_islands(inputHW1));
    }

    /**
     * AS1 > Path in Directed Graph [BFS]
     * @param A
     * @param B
     * @return
     */
    private int isPathAvailable_DirectedGraph(int A, ArrayList<ArrayList<Integer>> B) {
        HashMap<Integer, HashSet<Integer>> adjacencyList = new HashMap<>();

        //Form the adjacency list from input [Source : Map (Destination)]
        for (int i = 0; i < B.size(); i++) {
            ArrayList<Integer> currentEdge = B.get(i);
            int source = currentEdge.get(0);
            int destination = currentEdge.get(1);
            if (!adjacencyList.containsKey(source)) {
                adjacencyList.put(source, new HashSet<Integer>());
            }
            adjacencyList.get(source).add(destination);
        }

        //Visited array +
        boolean[] visitedNode = new boolean[A + 1];
        Arrays.fill(visitedNode, false); //false : unvisited , true : visited

        int source = 1;
        int destination = A;
        Queue<Integer> bfsQ = new LinkedList<>();
        bfsQ.add(source); visitedNode[source] = true;
        while (!bfsQ.isEmpty()) {
            //Pop a node
            int poppedNode = bfsQ.remove();
            if (poppedNode == destination) return 1;
            //Get the neighbours of poppedNode
            HashSet<Integer> neighbours = adjacencyList.get(poppedNode);
            if (neighbours != null) {
                for (Integer eachNeighbour : neighbours) {
                    if (!visitedNode[eachNeighbour]) {
                        bfsQ.add(eachNeighbour);
                    }
                }
            }
        }
        return 0;
    }

    /**
     * AS2 > First Depth First Search
     * You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.
     * Given 2 towns find whether you can reach the first town from the second without repeating any edge.
     * B C : query to find whether B is reachable from C.
     * Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).
     * There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.
     * NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.
     * @param A
     * @param B
     * @param C
     * @return
     */
    private int isReachable_dfs(ArrayList<Integer> A, final int B, final int C) {
        HashMap<Integer, HashSet<Integer>> adjacencyList = new HashMap<>();

        //Form the adjacency list from input [Source : Map (Destination)] // A[i] -> i+1
        for (int i = 0; i < A.size(); i++) {
            int source = A.get(i);
            int destination = i + 1;
            if (!adjacencyList.containsKey(source)) {
                adjacencyList.put(source, new HashSet<Integer>());
            }
            adjacencyList.get(source).add(destination);
        }

        HashSet<Integer> visitedNodes = new HashSet<>();
        int source = C;
        int destination = B; visitedNodes.add(C);
        return dfs_search(C, B, visitedNodes, adjacencyList);
    }
    private int dfs_search(int node, int searchNode, HashSet<Integer> visitedNodes, HashMap<Integer, HashSet<Integer>> adjacencyList) {
        if (node == searchNode) return 1;
        //Find the neighbours of node
        HashSet<Integer> nodeNeighbours = adjacencyList.get(node);
        if (nodeNeighbours != null) {
            for (int eachNeighbour : nodeNeighbours) {
                if (!visitedNodes.contains(eachNeighbour)) {
                    //Neighbour not visited earlier - add it to visited and call dfs
                    visitedNodes.add(eachNeighbour);
                    int returnVal = this.dfs_search(eachNeighbour, searchNode, visitedNodes, adjacencyList);
                    if (returnVal == 1) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    //---------------HOMEWORK--------------

    /**
     * HW1 > Number of islands
     * Given a matrix of integers A of size N x M consisting of 0 and 1.
     * A group of connected 1's forms an island.
     * From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.
     * @param A
     * @return
     */
    private int number_of_islands(ArrayList<ArrayList<Integer>> A) {
        HashMap<Integer, HashSet<Integer>> adjacencyList = new HashMap<>();

        int rows = A.size();
        int cols = A.get(0).size();
        int destNodeNumber;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int nodeNumber = this.getNodeNumber(i ,j, cols);
                if (!adjacencyList.containsKey(nodeNumber)) {
                    adjacencyList.put(nodeNumber, new HashSet<Integer>());
                }

                //If I'm 1 then check 8 neighbours
                if (A.get(i).get(j) == 1) {
                    //Add self loop
                    adjacencyList.get(nodeNumber).add(nodeNumber);

                    //Check its 8 neighbours

                    //Check row above
                    if (i-1 >= 0) {
                        if (j-1 >= 0 && A.get(i-1).get(j-1) == 1) {
                            destNodeNumber = this.getNodeNumber(i-1, j-1, cols);
                            adjacencyList.get(nodeNumber).add(destNodeNumber);
                        }
                        if (A.get(i-1).get(j) == 1) {
                            destNodeNumber = this.getNodeNumber(i-1, j, cols);
                            adjacencyList.get(nodeNumber).add(destNodeNumber);
                        }
                        if (j+1 < cols && A.get(i-1).get(j+1) == 1) {
                            destNodeNumber = this.getNodeNumber(i-1, j+1, cols);
                            adjacencyList.get(nodeNumber).add(destNodeNumber);
                        }
                    }
                    //Check same row
                    if (j-1 >= 0 && A.get(i).get(j-1) == 1) {
                        destNodeNumber = this.getNodeNumber(i, j-1, cols);
                        adjacencyList.get(nodeNumber).add(destNodeNumber);
                    }
                    if (j+1 < cols && A.get(i).get(j+1) == 1) {
                        destNodeNumber = this.getNodeNumber(i, j+1, cols);
                        adjacencyList.get(nodeNumber).add(destNodeNumber);
                    }

                    //Check below row
                    if (i+1 < rows) {
                        if (j-1 >= 0 && A.get(i+1).get(j-1) == 1) {
                            destNodeNumber = this.getNodeNumber(i+1, j-1, cols);
                            adjacencyList.get(nodeNumber).add(destNodeNumber);
                        }
                        if (A.get(i+1).get(j) == 1) {
                            destNodeNumber = this.getNodeNumber(i+1, j, cols);
                            adjacencyList.get(nodeNumber).add(destNodeNumber);
                        }
                        if (j+1 < cols && A.get(i+1).get(j+1) == 1) {
                            destNodeNumber = this.getNodeNumber(i+1, j+1, cols);
                            adjacencyList.get(nodeNumber).add(destNodeNumber);
                        }
                    }
                }

            }
        }

        boolean[] visitedNode = new boolean[rows * cols];
        Arrays.fill(visitedNode, false); //false : unvisited , true : visited

        //Mark all 0 nodes as visited
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int nodeNumber = this.getNodeNumber(i ,j, cols);
                if (A.get(i).get(j) == 0) {
                    visitedNode[nodeNumber] = true;
                }
            }
        }

        int islandCount = 0;
        for (int i = 0; i < (rows * cols); i++) {
            if (!visitedNode[i]) {
                this.dfs_island_parse(i, visitedNode, adjacencyList);
                islandCount++;
            }
        }

        return islandCount;
    }
    private int getNodeNumber(int i, int j, int rowSize) {
        return (i * 1) + (j * 1) + (i * (rowSize - 1));
    }
    private void dfs_island_parse(int sourceNode, boolean[] visitedNode, HashMap<Integer, HashSet<Integer>> adjacencyList) {
        //Find the neighbours of node
        visitedNode[sourceNode] = true; //Mark source node visit = true
        HashSet<Integer> nodeNeighbours = adjacencyList.get(sourceNode);
        if (nodeNeighbours != null) {
            for (int eachNeighbourNodeNumber : nodeNeighbours) {
                if (!visitedNode[eachNeighbourNodeNumber]) {
                    this.dfs_island_parse(eachNeighbourNodeNumber, visitedNode, adjacencyList);
                }
            }
        }
    }
}
