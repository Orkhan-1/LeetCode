public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int size = s.length();

        if (size < 2) {
            return 1;
        }

        int count = 0;

        boolean[][] dp = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            dp[i][i] = true;
            count++;
        }

        for (int i = 0; i < size - 1; i++) {
            int j = i + 1;
            if (s.charAt(i) == s.charAt(j)) {
                dp[i][j] = true;
                count++;
            }
        }

        for (int k = 2; k < size; k++) {
            for (int i = 0; i < size - k; i++) {
                int j = i + k;
                if (s.charAt(i) == s.charAt(j)) {
                    if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
