
//     Java
// Time complexity - O(M x N x L); L - number of string
// Space complexity - O(M x N)
public class OnesAndZeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String s : strs) {
            int zeroes = 0;
            int ones = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zeroes++;
                }
                if (c == '1') {
                    ones++;
                }
            }

            for (int i = m; i >= zeroes; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroes][j - ones] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
