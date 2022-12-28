// Question -> https://leetcode.com/problems/longest-increasing-subsequence/
// Question -> https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1

class Solution {
    static int[] dpArr;

    public static int recursion(int index, int n, int[] arr, int previous) {
        if (index == n) {
            return 0;
        }

        // NOTE - here in dpArr, we are taking 1 based indexing, just because we took
        // previous as -1, so dpArr[-1] will give error eventually. so no need to worry.
        if (dpArr[previous + 1] != -1) {
            return dpArr[previous + 1];
        }

        if (previous == -1 || arr[index] > arr[previous]) {
            // either take this element
            int ans1 = 1 + recursion(index + 1, n, arr, index);
            // or don't take this element, but make previous static for next round
            int ans2 = recursion(index + 1, n, arr, previous);

            return dpArr[previous + 1] = Math.max(ans1, ans2);
        } else {
            // if previous is bigger than index, then do nothing and just skip that index,
            // while keeping the previous static
            return dpArr[previous + 1] = recursion(index + 1, n, arr, previous);
        }
    }

    public int lengthOfLIS(int[] nums) {
        dpArr = new int[100001];
        for (int i = 0; i <= nums.length; i++) {
            dpArr[i] = -1;
        }
        // basically we are storing dpArr for previous index's max

        return recursion(0, nums.length, nums, -1);
    }
}