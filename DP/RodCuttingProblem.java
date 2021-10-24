package DP;

import java.util.Arrays;

public class RodCuttingProblem {
    public static int maxProfit(int l, int[] P) {
        // length 0 is the base case
        if (l == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        // we need to enumerate all the candidate
        for (int i = 0; i < l; i++) {
            // for each candidate find the max profit and update the max
            max = Math.max(max, maxProfit(l - i - 1, P));
        }
        return max;
    }

    // Memoization approach
    public static int maxProfitMemo(int l, int[] P) {
        int[] cache = new int[l + 1];
        Arrays.fill(cache, -1);
        return maxProfitMemo(l, P, cache);
    }

    public static int maxProfitMemo(int l, int[] P, int[] cache) {
        // length 0 is the base case
        if (l == 0) {
            return 0;
        }

        if (cache[l] != -1) {
            return cache[l];
        }

        int max = Integer.MIN_VALUE;
        // we need to enumerate all the candidate
        for (int i = 0; i < l; i++) {
            // for each candidate find the max profit and update the max
            max = Math.max(max, maxProfitMemo(l - i - 1, P, cache));
        }
        cache[l] = max;
        return max;
    }

    public static int maxProfitDp(int L , int[] P) {
        // Dp array length is L + 1
        int[] dp = new int[L + 1];

        // Outer loop is generate all sub problems with different length
        for (int l = 1; l <= L; l++) {
            dp[l] = Integer.MIN_VALUE;
            // Inner loop is to find the profit for each sub problem
            for (int i = 0; i < l; i++) {
                dp[l] = Math.max(dp[l], P[i] + dp[l - i - i]);
            }
        }
        return dp[L];
    }
}
