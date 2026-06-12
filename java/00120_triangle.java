/**
 * 🧩 Problem:
 * Given a triangle array, find the minimum path sum from
 * top to bottom.
 *
 * Triangle:
 *
 *          2
 *         3 4
 *        6 5 7
 *       4 1 8 3
 *
 * At each step, you may move to:
 *    - the same index
 *    - the next index
 * in the row below.
 *
 * Answer = 11
 *
 * 🎯 Goal:
 * Return the minimum path sum.
 *
 * 🧠 Solution:
 * Use Dynamic Programming.
 *
 * Let:
 *    dp[i][j] = minimum path sum to reach triangle[i][j]
 *
 * Transition:
 *
 * 1️⃣ First element of each row:
 *        Can only come from the first element above.
 *
 *        dp[i][0] =
 *            dp[i-1][0] + triangle[i][0]
 *
 * 2️⃣ Last element of each row:
 *        Can only come from the last element above.
 *
 *        dp[i][last] =
 *            dp[i-1][last-1] + triangle[i][last]
 *
 * 3️⃣ Middle elements:
 *        Can come from two parents.
 *
 *        dp[i][j] =
 *            min(dp[i-1][j-1], dp[i-1][j])
 *            + triangle[i][j]
 *
 * Finally, the answer is the minimum value
 * in the last row of dp.
 *
 * 💡 Example:
 *
 * Triangle:
 *
 *          2
 *         3 4
 *        6 5 7
 *       4 1 8 3
 *
 * DP:
 *
 *          2
 *         5 6
 *       11 10 13
 *      15 11 18 16
 *
 * Answer = 11
 *
 * 🧾 Time Complexity:
 *      O(n²)
 *
 * 🧾 Space Complexity:
 *      O(n²)
 */

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int[][] dp = new int[n][n];

        // Initialize the top of the triangle
        dp[0][0] = triangle.get(0).get(0);

        // Build the DP table
        for (int i = 1; i < n; i++) {

            // First element of the row
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);

            // Middle elements
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j])
                        + triangle.get(i).get(j);
            }

            // Last element of the row
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }

        // Find the minimum value in the last row
        int ans = dp[n - 1][0];
        for (int j = 1; j < n; j++) {
            ans = Math.min(ans, dp[n - 1][j]);
        }

        return ans;
    }
}