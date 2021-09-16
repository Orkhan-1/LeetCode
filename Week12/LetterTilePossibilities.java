import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities {

    private Set<String> set;
    private char[] chars;

    public int numTilePossibilities(String tiles) {

        int size = tiles.length();
        set = new HashSet<>();
        chars = tiles.toCharArray();

        for (int i = 1; i <= size; i++) {
            bt(new boolean[size], i, set, chars, new StringBuilder());
        }

        return set.size();
    }

    private void bt(boolean[] visited, int length, Set<String> set, char[] chars, StringBuilder current) {
        if (length == 0) {
            set.add(current.toString());
        }

        for (int i = 0; i < chars.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.append(chars[i]);
                bt(visited, length - 1, set, chars, current);
                current.deleteCharAt(current.length() - 1);
                visited[i] = false;
            }
        }
    }
}
