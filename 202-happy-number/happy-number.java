class Solution {
    public boolean isHappy(int n) {
        return (squareSum(n) == 1 || squareSum(n) == 7);
    }

    private int squareSum(int num) {
        int sum = 0;
        while (num > 0) {
            int lastDig = num%10;
            sum += lastDig * lastDig;
            num /= 10;
        }
        
        while (sum > 9) {
            sum = squareSum(sum);
        }

        return sum;
    }
}