import java.util.ArrayList;
import java.util.List;

// Time complexity - O (D*W + Q*W)
// Space complexity - O (D*W)
public class WordsWithinTwoEditsOfDictionary {

    // digital tree or prefix tree
    TrieNode root = new TrieNode('-');

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        for (String word : dictionary) {
            addWord(word);
        }
        for (String query : queries) {
            TrieNode current = root;
            if (searchWord(current, query, 0, 0)) {
                result.add(query);
            }
        }
        return result;
    }

    private void addWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode(word.charAt(i));
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }

    private boolean searchWord(TrieNode current, String word, int count, int index) {
        if (index == word.length()) {
            return count <= 2;
        }
        boolean result = false;
        for (int i = 0; i < current.children.length; i++) {
            if (current.children[i] != null) {
                result = result || searchWord(current.children[i], word,
                        count + (((word.charAt(index) - 'a') == i) ? 0 : 1), index + 1);
            }
        }
        return result;
    }

    class TrieNode {
        char data;
        boolean isEnd;
        TrieNode[] children;

        TrieNode(char data) {
            this.data = data;
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }

}
