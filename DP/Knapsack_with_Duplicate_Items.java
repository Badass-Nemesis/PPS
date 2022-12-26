// Question -> https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1

class Solution {

    static int[][] dpArr;

    public static int recursion(int W, int index, int n, int[] val, int[] wt) {
        if (index == n) {
            return 0;
        }

        if (dpArr[index][W] != -1) {
            return dpArr[index][W];
        }

        if (wt[index] > W) {
            dpArr[index][W] = recursion(W, index + 1, n, val, wt);
            return dpArr[index][W];
        } else {
            // acording to karan bhaiya, we don't need this ans1, but I dunno why
            int ans1 = val[index] + recursion(W - wt[index], index + 1, n, val, wt);
            int ans2 = val[index] + recursion(W - wt[index], index, n, val, wt);
            int ans3 = recursion(W, index + 1, n, val, wt);

            dpArr[index][W] = Math.max(ans1, Math.max(ans2, ans3));
            return dpArr[index][W];
        }
    }

    static int knapSack(int N, int W, int val[], int wt[]) {
        // code here
        dpArr = new int[1001][1001];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= W; j++) {
                dpArr[i][j] = -1;
            }
        }

        return recursion(W, 0, N, val, wt);
    }
}