package main.tutorial.AdvancedDSA.M18_Graphs;

import java.util.*;

public class Day88_101_Graphs2 {
    public void execute() {
        System.out.println("------------GRAPHS 2--------------");
        System.out.println("------------ASSIGNMENT------------");

        //AS2 > Coloring a Cycle Graph
        System.out.println("AS2 > Coloring a Cycle Graph : min no of colours (n = 5) => " + this.colouringCyclicGraph_minColours(5));

        //AS3 > Check Bipartite Graph
        int inputAS3_A = 3;
        ArrayList<ArrayList<Integer>> inputAS3_B = new ArrayList<>();
        inputAS3_B.add(new ArrayList<>(Arrays.asList(0, 1)));
        inputAS3_B.add(new ArrayList<>(Arrays.asList(0, 2)));
        inputAS3_B.add(new ArrayList<>(Arrays.asList(1, 2)));
        System.out.println("AS3 > Check Bipartite Graph => " + this.checkBipartiteGraph(inputAS3_A, inputAS3_B));

        int inputAS3_A_2 = 9;
        ArrayList<ArrayList<Integer>> inputAS3_B_2 = new ArrayList<>();
        inputAS3_B_2.add(new ArrayList<>(Arrays.asList(2, 5)));
        inputAS3_B_2.add(new ArrayList<>(Arrays.asList(6, 7)));
        inputAS3_B_2.add(new ArrayList<>(Arrays.asList(4, 8)));
        inputAS3_B_2.add(new ArrayList<>(Arrays.asList(2, 3)));
        inputAS3_B_2.add(new ArrayList<>(Arrays.asList(0, 3)));
        inputAS3_B_2.add(new ArrayList<>(Arrays.asList(4, 7)));
        inputAS3_B_2.add(new ArrayList<>(Arrays.asList(1, 8)));
        inputAS3_B_2.add(new ArrayList<>(Arrays.asList(3, 8)));
        inputAS3_B_2.add(new ArrayList<>(Arrays.asList(1, 3)));
        System.out.println("    > Check Bipartite Graph => " + this.checkBipartiteGraph(inputAS3_A_2, inputAS3_B_2));

        //AS4 > Construct Roads - Bipartite Graph
        int inputAS4_A = 5;
        ArrayList<ArrayList<Integer>> inputAS4_B = new ArrayList<>();
        inputAS4_B.add(new ArrayList<>(Arrays.asList(1, 3)));
        inputAS4_B.add(new ArrayList<>(Arrays.asList(1, 4)));
        inputAS4_B.add(new ArrayList<>(Arrays.asList(3, 2)));
        inputAS4_B.add(new ArrayList<>(Arrays.asList(3, 5)));
        System.out.println("AS4 > Construct Roads - Bipartite Graph => " + this.constructRoads_BipartiteGraph(inputAS4_A, inputAS4_B));

        //AS5 > Cycle in Undirected Graph DFS [Pass parent]
        int inputAS5_A = 5;
        ArrayList<ArrayList<Integer>> inputAS5_B = new ArrayList<>();
        inputAS5_B.add(new ArrayList<>(Arrays.asList(1, 2)));
        inputAS5_B.add(new ArrayList<>(Arrays.asList(1, 3)));
        inputAS5_B.add(new ArrayList<>(Arrays.asList(2, 3)));
        inputAS5_B.add(new ArrayList<>(Arrays.asList(1, 4)));
        inputAS5_B.add(new ArrayList<>(Arrays.asList(4, 5)));
        System.out.println("AS5 > Cycle in Undirected Graph [DFS] => " + this.isCycleInUndirectedGraph_dfs(inputAS5_A, inputAS5_B));

        int inputAS5_A_2 = 2;
        ArrayList<ArrayList<Integer>> inputAS5_B_2 = new ArrayList<>();
        inputAS5_B.add(new ArrayList<>(Arrays.asList(1, 2)));
        System.out.println("    > Cycle in Undirected Graph DFS [Pass parent] => " + this.isCycleInUndirectedGraph_dfs(inputAS5_A_2, inputAS5_B_2));
    }

    /**
     * AS2 > Coloring a Cycle Graph
     * Given the number of vertices A in a Cyclic Graph.
     * Your task is to determine the minimum number of colors required to color the graph so that no two Adjacent vertices have the same color.
     * @param A
     * @return
     */
    private int colouringCyclicGraph_minColours(int A) {
        //Observation - Even node - 2 colours , Odd nodes - 3 colours
        int colours = 0;
        if (A == 1) {
            colours = 1;
        } else if (A % 2 == 0) {
            //Even nodes
            colours = 2;
        } else {
            colours = 3;
        }
        return colours;
    }

    /**
     * AS3 > Check Bipartite Graph
     * @param A
     * @param B
     * @return
     */
    private int checkBipartiteGraph(int A, ArrayList<ArrayList<Integer>> B) {
        HashMap<Integer, HashSet<Integer>> adjacencyList = new HashMap<>();

        //Build adjacency list
        for (int i = 0; i < A; i++) {
            adjacencyList.put(i, new HashSet<Integer>());
        }
        for (int i = 0; i < B.size(); i++) {
            int source = B.get(i).get(0);
            int destination = B.get(i).get(1);
            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source);
        }

        Integer[] colouredNodes = new Integer[A];
        Arrays.fill(colouredNodes, 0);  // 0 : Unvisited , 1:  Set1 , 2 : Set2

