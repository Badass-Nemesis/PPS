// Question -> https://leetcode.com/problems/unique-paths/

class Solution {
    static int[][] dpArr;

    private static int recursion(int m, int n, int x, int y) {
        if (x == m - 1 && y == n - 1) {
            return 1;
        } else if (x == m || y == n) {
            return 0;
        }

        if (dpArr[x][y] != -1) {
            return dpArr[x][y];
        }

        int ans1 = recursion(m, n, x + 1, y); // moving right
        int ans2 = recursion(m, n, x, y + 1); // moving down

        dpArr[x][y] = ans1 + ans2;

        return dpArr[x][y];
    }

    public int uniquePaths(int m, int n) {
        dpArr = new int[101][101];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                dpArr[i][j] = -1;
            }
        }
        return recursion(m, n, 0, 0);
    }
}