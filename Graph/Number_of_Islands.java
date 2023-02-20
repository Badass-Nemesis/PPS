// Question -> https://leetcode.com/problems/number-of-islands/

class Solution {
    public static void recursion(char[][] grid, int currI, int currJ) {
        int n = grid.length;
        int m = grid[0].length;
        if (currI < 0 || currI >= n || currJ < 0 || currJ >= m || grid[currI][currJ] != '1') {
            return;
        }

        grid[currI][currJ] = '2';
        recursion(grid, currI + 1, currJ);
        recursion(grid, currI, currJ + 1);
        recursion(grid, currI - 1, currJ);
        recursion(grid, currI, currJ - 1);
    }

    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    recursion(grid, i, j);
                }
            }
        }

        return ans;
    }
}