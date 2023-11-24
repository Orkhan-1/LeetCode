public class BinarySearchTreeToGreaterSumTree {

    int sum = 0;

    // Time complexity - O (N)
    // Space complexity - O (log N), worst O (N)
    public TreeNode bstToGst(TreeNode node) {
        if (node == null) {
            return node;
        }
        bstToGst(node.right);
        sum += node.val;
        node.val = sum;
        bstToGst(node.left);
        return node;
    }
}
