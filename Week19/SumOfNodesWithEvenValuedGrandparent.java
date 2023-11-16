// Time complexity - O (N)
// Space complexity - O (log N) or O (N)
public class SumOfNodesWithEvenValuedGrandparent {
    int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {

        dfs(root, null, null);
        return sum;
    }

    private void dfs(TreeNode node, TreeNode parent,
                     TreeNode gParent) {
        if (node == null) {
            return;
        }

        if (gParent != null && gParent.val % 2 == 0) {
            sum += node.val;
        }
        dfs(node.left, node, parent);
        dfs(node.right, node, parent);
    }
}
