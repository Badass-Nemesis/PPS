// Question -> https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1

import java.util.Arrays;

class Solution {

    static int[] dpArr;

    public static int recursion(int[] arr, int index, int n) {
        if (index >= n) {
            return 0;
        }

        if (dpArr[index] != -1) {
            return dpArr[index];
        }

        int ans1 = arr[index] + recursion(arr, index + 2, n);
        int ans2 = recursion(arr, index + 1, n);

        dpArr[index] = Math.max(ans1, ans2);

        return dpArr[index];
    }

    // Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n) {
        // Your code here
        dpArr = new int[10001];
        Arrays.fill(dpArr, -1);
        return recursion(arr, 0, n);
    }
}