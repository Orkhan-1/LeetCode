// Time complexity -  O (N)
// Space complexity - O (N) - parent array
public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int parentU = find(parent, u);
            int parentV = find(parent, v);

            if (parentU == parentV) {
                return edge;
            } else {
                union(parent, parentU, parentV);
            }
        }

        return new int[2];
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private void union(int[] parent, int u, int v) {
        if (u < v) {
            parent[u] = v;
        } else {
            parent[v] = u;
        }
    }

}
