public class MinimumOperationsToReduceXtoZero {

    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        sum = sum - x;
        if (sum < 0) {
            return -1;
        } else if (sum == 0) {
            return nums.length;
        }
        int i = 0;
        int j = 0;
        int tempSum = 0;
        int max = Integer.MIN_VALUE;
        while (j < nums.length) {
            tempSum += nums[j++];
            while (tempSum >= sum) {
                if (tempSum == sum) {
                    max = Math.max(max, j - i);
                }
                tempSum -= nums[i++];
            }
        }
        return max == Integer.MIN_VALUE ? -1 : nums.length - max;
    }
}
