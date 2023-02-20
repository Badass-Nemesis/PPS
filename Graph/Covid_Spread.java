// Question -> https://practice.geeksforgeeks.org/problems/269f61832b146dd5e6d89b4ca18cbd2a2654ebbe/1

import java.util.*;

class Solution {
    public static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int helpaterp(int[][] hospital) {
        // code here
        int n = hospital.length;
        int m = hospital[0].length;
        int countAlive = 0;
        // int[][] visited = new int[n + 1][m + 1];
        Queue<Pair> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (hospital[i][j] == 2) {
                    queue.add(new Pair(i, j));
                } else if (hospital[i][j] == 1) {
                    countAlive++;
                }
            }
        }

        int time = 0;
        while (queue.size() != 0) {
            if (countAlive == 0) {
                break;
            }

            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Pair current = queue.remove();

                // left
                if (current.i > 0 && hospital[current.i - 1][current.j] == 1) {
                    countAlive--;
                    queue.add(new Pair(current.i - 1, current.j));
                    hospital[current.i - 1][current.j] = 2;
                }

                // right
                if (current.i < n - 1 && hospital[current.i + 1][current.j] == 1) {
                    countAlive--;
                    queue.add(new Pair(current.i + 1, current.j));
                    hospital[current.i + 1][current.j] = 2;
                }

                // top
                if (current.j > 0 && hospital[current.i][current.j - 1] == 1) {
                    countAlive--;
                    queue.add(new Pair(current.i, current.j - 1));
                    hospital[current.i][current.j - 1] = 2;
                }

                // down
                if (current.j < m - 1 && hospital[current.i][current.j + 1] == 1) {
                    countAlive--;
                    queue.add(new Pair(current.i, current.j + 1));
                    hospital[current.i][current.j + 1] = 2;
                }
            }

            time++;
        }

        return countAlive == 0 ? time : -1;
    }
}
