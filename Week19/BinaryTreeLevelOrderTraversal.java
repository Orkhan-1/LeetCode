import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    // Time complexity - O (N)
    // Space complexity - O (N)
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList();

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    temp.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (!temp.isEmpty()) {
                result.add(temp);
            }
        }
        return result;
    }
}
