package DP;

import java.util.Set;

public class CountBrokenWords {
    public static int countWays(String S, Set<String> dictionary) {
        return countWays(S.length() - 1, S, dictionary);
    }

    // Recursive approach O(2^n) time | O(1) space
    public static int countWays(int i, String S, Set<String> dictionary) {
        if (i == -1) {
            return 1;
        }

        int count = 0;
        for (int j = i; j >= 0; j--) {
            String subString = S.substring(j, i + 1);
            if (dictionary.contains(subString)) {
                count += countWays(j - 1,S, dictionary);
            }
        }
        return count;
    }

    // Memoization
    public static int countWaysMemo(String S, Set<String> dict) {
        int N = S.length();
        int[] cache = new int[N];
        return countWaysMemo(S.length() - 1, S, dict, cache);
    }

    public static int countWaysMemo(int i, String S, Set<String> dictionary, int[] cache) {
        if (i == -1) {
            return 1;
        }

        if (cache[i] != -1) {
            return cache[i];
        }

        int count = 0;
        for (int j = i; j >= 0; j--) {
            String subString = S.substring(j, i + 1);
            if (dictionary.contains(subString)) {
                count += countWaysMemo(j - 1,S, dictionary, cache);
            }
        }
        cache[i] = count;
        return count;
    }

    // DP solution time O(N^2) time | O(N) space
    public static int countWaysDP(String S, Set<String> dictionary) {
        int N = S.length();
        int[] dp = new int[N + 1];

        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = i; j >= 1; j--) {
                String subString = S.substring(j - 1, i);
                if (dictionary.contains(subString)) {
                    dp[i] += dp[j - 1];
                }
            }
        }
        return dp[N];
    }
}
