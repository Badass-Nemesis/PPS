// Question -> https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

import java.util.Arrays;

class Solution {

    static int[][] dpArr;

    public static int recursion(int weight, int index, int[] wt, int[] val, int n) {
        if (index == n) {
            return 0;
        }

        if (dpArr[index][weight] != -1) {
            return dpArr[index][weight];
        }

        if (wt[index] > weight) {
            return dpArr[index][weight] = recursion(weight, index + 1, wt, val, n);
        } else {
            int ans1 = val[index] + recursion(weight - wt[index], index + 1, wt, val, n);
            int ans2 = recursion(weight, index + 1, wt, val, n);
            dpArr[index][weight] = Math.max(ans1, ans2);

            return dpArr[index][weight];
        }
    }

    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) {
        // your code here
        // funfact, filling all the way upto 1001 gives TLE
        dpArr = new int[n][W + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dpArr[i], -1);
        }
        return recursion(W, 0, wt, val, n);
    }
}