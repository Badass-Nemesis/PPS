// Question -> https://practice.geeksforgeeks.org/problems/player-with-max-score/1?category=
// Question -> https://leetcode.com/problems/predict-the-winner/

import java.util.Arrays;

class Solution {

    static int[][] dp;

    public static int recursion(int left, int right, int[] arr) {
        if (left > right) {
            return 0;
        }

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        int ans1 = arr[left] + Math.min(recursion(left + 2, right, arr), recursion(left + 1, right - 1, arr));
        int ans2 = arr[right] + Math.min(recursion(left + 1, right - 1, arr), recursion(left, right - 2, arr));

        dp[left][right] = Math.max(ans1, ans2);

        return dp[left][right];
    }

    static Boolean is1winner(int N, int arr[]) {
        // code here
        dp = new int[1001][1001];
        for (int i = 0; i < 1001; i++) {
            Arrays.fill(dp[i], -1);
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }

        if (sum == 0) {
            return true;
        }

        int player1 = recursion(0, N - 1, arr);

        if (player1 >= (sum - player1)) {
            return true;
        } else {
            return false;
        }
    }
}