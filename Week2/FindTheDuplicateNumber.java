public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int current = Math.abs(nums[i]);
            if (nums[current] < 0) {
                return current;
            }
            nums[current] *= -1;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        return -1;
    }
}
