import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Time complexity - O (N)
// Space complexity - O (N)
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            traverse(root, result);
        }
        return result;
    }

    private void traverse(TreeNode node, List<Integer> result) {
        if (node.left != null) {
            traverse(node.left, result);
        }
        result.add(node.val);
        if (node.right != null) {
            traverse(node.right, result);
        }
    }
}
