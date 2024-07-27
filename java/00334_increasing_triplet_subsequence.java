public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int f = Integer.MAX_VALUE;
        int s = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= f) {
                f = nums[i];
            } else if (nums[i] <= s) {
                s = nums[i];
            } else {
                return true;
            }
        }

        return false;
    }

}
