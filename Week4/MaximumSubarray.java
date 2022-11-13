public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int maxValue=nums[0];
        int previousValue=nums[0];
        for (int i=1; i<nums.length; i++) {
            int current = Math.max (nums[i], previousValue+nums[i]);
            maxValue = Math.max (maxValue, current);
            previousValue=current;
        }
        return maxValue;
    }
}
