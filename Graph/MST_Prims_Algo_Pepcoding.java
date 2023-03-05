import java.util.*;

class Solution {
    public static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static class Pair implements Comparable<Pair> {
        int v; // vertex
        int av; // aquiring vertex
        int wt; // weight

        Pair(int v, int av, int wt) {
            this.v = v;
            this.av = av;
            this.wt = wt;
        }

        public int compareTo(Pair other) {
            return this.wt - other.wt;
        }
    }

    public static void MST(int V, ArrayList<Edge>[] graph) {
        Queue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(0, -1, 0));
        // aisehi bas, 0 ko include karne ke liye ek imaginary av (acquiring vertex)
        // liye h, jo -1 h
        int[] visited = new int[V];

        while (queue.size() != 0) {
            Pair curr = queue.remove();

            if (visited[curr.v] == 0) {
                if (curr.av == -1) {
                    // acquiring vertex mera agar -1 hua tab ko kuch print ni karna h. mera printing
                    // 0 se start hoga. ye av hum sirf isiliye set kiye h, taaki mera av aur v, dono
                    // initially 0 hi set na reh jaye, tab problem ho jayega
                } else {
                    System.out.println("[" + curr.v + "-" + curr.av + "@" + curr.wt + "]");
                }

                visited[curr.v] = 1;
                for (Edge e : graph[curr.v]) {
                    if (visited[e.nbr] == 0) {
                        queue.add(new Pair(e.nbr, curr.v, e.wt));
                    }
                }
            }
        }
    }
}