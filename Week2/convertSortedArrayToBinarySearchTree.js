var sortedArrayToBST = function(nums) {
    return dfs(0, nums.length - 1, nums);
};

function dfs(left, right, nums) {
    if (left > right) {
     return null;   
    }
    if (left === right) {
        return new TreeNode(nums[left])
    }
    let mid = Math.floor((left + right) / 2);
    let root = new TreeNode(nums[mid]);
    root.left = dfs(left, mid - 1, nums);
    root.right = dfs(mid + 1, right, nums);
    return root;
}