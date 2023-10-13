import java.util.LinkedList;
import java.util.Queue;

public class LinkedListCycleTwo {
    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node node1 = queue.poll();
            Node node2 = queue.peek();

            node1.next = node2;

            if (node1.left != null) {
                queue.add(node1.left);
            }

            if (node1.right != null) {
                queue.add(node1.right);
            }

            if (node2 == null) {
                queue.poll();

                if (queue.isEmpty()) {
                    return root;
                }
                queue.add(null);
            }
        }
        return root;
    }
}
