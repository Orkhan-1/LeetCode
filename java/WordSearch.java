public class WordSearch {

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && bt(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bt(char[][] board, int i, int j, String word, int index) {

        if (index == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }

        if (word.charAt(index) != board[i][j]) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '*';
        if (bt(board, i + 1, j, word, index + 1) ||
                bt(board, i - 1, j, word, index + 1) ||
                bt(board, i, j + 1, word, index + 1) ||
                bt(board, i, j - 1, word, index + 1)) {
            return true;
        }

        board[i][j] = temp;
        return false;
    }
}
