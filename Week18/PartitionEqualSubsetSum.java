public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        Boolean[][] dp = new Boolean[nums.length][sum / 2];

        return bt(nums, sum / 2, 0, 0, dp);
    }


    private boolean bt(int[] nums, int targetSum, int tempSum, int index, Boolean[][] dp) {

        if (targetSum == tempSum) {
            return true;
        }

        if (tempSum > targetSum || index > nums.length - 1) {
            return false;
        }

        if (dp[index][tempSum] != null) {
            return dp[index][tempSum];
        }

        boolean include = bt(nums, targetSum, tempSum + nums[index], index + 1, dp);
        boolean exclude = bt(nums, targetSum, tempSum, index + 1, dp);

        dp[index][tempSum] = include || exclude;
        return dp[index][tempSum];
    }
}
