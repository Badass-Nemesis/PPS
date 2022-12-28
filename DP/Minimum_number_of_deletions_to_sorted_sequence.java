// Question -> https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-to-make-a-sorted-sequence3248/1?category=

class Solution {
    static int[] dpArr;

    public static int recursion(int index, int[] arr, int previous) {
        if (index == arr.length) {
            return 0;
        }

        // NOTE - here in dpArr, we are taking 1 based indexing, just because we took
        // previous as -1, so dpArr[-1] will give error eventually. so no need to worry.
        if (dpArr[previous + 1] != -1) {
            return dpArr[previous + 1];
        }

        if (previous == -1 || arr[previous] < arr[index]) {
            int ans1 = 1 + recursion(index + 1, arr, index);
            int ans2 = recursion(index + 1, arr, previous);

            dpArr[previous + 1] = Math.max(ans1, ans2);
            return dpArr[previous + 1];
        } else {
            return dpArr[previous + 1] = recursion(index + 1, arr, previous);
        }
    }

    public int minDeletions(int arr[], int n) {
        // code here.
        dpArr = new int[1001];
        for (int i = 0; i < 1001; i++) {
            dpArr[i] = -1;
        }

        int ans = n - recursion(0, arr, n);
        return ans;
    }
}