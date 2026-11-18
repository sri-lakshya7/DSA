class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> q = new ArrayDeque<>();
        int level = 0;
        q.offer(entrance);
        maze[entrance[0]][entrance[1]] = '*';

        int[][] dirs = {{1,0}, {-1,0}, {0, -1}, {0,1}};

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] cords = q.poll();
                int x = cords[0], y = cords[1];

                if (x == 0 || y == 0 || x+1 == maze.length || y+1 == maze[0].length) {
                    if (level > 0)
                    return level;
                }

                for (int[] dir: dirs) validate(maze, q, x+dir[0], y+dir[1]);
            }
            level++;
        }
        return (-1);
    }

    private void validate(char[][] maze, Queue<int[]> q, int x, int y) {
        if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || maze[x][y] == '+' || maze[x][y] == '*') return;

        q.offer(new int[]{x, y});
        maze[x][y] = '*';
    }
}