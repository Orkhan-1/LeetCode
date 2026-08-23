/*





🧩 Problem:

Max Area of Island

💡 Setup:

You are given an m × n binary grid.

    1 → land
    0 → water

An island is formed by connecting adjacent land cells
horizontally or vertically (4-directional).

Return the area (number of cells) of the largest island.

If there is no island, return 0.

------------------------------------------------------------

💡 Example:

Input:

-1 -1 0 0
-1 0 0 1
0 0 1 1
0 0 1 0

There are three islands:

Island A:
1 1
1

Area = 3

Island B:
  1
1 1
1

Area = 4

Largest area = 4

------------------------------------------------------------

🧾 Time Complexity:

O(m × n)

Each cell is visited at most once.

------------------------------------------------------------

🧾 Space Complexity:

O(m × n) in the worst case

(recursion stack if the entire grid is one large island)

*/
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    int area = calculateArea(i, j, grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int calculateArea(int x, int y, int[][] grid) {

        int currentArea = 1;
        grid[x][y] = -1; // mark as visited

        if (x + 1 < grid.length && grid[x + 1][y] == 1) {
            currentArea += calculateArea(x + 1, y, grid);
        }

        if (x - 1 >= 0 && grid[x - 1][y] == 1) {
            currentArea += calculateArea(x - 1, y, grid);
        }

        if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
            currentArea += calculateArea(x, y + 1, grid);
        }

        if (y - 1 >= 0 && grid[x][y - 1] == 1) {
            currentArea += calculateArea(x, y - 1, grid);
        }

        return currentArea;
    }
}