import java.util.PriorityQueue;
import java.util.Queue;

// Time complexity -  O(m * n * log(m * n)) - m*n - grid, log(m * n) - minHeap operations
// Space complexity - O (m*n) - visited and minHeap both have time complexity
public class PathWithMinimumEffort {

    // dijkstra
    // Min Heap

    public static int minimumEffortPath(int[][] heights) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        Queue<int[]> minHeap = new PriorityQueue<>((e1, e2) -> e1[0] - e2[0]);
        minHeap.add(new int[]{0, 0, 0});
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int i = curr[1];
            int j = curr[2];
            if (i == heights.length - 1 && j == heights[0].length - 1) {
                return curr[0];
            }
            if (visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            for (int[] dir : dirs) {
                if (i + dir[0] >= 0 && i + dir[0] < heights.length && j + dir[1] >= 0 && j + dir[1] < heights[0].length) {
                    minHeap.add(new int[]{Math.max(curr[0], Math.abs(heights[i + dir[0]][j + dir[1]] - heights[i][j])), i + dir[0], j + dir[1]});
                }
            }
        }
        return -1;
    }
}
