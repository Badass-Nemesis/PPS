// Question -> https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1

class Solution {
    // Function to find minimum number of attempts needed in
    // order to find the critical floor.
    static int[][] dpArr;

    static int recursion(int n, int k) {
        if (n == 1)
            return k;
        if (k <= 1)
            return k;
        if (dpArr[n][k] != -1)
            return dpArr[n][k];

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            int ans1 = 1 + recursion(n - 1, i - 1);
            int ans2 = 1 + recursion(n, k - i);
            ans = Math.min(ans, Math.max(ans1, ans2));
        }

        return dpArr[n][k] = ans;
    }

    static int eggDrop(int n, int k) {
        dpArr = new int[201][201];
        for (int i = 0; i < 201; i++) {
            for (int j = 0; j < 201; j++) {
                dpArr[i][j] = -1;
            }
        }

        return recursion(n, k);
    }
}