// Question -> https://www.interviewbit.com/old/problems/distinct-subsequences/

class Solution {
    static int[][] dpArr;

    public static int recursion(int firstP, int secondP, String s1, String s2) {
        if (secondP == s2.length()) {
            return 1;
            // because we have completely found the s2 string in the s1 string, and now we
            // can return 1 as in we got 1 match for the s2 in s1.
        }

        if (firstP == s1.length()) {
            return 0;
            // since we reached the last of s1 string without finding s2 in it, that's why
            // we should return 0, as in there are 0 ways to get s2 in s1.
        }

        if (dpArr[firstP][secondP] != -1) {
            return dpArr[firstP][secondP];
        }

        if (s1.charAt(firstP) == s2.charAt(secondP)) {
            // as always two choices, take it or leave
            int ans1 = recursion(firstP + 1, secondP + 1, s1, s2);
            int ans2 = recursion(firstP + 1, secondP, s1, s2);

            dpArr[firstP][secondP] = ans1 + ans2; // total ways of matching the string s2 in s1
            return dpArr[firstP][secondP];
        } else {
            // since we didn't get any match, so we have to move leftP forward and not
            // secondP, because we have to find s2 in s1.
            dpArr[firstP][secondP] = recursion(firstP + 1, secondP, s1, s2);
            return dpArr[firstP][secondP];
        }
    }

    public int numDistinct(String A, String B) {
        dpArr = new int[701][701];
        for (int i = 0; i < 701; i++) {
            for (int j = 0; j < 701; j++) {
                dpArr[i][j] = -1;
            }
        }

        return recursion(0, 0, A, B);
    }
}
