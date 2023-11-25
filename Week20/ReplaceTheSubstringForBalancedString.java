public class ReplaceTheSubstringForBalancedString {

    // Time complexity - O (N)
    // Space complexity - O (1)

    public int balancedString(String s) {
        int[] chars = new int[26];

        for (char c : s.toCharArray()) {
            chars[c - 'A']++;
        }

        int target = s.length() / 4;
        int l = 0;
        int result = s.length();
        for (int r = 0; r < s.length(); r++) {
            chars[s.charAt(r) - 'A']--;
            while (l < s.length() && chars['Q' - 'A'] <= target
                    && chars['W' - 'A'] <= target &&
                    chars['R' - 'A'] <= target
                    && chars['E' - 'A'] <= target) {
                chars[s.charAt(l) - 'A']++;
                result = Math.min(result, r - l + 1);
                l++;
            }
        }
        return result;
    }

}
