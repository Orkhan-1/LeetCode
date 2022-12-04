import org.jetbrains.annotations.NotNull;

public class Trie {

    private final Node root;

    public Trie() {
        root = new Node('/');
    }

    public void insert(@NotNull String word) {
        Node current = this.root;
        for (int i = 0; i < word.length(); i++) {
            int child = word.charAt(i) - 'a';
            if (current.children[child] == null) {
                current.children[child] = new Node(word.charAt(i));
            }
            current = current.children[child];
        }
        current.isComplete = true;
    }

    public boolean search(@NotNull String word) {
        Node current = this.root;
        for (int i = 0; i < word.length(); i++) {
            int child = word.charAt(i) - 'a';
            if (current.children[child] == null) {
                return false;
            }
            current = current.children[child];
        }
        return current.isComplete;
    }

    public boolean startsWith(@NotNull String prefix) {
        Node current = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            int child = prefix.charAt(i) - 'a';
            if (current.children[child] == null) {
                return false;
            }
            current = current.children[child];
        }
        return true;
    }

    private static class Node {
        private boolean isComplete;
        private final Node[] children;

        public Node(char data) {
            this.isComplete = false;
            this.children = new Node[26];
        }
    }
}
