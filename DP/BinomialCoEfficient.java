package DP;

public class BinomialCoEfficient {
    // Recursion
    public static int binomialCoEfficient(int n, int k) {
        if (n == k || k == 0) {
            return 1;
        }

        return binomialCoEfficient(n - 1, k - 1) + binomialCoEfficient(n - 1, k);
    }

    //Memoization
    public static int binomialCoEfficient(int n, int k, int[][] cache) {
        if (cache[n][k] != 0) {
            return cache[n][k];
        }

        int res = binomialCoEfficient(n - 1, k - 1, cache) + binomialCoEfficient(n - 1, k, cache);
        cache[n][k] = res;
        return res;
    }

    // DP solution
    public static int binomialCoEfficient_DP(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            if (i <= k) {
                dp[i][i] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        return dp[n][k];
    }

}
