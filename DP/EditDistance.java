package DP;

import java.util.SplittableRandom;

public class EditDistance {
    // O(3^N) time | O(1) space
    public static int editDistance(int i, int j, String A, String B) {
        if (i == -1) {
            return j + 1;
        }

        if (j == -1) {
            return i + 1;
        }

        if (A.charAt(i) == B.charAt(j)) {
            return editDistance(i - 1, j - 1, A, B);
        } else {
            return Math.min(editDistance(i , j - 1 , A, B),  Math.min(editDistance(i - 1, j - 1, A, B),
                    editDistance(i - 1, j , A, B))) + 1;
        }
    }


    public static int editDistanceMemo(int i, int j, String A, String B, int[][] cache) {
        if (i == -1) {
            return j + 1;
        }

        if (j == -1) {
            return i + 1;
        }

        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        if (A.charAt(i) == B.charAt(j)) {
            int ed = editDistanceMemo(i - 1, j - 1, A, B, cache);
            cache[i][j] = ed;
            return cache[i][j];
        } else {
            int ed = Math.min(editDistanceMemo(i , j - 1 , A, B,cache),  Math.min(editDistanceMemo(i - 1, j - 1, A, B, cache),
                    editDistanceMemo(i - 1, j , A, B, cache))) + 1;
            cache[i][j] = ed;
            return ed;
        }
    }

    // DP solution - O(MN) time | O(MN) space
    public static int editDistanceDP(String A, String B) {
        int M = A.length();
        int N = B.length();

        int dp[][] = new int[M + 1][N + 1];
        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        return dp[M][N];
    }
}
