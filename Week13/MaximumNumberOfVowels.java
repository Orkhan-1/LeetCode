public class MaximumNumberOfVowels {

    public int maxVowels(String s, int k) {
        int max = 0;
        int current = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                current++;
            }
            if (i >= k && isVowel(s.charAt(i - k))) {
                current--;
            }
            max = Math.max(max, current);
        }
        return max;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
