import java.util.ArrayList;
import java.util.List;

// Time complexity -  O (V+E)
// Space complexity - O (N)
public class FindEventualSafeStates {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] stack = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (dfs(graph, i, visited, stack)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean dfs(int[][] graph, int node, boolean[] visited, boolean[] stack) {
        if (stack[node]) {
            return false;
        }

        if (visited[node]) {
            return true;
        }

        stack[node] = true;

        for (int next : graph[node]) {
            if (!dfs(graph, next, visited, stack)) {
                return false;
            }
        }

        stack[node] = false;
        visited[node] = true;
        return true;
    }
}
