package DP;

public class StoneJump {
    // recursive solution
    // O(X^n) time where x is the number of child for each node, and n is the
    // height of the tree. O(1) is the space
    public static int minCostJump(int i, int[] C, int x) {
        if (i == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= Math.min(i, x); j++) {
            min = Math.min(min, C[i] + minCostJump(i - j, C, x));
     }
        return min;
    }

    public static int minCostMemo(int i, int[] C, int x) {
        int[] cache = new int[C.length];
        return minCostMemo(i, C, x, cache);
    }

    public static int minCostMemo(int i, int[] C, int x, int[] cache) {
        if (i == 0) {
            return 0;
        }

        if (cache[i] != 0) {
            return cache[i];
        }

        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= Math.min(i, x); j++) {
            min = Math.min(min, minCostMemo(i - j, C, x, cache));
        }

        cache[i] = min;
        return min;
    }

    // O(MN) time | O(N) space
    public static int minCostDP(int[] C, int X) {
        int N = C.length;
        int[] dp = new int[N];

        for (int i = 1; i < N; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= Math.min(i, X); j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + C[i]);
            }
        }
        return dp[N - 1];
    }
}
