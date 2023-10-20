import java.util.*;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List <List<Integer>> results = new ArrayList <> ();

        Queue<List<Integer>> queue = new LinkedList <> ();
        queue.add (Arrays.asList (0));

        while (!queue.isEmpty ()) {
            List<Integer> current = queue.poll();

            if (current.get(current.size ()-1)==graph.length-1) {
                results.add (current);
            }

            for (int i: graph [current.get(current.size ()-1)]) {
                List <Integer> result = new ArrayList (current);
                result.add(i);
                queue.add(result);
            }
        }
        return results;
    }
}
