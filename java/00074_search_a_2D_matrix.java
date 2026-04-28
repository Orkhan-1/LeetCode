class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int column = matrix[0].length;

        int rowStart = 0;
        int rowEnd = row - 1;

        while (rowStart <= rowEnd) {
            int rowMid = rowStart + (rowEnd - rowStart) / 2;

            if (matrix[rowMid][column - 1] == target) {
                return true;
            } else if (matrix[rowMid][column - 1] > target) {
                rowEnd = rowMid - 1;
            } else {
                rowStart = rowMid + 1;
            }
        }

        int targetRow = rowStart;
        if (targetRow >= row) {
            return false;
        }

        int columnStart = 0;
        int columnEnd = column - 1;

        while (columnStart <= columnEnd) {
            int columnMid = columnStart +
                    (columnEnd - columnStart) / 2;

            if (matrix[targetRow][columnMid] == target) {
                return true;
            } else if (matrix[targetRow][columnMid] > target) {
                columnEnd = columnMid - 1;
            } else {
                columnStart = columnMid + 1;
            }
        }

        return false;
    }
}