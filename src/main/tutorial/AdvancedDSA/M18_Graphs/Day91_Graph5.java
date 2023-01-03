package main.tutorial.AdvancedDSA.M18_Graphs;

import java.util.*;

public class Day91_Graph5 {
    public void execute() {
        System.out.println("---------------------Day 91 : Graphs 5 ----------------------");
        System.out.println("--------------------------CLASSWORK--------------------------");

        System.out.println("--------------------------ASSIGNMENT-------------------------");

        //AS1 > Dijsktra
        ArrayList<ArrayList<Integer>> inputAS1_edgeWeight1 = new ArrayList<>();
        inputAS1_edgeWeight1.add(new ArrayList<>(Arrays.asList(0, 4, 9)));
        inputAS1_edgeWeight1.add(new ArrayList<>(Arrays.asList(3, 4, 6)));
        inputAS1_edgeWeight1.add(new ArrayList<>(Arrays.asList(1, 2, 1)));
        inputAS1_edgeWeight1.add(new ArrayList<>(Arrays.asList(2, 5, 1)));
        inputAS1_edgeWeight1.add(new ArrayList<>(Arrays.asList(2, 4, 5)));
        inputAS1_edgeWeight1.add(new ArrayList<>(Arrays.asList(0, 3, 7)));
        inputAS1_edgeWeight1.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
        inputAS1_edgeWeight1.add(new ArrayList<>(Arrays.asList(4, 5, 7)));
        inputAS1_edgeWeight1.add(new ArrayList<>(Arrays.asList(0, 5, 1)));
        System.out.println("AS1 > Dijsktra (N = 6 ; Source = 4) => " + this.dijkstras_shortestDistance(6, inputAS1_edgeWeight1, 4));

        //AS2 > Floyd Warshall Algorithm
        ArrayList<ArrayList<Integer>> inputAS2_edgeWeight1 = new ArrayList<>();
        inputAS2_edgeWeight1.add(new ArrayList<>(Arrays.asList(0, 5, -1, 10)));
        inputAS2_edgeWeight1.add(new ArrayList<>(Arrays.asList(-1, 0, 3, -1)));
        inputAS2_edgeWeight1.add(new ArrayList<>(Arrays.asList(-1, -1, 0, 1)));
        inputAS2_edgeWeight1.add(new ArrayList<>(Arrays.asList(-1, -1, -1, 0)));
        System.out.println("AS2 > Floyd Warshall Algorithm => " + this.floydWarshallAlgorithm(inputAS2_edgeWeight1));

        System.out.println("--------------------------HOMEWORK---------------------------");

        //HW2 > Sheldon and Pair of Cities
        System.out.println("HW2 > Sheldon and Pair of Cities => DONE");
    }

    /**
     * AS1 > Dijsktra
     */
    private class Node implements Comparator<Node> {
        int node;
        int cost;

        public Node() { }

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.cost < o2.cost) {
                return -1;
            } else if (o1.cost > o2.cost) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    private ArrayList<Integer> dijkstras_shortestDistance(int nodeCount, ArrayList<ArrayList<Integer>> edgeWeight, int source) {
        //Build the adjacency list
        HashMap<Integer, ArrayList<Node>> adjList = new HashMap<>();
        for (int i = 0; i < nodeCount; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edgeWeight.size(); i++) {
            int src = edgeWeight.get(i).get(0);
            int dest = edgeWeight.get(i).get(1);
            int weight = edgeWeight.get(i).get(2);

            //Edge from source -> dest (weight)
            //Same edge dest -> source (weight) =>undirected graph
            adjList.get(src).add(new Node(dest, weight));
            adjList.get(dest).add(new Node(src, weight));
        }

        //BestWeightArray - init to MAX (except source = 0) for betterment going ahead
        int[] bestWeight = new int[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            bestWeight[i] = Integer.MAX_VALUE;
        }
        bestWeight[source] = 0;

        //Build PR to hold nodes
        PriorityQueue<Node> pq = new PriorityQueue<>(nodeCount, new Node());

        //Find all neighbours of source - update distance to neighbour(s) temporarily + put to PQ
        ArrayList<Node> sourceNeighbours = adjList.get(source);
        for (Node eachSourceNeighbour : sourceNeighbours) {
            //Temp update best weight (of neighbour)
            bestWeight[eachSourceNeighbour.node] = eachSourceNeighbour.cost;
            //Add node to PR for further processing
            pq.add(new Node(eachSourceNeighbour.node, eachSourceNeighbour.cost));
        }

        while (!pq.isEmpty()) {
            //Pop the Node from PQ (lowest weight)
            Node popNode = pq.remove();

            //Explore neighbours of popNode (min Node)
            for (Node poppedNeighbour : adjList.get(popNode.node)) {
                //Calc weight to poppedNeighbour
                int weight = bestWeight[popNode.node] + poppedNeighbour.cost;
                if (weight < bestWeight[poppedNeighbour.node]) {
                    //Better weight found - update + add to PQ
                    bestWeight[poppedNeighbour.node] = weight;
                    pq.add(new Node(poppedNeighbour.node, weight));
                }
            }
        }

        //Remaining Int.MAX is unreachable (-1)
        ArrayList<Integer> bestWeights = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {
            if (bestWeight[i] != Integer.MAX_VALUE) {
                bestWeights.add(bestWeight[i]);
            } else {
                bestWeights.add(-1);
            }
        }
        return bestWeights;
    }

