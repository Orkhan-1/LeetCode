
// Time complexity -  O(N)
// Space complexity - O (1)
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int prevMax = nums[0];
        int totalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int currentMax = Math.max(prevMax + nums[i], nums[i]);
            totalMax = Math.max(currentMax, totalMax);
            prevMax = currentMax;
        }
        return totalMax;
    }
}
