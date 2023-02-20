// Question -> https://practice.geeksforgeeks.org/problems/bipartite-graph/1

import java.util.*;

class Solution {
    public static class Pair {
        int node;
        int level;

        Pair(int node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    // NOTE - For shuv bhaiya's code, try thinking about the level of the nodes,
    // instead of color.

    // shuv bhaiya's code
    public static boolean bfs3(int node, ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(node);
        color[node] = 0;

        while (queue.size() != 0) {
            int curr = queue.remove();
            for (Integer neigbour : adj.get(curr)) {
                if (color[neigbour] == -1) {
                    color[neigbour] = 1 - color[curr];
                    queue.add(neigbour);
                } else if (color[neigbour] == color[curr]) {
                    return true;
                }
            }
        }

        return false;
    }

    // shuv bhaiya's code
    public static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] color, int parentColor) {
        color[node] = 1 - parentColor; // agar parentColor 1 hua to 0 ho jayega, agar 0 hua to 1 ho jayega

        for (Integer neighbour : adj.get(node)) {
            if (color[neighbour] == -1) {
                if (dfs(neighbour, adj, color, color[node]) == true) {
                    return true;
                }
            } else if (color[neighbour] == color[node]) {
                return true;
            }
        }

        return false;
    }

    // my dumb code. I just wrote this math's thing literally, just to satisfy the
    // compiler.
    public static boolean bfs(int V, ArrayList<ArrayList<Integer>> adj, int[] visited, int node) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // int[] visited = new int[V];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(node);
        set1.add(node);
        int level = 1;

        while (queue.size() != 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int temp = queue.remove();
                if (visited[temp] == 0) {
                    visited[temp] = 1;
                    for (Integer neighbour : adj.get(temp)) {
                        if (level % 2 == 0) {
                            set1.add(neighbour);
                        } else {
                            set2.add(neighbour);
                        }

                        if (set1.contains(neighbour) == true && set2.contains(neighbour) == true) {
                            return false;
                        }

                        queue.add(neighbour);
                    }
                }
            }

            level++;
        }

        return true;
    }

    // sumeet sir's code. isme we are checking the level where that node was visited
    // (using visited array). If the node was visited and the node's level doesn't
    // match with visited's level, then it's a problem. because in bfs, since we go
    // levelwise visiting every node, so if there is an odd length cycle, the node
    // level and visited level will conflict. Else in the case of even length cycle,
    // we would get to the last end of the cycle at same point, at same level.
    public static boolean bfs2(int src, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, 0));

        while (queue.size() != 0) {
            Pair curr = queue.remove();

            if (visited[curr.node] != -1) {
                if (visited[curr.node] != curr.level) {
                    return false;
                }
            } else {
                visited[curr.node] = curr.level;
            }

            for (Integer neighbour : adj.get(curr.node)) {
                if (visited[neighbour] == -1) {
                    queue.add(new Pair(neighbour, curr.level + 1));
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        // int[] visited = new int[V];
        // for (int i = 0; i < V; i++) {
        // if (visited[i] == 0) {
        // if (bfs(V, adj, visited, i) == true) {
        // return false;
        // }
        // }
        // }

        int[] color = new int[V];
        Arrays.fill(color, -1);
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                // if (dfs(i, adj, color, 0) == true) {
                // return false;
                // }

                if (bfs3(V, adj, color) == true) {
                    return false;
                }
            }
        }

        return true;
    }
}