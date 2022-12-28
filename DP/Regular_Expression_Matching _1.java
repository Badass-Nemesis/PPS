// Question -> https://leetcode.com/problems/regular-expression-matching/
// Question -> https://www.interviewbit.com/problems/regular-expression-ii/

// Note -> different operators, in different things
class Solution {
    static int[][] dpArr;

    public static int recursion(int firstP, int secondP, String s1, String s2) {
        if (firstP == s1.length() && secondP == s2.length()) {
            // iska matlab ki dono pointer last tak pahuch gaya h, aur saara qes mark aur
            // star sab utilize ho gaya h s2 mein se, to get the string s1
            return 1;
        }

        if (firstP == s1.length()) {
            // agar mera s1 ka pointer last tak pahuch gaya h, to isme 2 hi case ho sakta h.
            // agar s2 ka pointer last tak pahuch gaya usme (by only getting star in the
            // path), tab fir usko valid bol sakte h, kyunki star mera nothingness mein
            // dissolve ho sakta h. aur dusra kuch aur case hoga iske alawa, jaise beech
            // path mein qes mark aa jaye, ya fir while loop tuut jaaye, tab fir iska matlab
            // hum s2 ko kabhi change ni kar payenge, to usme return false.
            while (secondP < s2.length() && s2.charAt(secondP) == '*') {
                secondP++;
            }

            if (secondP == s2.length()) {
                return 1;
            } else {
                return 0;
            }
        }

        if (secondP == s2.length()) {
            // s1 ka pointer end hone se pehle s2 ka saara element hi exhaust ho gaya h, to
            // usme kuch kar hi ni sakte h, isiliye return false.
            return 0;
        }

        // basic memoization
        if (dpArr[firstP][secondP] != -1) {
            return dpArr[firstP][secondP];
        }

        // ab aaya 3 asli case
        if (s1.charAt(firstP) == s2.charAt(secondP) || s2.charAt(secondP) == '.') {
            return dpArr[firstP][secondP] = recursion(firstP + 1, secondP + 1, s1, s2);
        }

        if (s2.charAt(secondP) == '*') {
            // this means that we could either take the star into consideration, or not.
            // while taking into consideration, we have to move the s1 pointer, else we can
            // ignore the star and just move s2 pointer.
            // return dpArr[firstP][secondP] = recursion(firstP + 1, secondP, s1, s2)
            // | recursion(firstP, secondP + 1, s1, s2);

            // or, we could do this
            // basic take it or leave it move
            int ans1 = recursion(firstP + 1, secondP, s1, s2);
            int ans2 = recursion(firstP, secondP + 1, s1, s2);

            dpArr[firstP][secondP] = ans1 | ans2;
            // 0 OR 1 is 1, so that is basically a logic for false OR true = true

            return dpArr[firstP][secondP];
        }

        if (s1.charAt(firstP) != s2.charAt(secondP)) {
            // if all the above cases are not there, and it enters this block, i.e. the
            // characters itself are different in both of them, then there's no chance that
            // s2 can be transformed into s1.
            return dpArr[firstP][secondP] = 0;
        }

        return 0;
    }

    public boolean isMatch(String s, String p) {
        dpArr = new int[2533][2533];
        for (int i = 0; i < 2533; i++) {
            for (int j = 0; j < 2533; j++) {
                dpArr[i][j] = -1;
            }
        }
        int ans = recursion(0, 0, s, p);

        if (ans > 0) {
            return true;
        } else {
            return false;
        }
    }
}