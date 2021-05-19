class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(0));
        
        while(!queue.isEmpty()) {
            List<Integer> cur = queue.remove();
            if(cur.get(cur.size() - 1) == graph.length - 1) {
                result.add(cur);
                continue;
            }
            
            for(int n : graph[cur.get(cur.size() - 1)]) {
                List<Integer> next = new ArrayList(cur);
                next.add(n);
                queue.add(next);
            }
        }
        return result;
    }
}