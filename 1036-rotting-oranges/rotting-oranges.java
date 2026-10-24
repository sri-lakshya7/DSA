class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) q.offer(new int[]{i,j,0});
            }
        }

        int time = 0;
        while (!q.isEmpty()) {
            int[] cords = q.poll();
            int i = cords[0], j = cords[1], t = cords[2];
            rot(i, j, t, grid, q);
            time = t;
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) return (-1);
            }
        }

        return time;
    }

    private void rot(int i, int j, int t, int[][] grid, Queue<int[]> q) {
        if (i > 0 && grid[i-1][j] == 1) {
            q.offer(new int[]{i-1, j, t+1});
            grid[i-1][j] = 2;
        }
        if (j > 0 && grid[i][j-1] == 1) {
            q.offer(new int[]{i, j-1, t+1});
            grid[i][j-1] = 2;
        }
        if (i < grid.length-1 && grid[i+1][j] == 1) {
            q.offer(new int[]{i+1, j, t+1});
            grid[i+1][j] = 2;
        }
        if (j < grid[i].length-1 && grid[i][j+1] == 1) {
            q.offer(new int[]{i, j+1, t+1});
            grid[i][j+1] = 2;
        }
    }
}