/*






🧩 Problem:

Pacific Atlantic Water Flow

💡 Example:

Heights:
                        🌊  Pacific
                     ┌──────────────┐
              🌊     │  1  2  2  3  │
           Pacific   │  3  2  3  4  │  🌊  Atlantic
                     │  2  4  5  3  │
                     │  6  7  1  4  │
                     └──────────────┘
                         Atlantic  🌊

Given an m x n matrix of heights, water flows from a cell to its 4-directional neighbors
(up, down, left, right) if the neighbor height is greater than or equal to the current cell.

Two oceans exist:
- Pacific Ocean touches top row and left column
- Atlantic Ocean touches bottom row and right column

Return all coordinates where water can flow to BOTH oceans.

------------------------------------------------------------

🧠 Key Insight (Reverse Thinking):

Instead of starting from each cell and simulating water flow to oceans,
we reverse the process:

Start DFS/BFS FROM the oceans and move inward.

Reverse movement rule:
We can move from cell (r, c) → (nr, nc) only if:
    heights[nr][nc] >= heights[r][c]

This ensures that in the original direction, water can flow downhill to the ocean.

------------------------------------------------------------

🧾 Time Complexity:
    O(m × n)

🧾 Space Complexity:
    O(m × n)

*/

import java.util.*;

class Solution {

    private int m;
    private int n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific ocean (top + left borders)
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific, heights);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, pacific, heights);
        }

        // Atlantic ocean (bottom + right borders)
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, atlantic, heights);
        }
        for (int j = 0; j < n; j++) {
            dfs(m - 1, j, atlantic, heights);
        }

        // Collect result
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int x, int y, boolean[][] visited, int[][] heights) {

        visited[x][y] = true;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int[] d : dirs) {

            int nx = x + d[0];
            int ny = y + d[1];

            if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                continue;
            }
            if (visited[nx][ny]) {
                continue;
            }

            if (heights[nx][ny] >= heights[x][y]) {
                dfs(nx, ny, visited, heights);
            }
        }
    }
}

