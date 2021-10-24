package DP;

import java.util.Arrays;

public class PaintingHouse {
    public static final int RED = 0;
    public static final int BLUE = 1;
    public static final int GREEN = 2;

    // Standard recursive solution
    // Time O(2^n) | O(1) space
    public static int minCostRec(int[][] cost) {
        int costRed = minCost(cost, 0, RED);
        int costBlue = minCost(cost, 0, BLUE);
        int costGreen = minCost(cost, 0, GREEN);
        return Math.min(costRed, Math.min(costBlue, costGreen));
    }

    public static int minCost(int[][] cost, int i, int color) {
        if (i == cost.length) {
            return 0;
        }

        switch (color) {
            case RED : {
                int costBlue = minCost(cost,i + 1, BLUE);
                int costGreen = minCost(cost,i + 1, GREEN);
                return cost[i][RED] + Math.min(costBlue, costGreen);
            }

            case BLUE : {
                int costGreen = minCost(cost,i + 1, GREEN);
                int costRed = minCost(cost,i + 1, RED);
                return cost[i][BLUE] + Math.min(costRed, costGreen);
            }

            case GREEN : {
                int costRed = minCost(cost,i + 1, RED);
                int costBlue = minCost(cost,i + 1, BLUE);
                return cost[i][GREEN] + Math.min(costRed, costBlue);
            }
        }
        return 0;
    }

    // Top down approach using memoization
    // O(N) time | O(N) space
    public static int minCostMemo(int[][] cost) {
        int[][] cache = new int[cost.length][cost[0].length];

        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }

        int costRed = minCostMemo(cost, 0, RED, cache);
        int costBlue = minCostMemo(cost, 0, BLUE, cache);
        int costGreen = minCostMemo(cost, 0, GREEN, cache);
        return Math.min(costRed, Math.min(costBlue, costGreen));

    }

    // Memoization approach
    public static int minCostMemo(int[][] cost, int i, int color, int[][] cache) {
        if (i == cost.length) {
            return 0;
        }

        if (cache[i][color] != -1) {
            return cache[i][color];
        }

        switch (color) {
            case RED : {
                int costBlue = minCostMemo(cost,i + 1, BLUE, cache);
                int costGreen = minCostMemo(cost,i + 1, GREEN, cache);
                return cache[i][color] = cost[i][RED] + Math.min(costBlue, costGreen);
            }

            case BLUE : {
                int costGreen = minCostMemo(cost,i + 1, GREEN, cache);
                int costRed = minCostMemo(cost,i + 1, RED, cache);
                return cache[i][color] = cost[i][BLUE] + Math.min(costRed, costGreen);
            }

            case GREEN : {
                int costRed = minCostMemo(cost,i + 1, RED, cache);
                int costBlue = minCostMemo(cost,i + 1, BLUE, cache);
                return cache[i][color] = cost[i][GREEN] + Math.min(costRed, costBlue);
            }
        }
        return 0;
    }

    // O(N) time | O(N) space
    public static int minCostDP(int[][] costs) {
        int[][] dp = new int[costs.length + 1][3];
        int n = costs.length;

        if (costs.length == 0) {
            return 0;
        }

        for (int i = 1; i <= n; i++) {
            dp[i][RED] = costs[i][RED] + Math.min(dp[i - 1][BLUE], dp[i - 1][GREEN]);
            dp[i][GREEN] = costs[i][GREEN] + Math.min(dp[i - 1][RED], dp[i - 1][BLUE]);
            dp[i][BLUE] = costs[i][BLUE] + Math.min(dp[i - 1][RED], dp[i - 1][GREEN]);
        }

        return Math.min(dp[n][RED], Math.min(dp[n][BLUE], dp[n][GREEN]));
    }


}
