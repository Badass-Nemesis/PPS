// Question -> Count ways to reach the n'th stair

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        while (t-- > 0) {

            // taking count of stairs
            int m = sc.nextInt();

            // creating an object of class DynamicProgramming
            Solution obj = new Solution();

            // calling method countWays() of class
            // DynamicProgramming
            System.out.println(obj.countWays(m));

        }

    }
}
// } Driver Code Ends

class Solution {
    static int[] dpArr;

    static int recursion(int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }

        if (dpArr[n] != -1) {
            return dpArr[n];
        }

        int a = recursion(n - 1);
        int b = recursion(n - 2);
        int ans = (a + b) % 1000000007;
        dpArr[n] = ans;
        return ans;
    }

    // Function to count number of ways to reach the nth stair.
    int countWays(int n) {
        // your code here
        dpArr = new int[10001];
        for (int i = 0; i < 10001; i++) {
            dpArr[i] = -1;
        }

        return recursion(n);
    }
}
