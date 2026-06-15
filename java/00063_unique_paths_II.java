/*



🧩 Problem:

Given an m × n grid where:

    - 0 → empty cell
    - 1 → obstacle

obstacleGrid:
        0 0 0
        0 1 0
        0 0 0

Find the number of unique paths from the top-left corner
to the bottom-right corner.

You can only move:

        - Right ➡️
        - Down ⬇️

If a cell contains an obstacle, it cannot be visited.

🧠 Solution:

Use Dynamic Programming (Quintessential Dynamic Programming problem)

Let:
dp[i][j] = number of ways to reach cell (i, j)

Rules:
        1️⃣ If the current cell is an obstacle:
dp[i][j] = 0
        2️⃣ Otherwise:
dp[i][j] = dp[i-1][j]   // from top
           + dp[i][j-1]   // from left

Since we can only move right or down, these are the only
two possible previous positions.

💡 Example:

obstacleGrid:
        0 0 0
        0 1 0
        0 0 0

DP Table:
        1 1 1
        1 0 1
        1 1 2

Answer = 2

🧾 Time Complexity:
O(m × n)

🧾 Space Complexity:
O(m × n)


 */

class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        // Initialize first column
        boolean xObstacle = true;
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 0 && xObstacle) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
                xObstacle = false;
            }
        }

        // Initialize first row
        boolean yObstacle = true;
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 0 && yObstacle) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
                yObstacle = false;
            }
        }

        // Fill DP table
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {

                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}