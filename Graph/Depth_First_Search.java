// Question -> https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

import java.util.*;

class Solution {
    public static void recursive(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfsWala, int[] visitedWala,
            int currParent) {
        visitedWala[currParent] = 1;
        dfsWala.add(currParent);
        for (Integer child : adj.get(currParent)) {
            if (visitedWala[child] == 0) {
                recursive(adj, dfsWala, visitedWala, child);
            }
        }
    }

    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] visitedWala = new int[V + 1];
        ArrayList<Integer> dfsWala = new ArrayList<>();
        recursive(adj, dfsWala, visitedWala, 0);

        return dfsWala;
    }
}