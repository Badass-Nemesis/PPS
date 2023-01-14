// Question -> https://www.interviewbit.com/problems/regular-expression-ii/
// Question -> https://leetcode.com/problems/regular-expression-matching/

class Solution {
    static int[][] dpArr;

    // This officially declares me as dumbest person to ever study CSE. There are
    // many edge cases and special cases and I'm done with this qes from stressing
    // me all the way to my core.
    public static int recursion(String p, String s, int i, int j) {
        if (i == p.length() && j == s.length()) {
            return 1;
        }

        if (i == p.length()) {
            return 0;
        }

        if (j == s.length()) {
            if (p.charAt(i) == '*') {
                i++;
            }

            while (i < p.length()) {
                if (i + 1 == p.length()) {
                    return 0;
                }

                if (p.charAt(i + 1) == '*') {
                    i += 2;
                } else {
                    return 0;
                }
            }

            return 1;
        }

        if (dpArr[i][j] != -1) {
            return dpArr[i][j];
        }

        if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '.') {
            int ans1 = recursion(p, s, i + 1, j + 1);
            if (i + 1 != p.length() && p.charAt(i + 1) == '*') {
                int tempAns1 = recursion(p, s, i + 2, j);
                int tempAns2 = recursion(p, s, i, j + 1);
                ans1 = tempAns1 | tempAns2;
            }

            return dpArr[i][j] = ans1;
        } else {
            if (p.charAt(i) == '*') {
                return dpArr[i][j] = recursion(p, s, i + 1, j);
            }
            if (i + 1 != p.length() && p.charAt(i + 1) == '*') {
                return dpArr[i][j] = recursion(p, s, i + 2, j);
            }
        }

        return 0;
    }

    public boolean isMatch(String s, String p) {
        dpArr = new int[31][21];
        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 21; j++) {
                dpArr[i][j] = -1;
            }
        }

        int ans = recursion(p, s, 0, 0);

        if (ans > 0) {
            return true;
        } else {
            return false;
        }
    }
}