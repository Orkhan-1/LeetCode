/*

🧩 Problem:

Minesweeper

💡 Example:

Board:

    E  E  E  E
    E  E  M  E
    E  E  E  E
    E  E  E  E

Click = (3,0)

Step 1:
No adjacent mines → mark as 'B'

    E  E  E  E
    E  E  M  E
    B  B  E  E
    B  B  E  E

Step 2:
Continue revealing neighboring empty cells.

If a revealed cell has adjacent mines,
replace it with the count instead of expanding.

Example final board:

    B  1  E  E
    B  1  M  E
    B  1  1  1
    B  B  B  B

If the clicked cell is a mine:

    M  →  X

------------------------------------------------------------

🧠 Key Insight:

There are only two cases:

1. Clicked cell is a mine ('M')
   → Change it to 'X' and stop.

2. Clicked cell is empty ('E')
   → Count adjacent mines.

      • If count > 0
            Replace with digit ('1'...'8').

      • If count == 0
            Replace with 'B'
            Recursively reveal all 8 neighbors.

Important:
Mark the current cell as 'B' BEFORE DFS so that
it isn't visited again.

------------------------------------------------------------

🧾 Time Complexity:
    O(m × n)
    (Every cell is visited at most once.)

🧾 Space Complexity:
    O(m × n)
    (Worst-case recursion stack.)

*/

class Solution {

    private final int[][] dirs = {
            {-1,-1}, {-1,0}, {-1,1},
            {0,-1},          {0,1},
            {1,-1},  {1,0},  {1,1}
    };

    public char[][] updateBoard(char[][] board, int[] click) {

        int r = click[0];
        int c = click[1];

        // Clicked on a mine
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        }

        dfs(board, r, c);

        return board;
    }

    private void dfs(char[][] board, int r, int c) {

        int m = board.length;
        int n = board[0].length;

        if (r < 0 || c < 0 || r >= m || c >= n) {
            return;
        }

        if (board[r][c] != 'E') {
            return;
        }

        int mines = countMines(board, r, c);

        // Stop expansion if adjacent mines exist
        if (mines > 0) {
            board[r][c] = (char) ('0' + mines);
            return;
        }

        // No adjacent mines
        board[r][c] = 'B';

        for (int[] d : dirs) {
            dfs(board, r + d[0], c + d[1]);
        }
    }

    private int countMines(char[][] board, int r, int c) {

        int m = board.length;
        int n = board[0].length;
        int count = 0;

        for (int[] d : dirs) {

            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nc < 0 || nr >= m || nc >= n) {
                continue;
            }

            if (board[nr][nc] == 'M') {
                count++;
            }
        }

        return count;
    }
}