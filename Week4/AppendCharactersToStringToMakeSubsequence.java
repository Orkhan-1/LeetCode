public class AppendCharactersToStringToMakeSubsequence {

    public int appendCharacters(String s, String t) {

        char[] a = t.toCharArray();
        char[] b = s.toCharArray();

        int i = 0;
        int j = 0;

        while (i < t.length() && j < s.length()) {
            if (a[i] != b[j]) {
                j++;
            } else if (a[i] == b[j]) {
                i++;
                j++;
            }
        }

        return t.length() - i;
    }
}
