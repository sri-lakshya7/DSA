class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
        } while (slow != fast && fast != 1);

        return (fast == 1);
    }

    private int squareSum(int num) {
        int sum = 0;
        while (num > 0) {
            int lastDig =num % 10;
            sum += lastDig * lastDig;
            num /= 10;
        }
        return sum;
    }
}