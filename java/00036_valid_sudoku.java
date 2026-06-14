/**
 * 🧩 Problem:
 * Given a 9 x 9 Sudoku board, determine whether it is valid.
 *
 * Rules:
 *    1️⃣ Each row must contain digits 1-9 without duplicates.
 *    2️⃣ Each column must contain digits 1-9 without duplicates.
 *    3️⃣ Each 3 x 3 sub-box must contain digits 1-9
 *        without duplicates.
 *
 * Empty cells are represented by '.' and are ignored.
 *
 * 🎯 Goal:
 * Return:
 *      true  -> if the board is valid
 *      false -> otherwise
 *
 * ---------------------------------------------------
 *
 * 🧠 Idea:
 *
 * We need to verify three constraints:
 *
 *    ✔ Rows
 *    ✔ Columns
 *    ✔ 3×3 Boxes
 *
 * Instead of checking every pair of cells,
 * we use boolean arrays to remember which numbers
 * have already been seen.
 *
 * ---------------------------------------------------
 *
 * Let:
 *
 *      rows[9][9]
 *      cols[9][9]
 *      boxes[9][9]
 *
 * Meaning:
 *
 * rows[r][d]
 *      Has digit (d+1) appeared in row r?
 *
 * cols[c][d]
 *      Has digit (d+1) appeared in column c?
 *
 * boxes[b][d]
 *      Has digit (d+1) appeared in box b?
 *
 * ---------------------------------------------------
 *
 * 🧠 Box Number:
 *
 * Each cell belongs to one of 9 boxes.
 *
 * Formula:
 *
 *      box = (row / 3) * 3 + (col / 3)
 *
 * Example:
 *
 *      0 0 0 | 1 1 1 | 2 2 2
 *      0 0 0 | 1 1 1 | 2 2 2
 *      0 0 0 | 1 1 1 | 2 2 2
 *     -----------------------
 *      3 3 3 | 4 4 4 | 5 5 5
 *      3 3 3 | 4 4 4 | 5 5 5
 *      3 3 3 | 4 4 4 | 5 5 5
 *     -----------------------
 *      6 6 6 | 7 7 7 | 8 8 8
 *      6 6 6 | 7 7 7 | 8 8 8
 *      6 6 6 | 7 7 7 | 8 8 8
 *
 * ---------------------------------------------------
 *
 * 🧠 Algorithm:
 *
 * For every cell:
 *
 *    1️⃣ Skip '.' cells.
 *
 *    2️⃣ Convert character to index:
 *
 *            digit = board[r][c] - '1'
 *
 *    3️⃣ Compute:
 *
 *            box = (r / 3) * 3 + (c / 3)
 *
 *    4️⃣ If digit already exists in:
 *
 *            rows[r]
 *         or cols[c]
 *         or boxes[box]
 *
 *         return false.
 *
 *    5️⃣ Otherwise mark it as seen.
 *
 * If the entire board is processed,
 * return true.
 *
 * ---------------------------------------------------
 *
 * 🧾 Time Complexity:
 *      O(9 × 9) = O(1)
 *
 * 🧾 Space Complexity:
 *      O(9 × 9) = O(1)
 */

class Solution {

    public boolean isValidSudoku(char[][] board) {

        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                if (board[r][c] == '.') {
                    continue;
                }

                int digit = board[r][c] - '1';
                int box = (r / 3) * 3 + (c / 3);

                if (rows[r][digit] ||
                        cols[c][digit] ||
                        boxes[box][digit]) {
                    return false;
                }

                rows[r][digit] = true;
                cols[c][digit] = true;
                boxes[box][digit] = true;
            }
        }

        return true;
    }
}