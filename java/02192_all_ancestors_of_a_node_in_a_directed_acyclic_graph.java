class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // build map with K - node, V - ancestors
        // start from 0 dfs and add to the answer all ancestors for nodes that we visit
        // mark visited nodes not to go to cycle

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int node = edges[i][1];
            int parent = edges[i][0];

            if (graph.get(node) == null) {
                List<Integer> parents = new ArrayList<>();
                parents.add(parent);
                graph.put(node, parents);
            } else {
                List<Integer> parents = graph.get(node);
                parents.add(parent);
                graph.put(node, parents);
            }
        }

        Map<Integer, Set<Integer>> result = new HashMap<>();

        List<List<Integer>> finalResult = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> parents = new ArrayList(dfs(i, graph, result));
            if (parents != null) {
                Collections.sort(parents);
            }
            finalResult.add(parents);
        }

        return finalResult;
    }

    private Set<Integer> dfs(int node, Map<Integer, List<Integer>> graph, Map<Integer, Set<Integer>> result) {
        if (result.get(node) != null) {
            return result.get(node);
        }

        Set<Integer> ancestors = new HashSet<>();

        List<Integer> parents = graph.get(node);

        if (parents == null) {
            result.put(node, new HashSet<>());
            return new HashSet<>();
        }

        for (int parent : graph.get(node)) {
            ancestors.add(parent);
            ancestors.addAll(dfs(parent, graph, result));
        }

        result.put(node, ancestors);
        return ancestors;
    }

     /*  private void dfs (int node, Map <Integer, List<Integer>> graph, Map <Integer,
                      List< Integer>> result, Set <Integer> tempResult) {

            if (result.get (node)!=null) {
                tempResult.addAll (result.get (node));
                return;
            }

            List <Integer> parents = graph.get (node);

            if (parents == null) {
                result.put (node, new ArrayList <> ());
                tempResult.add (node);
                return;
            }

            for (Integer parent: parents) {
                dfs (parent, graph, result, tempResult);
                tempResult.add (parent);
            }
            result.put (node, new ArrayList <> (tempResult));

    }

    */

}

// Time complexity - O(n^2 logn)
// Space complexity - O(n^2)