// Question -> https://leetcode.com/problems/coin-change-ii/description/

class Solution {
    static int[][] dpArr;

    static int recursion(int amount, int[] coins, int index) {
        if (amount < 0 || index == coins.length) {
            return 0;
        } else if (amount == 0) {
            return 1;
        }

        if (dpArr[amount][index] != -1) {
            return dpArr[amount][index];
        }

        int ans = 0;
        // ya to wo coin ko lenge hum
        ans += recursion(amount - coins[index], coins, index);
        // ya fir wo coin ko lene ki jagah dusra coin lenge
        ans += recursion(amount, coins, index + 1);

        dpArr[amount][index] = ans;

        return ans;
    }

    public int change(int amount, int[] coins) {
        dpArr = new int[5001][301];
        for (int i = 0; i < 5001; i++) {
            for (int j = 0; j < 301; j++) {
                dpArr[i][j] = -1;
            }
        }

        return recursion(amount, coins, 0);
    }
}