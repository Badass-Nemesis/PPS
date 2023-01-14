// Question -> https://practice.geeksforgeeks.org/problems/max-length-chain/1

class GfG {
    static class Pair {
        int x;
        int y;

        public Pair(int a, int b) {
            x = a;
            y = b;
        }
    }

    static int[] dpArr;

    public static int recursion(Pair arr[], int n, int i, int prev) {
        if (i == n) {
            return 0;
        }

        // nothing to see here, just taking 1 indexing because of -1
        if (dpArr[prev + 1] != -1) {
            return dpArr[prev + 1];
        }

        if (prev == -1 || arr[prev].y < arr[i].x) {
            int ans1 = 1 + recursion(arr, n, i + 1, i);
            int ans2 = recursion(arr, n, i + 1, prev);
            dpArr[prev + 1] = Math.max(ans1, ans2);
            return dpArr[prev + 1];
        } else {
            dpArr[prev + 1] = recursion(arr, n, i + 1, prev);
            return dpArr[prev + 1];
        }
    }

    int maxChainLength(Pair arr[], int n) {
        // your code here
        dpArr = new int[100001];
        for (int i = 0; i < n; i++) {
            dpArr[i] = -1;
        }

        return recursion(arr, n, 0, -1);
    }
}
