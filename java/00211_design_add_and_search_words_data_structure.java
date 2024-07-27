
// Time complexity - O (N)
// Space complexity - O (N)
public class WordDictionary {
    private TrieNode root = new TrieNode('-');

    class TrieNode {

        char data;
        boolean isEnd = false;
        TrieNode[] children;

        TrieNode(char data) {
            this.data = data;
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }

    public WordDictionary() {
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) { // map 'm', 'a'
            if (current.children[word.charAt(i) - 'a'] == null) {
                current.children[word.charAt(i) - 'a'] = new TrieNode(word.charAt(i));
            }
            current = current.children[word.charAt(i) - 'a'];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    public boolean search(String word, int index, TrieNode root) {

        // base case
        if (index == word.length() && root.isEnd) { // .ap
            return true;
        }

        if (index == word.length()) {
            return false;
        }

        if (word.charAt(index) == '.') {
            for (int i = 0; i < 26; i++) { // bad, map
                if (root.children[i] != null && search(word, index + 1, root.children[i])) {
                    return true;
                }
            }
        } else {
            return root.children[word.charAt(index) - 'a'] != null && // bad
                    search(word, index + 1, root.children[word.charAt(index) - 'a']);
        }
        return false;
    }
}

