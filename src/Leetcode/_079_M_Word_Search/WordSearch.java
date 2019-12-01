package Leetcode._079_M_Word_Search;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0 || word.length() == 0) { return false; }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backTrack(board, i, j, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private boolean backTrack(char[][] board, int row, int col, String remainWord) {
        final int m = board.length;
        final int n = board[0].length;

        if ((row >= m || row < 0) || (col >= n || col < 0) || board[row][col] != remainWord.charAt(0)) {
            return false;
        }

        if (remainWord.length() == 1 && board[row][col] == remainWord.charAt(0)) {
            return true;
        }

        char tmp = board[row][col];
        board[row][col] = '-';

        String word = remainWord.substring(1, remainWord.length());
        boolean ret = backTrack(board, row + 1, col, word)
                        || backTrack(board, row - 1, col, word)
                        || backTrack(board, row, col + 1, word)
                        || backTrack(board, row, col - 1, word);

        board[row][col] = tmp;
        return ret;
    }

    public void unittest1() {
        char[][] board = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
    }

    public static void main(String[] args) {
        WordSearch a = new WordSearch();
        a.unittest1();
    }
}
