import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int result = 0;
        Map<String, Integer> dp = new HashMap<>();

        for (String word : words) {
            dp.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                StringBuilder current = new StringBuilder(word);
                String next = current.deleteCharAt(i).toString();
                if (dp.containsKey(next)) {
                    dp.put(word, Math.max(dp.get(word), dp.get(next) + 1));
                }
            }
            result = Math.max(result, dp.get(word));
        }

        return result;
    }
}
