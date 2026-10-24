class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0, zero = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) q.offer(new int[]{i,j});
                else if (grid[i][j] == 1) fresh++;
                else zero++;
            }
        }

        if (zero == grid.length * grid[0].length) return 0;

        int time = -1;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int run = 0; run < n; run++) {
                int[] cords = q.poll();
                int i = cords[0], j = cords[1];
                fresh -= rot(i, j, grid, q);
            }
            time++;
        }

        if (fresh > 0) return (-1);
        return time;
    }

    private int rot(int i, int j, int[][] grid, Queue<int[]> q) {
        int rotted = 0;
        if (i > 0 && grid[i-1][j] == 1) {
            q.offer(new int[]{i-1, j});
            grid[i-1][j] = 2;
            rotted++;
        }
        if (j > 0 && grid[i][j-1] == 1) {
            q.offer(new int[]{i, j-1});
            grid[i][j-1] = 2;
            rotted++;
        }
        if (i < grid.length-1 && grid[i+1][j] == 1) {
            q.offer(new int[]{i+1, j});
            grid[i+1][j] = 2;
            rotted++;
        }
        if (j < grid[i].length-1 && grid[i][j+1] == 1) {
            q.offer(new int[]{i, j+1});
            grid[i][j+1] = 2;
            rotted++;
        }

        return rotted;
    }
}