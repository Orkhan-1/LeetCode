import java.util.ArrayList;
import java.util.List;

// Time complexity - O (N)
// Space complexity - O (N)
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrderTravere(root, result);
        return result;
    }

    private void postOrderTravere(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        postOrderTravere(node.left, result);
        postOrderTravere(node.right, result);
        result.add(node.val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
