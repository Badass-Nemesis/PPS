// Question -> https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1

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
            return dpArr[i][j] = 1 + recursion(i + 1, j + 1, s1, s2);
        } else {
            int ans1 = recursion(i + 1, j, s1, s2);
            int ans2 = recursion(i, j + 1, s1, s2);

            dpArr[i][j] = Math.max(ans1, ans2);
            return dpArr[i][j];
        }
    }

    public int minOperations(String str1, String str2) {
        // Your code goes here
        dpArr = new int[1001][1001];
        for (int i = 0; i < 1001; i++) { // str1.length()
            for (int j = 0; j < 1001; j++) { // str2.length()
                dpArr[i][j] = -1;
            }
        }

        int ans = str1.length() + str2.length() - 2 * Math.abs(recursion(0, 0, str1, str2));

        return ans;
    }
}