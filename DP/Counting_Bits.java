// Question -> https://leetcode.com/problems/counting-bits/

class Solution {
    public int[] countBits(int n) {
        int[] dpArr = new int[n + 1];
        // kyunki total n+1 size ka hi ans array banega, including the 0th index, jisme
        // hamesha 0 hi aayega
        dpArr[0] = 0;

        for (int i = 1; i <= n; i++) {
            int x = (int) (Math.log(i) / Math.log(2));
            // in above x, we are finidng the closest 2 ka power element for the value of i,
            // by taking log2(i), just so we can get the most significant bit of the number
            dpArr[i] = 1 + dpArr[i - (1 << x)];
            // so above we are finding the number of 1 bits using DP (we could also use
            // recursion, no problem in that). first we need to add the current 1 bit count
            // (kyunki log2(i) le chuke h usse, matlab MSB), uske baad we need to find the 1
            // bit count of (i-2^x). since i-2^x has ocurred already in the dp before,
            // that's why we can simply put the value of it here.
        }

        return dpArr;
    }
}