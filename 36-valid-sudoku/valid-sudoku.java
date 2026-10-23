class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                HashSet<Character> set = new HashSet<>();
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        if (board[i+r][j+c] == '.') continue;
                        if (set.contains(board[i+r][j+c])) return false;
                        set.add(board[i+r][j+c]);
                    }
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        for (int j = 0; j < 9; j++) {
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') continue;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }

        return true;
    }
}