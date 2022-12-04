
public class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (current.nodes[word.charAt(i) - 'a'] == null) {
                current.nodes[word.charAt(i) - 'a'] = new TrieNode();
            }
            current = current.nodes[word.charAt(i) - 'a'];
            if (i == word.length() - 1) {
                current.isComplete = true;
            }
        }
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    public boolean search(String word, int index, TrieNode root) {
        if (index >= word.length() && root.isComplete) {
            return true;
        }

        if (index >= word.length()) {
            return false;
        }

        if (word.charAt(index) == '.') {
            for (int i = 0; i < 26; i++) {
                if (root.nodes[i] != null && search(word, index + 1, root.nodes[i])) {
                    return true;
                }

            }
        } else {
            return root.nodes[word.charAt(index) - 'a'] != null && search(word, index + 1, root.nodes[word.charAt(index) - 'a']);
        }
        return false;
    }
}

class TrieNode {
    TrieNode[] nodes;

    TrieNode() {
        nodes = new TrieNode[26];
    }

    boolean isComplete = false;
}