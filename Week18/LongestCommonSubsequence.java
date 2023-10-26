public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {

        int f = text1.length();
        int s = text2.length();

        int[][] dp = new int[f + 1][s + 1];

        for (int i = 1; i <= f; i++) {
            for (int j = 1; j <= s; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[f][s];
    }
}
