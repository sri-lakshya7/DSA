class Solution {
    public int equalPairs(int[][] grid) {
        int[][] newGrid = new int[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid.length; j++)
                newGrid[i][j] = grid[j][i];
        
        int pairs = 0;
        for (int[] row: grid)
            for (int[] col: newGrid)
                if (Arrays.equals(row, col))
                    pairs++;
        
        return pairs;
    }
}