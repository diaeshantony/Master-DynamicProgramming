package DP;

public class MinCostPath {
    // Recursive approach, the height of the tree is 2n and
    // time is O(4^N) | O(1) space
    public static int minCostPath(int i, int j, int[][] grid) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }

        int min = Integer.MAX_VALUE;
        if (i > 0) {
            min = minCostPath(i - 1, j , grid) + grid[i][j];
        }

        if (j > 0) {
            min = Math.min(min, minCostPath(i, j - 1, grid) + grid[i][j]);
        }

        return min;
    }

    public static int minCostPathMemo(int i, int j, int[][] grid, int[][] cache) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }

        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        int min = Integer.MAX_VALUE;
        if (i > 0) {
            min = minCostPathMemo(i - 1, j , grid, cache) + grid[i][j];
        }
        if (j > 0) {
            min = Math.min(min, minCostPathMemo(i, j - 1, grid, cache) + grid[i][j]);
        }
        cache[i][j] = min;
        return min;
    }

    // DP : O(N^2) time | O(N^2) space
    public static int minCostPathDP(int[][] G) {
        int N = G.length;
        int[][] dp = new int[N][N];
        dp[0][0] = G[0][0];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                dp[i][j] = Integer.MAX_VALUE;
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j] + G[i][j];
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + G[i][j]);
                }
            }
        }
        return dp[N - 1][N - 1];
    }
}
