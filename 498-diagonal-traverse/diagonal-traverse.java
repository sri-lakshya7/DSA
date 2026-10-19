class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] res = new int[n*m];
        int r = 0, c = 0, idx = 0;

        while (true) {
            boolean isVis = false;
            while (r >= 0 && c < m) {
                isVis = true;
                res[idx++] = mat[r][c];
                r--; c++;
            }
            r++;
            if (c == m) {
                r++; c--;
            }

            while (r < n && c >= 0) {
                isVis = true;
                res[idx++] = mat[r][c];
                r++; c--;
            }
            c++;
            if (r == n) {
                r--; c++;
            }

            if (!isVis) break;
        }

        return res;
    }
}