// Question -> https://www.interviewbit.com/problems/interleaving-strings/

class Solution {
    static int[][][] dpArr;

    public static int recursion(int i, int j, int k, String a, String b, String c) {
        if (k == c.length() && i == a.length() && j == b.length()) {
            return 1;
        }
        if (k == c.length()) {
            return 0;
        }
        if (i == a.length() && j == b.length()) {
            return 0;
        }
        if (i == a.length()) {
            if (b.charAt(j) == c.charAt(k)) {
                return recursion(i, j + 1, k + 1, a, b, c);
            } else {
                return 0;
            }
        }
        if (j == b.length()) {
            if (a.charAt(i) == c.charAt(k)) {
                return recursion(i + 1, j, k + 1, a, b, c);
            } else {
                return 0;
            }
        }

        if (dpArr[i][j][k] != -1) {
            return dpArr[i][j][k];
        }

        if (a.charAt(i) == c.charAt(k) && b.charAt(j) == c.charAt(k)) {
            int ans1 = recursion(i + 1, j, k + 1, a, b, c);
            int ans2 = recursion(i, j + 1, k + 1, a, b, c);
            return dpArr[i][j][k] = ans1 | ans2;
        }
        if (a.charAt(i) == c.charAt(k)) {
            return dpArr[i][j][k] = recursion(i + 1, j, k + 1, a, b, c);
        }
        if (b.charAt(j) == c.charAt(k)) {
            return dpArr[i][j][k] = recursion(i, j + 1, k + 1, a, b, c);
        }

        return dpArr[i][j][k] = 0;
    }

    public int isInterleave(String A, String B, String C) {
        dpArr = new int[151][151][151];
        for (int i = 0; i <= A.length(); i++) {
            for (int j = 0; j <= B.length(); j++) {
                for (int k = 0; k <= C.length(); k++) {
                    dpArr[i][j][k] = -1;
                }
            }
        }

        if (recursion(0, 0, 0, A, B, C) > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
