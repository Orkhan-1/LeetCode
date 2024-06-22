// Time complexity -  O(N)
// Space complexity - O (N)
public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + costs[0]; // direct cost

            int j = i - 1;
            while (j >= 1 && days[i - 1] - days[j - 1] < 7) {
                j--;
            }

            dp[i] = Math.min(dp[i], dp[j] + costs[1]);

            j = i - 1;
            while (j >= 1 && days[i - 1] - days[j - 1] < 30) {
                j--;
            }

            dp[i] = Math.min(dp[i], dp[j] + costs[2]);
        }

        return dp[n];
    }
}
