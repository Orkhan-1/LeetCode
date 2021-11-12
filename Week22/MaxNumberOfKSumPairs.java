import java.util.Arrays;

public class MaxNumberOfKSumPairs {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int result = 0;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < k) {
                i++;
            } else if (sum > k) {
                j--;
            } else {
                result++;
                i++;
                j--;
            }
        }
        return result;
    }
}
