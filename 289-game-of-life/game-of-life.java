class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0]. length; j++) {
                board[i][j] = countLive(board, i, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0]. length; j++) {
                board[i][j] = correctBoard(board, i, j);
            }
        }
    }

    private int countLive(int[][] board, int i, int j) {
        int sum = 0;
        sum += isLive(board, i-1, j-1);
        sum += isLive(board, i-1, j);
        sum += isLive(board, i-1, j+1);
        sum += isLive(board, i, j-1);
        sum += isLive(board, i, j+1);
        sum += isLive(board, i+1, j-1);
        sum += isLive(board, i+1, j);
        sum += isLive(board, i+1, j+1);
        if (board[i][j] == 0) {
            if (sum == 3) sum = 2;
            else sum = 0;
        }
        return (sum*10 + board[i][j]);
    }
    private int isLive(int[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return 0;
        return board[i][j]%10;
    }
    private int correctBoard(int[][] board, int i, int j) {
        if (board[i][j]/10 < 2 || board[i][j]/10 > 3) return 0;
        return 1;
    }
}