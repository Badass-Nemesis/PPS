// Question -> https://www.interviewbit.com/old/problems/repeating-subsequence/

class Solution {
    static int[][] dpArr;

    public static int recursion(int firstP, int secondP, String s1, String s2) {
        if (firstP == s1.length() || secondP == s2.length()) {
            return 0;
        }

        if (dpArr[firstP][secondP] != -1) {
            return dpArr[firstP][secondP];
        }

        if (s1.charAt(firstP) == s2.charAt(secondP) && firstP != secondP) {
            dpArr[firstP][secondP] = 1 + recursion(firstP + 1, secondP + 1, s1, s2);
            return dpArr[firstP][secondP];
        } else {
            int ans1 = recursion(firstP + 1, secondP, s1, s2);
            int ans2 = recursion(firstP, secondP + 1, s1, s2);

            dpArr[firstP][secondP] = Math.max(ans1, ans2);
            return dpArr[firstP][secondP];
        }
    }

    public int anytwo(String A) {
        dpArr = new int[101][101];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                dpArr[i][j] = -1;
            }
        }

        int ans = recursion(0, 0, A, A);

        if (ans >= 2) {
            return 1;
        } else {
            return 0;
        }
    }
}

// my brute-force is not working, dunno why.
class Solution2 {
    public int anytwo(String A) {
        for (int i = 0; i < A.length(); i++) {
            for (int j = i; j < A.length(); j++) {
                if (A.charAt(i) == A.charAt(j)) {
                    int leftP = i + 1;
                    int rightP = j + 1;
                    while (leftP < j && rightP < A.length()) {
                        if (A.charAt(leftP) == A.charAt(rightP)) {
                            return 1;
                        } else {
                            leftP++;
                            rightP++;
                        }
                    }
                }
            }
        }

        return 0;
    }
}