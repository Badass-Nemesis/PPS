// Question -> https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

import java.util.*;

class Solution {

    public static boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] visited,
            int[] recursiveVisited) {
        visited[node] = 1;
        recursiveVisited[node] = 1;
        for (Integer neighbour : adj.get(node)) {
            if (visited[neighbour] == 0) {
                if (dfs(neighbour, node, adj, visited, recursiveVisited) == true) {
                    return true;
                }
            } else if (recursiveVisited[neighbour] == 1) {
                return true;
            }
        }
        recursiveVisited[node] = 0;

        return false;
    }

    public static boolean bfs(int V, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        // basically we are using kahn's algo to check whether we are getting all in
        // degree zero for this or not
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (Integer neighbour : adj.get(i)) {
                inDegree[neighbour]++;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (queue.size() != 0) {
            int curr = queue.remove();
            visited[curr] = 1;

            for (Integer neighbour : adj.get(curr)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
            count++;
        }

        // for (int i = 0; i < V; i++) {
        // if (inDegree[i] > 0) {
        // return true;
        // }
        // }

        // return false;

        return count == V ? false : true;
    }

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] visited = new int[V];
        // int[] recursiveVisited = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                // if (dfs(i, -1, adj, visited, recursiveVisited) == true) {
                // return true;
                // }
                if (bfs(V, adj, visited) == true) {
                    return true;
                }
            }
        }

        return false;
    }
}