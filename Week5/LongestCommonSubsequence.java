public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int c = text1.length();
        int r = text2.length();
        int[][] dp = new int[c + 1][r + 1];
        for (int i = 1; i <= c; ++i) {
            for (int j = 1; j <= r; ++j) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[c][r];
    }
}
