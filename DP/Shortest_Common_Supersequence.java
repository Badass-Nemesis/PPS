// Question -> https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1
// Question -> https://leetcode.com/problems/shortest-common-supersequence/
// Note - LC wala qes mein tableDP lagega LCS nikaalne ke liye. so don't waste time on that

class Solution {
    static int[][] dpArr;

    static String answer;

    public static int recursion(int i, int j, String s1, String s2) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (dpArr[i][j] != -1) {
            return dpArr[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            answer += s1.charAt(i);
            return dpArr[i][j] = 1 + recursion(i + 1, j + 1, s1, s2);
        } else {
            int ans1 = recursion(i + 1, j, s1, s2);
            int ans2 = recursion(i, j + 1, s1, s2);
            dpArr[i][j] = Math.max(ans1, ans2);
            return dpArr[i][j];
        }
    }

    // Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X, String Y, int m, int n) {
        // Your code here
        dpArr = new int[101][101];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dpArr[i][j] = -1;
            }
        }
        answer = "";

        int ans = recursion(0, 0, X, Y);

        // int pointer1 = 0;
        // int pointer2 = 0;
        // int pointer3 = 0;
        // String finalAns = "";

        // for (int i = 0; i < ans; i++) {
        // char ch = answer.charAt(pointer3);
        // while (pointer1 < m && X.charAt(pointer1) != ch) {
        // finalAns += X.charAt(pointer1++);
        // }

        // while (pointer2 < n && Y.charAt(pointer2) != ch) {
        // finalAns += Y.charAt(pointer2++);
        // }

        // finalAns += answer.charAt(pointer3);
        // ++pointer1;
        // ++pointer2;
        // ++pointer3;
        // }

        return (m + n - ans);
        // return finalAns;
    }
}