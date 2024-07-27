import java.util.ArrayList;
import java.util.List;

// Time complexity -  O(2^N)
// Space complexity - O (2^N)
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        if (S == null || S.isEmpty()) {
            return result;
        }
        bt(S.toCharArray(), 0, result);
        return result;
    }

    private void bt(char[] chars, int index, List<String> result) {
        result.add(new String(chars));

        for (int i = index; i < chars.length; i++) {
            char ch = chars[i];
            char tempChar = ch;

            if (ch >= 'a' && ch <= 'z') {
                chars[i] = Character.toUpperCase(ch);
                bt(chars, i + 1, result);
            } else if (ch >= 'A' && ch <= 'Z') {
                chars[i] = Character.toLowerCase(ch);
                bt(chars, i + 1, result);
            }
            chars[i] = tempChar;
        }
    }
}
