// Question -> https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

import java.util.*;
// import java.io.*;

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> bfsWala = new ArrayList<>();
        int[] visitedWala = new int[V + 1];
        Arrays.fill(visitedWala, 0);
        Queue<Integer> childQueue = new ArrayDeque<>();
        childQueue.add(0);
        visitedWala[0] = 1;

        while (childQueue.size() != 0) {
            int currNode = childQueue.remove();
            bfsWala.add(currNode);
            for (Integer child : adj.get(currNode)) {
                if (visitedWala[child] == 0) {
                    visitedWala[child] = 1;
                    childQueue.add(child);
                }
            }
        }

        return bfsWala;
    }
}