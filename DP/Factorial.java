// Question -> https://practice.geeksforgeeks.org/problems/factorial5739/1

class Solution {
    static long factorial(int N) {
        long[] dpArr = new long[N + 1];
        dpArr[0] = 1;
        for (int i = 1; i <= N; i++) {
            dpArr[i] = i * dpArr[i - 1];
        }

        return dpArr[N];
    }
}