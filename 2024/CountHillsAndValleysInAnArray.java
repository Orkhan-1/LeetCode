
// Time complexity - O (N)
// Space complexity - O (1)
public class CountHillsAndValleysInAnArray {

    public int countHillValley(int[] nums) {
        int result = 0;
        int lValue = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (lValue < nums[i] && nums[i] > nums[i + 1] ||
                    lValue > nums[i] && nums[i] < nums[i + 1]) {
                lValue = nums[i];
                result++;
            }
        }
        return result;
    }
}
