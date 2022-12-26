// Question -> https://practice.geeksforgeeks.org/problems/reach-a-given-score-1587115621/1

//{ Driver Code Starts
// Driver Code
import static java.lang.System.out;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int T = in.nextInt(); T-- > 0;) {
            int n = in.nextInt();

            Geeks obj = new Geeks();
            out.println(obj.count(n));
        }
    }
}
// } Driver Code Ends

// Complete this function!

class Geeks {
    static long[][] dpArr;

    static long recursion(int index, long sum, long[] arr) {
        if (sum == 0) {
            return 1;
        } else if (sum < 0 || index > 2) {
            return 0;
        }

        if (dpArr[index][(int) sum] != -1) {
            return dpArr[index][(int) sum];
        }

        // ya to wo index wala element ko le lenge, to fir sum mein se utna ko minus
        // karna padega
        long ans1 = recursion(index, sum - arr[index], arr);
        // ya fir wo index wala ko ni lenge, to fir aage jaana padega humlog ko 1 index
        long ans2 = recursion(index + 1, sum, arr);

        dpArr[index][(int) sum] = ans1 + ans2;
        return dpArr[index][(int) sum];
    }

    public long count(int n) {
        dpArr = new long[3][10001];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10001; j++) {
                dpArr[i][j] = -1;
            }
        }

        long[] arr = { 3, 5, 10 };
        return recursion(0, n, arr);
    }
}