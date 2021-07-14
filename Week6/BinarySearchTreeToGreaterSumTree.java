class BinarySearchTreeToGreaterSumTree {
    int sum = 0;

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