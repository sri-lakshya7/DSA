class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0;

        for (int i = 1; i < grid.length-1; i++) {
            for (int j = 1; j < grid[i].length-1; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 2;
                    if (isClosed(grid, i, j)) count++;
                    System.out.println(i + " " + j);
                }
            }
        }

        return count;
    }

    private boolean isClosed(int[][] grid, int i, int j) {
        if (i == 0 || j == 0 || i == grid.length-1 || j == grid[i].length-1) return false;
        boolean valid = true;

        if (grid[i-1][j] == 0) {
            grid[i-1][j] = 2;
            valid = isClosed(grid, i-1, j) && valid;
        }
        if (grid[i+1][j] == 0) {
            grid[i+1][j] = 2;
            valid = isClosed(grid, i+1, j) && valid;
        }
        if (grid[i][j-1] == 0) {
            grid[i][j-1] = 2;
            valid = isClosed(grid, i, j-1) && valid;
        }
        if (grid[i][j+1] == 0) {
            grid[i][j+1] = 2;
            valid = isClosed(grid, i, j+1) && valid;
        }

        return valid;
    }
}