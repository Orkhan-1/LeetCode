public class MinimumPathSum {
    public int minPathSum(int[][] grids) {
        if (grids == null || grids.length == 0 || grids[0] == null || grids[0].length == 0) {
            return 0;
        }
        for (int i = 1; i < grids.length; i++) {
            grids[i][0] = grids[i - 1][0] + grids[i][0];
        }
        for (int i = 1; i < grids[0].length; i++) {
            grids[0][i] = grids[0][i - 1] + grids[0][i];
        }
        for (int i = 1; i < grids.length; i++) {
            for (int j = 1; j < grids[0].length; j++) {
                grids[i][j] = Math.min(grids[i - 1][j], grids[i][j - 1]) + grids[i][j];
            }
        }
        return grids[grids.length - 1][grids[0].length - 1];
    }
}
