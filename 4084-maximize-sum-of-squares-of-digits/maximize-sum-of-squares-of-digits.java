class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > num * 9) return "";

        int n = num, s = sum;
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            if (s > 9) {
                sb.append(9);
                s -= 9;
            } else {
                sb.append(s % 10);
                s -= s % 10;
            }
        }
        return sb.toString();
    }
}