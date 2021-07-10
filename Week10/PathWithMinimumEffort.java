import java.util.PriorityQueue;

class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
         boolean[][] visited = new boolean[heights.length][heights[0].length];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<int[]> queue = new PriorityQueue<>((e1, e2) -> e1[0] - e2[0]);
        queue.add(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[1], j = curr[2];
            if (i == heights.length - 1 && j == heights[0].length - 1) {
                return curr[0];
            }
            if (visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            for (int[] dir : dirs) {
                if (i + dir[0] >= 0 && i + dir[0] < heights.length && j + dir[1] >= 0 && j + dir[1] < heights[0].length) {
                    queue.add(new int[]{Math.max(curr[0], Math.abs(heights[i + dir[0]][j + dir[1]] - heights[i][j])), i + dir[0], j + dir[1]});
                }
            }
        }
        return -1;
    }
}