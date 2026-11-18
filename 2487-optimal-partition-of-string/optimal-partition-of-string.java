class Solution {
    public int partitionString(String s) {
        boolean[] map = new boolean[26];
        int min = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map[ch-'a']) {
                min++;
                clearArray(map);
            }
            map[ch-'a'] = true;
        }
        min++;
        return min;
    }
    private void clearArray(boolean[] arr) {
        for (int i = 0; i < 26; i++) arr[i] = false;
    }
}