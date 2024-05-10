import java.util.*;

// Time complexity - O(V + E) - Constructing the graph - O(E), Visiting each node - O(V)
// Space complexity - O(V + E)
public class CourseScheduleTwo {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(i, graph, visited, stack, result)) {
                return new int[0];
            }
        }

        int[] array = new int[result.size()];
        int index = 0;
        for (Integer element : result) {
            array[index++] = element;
        }
        return array;
    }

    private boolean hasCycle(int node, List<Integer>[] graph, boolean[] visited, boolean[] stack, List<Integer> result) {
        if (stack[node]) {
            return true;
        }

        if (visited[node]) {
            return false;
        }

        visited[node] = true;
        stack[node] = true;

        for (int neighbor : graph[node]) {
            if (hasCycle(neighbor, graph, visited, stack, result)) {
                return true;
            }
        }
        result.add(0, node);
        stack[node] = false;
        return false;
    }
}
