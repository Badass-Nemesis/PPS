// Question -> https://leetcode.com/problems/coin-change/

class Solution {
    static int[] dpArr;

    static int recursion(int[] coins, int amount) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        } else if (amount == 0) {
            return 1;
        }

        if (dpArr[amount] != -1) {
            // since usko khud ko bhi add karke return karna hoga, isiliye ans+1 return kar
            // rahe h
            return dpArr[amount] + 1;
        }

        int ans = Integer.MAX_VALUE - 1;
        for (int i = 0; i < coins.length; i++) {
            ans = Math.min(ans, recursion(coins, amount - coins[i]));
        }

        dpArr[amount] = ans;
        // since usko khud ko bhi add karke return karna hoga, isiliye ans+1 return kar
        // rahe h
        return ans + 1;
    }

    public int coinChange(int[] coins, int amount) {
        dpArr = new int[10001];
        for (int i = 0; i < 10001; i++) {
            dpArr[i] = -1;
        }

        // since mere paas apne aap ko bhi add kiya hua ans aa raha h, to hum ek minus
        // karke ans return karenge idhar
        int finalAns = recursion(coins, amount);
        if (finalAns >= Integer.MAX_VALUE) {
            return -1;
        } else {
            return finalAns - 1;
        }
    }
}