class Solution {
    public void solve(char[][] board) {

        // visit every cell and find all 0 and dfs in 4 directions

        Set<String> visited = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    if (dfs(i - 1, j, board, visited) && dfs(i + 1, j, board, visited) && dfs(i, j + 1, board, visited) && dfs(i, j - 1, board, visited)) {
                        String coor = i + "_" + j;
                        visited.add(coor);
                        setValueToX(board, visited);
                    }
                    visited.clear();
                }
            }
        }

        // log visited 0 cells
        // if 4 dir can be surrounded set visited cells to X

    }

    private boolean dfs(int x, int y, char[][] board, Set<String> visited) {

        if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1) {
            return false;
        }

        String coor = x + "_" + y;
        if (visited.contains(coor)) {
            return true;
        }

        if (board[x][y] == 'X') {
            return true;
        } else {
            visited.add(coor);
            return dfs(x - 1, y, board, visited) && dfs(x + 1, y, board, visited) && dfs(x, y + 1, board, visited) && dfs(x, y - 1, board, visited);
        }

    }

    private void setValueToX(char[][] board, Set<String> visited) {
        for (String coor : visited) {
            String[] coordinates = coor.split("_");
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            board[x][y] = 'X';
        }
    }
}

// Time complexity - O(N^2)
// Space complexity - O(N)