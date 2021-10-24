package DP;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class LongestCommonSubSequenceInStrings {

    // Recursive version O(2^N) time | O(1) space
    public static int LCS(int i, int j, String A, String B) {
        if (i == -1 || j == -1) {
            return 0;
        }

        if (A.charAt(i) == B.charAt(j)) {
            return LCS(i - 1, j - 1, A, B) + 1;
        } else {
            return Math.max(LCS(i - 1, j, A, B), LCS(i, j - 1, A, B));
        }
    }

    // Memoization
    public static int LCSMemo(String A, String B) {
        int[][] cache = new int[A.length()][B.length()];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return LCSMemo(A.length() - 1, B.length() - 1, A, B, cache);
    }

    public static int LCSMemo(int i, int j, String A, String B, int[][] cache) {
        if (i == -1 || j == -1) {
            return 0;
        }

        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        if (A.charAt(i) ==  B.charAt(j)) {
            cache[i][j] = LCSMemo(i - 1, j - 1, A, B, cache) + 1;
            return cache[i][j];
        } else {
            cache[i][j] = Math.max(LCSMemo(i - 1, j, A, B, cache), LCSMemo(i, j - 1, A, B, cache));
            return cache[i][j];
        }
    }

    // DP version O(MN) time | O(MN) space
    public static int LCSdp(String A, String B) {
        int M = A.length();
        int N = B.length();

        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[M][N];
    }
}
