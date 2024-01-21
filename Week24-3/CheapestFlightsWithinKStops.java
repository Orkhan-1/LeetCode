import java.util.*;

// Time complexity - O (V+E)
// Space complexity - O (V+E)
public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<List<Integer>>> neighbors = new HashMap<>(); // 0 => 1,100; 2,500

        for (int i = 0; i < flights.length; i++) {
            int source = flights[i][0];
            int destination = flights[i][1];
            int cost = flights[i][2];
            if (neighbors.get(source) == null) {
                neighbors.put(source, new ArrayList<>());
            }
            neighbors.get(source).add(List.of(destination, cost));
        }

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        dijkstra(neighbors, minCost, src, k);
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }

    public void dijkstra(Map<Integer, List<List<Integer>>> neighbors, int[] minCost, int source, int stops) {

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{source, 0, stops});
        minCost[source] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNode = current[0];
            int currentCost = current[1];
            int currentStop = current[2];

            if (!neighbors.containsKey(currentNode)) {
                continue;
            }

            for (List<Integer> neighbor : neighbors.get(currentNode)) {
                int neighborNode = neighbor.get(0);
                int neighborCost = neighbor.get(1);

                int totalCost = currentCost + neighborCost;
                if (minCost[neighborNode] > totalCost) {
                    minCost[neighborNode] = totalCost;
                    if (currentStop > 0) {
                        int temp = currentStop;
                        queue.add(new int[]{neighborNode, totalCost, temp - 1});
                    }
                }
            }
        }
    }

}
