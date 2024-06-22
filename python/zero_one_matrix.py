from collections import deque

#     Python
# Time complexity - O(rows * cols)
# Space complexity - O(rows * cols)
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if not matrix or not matrix[0]:
            return matrix

        rows, cols = len(matrix), len(matrix[0])
        queue = deque()
        visited = [[False] * cols for _ in range(rows)]

        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == 0:
                    queue.append((i, j))
                    visited[i][j] = True

        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        while queue:
            row, col = queue.popleft()
            for dx, dy in dirs:
                new_row, new_col = row + dx, col + dy
                if 0 <= new_row < rows and 0 <= new_col < cols and not visited[new_row][new_col]:
                    matrix[new_row][new_col] = matrix[row][col] + 1
                    visited[new_row][new_col] = True
                    queue.append((new_row, new_col))

        return matrix
