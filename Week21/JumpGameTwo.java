import java.util.Arrays;

// Time complexity -  O(N2) - Inner loop size worst case is N
// Space complexity - O (N) - size of DP
public class JumpGameTwo {

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            int maxJumps = nums[i];
            for (int j = 1; j <= maxJumps && i + j < nums.length; j++) {
                int currentValue = dp[i + j];
                int newValue = dp[i] + 1;
                dp[i + j] = Math.min(currentValue, newValue);
            }
        }
        return dp[nums.length - 1];
    }
}
