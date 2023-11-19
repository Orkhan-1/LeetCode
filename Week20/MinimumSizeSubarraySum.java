public class MinimumSizeSubarraySum {

    // Time complexity - O (N)
    // Space complexity - O (1)
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                min = Math.min(min, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
