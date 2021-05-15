class DistributeCoinsInBinaryTree {
    private int temp = 0;
    
    public int distributeCoins(TreeNode root) {
        helper(root);
        return temp;
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        int result = root.val + l + r - 1;
        temp += Math.abs(result);
        return result;
    }  
}