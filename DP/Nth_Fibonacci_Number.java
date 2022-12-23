// Question -> https://practice.geeksforgeeks.org/problems/nth-fibonacci-number1335/1

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

// User function Template for Java
class Solution {
    static long[] dpArr;

    static long recursion(long n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        if (dpArr[(int) n] != -1) {
            return dpArr[(int) n];
        }

        long ans = (recursion(n - 1) + recursion(n - 2)) % 1000000007;
        dpArr[(int) n] = ans;

        return ans;
    }

    static long nthFibonacci(long n) {
        // code here
        dpArr = new long[1001];
        for (int i = 0; i < 1001; i++) {
            dpArr[i] = -1;
        }

        return recursion(n);
    }
}