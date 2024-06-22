import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Time complexity - O (N^2)
// Space complexity - O (N^2)
public class MaximalNetworkRank {

    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> connectedCities = new HashMap<>();

        for (int i = 0; i < n; i++) {
            connectedCities.put(i, new HashSet<>());
        }

        for (int[] road : roads) {
            connectedCities.get(road[0]).add(road[1]);
            connectedCities.get(road[1]).add(road[0]);
        }

        int maxRank = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int currentRank = connectedCities.get(i).size() + connectedCities.get(j).size();

                if (connectedCities.get(i).contains(j) || connectedCities.get(j).contains(i)) {
                    currentRank--;
                }

                maxRank = Math.max(maxRank, currentRank);
            }
        }

        return maxRank;
    }
}
