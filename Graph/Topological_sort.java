// Question -> https://practice.geeksforgeeks.org/problems/topological-sort/1

import java.util.*;

class Solution {
    static Stack<Integer> st;

    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[node] = 1;
        for (Integer neighbour : adj.get(node)) {
            if (visited[neighbour] == 0) {
                dfs(neighbour, adj, visited);
            }
        }
        st.push(node);
    }

    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // add your code here
        int[] visited = new int[V];
        Arrays.fill(visited, 0);
        st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(i, adj, visited);
            }
        }

        int[] ans = new int[V];
        for (int i = 0; i < V; i++) {
            ans[i] = st.pop();
        }

        return ans;
    }
}