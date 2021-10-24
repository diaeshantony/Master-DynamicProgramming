package DP;

public class MoneyRobbing {

    // recursive solution
    // O(2^N) time | O(1) space
    public static int maxProfit(int [] S, int i) {
        if (i < 0) {
            return 0;
        }

        if (i == 0) {
            return S[0];
        }

        return Math.max(S[i] + maxProfit(S,i - 2), maxProfit(S, i - 1));

    }

    // memoization
    public static int maxProfitMemo(int[] S, int i, int[] cache) {
        if (i < 0) {
            return 0;
        }

        if (i == 0) {
            return S[0];
        }

        if (cache[i] != 0) {
            return cache[i];
        }

        int profit = Math.max(S[i] + maxProfitMemo(S, i - 2, cache), maxProfitMemo(S, i - 1, cache));
        cache[i] = profit;

        return profit;
    }

    // DP
    // O(N) time | O(N) space
    public static int maxProfitDP(int[] S) {
        int N = S.length;
        int [] dp = new int[N + 1];

        dp[1] = S[0];
        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(S[i -1] + dp[i - 2], dp[i - 1]);
        }
        return dp[N];
    }
}
