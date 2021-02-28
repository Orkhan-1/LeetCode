public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int size = s.length();

        if (size < 2) {
            return s;
        }

        int maxLength = 1;
        int start = 1;
        int end = 1;

        boolean[][] dp = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < size - 1; i++) {
            int j = i + 1;
            if (s.charAt(i) == s.charAt(j)) {
                dp[i][j] = true;
                if (j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }

        for (int k = 2; k < size; k++) {
            for (int i = 0; i < size - k; i++) {
                int j = i + k;
                if (s.charAt(i) == s.charAt(j)) {
                    if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (j - i + 1 > maxLength) {
                            maxLength = j - i + 1;
                            start = i;
                            end = j;
                        }
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }
}
