// Question -> https://practice.geeksforgeeks.org/problems/maximum-sum-problem2211/1?category=

class Solution {
    static int[] dpArr;

    public static int recursion(int n) {
        if (n <= 1) {
            return n;
        }

        if (dpArr[n] != -1) {
            return dpArr[n];
        }

        int a = recursion(n / 2);
        int b = recursion(n / 3);
        int c = recursion(n / 4);

        if (a + b + c > n) {
            dpArr[n] = a + b + c;
        } else {
            dpArr[n] = n;
        }

        return dpArr[n];
    }

    public int maxSum(int n) {
        // code here.
        dpArr = new int[1000001];
        for (int i = 0; i < dpArr.length; i++) {
            dpArr[i] = -1;
        }
        return recursion(n);
    }
}