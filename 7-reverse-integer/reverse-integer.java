class Solution {
    public int reverse(int x) {
        int num = 0, sign = 1;
        if (x < 0) sign = -1;

        while (x != 0) {
            if (num < Integer.MIN_VALUE / 10 || num > Integer.MAX_VALUE / 10) return 0;
            num = num*10 + x%10;
            x /= 10;
        }

        return num;
    }
}