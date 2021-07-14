class MaximumDifferenceBetweenNodeAndAncestor {
    private int result = Integer.MIN_VALUE;
    
    public int maxAncestorDiff(TreeNode root) {
	    if(root !=null) {
         dfs(root,root.val,root.val);   
        }
	    return result;
    }
    
    private void dfs(TreeNode node, int min, int max) {
	    if(max-min > result) {
         result = max-min;   
        }
	    if(node.left !=null) {
            dfs(node.left, Math.min(min, node.left.val),Math.max(max, node.left.val));
        }
		    
	    if(node.right !=null) {
            dfs(node.right, Math.min(min, node.right.val),Math.max(max, node.right.val));  
        }	     
    }
}
