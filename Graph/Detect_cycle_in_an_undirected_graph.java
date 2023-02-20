// Question -> https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

import java.util.*;

class Solution {
    // Function to detect cycle in an undirected graph.
    public static class Pair {
        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public static boolean dfs(int parent, int src, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[src] = 1;
        for (Integer neighbour : adj.get(src)) {
            if (visited[neighbour] == 0) {
                if (dfs(src, neighbour, adj, visited) == true) {
                    return true;
                }
            } else if (parent != neighbour) {
                return true;
            }
        }
        return false;
    }

    public static boolean bfs(int V, int i, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(i, -1));

        while (queue.size() != 0) {
            Pair curr = queue.remove();

            if (visited[curr.node] == 1) {
                return true;
            }
            visited[curr.node] = 1;

            for (Integer neighbour : adj.get(curr.node)) {
                if (visited[neighbour] == 0) {
                    queue.add(new Pair(neighbour, curr.node));
                }
            }
        }

        return false;
    }

    public static boolean bfs2(int V, int i, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[i] = 1;
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(i, -1));
        // pehla node pair push karenge. aur since uska koi parent ni h, to -1 push kar
        // denge
        while (queue.size() != 0) {
            Pair curr = queue.remove();
            for (Integer neighbour : adj.get(curr.node)) {
                if (visited[neighbour] == 0) {
                    visited[neighbour] = 1;
                    queue.add(new Pair(neighbour, curr.node));
                } else if (neighbour != curr.parent) {
                    return true;
                }
            }

        }

        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] visited = new int[V];
        Arrays.fill(visited, 0);

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                // if (bfs(V, i, adj, visited) == true) {
                // return true;
                // }

                if (dfs(-1, i, adj, visited) == true) {
                    return true;
                }
            }
        }

        return false;
    }
}