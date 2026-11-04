class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) return s;
        StringBuilder[] arr = new StringBuilder[numRows];
        for (int i = 0; i < arr.length; i++) arr[i] = new StringBuilder();
        
        int col = s.length() / (2 * numRows - 2);
        if (col * numRows < s.length()) col++;

        int idx = 0;
        for (int i = 0; i < col; i++) {
            int j = 0;
            while (j < numRows-1 && idx < s.length()) {
                arr[j++].append(s.charAt(idx++));
            }
            while (j > 0 && idx < s.length()) {
                arr[j--].append(s.charAt(idx++));
            }
        }
        char[] str = new char[s.length()];
        idx = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                str[idx++] = arr[i].charAt(j);
            }
        }
        return new String(str);
    }
}