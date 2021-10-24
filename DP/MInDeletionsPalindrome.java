package DP;

public class MInDeletionsPalindrome {
    // Recursive solution : O(2^n) time | O(1) space
    public static int minDeletionsPalindrome(int i, int j, String S) {
        if (i >= j) {
            return 0;
        }

        if (S.charAt(i) == S.charAt(j)) {
            return minDeletionsPalindrome(i + 1, j - 1, S);
        } else {
            return Math.min(minDeletionsPalindrome(i + 1, j, S), minDeletionsPalindrome(i, j - 1, S)) + 1;
        }
    }

    public static int minDeletionsPalindromeMemo(int i, int j, String S, int[][] cache) {
        if (i >= j) {
            return 0;
        }

        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        if (S.charAt(i) == S.charAt(j)) {
            cache[i][j] = minDeletionsPalindromeMemo(i + 1, j - 1, S, cache);
            return cache[i][j];
        } else {
            cache[i][j] = Math.min(minDeletionsPalindromeMemo(i + 1, j, S, cache), minDeletionsPalindromeMemo(i, j - 1, S, cache)) + 1;
            return cache[i][j];
        }
    }

    // O(N^2) time | O(N^2) space
    public static int minDeletionsPalindromeDP(String S) {
        int N = S.length();
        int[][] dp = new int[N][N];

        // When we have two pointer, the for loop iteration is different, note below
        for (int l = 1; l <= N; l++) {
            // i from 0 to N - l
            for (int i = 0; i < N - l; i++) {
                // j = l + i - 1
                int j = l + i - 1;

                if (i == j) {
                    dp[i][j] = 0;
                    continue;
                }

                if (S.charAt(i) == S.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
                }
            }
        }
        return dp[0][N - 1];
    }
}
