import java.util.Arrays;

// Time complexity -  O (N^3)
// Space complexity - O (N^2)
public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }

        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }

        for (int k = 0; k < n; k++) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) { // 0-5 ==> 0,3 + 3,5 OR 0,5
                    if (graph[x][k] != Integer.MAX_VALUE && graph[k][y] != Integer.MAX_VALUE) {
                        graph[x][y] = Math.min(graph[x][y], graph[x][k] + graph[k][y]);
                    }
                }
            }
        }

        int minCities = n + 1;
        int result = -1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && graph[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            if (count <= minCities) {
                minCities = count;
                result = i;
            }
        }

        return result;
    }

}
