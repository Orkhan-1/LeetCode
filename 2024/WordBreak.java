import java.util.List;

// Time complexity - O (N*L) n is the length of the input string s and L is the average length of words in the word dictionary.
// Space complexity - O (N)
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {

                if (i >= word.length() && dp[i - word.length()] && s.substring(i - word.length(), i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
