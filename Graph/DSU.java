// Path compression + Rank 

public class DSU {
    public static int[] par;
    public static int[] rank;

    public static int find(int i) {
        if (par[i] == i) {
            return i;
        } else {
            return par[i] = find(par[i]);
        }
    }

    public static void union(int i, int j) {
        i = find(i);
        j = find(j);

        if (rank[i] > rank[j]) {
            par[j] = i;
        } else if (rank[i] < rank[j]) {
            par[i] = j;
        } else if (rank[i] == rank[j]) {
            par[i] = j;
            rank[i]++;
        }
    }
}
