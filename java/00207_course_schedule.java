class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map <Integer, Set <Integer>> graph = new HashMap <> ();

        for (int i=0; i<prerequisites.length; i++) {
            int course = prerequisites [i][0];
            int prerequisite = prerequisites [i] [1];

            if (graph.get (course)!=null) {
                Set <Integer> currentPrerequisites = graph.get (course);
                currentPrerequisites.add (prerequisite);
                graph.put (course, currentPrerequisites);
            } else {
                Set <Integer> currentPrerequisites = new HashSet <> ();
                currentPrerequisites.add (prerequisite);
                graph.put (course, currentPrerequisites);
            }
        }

        Set <Integer> visited = new HashSet <> ();
        for (int i=0; i<numCourses; i++) {
            if (graph.get(i)==null ) {
                continue;
            }

            if (hasCycle(i, graph, new HashSet <> (), visited)) {
                return false;
            }
            visited.add (i);
        }
        return true;
    }

    private boolean hasCycle (int node, Map <Integer, Set <Integer>> graph, Set <Integer> stack, Set <Integer> visited) {

        if (stack.contains (node)) {
            return true;
        }
        stack.add (node);
        Set <Integer> nodes = graph.get (node);
        if (nodes!=null) {
            for (int j: nodes) {
                if (visited.contains (j)) {
                    continue;
                }
                if (hasCycle(j, graph, stack, visited)) {
                    return true;
                }
                stack.remove (j);
            }
        }

        return false;
    }
}

// Time complexity - O(n + p) - n is the number of courses and p is the number of prerequisites
// Space complexity - O(n + p)