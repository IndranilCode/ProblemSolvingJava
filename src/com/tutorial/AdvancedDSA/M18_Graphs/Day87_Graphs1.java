package com.tutorial.AdvancedDSA.M18_Graphs;

import java.util.*;

public class Day87_Graphs1 {
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
}
