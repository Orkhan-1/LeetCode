
// Time complexity - O (R*C)
// Space complexity - O (1)
public class MaximumMatrixSum {

    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;
        int negativeNumbers = 0;
        int minNumber = Integer.MAX_VALUE;

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                if (matrix[x][y] <= 0) {
                    negativeNumbers++;
                }
                totalSum += Math.abs(matrix[x][y]);
                minNumber = Math.min(minNumber, Math.abs(matrix[x][y]));
            }
        }

        if (negativeNumbers % 2 == 0) {
            return totalSum;
        }
        return totalSum - minNumber * 2;
    }
}
