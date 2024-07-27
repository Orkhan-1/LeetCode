public class TargetSum {

    int result = 0;

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        bt(nums, 0, S);
        return result;
    }

    private void bt(int[] nums, int index, int currentSum) {
        if (index == nums.length && currentSum == 0) {
            result++;
        }
        if (index == nums.length) {
            return;
        }
        bt(nums, index + 1, currentSum - nums[index]);
        bt(nums, index + 1, currentSum + nums[index]);
    }
}
