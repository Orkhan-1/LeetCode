from typing import List, Set

class Solution:
    def solve(self, board: List[List[str]]) -> None:
        if not board or not board[0]:
            return

        self.rows, self.cols = len(board), len(board[0])
        visited = set()

        for i in range(self.rows):
            for j in range(self.cols):
                if board[i][j] == 'O':
                    visited.clear()
                    if self.dfs(i, j, board, visited):
                        self.set_value_to_x(board, visited)

    def dfs(self, x: int, y: int, board: List[List[str]], visited: Set[str]) -> bool:
        # If out of bounds, means region touches border, so can't be surrounded
        if x < 0 or x >= self.rows or y < 0 or y >= self.cols:
            return False

        coord = f"{x}_{y}"
        if coord in visited:
            return True

        if board[x][y] == 'X':
            return True

        visited.add(coord)

        # Explore all 4 directions; all must be True (surrounded)
        up = self.dfs(x - 1, y, board, visited)
        down = self.dfs(x + 1, y, board, visited)
        left = self.dfs(x, y - 1, board, visited)
        right = self.dfs(x, y + 1, board, visited)

        return up and down and left and right

    def set_value_to_x(self, board: List[List[str]], visited: Set[str]) -> None:
        for coord in visited:
            x, y = map(int, coord.split('_'))
            board[x][y] = 'X'

# Time complexity - O(N^2)
# Space complexity - O(N)