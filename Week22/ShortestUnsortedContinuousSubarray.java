public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                min = Math.min(min, nums[i]);
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                max = Math.max(max, nums[i]);
            }
        }
        int u;
        int l;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l]) {
                break;
            }
        }
        for (u = nums.length - 1; u >= 0; u--) {
            if (max > nums[u]) {
                break;
            }
        }
        return u - l < 0 ? 0 : u - l + 1;
    }

}
