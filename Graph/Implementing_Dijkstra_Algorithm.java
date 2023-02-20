// Question -> https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

import java.util.*;

class Solution {
    public static class Pair implements Comparable<Pair> {
        int node;
        int wsf;

        Pair(int node, int wsf) {
            this.node = node;
            this.wsf = wsf;
        }

        public int compareTo(Pair other) {
            return this.wsf - other.wsf;
        }
    }

    // Function to find the shortest distance of all the vertices
    // from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Write your code here
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0;
        Queue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(S, 0));

        while (queue.size() != 0) {
            Pair curr = queue.remove();

            for (ArrayList<Integer> neighbours : adj.get(curr.node)) {
                int neighbour = neighbours.get(0);
                int weight = neighbours.get(1);

                if (distance[neighbour] > distance[curr.node] + weight) {
                    distance[neighbour] = distance[curr.node] + weight;
                    queue.add(new Pair(neighbour, distance[neighbour]));
                }
            }
        }

        return distance;
    }
}
