public class GreatestEnglishLetterInUpperAndLowerCase {

    public String greatestLetter(String s) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((int) c < 91) {
                upper[c - 'A'] = true;
            } else {
                lower[c - 'a'] = true;
            }
        }
        for (int i = 25; i >= 0; i--) {
            if (lower[i] && upper[i]) {
                return Character.toString(i + 'A');
            }
        }
        return "";
    }
}
