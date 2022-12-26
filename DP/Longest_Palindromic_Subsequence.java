// Question -> https://practice.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1

class Solution {
    static int[][] dpArr;

    public static int recursion(int i, int j, String s1, String s2) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (dpArr[i][j] != -1) {
            return dpArr[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            dpArr[i][j] = 1 + recursion(i + 1, j + 1, s1, s2);
            return dpArr[i][j];
        } else {
            int ans1 = recursion(i + 1, j, s1, s2);
            int ans2 = recursion(i, j + 1, s1, s2);

            dpArr[i][j] = Math.max(ans1, ans2);
            return dpArr[i][j];
        }
    }

    public int longestPalinSubseq(String S) {
        // code here
        dpArr = new int[1001][1001];
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                dpArr[i][j] = -1;
            }
        }

        String s1 = S;
        String s2 = "";
        for (int i = s1.length() - 1; i >= 0; i--) {
            s2 += s1.charAt(i);
        }

        return recursion(0, 0, s1, s2);
    }
}