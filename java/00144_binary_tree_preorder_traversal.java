import java.util.ArrayList;
import java.util.List;

// Time complexity - O (N)
// Space complexity - O (N)
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrderTraverse(root, result);
        return result;
    }

    private void preOrderTraverse(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        preOrderTraverse(node.left, result);
        preOrderTraverse(node.right, result);
    }
}
