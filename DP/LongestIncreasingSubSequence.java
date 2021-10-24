package DP;

public class LongestIncreasingSubSequence {
    // Recursive approach O(2^N) time | O(1) space
    public static int longestIncreasingSubSequence(int i, int[] A) {
        if (i == 0) {
            return 1;
        }

        int max = 0;
        for (int j = 0; j < i; j++) {
            int lis = longestIncreasingSubSequence(j, A);
            if (A[i] > A[j]) {
                lis += 1;
            }
            max = Math.max(max, lis);
        }
        return max;
    }

    // Memoization
    public static int lisMemo(int[] A) {
        int[] cache = new int[A.length];
        return lisMemo(A.length - 1, A, cache);
    }

    public static int lisMemo(int i, int[] A, int[] cache) {
        if (i == 0) {
            return 1;
        }

        if (cache[i] != 0) {
            return cache[i];
        }

        int max = 0;
        for (int j = 0; j < i; j++) {
            int lis = lisMemo(j, A, cache);
            if (A[i] > A[j]) {
                lis += 1;
            }
            max = Math.max(max, lis);
        }
        cache[i] = max;
        return max;
    }


    // O(N^2) time | O(N) space
    public static int lisDP(int[] A) {
        int N = A.length;
        int[] dp = new int[N];
        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                int lis = dp[j];
                if (A[i] > A[j]) {
                    lis += 1;
                }
                dp[i] = Math.max(dp[i], lis);
            }
        }
        return dp[N - 1];
    }

}
