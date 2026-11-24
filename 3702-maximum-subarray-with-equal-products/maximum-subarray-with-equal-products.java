class Solution {
    public int maxLength(int[] nums) {
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            long prod = nums[i];
            int gcd = nums[i], lcm = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                prod *= nums[j];
                gcd = getGCD(gcd, nums[j]);
                lcm = getLCM(lcm, nums[j]);

                if (prod == lcm * gcd)
                    if (j-i+1 > longest) 
                        longest = j-i+1;

                if (prod > 1_000_000_000_000L) break;
            }
        }
        return longest;
    }
    private int getGCD(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return Math.abs(num1);
    }
    private int getLCM(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            return 0;
        }
        return Math.abs((num1 / getGCD(num1, num2)) * num2);
    }
}