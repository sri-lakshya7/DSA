class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int temp = x, num = 0;
        while (temp > 0) {
            num = num*10 + temp%10;
            temp /= 10;
        }
        return x == num;
    }
}