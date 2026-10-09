class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) continue;

            dfs(isConnected, visited, i);
            count++;
        }
        return count;
    }

    private void dfs(int[][] matrix, boolean[] visited, int i) {
        visited[i] = true;
        int[] arr = matrix[i];
        for (int j = 0; j < arr.length; j++) {
            if (!visited[j] && arr[j] == 1) {
                dfs(matrix, visited, j);
            }
        }
    }
}