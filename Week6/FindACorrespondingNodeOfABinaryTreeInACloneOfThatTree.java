class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree{
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
         if (original == target) {
            return cloned;
        }
        
        TreeNode left = null;
        TreeNode right = null;
        if (original.left != null) {
            left = getTargetCopy(original.left, cloned.left, target);
        }
        if (original.right != null) {
            right = getTargetCopy(original.right, cloned.right, target);
        }
        
        return left != null ? left : right;
    }   
}
