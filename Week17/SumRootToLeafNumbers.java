public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int current) {
        if (node == null) {
            return 0;
        }

        current = current * 10 + node.val;

        if (node.left == null && node.right == null) {
            return current;
        }

        int leftValue = dfs(node.left, current);
        int rightValue = dfs(node.right, current);

        return leftValue + rightValue;
    }
}
