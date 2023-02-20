// Question -> https://practice.geeksforgeeks.org/problems/snake-and-ladder-problem4816/1

import java.util.*;

class Solution {
    static int minThrow(int N, int arr[]) {
        // code here
        int[] adj = new int[31];
        Arrays.fill(adj, -1);

        for (int i = 0; i < arr.length; i += 2) {
            adj[arr[i]] = arr[i + 1];
        }

        int[] visited = new int[31];
        Arrays.fill(visited, 0);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);

        int count = 0;
        visited[1] = 1;

        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                int temp = queue.remove();
                if (temp == 30) {
                    return count;
                }

                for (int i = temp + 1; i < temp + 7; i++) {
                    if (i > 30) {
                        break;
                    }

                    if (visited[i] == 1) {
                        // do nothing
                    } else {
                        visited[i] = 1;

                        if (adj[i] == -1) {
                            queue.add(i);
                        } else {
                            queue.add(adj[i]);
                        }
                    }
                }
            }
            count++;
        }

        return count;
    }
}