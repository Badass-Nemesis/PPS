// Question -> https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1?category=

class Solution {
    // Function to find the length of longest common subsequence in two strings.
    static int[][] dpArr;

    public static int recursion(int firstPointer, int secondPointer, String s1, String s2) {
        if (firstPointer == s1.length() || secondPointer == s2.length()) {
            return 0; // not possible
        }

        if (dpArr[firstPointer][secondPointer] != -1) {
            return dpArr[firstPointer][secondPointer];
        }

        if (s1.charAt(firstPointer) == s2.charAt(secondPointer)) {
            // if found same character at indices, then store it in dp as 1 found and
            // increment the pointers
            dpArr[firstPointer][secondPointer] = 1 + recursion(firstPointer + 1, secondPointer + 1, s1, s2);
            return dpArr[firstPointer][secondPointer];
        } else {
            int ans1 = recursion(firstPointer + 1, secondPointer, s1, s2);
            int ans2 = recursion(firstPointer, secondPointer + 1, s1, s2);
            // no need for this ans3, because it is same as above if block
            // int ans3 = recursion(firstPointer + 1, secondPointer + 1, s1, s2);

            dpArr[firstPointer][secondPointer] = Math.max(ans1, ans2);
            // returning and storing max, because we need max subsequence
            return dpArr[firstPointer][secondPointer];
        }

    }

    static int lcs(int x, int y, String s1, String s2) {
        // your code here
        dpArr = new int[1001][1001];
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                dpArr[i][j] = -1;
            }
        }

        return recursion(0, 0, s1, s2);
    }
}