import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {

        int size = p.length();
        int[] pLetters = new int[26];
        int[] sLetters = new int[26];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            pLetters[p.charAt(i) - 'a']++;
        }

        int currentSize = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sLetters[c - 'a'] += 1;
            currentSize++;
            if (currentSize > size) {
                sLetters[s.charAt(i - size) - 'a']--;
            }

            if (Arrays.equals(sLetters, pLetters)) {
                result.add(i - size + 1);
            }
        }
        return result;
    }
}
