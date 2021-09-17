import java.util.ArrayList;
import java.util.List;

public class DeleteNodesAndReturnForest {

    private List<TreeNode> result = new ArrayList<TreeNode>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        TreeNode node = dfs(root, to_delete);
        if (node != null) {
            result.add(node);
        }
        return result;
    }

    public TreeNode dfs(TreeNode node, int[] to_delete) {
        if (node == null) {
            return null;
        }
        node.left = dfs(node.left, to_delete);
        node.right = dfs(node.right, to_delete);

        if (contains(node.val, to_delete)) {
            if (node.left != null) {
                result.add(node.left);
            }
            if (node.right != null) {
                result.add(node.right);
            }

            return null;
        }
        return node;
    }

    private boolean contains(int value, int[] to_delete) {
        for (int del : to_delete) {
            if (value == del) {
                return true;
            }
        }
        return false;
    }
}
