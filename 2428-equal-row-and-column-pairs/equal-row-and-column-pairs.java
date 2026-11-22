class Solution {
    public int equalPairs(int[][] grid) {
        int pairs = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isValid(grid, i, j)) pairs++;
            }
        }
        return pairs;
    }

    private boolean isValid(int[][] grid, int i, int j) {
        for (int k = 0; k < grid.length; k++) {
            if (grid[k][j] != grid[i][k]) return false;
        }
        return true;
    }
}