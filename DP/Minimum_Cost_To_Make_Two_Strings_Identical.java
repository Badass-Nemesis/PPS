// Question -> https://practice.geeksforgeeks.org/problems/minimum-cost-to-make-two-strings-identical1107/1?category=

class Solution {
    static int[][] dpArr;

    public static int recursion(int i, int j, String s1, String s2) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (dpArr[i][j] != -1) {
            return dpArr[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            dpArr[i][j] = 1 + recursion(i + 1, j + 1, s1, s2);
            return dpArr[i][j];
        } else {
            int ans1 = recursion(i + 1, j, s1, s2);
            int ans2 = recursion(i, j + 1, s1, s2);

            dpArr[i][j] = Math.max(ans1, ans2);
            return dpArr[i][j];
        }
    }

    public int findMinCost(String X, String Y, int costX, int costY) {
        // Your code goes here
        dpArr = new int[1001][1001];
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                dpArr[i][j] = -1;
            }
        }

        int lcs = recursion(0, 0, X, Y);
        int ans = costX * (X.length() - lcs) + costY * (Y.length() - lcs);

        return ans;
    }
}