// Question -> https://practice.geeksforgeeks.org/problems/topological-sort/1
// Question -> https://leetcode.com/problems/course-schedule-ii/

import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // ignore this section of the code if u r piro. because I had to convert this
        // matrix into adjacency list to get it working. because I'm dumb
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(v).add(u);
        }

        // basically we are seeing what's the dependency on each node
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (Integer neighbour : adj.get(i)) {
                inDegree[neighbour]++;
            }
        }

        // normal bf wala code. sabse pehla 0 dependency wala ko add karenge. agar 0
        // dependency ni mila, iska matlab cyclic graph tha ye. topological sorting
        // karne ke liye we strictly need directed acyclic graph
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] ans = new int[numCourses];
        int index = 0;

        while (queue.size() != 0) {
            int curr = queue.remove();
            ans[index] = curr;
            index++;

            for (Integer neighbour : adj.get(curr)) {
                inDegree[neighbour]--;
                // we are adding only 0 dependency wala node, because topological sorting mein
                // hamesha low dependency wala upar hota h
                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
        // System.out.println(ans[0] + " " + ans[1]); // debug

        return index == numCourses ? ans : new int[0];
    }
}