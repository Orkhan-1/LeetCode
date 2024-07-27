public class JumpGame {

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i]);
            if (max <= 0) {
                return false;
            }
            max--;
        }
        return true;
    }
}
