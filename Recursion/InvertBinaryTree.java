//     Java
// Time complexity - O (N)
// Space complexity - O (H) - depth of recursion stack
// Worst (unbalanced) O(n) - , Best (balanced) - O(log(n))
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
