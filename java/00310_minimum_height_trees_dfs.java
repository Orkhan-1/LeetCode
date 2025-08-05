class Solution {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int to = edges[i][0];
            int from = edges[i][1];

            if (map.get(to) == null) {
                Set<Integer> sets = new HashSet<>();
                sets.add(from);
                map.put(to, sets);
            } else {
                Set<Integer> sets = map.get(to);
                sets.add(from);
            }

            if (map.get(from) == null) {
                Set<Integer> sets = new HashSet<>();
                sets.add(to);
                map.put(from, sets);
            } else {
                Set<Integer> sets = map.get(from);
                sets.add(to);
            }
        }

        List<Integer> result = new ArrayList<>();
        Integer min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            int h = dfs(i, map, visited);

            if (h < min) {
                result.clear();
                result.add(i);
                min = h;
            } else if (h == min) {
                result.add(i);
            }
        }
        return result;
    }

    private static int dfs(int i, Map<Integer, Set<Integer>> map, Set<Integer> visited) {
        Set<Integer> nodes = map.get(i);

        int max = 0;
        int currentMax = 0;

        if (nodes != null) {
            for (int j : nodes) {
                if (!visited.contains(j)) {
                    visited.add(j);
                    currentMax = 1 + dfs(j, map, visited);
                }
                max = Math.max(max, currentMax);
            }
        }

        return max;
    }
}

// Using DFS from every node (O(n²)) to compute the height of the tree rooted at each node. Since n can go up to 20,000, this becomes too slow

// Time complexity - O(n^2)
// Space complexity - O (n)