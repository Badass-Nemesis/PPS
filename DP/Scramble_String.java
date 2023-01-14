// Question -> https://www.interviewbit.com/problems/scramble-string/

class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY

    // Not working code here
    /*
     * static HashMap<Pair, Boolean> hm;
     * 
     * public static boolean recursion(String a, String b) {
     * Pair p = new Pair(a, b);
     * if (a.equals(b)) {
     * return true;
     * }
     * 
     * if (hm.containsKey(p)) {
     * return hm.get(p);
     * }
     * 
     * for (int i = 1; i < a.length() - 1; i++) {
     * String s1 = a.substring(0, i);
     * String s2 = a.substring(i);
     * String s3 = b.substring(0, i);
     * String s4 = b.substring(i);
     * String s5 = b.substring(0, a.length() - i);
     * String s6 = b.substring(a.length() - i);
     * 
     * if ((recursion(s1, s3) && recursion(s2, s4)) || (recursion(s1, s6) &&
     * recursion(s2, s5))) {
     * hm.put(p, true);
     * return hm.get(p);
     * }
     * }
     * 
     * hm.put(p, false);
     * return hm.get(p);
     * }
     * 
     * public static class Pair {
     * String a;
     * String b;
     * 
     * Pair(String a, String b) {
     * this.a = a;
     * this.b = b;
     * }
     * }
     */

    static Boolean[][][] dpArr;

    static boolean recursion(String s1, String s2, int si1, int si2, int len) {
        // checking if left side of s1 (i.e. from starting index 1 to stating index 1 -
        // length) is equal to left side of s2 (i.e. from starting index 2 to starting
        // index 2 - length) or not.
        if (s1.substring(si1, si1 + len).equals(s2.substring(si2, si2 + len))) {
            return true;
        }

        if (dpArr[si1][si2][len] != null) {
            return dpArr[si1][si2][len];
        }

        // this for loops is only here to give use the idea of how many cuts we can
        // perform
        for (int k = 1; k < len; k++) {
            /*
             * what we are checking here:-
             * 1) are left side of s1 and s2 string equal or not?
             * 2) are right side of s1 and s2 string equal or not?
             * 3) are right side of s1 ans left side of s2 equal or not
             * 4) are left side of s1 and right side of s2 equal or not
             * 
             * the starting index and length of substring matters the most here.
             * in 4th option, take a look at the (...,si2+len-k,k), it is written in this
             * form instead of si2+k, because in 2nd option we are checking both s1's and
             * s2's right side, that's why it doesn't matter there how we are changing the
             * stating index. whereas in 4th option, we are taking left portion of s1 and
             * right portion of s2. since we are taking k length right portion of s2, so we
             * need to see it like this (move backwards from the last ending, about k
             * length), that's why we are writing the starting index of s2 as move forward
             * from s2 by the length of len-k units.
             */
            if ((recursion(s1, s2, si1, si2, k) && recursion(s1, s2, si1 + k, si2 + k, len - k))
                    || (recursion(s1, s2, si1 + k, si2, len - k) && recursion(s1, s2, si1, si2 + len - k, k))) {
                dpArr[si1][si2][len] = true;
                return true;
            }
        }

        dpArr[si1][si2][len] = false;
        return false;
    }

    public int isScramble(final String A, final String B) {
        if (A.length() != B.length()) {
            return 0;
        }

        dpArr = new Boolean[A.length() + 1][A.length() + 1][A.length() + 1];
        boolean ans = recursion(A, B, 0, 0, A.length());
        return ans == true ? 1 : 0;
    }

}
