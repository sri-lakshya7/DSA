class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0;

        for (int i = 1; i < grid.length-1; i++) {
            for (int j = 1; j < grid[i].length-1; j++) {
                if (grid[i][j] == 0 && isClosed(grid, i, j)) count++;
            }
        }

        return count;
    }

    private boolean isClosed(int[][] grid, int row, int col) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{row, col});
        boolean valid = true;

        while (!q.isEmpty()) {
            int i = q.peek()[0], j = q.poll()[1];
            if (i == 0 || j == 0 || i == grid.length-1 || j == grid[i].length-1) {
                valid = false;
                continue;
            }
            grid[i][j] = 2; // represents visited

            if (grid[i-1][j] == 0) q.offer(new int[]{i-1, j});
            if (grid[i+1][j] == 0) q.offer(new int[]{i+1, j});
            if (grid[i][j-1] == 0) q.offer(new int[]{i, j-1});
            if (grid[i][j+1] == 0) q.offer(new int[]{i, j+1});
        }

        return valid;
    }
}