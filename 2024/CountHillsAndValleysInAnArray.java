public class CountHillsAndValleysInAnArray {

    public int countHillValley(int[] nums) {
        int length = nums.length;
        int result = 0;
        int prev = nums[0];
        for (int i = 1; i < length - 1; i++) {
            if (prev < nums[i] && nums[i] > nums[i + 1] ||
                    prev > nums[i] && nums[i] < nums[i + 1]) {
                prev = nums[i];
                result++;
            }
        }
        return result;
    }
}
