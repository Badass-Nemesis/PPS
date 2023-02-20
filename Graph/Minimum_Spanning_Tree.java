// Question -> https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1

import java.util.*;

class Solution {

    /*
     * THIS IS SHUV BHAIYA's CODE, AND THIS WORKED PERFECTLY FINE. WHILE MY JAVA
     * CODE IS SOMEHOW GIVING ERROR FOR ARRAYLIST INDEX OUT OF BOUNDS. FUQING
     * DUMBASS GFG
     */

    // vector<int> dist(n+1, INT_MAX);
    // vector<bool> vis(n+1, false);
    // dist[0] = 0;

    // priority_queue<pair<int, int>, vector<pair<int, int>> , greater<pair<int,
    // int>>> pq;
    // pq.push({0,0});

    // while(!pq.empty()){
    // int node = pq.top().second;
    // pq.pop();
    // vis[node] = true;
    // for(auto it: adj[node]){
    // int v = it[0], weight = it[1];
    // if(vis[v]==false && weight<dist[v]){
    // dist[v] = weight;
    // pq.push({weight, v});
    // }
    // }
    // }

    // int ans = 0;
    // for(int i=1; i<=n;i++){
    // if(dist[i]!=INT_MAX){
    // ans+=dist[i];
    // }
    // }
    // return ans;

    public static class Pair implements Comparable<Pair> {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int compareTo(Pair other) {
            return this.weight - other.weight;
        }
    }

    static int spanningTree(int V, int E, int edges[][]) {
        // Code Here.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        Queue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(0, 0));
        int[] visited = new int[V];
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        while (queue.size() != 0) {
            Pair curr = queue.remove();

            if (visited[curr.node] == 0) {
                visited[curr.node] = 1;

                for (Pair neighbour : adj.get(curr.node)) {
                    if (visited[neighbour.node] == 0) {
                        if (neighbour.weight < distance[neighbour.node]) {
                            distance[neighbour.node] = neighbour.weight;
                            queue.add(new Pair(neighbour.node, distance[neighbour.node]));
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] != Integer.MAX_VALUE) {
                ans += distance[i];
            }
        }
        return ans;
    }
}