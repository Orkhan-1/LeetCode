public class MinimumDepthOfBinaryTree {

    private int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        dfs(root, 1);
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (min > level) {
                min = level;
            }
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
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
