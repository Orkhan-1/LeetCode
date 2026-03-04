/*

🏠 Problem:
You are given a row of n houses, each can be painted with one of 3 colors:
Red, Blue, or Green. The cost of painting each house with a certain color
is represented by a cost matrix: costs[i][j], where:
  i -> house index
  j -> color index (0=Red, 1=Blue, 2=Green)

🎯 Goal:
Paint all houses so that no two adjacent houses have the same color,
and minimize the total painting cost.

📊 Example:
Input:
costs = [
  [17, 2, 17],
  [16, 16, 5],
  [14, 3, 19]
]

🏠1  🎨 R=17  B=2   G=17
🏠2  🎨 R=16  B=16  G=5
🏠3  🎨 R=14  B=3   G=19

Dynamic choices:
For 🏠2 → if painted R, must choose min(B,G) from 🏠1, etc.

DP progression:
House1: [17, 2, 17]
House2: [18, 33, 7]
House3: [21, 10, 37]
Answer 🎯 = min(21, 10, 37) = 10

Transition:
dp[i][0] = costs[i][0] + min(dp[i-1][1], dp[i-1][2])
dp[i][1] = costs[i][1] + min(dp[i-1][0], dp[i-1][2])
dp[i][2] = costs[i][2] + min(dp[i-1][0], dp[i-1][1])

⏱️ Time: O(n)
💾 Space: O(1) (if done in-place)
*/

class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        int n = costs.length;
        return Math.min(Math.min(costs[n - 1][0], costs[n - 1][1]), costs[n - 1][2]);
    }
}