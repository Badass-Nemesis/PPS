// Question -> https://practice.geeksforgeeks.org/problems/find-whether-path-exist5238/1

import java.util.*;

class Solution {
    public static void recursion(int[][] grid, int[][] visited, int currI, int currJ) {
        int n = grid.length;
        if (currI < 0 || currI >= n || currJ < 0 || currJ >= n || visited[currI][currJ] == 1
                || grid[currI][currJ] == 0) {
            return;
        }

        visited[currI][currJ] = 1;
        recursion(grid, visited, currI + 1, currJ);
        recursion(grid, visited, currI, currJ + 1);
        recursion(grid, visited, currI - 1, currJ);
        recursion(grid, visited, currI, currJ - 1);
    }

    // Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid) {
        // Code here
        int n = grid.length;
        int[][] visitedWala = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(visitedWala[0], 0);
        }

        int startingI = 0;
        int startingJ = 0;
        int endingI = 0;
        int endingJ = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    startingI = i;
                    startingJ = j;
                }

                if (grid[i][j] == 2) {
                    endingI = i;
                    endingJ = j;
                }
            }
        }

        recursion(grid, visitedWala, startingI, startingJ);

        if (visitedWala[endingI][endingJ] == 1) {
            return true;
        } else {
            return false;
        }
    }
}