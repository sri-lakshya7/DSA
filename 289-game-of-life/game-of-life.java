class Solution {
    public void gameOfLife(int[][] board) {
        int[][] res = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                res[i][j] = helper(board, i, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = res[i][j];
            }
        }
    }

    private int helper(int[][] old, int i, int j) {
        int sum = 0;
        sum += isLive(old, i-1, j-1);
        sum += isLive(old, i-1, j);
        sum += isLive(old, i-1, j+1);
        sum += isLive(old, i, j-1);
        sum += isLive(old, i, j+1);
        sum += isLive(old, i+1, j-1);
        sum += isLive(old, i+1, j);
        sum += isLive(old, i+1, j+1);
        
        if (old[i][j] == 0) {
            if (sum == 3) return 1;
            return 0;
        }

        if (sum < 2 || sum > 3) return 0;
        return 1;
    }
    private int isLive(int[][] old, int i, int j) {
        if (i < 0 || j < 0 || i == old.length || j == old[0].length) return 0;
        return old[i][j];
    }
}