import java.util.Arrays;

public class MST_Kruskal_Algo {
    public static int[] parent;
    public static int[] rank;

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    public static boolean union(int x, int y) {
        int leaderX = parent[x];
        int leaderY = parent[y];

        if (leaderX != leaderY) {
            if (rank[leaderX] > rank[leaderY]) {
                parent[leaderY] = leaderX;
            } else if (rank[leaderX] < rank[leaderY]) {
                parent[leaderX] = leaderY;
            } else {
                parent[leaderX] = leaderY;
                rank[leaderY]++;
            }

            return true;
        }
        return false;
    }

    public static class Pair implements Comparable<Pair> {
        int u;
        int v;
        int wt;

        Pair(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair other) {
            return this.wt - other.wt;
        }
    }

    public static int minCostToSupplyWater(int n, int[][] edges) {
        Pair[] arr = new Pair[edges.length];
        for (int i = 0; i < edges.length; i++) {
            arr[i] = new Pair(edges[i][0], edges[i][1], edges[i][2]);
        }

        Arrays.sort(arr);

        parent = new int[arr.length];
        rank = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean valid = union(arr[i].u, arr[i].v);
            if (valid == true) {
                ans += arr[i].wt;
            }
        }

        return (int) ans;
    }
}
