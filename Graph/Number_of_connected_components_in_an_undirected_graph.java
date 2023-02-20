// Question -> https://www.geeksforgeeks.org/program-to-count-number-of-connected-components-in-an-undirected-graph/

import java.util.*;

class Solution {
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[node] = 1;

        for (Integer neigbour : adj.get(node)) {
            if (visited[neigbour] == 0) {
                dfs(neigbour, adj, visited);
            }
        }

        return;
    }

    public static int numberOfConnected(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        Arrays.fill(visited, 0);
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(i, adj, visited);
                count++;
            }
        }

        return count;
    }
}