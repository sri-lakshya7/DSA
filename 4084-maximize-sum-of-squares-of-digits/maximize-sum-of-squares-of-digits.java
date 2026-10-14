class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > num * 9) return "";

        char[] arr = new char[num];
        for (int i = 0; i < num; i++) {
            int dig = 0;
            if (sum > 9) dig = 9;
            else dig = sum % 10;

            arr[i] = (char)('0' + dig);
            sum -= dig;
        }
        return new String(arr);
    }
}