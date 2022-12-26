// Question -> https://leetcode.com/problems/unique-paths/

import java.util.*;

class Solution {
    private static int nCrModp(int n, int r, int p) {
        if (r > n - r) {
            r = n - r;
        }

        long[] C = new long[r + 1];
        Arrays.fill(C, 0);

        C[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, r); j > 0; j--) {
                C[j] = (C[j] + C[j - 1]) % p;
            }
        }

        return (int) C[r];
    }

    public int uniquePaths(int m, int n) {
        return nCrModp(m + n - 2, n - 1, 2000000009);
    }
}