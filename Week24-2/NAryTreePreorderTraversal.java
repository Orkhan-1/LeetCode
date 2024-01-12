import java.util.ArrayList;
import java.util.List;

// Time complexity - O (N)
// Space complexity - O (N)
public class NAryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preOrderTraverse(root, result);
        return result;
    }

    private void preOrderTraverse(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        if (node.children != null) {
            for (Node child : node.children) {
                preOrderTraverse(child, result);
            }
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
