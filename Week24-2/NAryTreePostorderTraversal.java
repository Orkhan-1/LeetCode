import java.util.ArrayList;
import java.util.List;

// Time complexity - O (N)
// Space complexity - O (N)
public class NAryTreePostorderTraversal {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postOrderTraverse(root, result);
        return result;
    }

    private void postOrderTraverse(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }

        if (node.children != null) {
            for (Node child : node.children) {
                postOrderTraverse(child, result);
            }
        }
        result.add(node.val);
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
