class Solution {
    public String[] createGrid(int m, int n) {
        String[] str = new String[m];

        for (int i = 0; i < m; i++) {
            char[] arr = new char[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == n-1) arr[j] = '.';
                else arr[j] = '#';
            }
            str[i] = new String(arr);
        }

        return str;
    }
}