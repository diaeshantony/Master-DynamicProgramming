package DP;

public class RegularExpressionMatching {

    public static boolean matches(String S, String R) {
        return matches(S.length() - 1, R.length() - 1, S, R);
    }
    public static boolean matches(int i, int j, String S, String R) {
        if ((i == -1 && j == -1) || R.substring(i, j + 1).equals("*")) {
            return true;
        } else if (i == -1 || j == -1) {
            return false;
        }

        if (S.charAt(i) == R.charAt(j)) {
            return matches(i - 1, j - 1, S, R);
        } else if (R.charAt(j) == '.') {
            return matches(i - 1, j - 1, S, R);
        } else if (R.charAt(j) == '*') {
            return matches(i - 1, j, S, R) || matches(i, j - 1, S, R);
        }
        return false;
    }

    public static boolean matchesMemo(String S, String R) {
        int M = S.length();
        int N = S.length();
        Boolean[][] cache = new Boolean[M + 1][N + 1];
        return matchesMemo(M - 1, N - 1, S, R, cache);
    }

    public static boolean matchesMemo(int i, int j, String S, String R, Boolean[][] cache) {
        if ((i == -1 && j == -1) || R.substring(i, j + 1).equals("*")) {
            return true;
        } else if (i == -1 || j == -1) {
            return false;
        }

        if (cache[i][j] != null) {
            return cache[i][j];
        }

        if (S.charAt(i) == R.charAt(j)) {
            cache[i][j] = matchesMemo(i - 1, j - 1, S, R, cache);
            return cache[i][j];
        } else if (R.charAt(j) == '.') {
            cache[i][j] = matchesMemo(i - 1, j - 1, S, R, cache);
            return cache[i][j];
        } else if (R.charAt(j) == '*') {
            cache[i][j] = matchesMemo(i - 1, j, S, R, cache) || matchesMemo(i, j - 1, S, R,cache);
            return cache[i][j];
        }
        return false;
    }

    public static boolean matchesDP(String S, String R) {
        int M = S.length();
        int N = R.length();
        boolean[][] dp = new boolean[M + 1][N + 1];
        dp[0][0] = true;

        for (int i = 1; i <= M; i++) {
            for (int j = 1;j <= N; j++) {
                if (S.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (R.charAt(j) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (R.charAt(j) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[M][N];
    }



}
