// Time complexity - O (N)
// Space complexity - O (max (Depth))
public class SmallestSubtreeWithAllTheDeepestNodes {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        TreeNode parent = root;
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        while (left != right) {
            if (left > right) {
                parent = parent.left;
            } else {
                parent = parent.right;
            }
            left = getDepth(parent.left);
            right = getDepth(parent.right);
        }
        return parent;
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }
}
