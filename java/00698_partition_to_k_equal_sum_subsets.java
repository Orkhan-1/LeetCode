// Time complexity - O (2^N)
// Space complexity - O (N)
public class PartitionToKEqualSumSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false;
        }

        int target = sum / k;
        boolean[] visited = new boolean[nums.length];

        return bt(nums, visited, 0, k, 0, target);
    }

    private boolean bt(int[] nums, boolean[] visited, int start, int k, int currentSum, int target) {
        if (k == 0) {
            return true;
        }

        if (currentSum == target) {
            return bt(nums, visited, 0, k - 1, 0, target);
        }

        for (int i = start; i < nums.length; i++) {
            if (!visited[i] && currentSum + nums[i] <= target) {
                visited[i] = true;
                if (bt(nums, visited, i + 1, k, currentSum + nums[i], target)) {
                    return true;
                }
                visited[i] = false;
            }
        }

        return false;
    }
}
