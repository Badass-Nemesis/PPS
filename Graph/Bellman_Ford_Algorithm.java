// Question -> https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1

import java.util.*;

// User function Template for Java

/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution {
    // FINALLY THIS CODE WORKED.
    // Credits to Striver chacha.
    public static int[] bellman_ford3(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int iterations = V - 1;
        int[] dist = new int[V];
        Arrays.fill(dist, 100000000);
        dist[S] = 0;

        while (iterations-- > 0) {
            for (ArrayList<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);

                if (dist[u] == 100000000) {
                    continue;
                }

                if (dist[v] > dist[u] + wt) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        int[] tempDist = dist;
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);

            if (tempDist[u] == 100000000) {
                continue;
            }

            if (tempDist[v] > tempDist[u] + wt) {
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }

        return dist;
    }

    // FUNFACT -> NEITHER OF THEM WORKS. PEPCODING's CODE GIVES WA FOR DETECTING
    // CYCLE, and SHUV BHAIYA's CODE GIVES WA ON TESTCASE 6 FOR WHATEVER REASON

    // this is shuv bhaiya's code
    static int[] bellman_ford2(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int t = V - 1;
        int[] dist = new int[V];
        Arrays.fill(dist, 100000000);
        dist[S] = 0;
        while (t-- > 0) {
            int[] updated = dist;
            for (ArrayList<Integer> edge : edges) {
                int u = edge.get(0); // edge starting point
                int v = edge.get(1); // edge going to point
                int wt = edge.get(2); // weight of that edge

                updated[v] = Math.min(updated[v], dist[u] + wt);
            }

            if (updated == dist) {
                break;
            }

            dist = updated;
        }

        return dist;
    }

    // this is pepcoding's code
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int[] path = new int[V];
        Arrays.fill(path, 100000000);
        path[S] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> edge : edges) {
                int u = edge.get(0); // edge starting point
                int v = edge.get(1); // edge going to point
                int wt = edge.get(2); // weight of that edge

                if (path[u] == 100000000) {
                    continue;
                }

                if (path[v] > path[u] + wt) {
                    path[v] = path[u] + wt;
                }
            }
        }

        return path;
    }
}
