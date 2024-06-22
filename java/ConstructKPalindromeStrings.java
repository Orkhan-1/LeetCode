public class ConstructKPalindromeStrings {

    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        int[] chars = new int[26];
        int odd = 0;
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        for (int c : chars) {
            odd += (c % 2 == 1) ? 1 : 0;
        }
        return odd <= k;
    }
}
