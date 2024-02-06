// Time complexity - O (N)
// Space complexity - O (N) - the height of the binary tree
public class DiameterOfBinaryTree {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = dfs(node.left);
        int rightDepth = dfs(node.right);
        diameter = Math.max(diameter, leftDepth + rightDepth);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
