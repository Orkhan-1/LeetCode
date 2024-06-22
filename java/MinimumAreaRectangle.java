import java.util.HashSet;
import java.util.Set;

public class MinimumAreaRectangle {

    // Time complexity - O (N^2)
    // Space complexity - O (N)
    public int minAreaRect(int[][] points) {
        Set<String> set = new HashSet<>();
        for (int[] point : points) {
            set.add(point[0] + "," + point[1]);
        }

        int minArea = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                if (x1 != x2 && y1 != y2) {
                    if (set.contains(x1 + "," + y2) && set.contains(x2 + "," + y1)) {
                        minArea = Math.min(minArea, Math.abs(x1 - x2) * Math.abs(y1 - y2));
                    }
                }
            }
        }
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}
