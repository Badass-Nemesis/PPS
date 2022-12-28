// Question -> https://practice.geeksforgeeks.org/problems/buying-vegetables0016/1?category=

class Solution {
    static int[][] dpArr;

    public static int recursion(int level, int[][] cost, int previous) {
        // previous is used for checking we don't get vegetables from alternate vendor,
        // so basically previous is vendor's index. and level is just LEVEL (i.e. N in
        // Nx3 matrix).
        if (level == cost.length) {
            // that means we've reached the last shop/level
            return 0;
        }

        if (previous == -1) {
            // this block will activate for only one time(i.e. for the first time)
            int ans1 = cost[level][0] + recursion(level + 1, cost, 0);
            int ans2 = cost[level][1] + recursion(level + 1, cost, 1);
            int ans3 = cost[level][2] + recursion(level + 1, cost, 2);

            // basically choosing which vendor to get vegetables from, in first place, and
            // then choose the min
            return Math.min(ans1, Math.min(ans2, ans3));
        } else if (dpArr[level][previous] != -1) {
            // basic memoization
            return dpArr[level][previous];
        } else {
            int ans = Integer.MAX_VALUE;
            // iterating through every vendor while checking the previous vendor's index
            for (int i = 0; i < 3; i++) {
                if (i == previous) {
                    // do nothing
                } else {
                    ans = Math.min(ans, cost[level][i] + recursion(level + 1, cost, i));
                }
            }

            dpArr[level][previous] = ans;
            return dpArr[level][previous];
        }
    }

    static int minCost(int N, int cost[][]) {
        // code here
        dpArr = new int[100001][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                dpArr[i][j] = -1;
            }
        }
        return recursion(0, cost, -1);
    }
}