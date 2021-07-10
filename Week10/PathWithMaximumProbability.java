import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class PathWithMaximumProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            map.get(edge[0]).put(edge[1], succProb[i]);
            map.get(edge[1]).put(edge[0], succProb[i]);
        }
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int s = queue.poll();
            for (int e : map.get(s).keySet()) {
                if (maxProb[s] * map.get(s).get(e) > maxProb[e]) {
                    maxProb[e] = maxProb[s] * map.get(s).get(e);
                    queue.offer(e);
                }
            }
        }
        return maxProb[end];
    }
}