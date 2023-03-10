// Question -> https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1

import java.util.*;

class Solution {
    public static Stack<Integer> st;

    public static void topo_sort(int node, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[node] = 1;
        for (Integer neighbour : adj.get(node)) {
            if (visited[neighbour] == 0) {
                topo_sort(neighbour, adj, visited);
            }
        }
        st.push(node);
    }

    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[node] = 1;
        for (Integer neighbour : adj.get(node)) {
            if (visited[neighbour] == 0) {
                dfs(neighbour, adj, visited);
            }
        }
    }

    // Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        st = new Stack<>();

        // this is basically opposite of graph. all edges will become opposite
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            transpose.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (Integer neighbour : adj.get(i)) {
                transpose.get(neighbour).add(i);
            }
        }

        int[] visited = new int[V];
        Arrays.fill(visited, 0);

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                topo_sort(i, adj, visited);
            }
        }

        Arrays.fill(visited, 0);

        int count = 0;
        while (st.size() > 0) {
            int node = st.pop();
            if (visited[node] == 0) {
                dfs(node, transpose, visited);
                count++;
            }
        }

        return count;
    }
}