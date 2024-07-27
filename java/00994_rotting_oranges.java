import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int time = 0;

        int[] directions = new int[]{0, 1, 0, -1, 0};

        Queue<int[]> queue = new LinkedList();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                for (int j = 0; j < directions.length - 1; j++) {
                    int x = current[0] + directions[j];
                    int y = current[1] + directions[j + 1];
                    checkCoordinates(new int[]{x, y}, directions, grid, queue);
                }
            }

            if (!queue.isEmpty()) {
                time++;
            }

        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }

    private void checkCoordinates(int[] current, int[] directions, int[][] grid, Queue<int[]> queue) {
        int x = current[0];
        int y = current[1];

        if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1) {
            grid[x][y] = 2;
            queue.add(current);
        }
    }
}