    /**
     * AS2 > Floyd Warshall Algorithm
     * @param A
     * @return
     */
    private ArrayList<ArrayList<Integer>> floydWarshallAlgorithm(ArrayList<ArrayList<Integer>> A) {
        int vertices = A.size();

        //Disconnected edges - update as high int
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (A.get(i).get(j) == -1) {
                    A.get(i).set(j, 10000000);
                }
            }
        }

        // Intermediate vertex (0 - v-1)
        for (int k = 0; k < vertices; k++) {
            // Source vertex (0 - v-1)
            for (int i = 0; i < vertices; i++) {
                // Source vertex (0 - v-1)
                for (int j = 0; j < vertices; j++) {
                    if (A.get(i).get(k) + A.get(k).get(j) < A.get(i).get(j)) {
                        A.get(i).set(j, A.get(i).get(k) + A.get(k).get(j));
                    }
                }
            }
        }

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (A.get(i).get(j) == 10000000) {
                    A.get(i).set(j, -1);
                }
            }
        }

        return A;
    }


    //-------------------------HOMEWORK--------------------------

    /**
     * HW2 > Sheldon and Pair of Cities
     * Sheldon lives in a country with A cities (numbered from 1 to A) and B bidirectional roads.
     * Roads are denoted by integer array D, E and F of size M, where D[i] and E[i] denotes the cities and F[i] denotes the distance between the cities.
     * Now he has many lectures to give in the city and is running short of time, so he asked you C queries,
     * for each query i, find the shortest distance between city G[i] and H[i].
     * If the two cities are not connected then the distance between them is assumed to be -1.
     * @param A
     * @param B
     * @param C
     * @param D
     * @param E
     * @param F
     * @param G
     * @param H
     * @return
     */
    private ArrayList<Integer> sheldonPairOfCities(int A, int B, int C, ArrayList<Integer> D, ArrayList<Integer> E, ArrayList<Integer> F, ArrayList<Integer> G, ArrayList<Integer> H) {
        //A : No of cities (1 - A)
        //B : Bidirectional roads count
        //D, E, F : D[i] source , E[i] destination, F[i] = distance (cost) [NOTE : Same edge might occur again with different values]
        //G, H : C #of queries as G,H where G[i] is source , H[i] is destination

        //PROCESS: Prepare the matrix and apply floyd warshalls algo - get the min distance b/w all pair of cities

        //Prepare the distance matrix
        int[][] matrix = new int[A + 1][A + 1];
        //Initially all are disconnected (asif) [1000001]
        for (int[] row : matrix) {
            Arrays.fill(row, 1000001);
        }
        //City i to i should be 0 (ie diagonal)
        for (int i = 1; i <= A; i++) {
            matrix[i][i] = 0;
        }
        //Parse the edge & weight arrays
        for (int i = 0; i < D.size(); i++) {
            int source = D.get(i);
            int destination = E.get(i);
            int distance = F.get(i);
            //Populate the weight in the matrix (source- dest & dest- source)
            matrix[source][destination] = Math.min(distance, matrix[source][destination]);
            matrix[destination][source] = Math.min(distance, matrix[source][destination]);
        }

        //Run floyd warshalls to prepare the data (lowest distance b/w any pair)
        // Intermediate vertex (0 - v-1)
        for (int k = 1; k <= A; k++) {
            // Source vertex (0 - v-1)
            for (int i = 1; i <= A; i++) {
                // Dest vertex (0 - v-1)
                for (int j = 1; j <= A; j++) {
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }

        //Re-update disconnected edges as -1
        for (int i = 1; i <= A; i++) {
            for (int j = 1; j <= A; j++) {
                if (matrix[i][j] == 1000001) {
                    matrix[i][j] = -1;
                }
            }
        }

        ArrayList<Integer> allQueryDistances = new ArrayList<>();
        //Now parse all queries and do the lookup
        for (int i = 0; i < G.size(); i++) {
            int source = G.get(i);
            int destination = H.get(i);
            allQueryDistances.add(matrix[source][destination]);
        }
        return allQueryDistances;
    }
}
