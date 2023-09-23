import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int[] directions = new int[] { 0, 1, 0, -1, 0 };
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{ i, j });
                }
            }
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for(int j = 0; j < directions.length-1; j++) {
                    int x = current[0] + directions[j];
                    int y = current[1] + directions[j+1];
                    checkCoordinate(new int[] {x,y}, grid, queue);
                }
            }
            if(!queue.isEmpty()) {
                time++;
            }
        }
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }

    private void checkCoordinate (int [] coordinate, int[][] grid, Queue <int []> queue) {
        int x = coordinate[0];
        int y = coordinate[1];
        if(0 <= x && 0 <= y && x < grid.length && y < grid[0].length && grid[x][y] == 1) {
            grid[x][y] = 2;
            queue.add(new int[]{ x, y });
        }
    }
}
