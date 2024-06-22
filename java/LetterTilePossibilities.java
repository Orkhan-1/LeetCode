import java.util.HashSet;
import java.util.Set;

// Time complexity -  O(N!)
// Space complexity - O (N!)
public class LetterTilePossibilities {

    public int numTilePossibilities(String tiles) {
        Set<String> result = new HashSet<>();
        bt(tiles.toCharArray(), new boolean[tiles.length()], new StringBuilder(), result);
        return result.size();
    }

    private void bt(char[] tiles, boolean[] visited, StringBuilder tempResult, Set<String> result) {
        for (int i = 0; i < tiles.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tempResult.append(tiles[i]);
                result.add(tempResult.toString());
                bt(tiles, visited, tempResult, result);
                tempResult.deleteCharAt(tempResult.length() - 1);
                visited[i] = false;
            }
        }
    }
}