        //Graph can be disconnected - so parse all nodes
        for (int i = 0; i < A; i++) {
            Queue<Integer> bfsQ = new LinkedList<>();

            int existingColor = colouredNodes[i];
            if (existingColor != 0) {
                continue;
            }

            //Start BFS with node 0 & put into Set1
            bfsQ.add(i); colouredNodes[i] = 1;
            while (!bfsQ.isEmpty()) {
                //Pop a node
                int poppedNode = bfsQ.remove();
                //Get the Set of poppedNode
                int poppedNodeSet = colouredNodes[poppedNode];
                int otherSet = poppedNodeSet == 1 ? 2 : 1;

                //Get the neighbours of poppedNode
                HashSet<Integer> neighbours = adjacencyList.get(poppedNode);
                for (Integer eachNeighbour : neighbours) {
                    int neighbourColour = colouredNodes[eachNeighbour];

                    if (neighbourColour == 0) { //If unvisited - mark as other set
                        colouredNodes[eachNeighbour] = otherSet;
                        bfsQ.add(eachNeighbour);
                    } else { //Visited - validate colour
                        if (neighbourColour != otherSet) {
                            return 0; //Colour mismatch - return non-bipartite
                        }
                    }
                }
            }
        }

        return 1;
    }

    /**
     * AS4 > Construct Roads - Bipartite Graph
     * Country consist of N cities connected by N - 1 roads.
     * King of that country want to construct maximum number of roads such that the new country formed remains bipartite country.
     * @param A
     * @param B
     * @return
     */
    private int constructRoads_BipartiteGraph(int A, ArrayList<ArrayList<Integer>> B) {
        HashMap<Integer, HashSet<Integer>> adjacencyList = new HashMap<>();
        int mod = 1000000007;

        //Build adjacency list
        for (int i = 0; i <= A; i++) {
            adjacencyList.put(i, new HashSet<Integer>());
        }
        for (int i = 0; i < B.size(); i++) {
            int source = B.get(i).get(0);
            int destination = B.get(i).get(1);
            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source);
        }

        Integer[] colouredNodes = new Integer[A+1];
        Arrays.fill(colouredNodes, 0);  // 0 : Unvisited , 1:  Set1 , 2 : Set2

        //Graph can be disconnected - so parse all nodes
        for (int i = 0; i < A ; i++) {
            Queue<Integer> bfsQ = new LinkedList<>();

            int existingColor = colouredNodes[i]; //Find colour of starting source node
            if (existingColor != 0) { //If already coloured leave - its already processed
                continue;
            }

            //Start BFS with node 0 & put into Set1
            bfsQ.add(i); colouredNodes[i] = 1;
            while (!bfsQ.isEmpty()) {
                //Pop a node
                int poppedNode = bfsQ.remove();

                //Get the Set of poppedNode
                int poppedNodeSet = colouredNodes[poppedNode];
                int otherSet = poppedNodeSet == 1 ? 2 : 1;

                //Get the neighbours of poppedNode
                HashSet<Integer> neighbours = adjacencyList.get(poppedNode);
                for (Integer eachNeighbour : neighbours) {
                    int neighbourColour = colouredNodes[eachNeighbour];
                    if (neighbourColour == 0) { //If unvisited - mark as other set
                        colouredNodes[eachNeighbour] = otherSet;
                        bfsQ.add(eachNeighbour);
                    }
                }
            }
        }

        //Now all nodes are coloured - count set 1 & set 2
        int set1Count = 0;
        int set2Count = 0;
        for (int i = 1; i <= A; i++) {
            if (colouredNodes[i] == 1) {
                set1Count++;
            } else {
                set2Count++;
            }
        }

        long product = ((long)set1Count * set2Count) % mod;
        if (product < 0) {
            product = product + mod;
        }

        return (int)(product - (A - 1));
    }

    /**
     * AS5 > Cycle in Undirected Graph BFS [WRONG - Need to maintain parent]
     * @param A
     * @param B
     * @return
     */
    private int isCycleInUndirectedGraph(int A, ArrayList<ArrayList<Integer>> B) {
        HashMap<Integer, HashSet<Integer>> adjacencyList = new HashMap<>();

        //Build adjacency list
        for (int i = 1; i <= A; i++) {
            adjacencyList.put(i, new HashSet<>());
        }
        for (int i = 0; i < B.size(); i++) {
            int source = B.get(i).get(0);
            int destination = B.get(i).get(1);
            adjacencyList.get(source).add(destination);
        }

        Boolean[] visitedNodes = new Boolean[A + 1];
        Arrays.fill(visitedNodes, false);  // false : unvisited, true : visited

        //Parse all nodes
        for (int i = 1; i <= A; i++) {
            //Only bfs unvisited nodes
            if (!visitedNodes[i]) {
                Queue<Integer> bfsQ = new LinkedList<>();
                //Visit i + add i to Q
                visitedNodes[i] = true;
                bfsQ.add(i);

                while (!bfsQ.isEmpty()) {
                    //Pop a node
                    int poppedNode = bfsQ.remove();

                    //Get the neighbours of poppedNode
                    HashSet<Integer> neighbours = adjacencyList.get(poppedNode);
                    for (Integer eachNeighbour : neighbours) {
                        //If neighbour is already visited - loop
                        if (visitedNodes[eachNeighbour]) {
                            return 1;
                        } else {
                            //Add neighbour to visited + bfsQ
                            visitedNodes[eachNeighbour] = true;
                            bfsQ.add(eachNeighbour);
                        }
                    }
                }
            }
        }

        return 0;
    }

    /**
     * AS5 > Cycle in Undirected Graph DFS [Pass parent]
     * @param A
     * @param B
     * @return
     */
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

    private int dfs_search(int node, int searchNode, HashSet<Integer> visitedNodes, HashMap<Integer, HashSet<Integer>> adjacencyList) {
        return 0;
    }

}
