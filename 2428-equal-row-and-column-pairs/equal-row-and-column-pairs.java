class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<ArrayList<Integer>, Integer> map = new HashMap<>();
        for (int i =0; i < grid.length; i++) {
            ArrayList<Integer> lst = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++)
                lst.add(grid[i][j]);
            
            map.put(lst, map.getOrDefault(lst, 0)+1);
        }
        int pairs = 0;

        for (int j = 0; j < grid[0].length; j++) {
            ArrayList<Integer> lst = new ArrayList<>();
            for (int i = 0; i < grid.length; i++)
                lst.add(grid[i][j]);
            
            pairs+=map.getOrDefault(lst,0);
        }

        return pairs;
    }
}

