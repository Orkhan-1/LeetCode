// Time complexity - O (N)
// Space complexity - O (N)
public class DistributeCoinsInBinaryTree {

    int result = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);
        result += Math.abs(left) + Math.abs(right);
        return node.val + left + right - 1;
    }
}
