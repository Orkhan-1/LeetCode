import java.util.*;

/*
Time complexity - O(E + Q * V)

Graph Construction: O(E) -  E is the number of equations (edges)
DFS Search: in the worst case, we visit all nodes V and we do it for Q times for each query O(Q * V)
*/

/*
Space complexity - O(E + V)

Graph Storage: For each of the E equations, we store two edges in this adjacency list => O(E).
Visited Set: in the worst case it'll contain all nodes => O (V)
DFS recursion stack: in the worst case it'll contain all nodes => O (V)

O(E + 2V) => O(E + V)
 */

public class Solution {
    private Map<String, Map<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);
            double value = values[i];
            graph.putIfAbsent(A, new HashMap<>());
            graph.putIfAbsent(B, new HashMap<>());
            graph.get(A).put(B, value);
            graph.get(B).put(A, 1.0 / value);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String A = queries.get(i).get(0);
            String B = queries.get(i).get(1);
            if (!graph.containsKey(A) || !graph.containsKey(B)) {
                result[i] = -1.0;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(A, B, visited);
            }
        }
        return result;
    }

    private double dfs(String A, String B, Set<String> visited) {
        if (A.equals(B)) return 1.0;
        visited.add(A);
        Map<String, Double> neighbors = graph.get(A);
        for (String neighbor : neighbors.keySet()) {
            if (visited.contains(neighbor)) {
                continue;
            }
            double result = dfs(neighbor, B, visited);
            if (result != -1.0) {
                return neighbors.get(neighbor) * result;
            }
        }
        return -1.0;
    }
}
