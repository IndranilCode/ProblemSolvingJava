package main.tutorial.AdvancedDSA.M18_Graphs;

import java.util.*;

public class Day90_Graph4 {
    public void execute() {
        System.out.println("---------------------Day 90 : Graphs 4 ----------------------");
        System.out.println("--------------------------ASSIGNMENT-------------------------");

        //AS2 > Commutable Islands
        ArrayList<ArrayList<Integer>> inputAS2_edgeWeight1 = new ArrayList<>();
        inputAS2_edgeWeight1.add(new ArrayList<>(Arrays.asList(1, 2, 1)));
        inputAS2_edgeWeight1.add(new ArrayList<>(Arrays.asList(2, 3, 4)));
        inputAS2_edgeWeight1.add(new ArrayList<>(Arrays.asList(1, 4, 3)));
        inputAS2_edgeWeight1.add(new ArrayList<>(Arrays.asList(4, 3, 2)));
        inputAS2_edgeWeight1.add(new ArrayList<>(Arrays.asList(1, 3, 10)));
        System.out.println("AS2 > Commutable Islands (N = 4) => " + this.commutableIslandsTotalCost(4, inputAS2_edgeWeight1));

        System.out.println("--------------------------HOMEWORK---------------------------");
    }

    /**
     * AS2 > Commutable Islands
     * There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.
     * We need to find bridges with minimal cost such that all islands are connected.
     * It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.
     */
    private class Node implements Comparator<Node> {
        int source;
        int destination;
        int cost;

        public Node() {

        }

        public Node(int source, int destination, int cost) {
            this.source = source;
            this.destination = destination;
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
    private int commutableIslandsTotalCost(int n, ArrayList<ArrayList<Integer>> edgeWeights) {
        //PROCESS: Build Min heap of all nodes
        //Pop cheapest node and add the edge - check for cycle formation - if cycle reject the edge
        PriorityQueue<Node> pq = new PriorityQueue<>(n, new Node());
        for (int i = 0; i < edgeWeights.size(); i++) {
            pq.add(new Node(edgeWeights.get(i).get(0), edgeWeights.get(i).get(1), edgeWeights.get(i).get(2)));
        }

        int totalVisited = 1;
        int totalCost = 0;

//        //Add the edges to check cycle
//        ArrayList<ArrayList<Integer>> edges
//        HashMap<Integer, ArrayList<Integer>> dynamicAdjList = new HashMap<>();
//        HashMap<Integer, ArrayList<Integer>> dynamicAdjListCopy = new HashMap<>();
//        for(int i = 1; i <= n; i++) {
//            dynamicAdjListCopy.put(i, new ArrayList<>());
//        }
//
//        //While not all nodes are connected
//        while (totalVisited != n) {
//            //Pop cheapest node
//            Node poppedNode = pq.remove();
//
//            //Add poppedNode to the dynamicAdjListCopy - check for cycle
//            dynamicAdjListCopy.get(poppedNode.source).add(poppedNode.destination);
//            dynamicAdjListCopy.get(poppedNode.destination).add(poppedNode.source);
//
//        }

        //Add the edges to check cycle
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        //While not all nodes are connected
        while (totalVisited != n && !pq.isEmpty()) {
            //Pop cheapest node
            Node poppedNode = pq.remove();

            //Add poppedNode to the dynamicAdjListCopy - check for cycle
            edges.add(new ArrayList<>(Arrays.asList(poppedNode.source, poppedNode.destination)));
            if (this.isCycleInUndirectedGraph_dfs(n, edges) == 1) {
                //Cycle found - reject the edge - don't count as visited
                edges.remove(edges.size() - 1);
            } else {
                totalVisited++;
                totalCost = totalCost + poppedNode.cost;
            }
        }

        return totalCost;
    }
    private int isCycleInUndirectedGraph_dfs(int A, ArrayList<ArrayList<Integer>> B) {
        HashMap<Integer, HashSet<Integer>> adjacencyList = new HashMap<>();

        //Build adjacency list
        for (int i = 1; i <= A; i++) {
            adjacencyList.put(i, new HashSet<>());
        }
        for (int i = 0; i < B.size(); i++) {
            int source = B.get(i).get(0);
            int destination = B.get(i).get(1);
            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source);
        }

        Boolean[] visitedNodes = new Boolean[A + 1];
        Arrays.fill(visitedNodes, false);  // false : unvisited, true : visited

        //Start DFS
        for (int i = 1; i <= A; i++) {
            //Only process unvisited nodes
            if (!visitedNodes[i]) {
                int returnVal = this.isCyclic(i, i, visitedNodes, adjacencyList);
                if (returnVal == 1) {
                    return 1;
                }
            }
        }
        return 0;
    }
    private int isCyclic(Integer node, Integer parent, Boolean[] visitedNodes, HashMap<Integer, HashSet<Integer>> adjacencyList) {
        visitedNodes[node] = true;

        //Get neighbors of node
        HashSet<Integer> neighbours = adjacencyList.get(node);
        for (int eachNeighbour : neighbours) {
            if (eachNeighbour != parent && visitedNodes[eachNeighbour]) {
                return 1;
            } else if (!visitedNodes[eachNeighbour]) {
                if (this.isCyclic(eachNeighbour, node, visitedNodes, adjacencyList) == 1) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
