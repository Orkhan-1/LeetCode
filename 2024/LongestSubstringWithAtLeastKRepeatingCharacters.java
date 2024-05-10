public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k > s.length()) {
            return 0;
        }
        return longestSubstringHelper(s, k, 0, s.length() - 1);
    }

    private int longestSubstringHelper(String s, int k, int start, int end) {
        if (end - start + 1 < k) {
            return 0;
        }

        int[] count = new int[26];
        for (int i = start; i <= end; i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = start; i <= end; i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                int j = i + 1;
                while (j <= end && count[s.charAt(j) - 'a'] < k) {
                    j++;
                }
                return Math.max(longestSubstringHelper(s, k, start, i - 1), longestSubstringHelper(s, k, j, end));
            }
        }

        return end - start + 1;
    }
}
