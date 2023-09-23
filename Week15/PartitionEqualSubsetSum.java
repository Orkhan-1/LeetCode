public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int targetSum = totalSum / 2;
        return canPartitionHelper(nums, 0, targetSum);
    }

    private boolean canPartitionHelper(int[] nums, int currentIndex, int remainingSum) {
        if (remainingSum == 0) {
            return true;
        }
        if (currentIndex >= nums.length || remainingSum < 0) {
            return false;
        }

        if (canPartitionHelper(nums, currentIndex + 1, remainingSum - nums[currentIndex])) {
            return true;
        }

        if (canPartitionHelper(nums, currentIndex + 1, remainingSum)) {
            return true;
        }
        return false;
    }
}
