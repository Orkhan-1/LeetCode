public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        if (mid - 1 >= lo) {
            node.left = construct(nums, lo, mid - 1);
        }
        if (mid + 1 <= hi) {
            node.right = construct(nums, mid + 1, hi);
        }
        return node;
    }
}
