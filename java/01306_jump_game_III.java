// Time complexity - O (n), canReach is called for each index once
// Space complexity - O (n), dp and at most n recursive call

public class Solution {
    public boolean canReach(int[] arr, int start) {
        Boolean[] dp = new Boolean[arr.length];
        return canReach(start, arr, dp);
    }

    private boolean canReach(int position, int[] arr, Boolean[] dp) {
        if (position < 0 || position >= arr.length) {
            return false;
        }

        if (arr[position] == 0) {
            return true;
        }

        if (dp[position] != null) {
            return dp[position];
        }

        dp[position] = false;

        boolean canReachZero = canReach(position + arr[position], arr, dp) ||
                canReach(position - arr[position], arr, dp);

        dp[position] = canReachZero;
        return canReachZero;
    }
}
