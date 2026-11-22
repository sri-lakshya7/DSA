class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i =0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                sb.append(grid[i][j]).append(',');
            }
            String str = sb.toString();
            map.put(str, map.getOrDefault(str, 0)+1);
        }
        int pairs = 0;

        for (int j = 0; j < grid[0].length; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < grid.length; i++) {
                sb.append(grid[i][j]).append(',');
            }
            String str = sb.toString();
            if (map.containsKey(str) && map.get(str) > 0)
                pairs+=map.getOrDefault(str,0);
        }

        return pairs;
    }
}