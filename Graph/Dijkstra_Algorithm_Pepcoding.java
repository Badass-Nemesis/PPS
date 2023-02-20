import java.util.*;

class Solution {
    public static void dijkstraAlgo(int V, ArrayList<Pair2>[] adj) {
        int[] visited = new int[V];
        Queue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(0, 0 + " ", 0));

        while (queue.size() != 0) {
            Pair curr = queue.remove();

            if (visited[curr.val] == 1) {
                // do nothing
            } else {
                visited[curr.val] = 1;

                System.out.println(curr.val + " via " + curr.psf + " @ " + curr.wsf);

                for (Pair2 neighbour : adj[curr.val]) {
                    if (visited[neighbour.nbr] == 0) {
                        queue.add(new Pair(neighbour.nbr, curr.psf + neighbour + " ", neighbour.weight));
                    }
                }
            }
        }
    }

    public static class Pair2 {
        int nbr; // neighbour
        int weight; // weight

        Pair2(int nbr, int weight) {
            this.nbr = nbr;
            this.weight = weight;
        }
    }

    public static class Pair implements Comparable<Pair> {
        int val; // value
        String psf; // path so far
        int wsf; // weight so far

        Pair(int val, String psf, int wsf) {
            this.val = val;
            this.psf = psf;
            this.wsf = wsf;
        }

        public int compareTo(Pair other) {
            return this.wsf - other.wsf;
        }
    }
}