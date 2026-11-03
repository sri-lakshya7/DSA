class Solution {
    public int minMoves(int[] nums) {
        int sum = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) max = nums[i];
            sum += nums[i];
        }

        return (max * nums.length) - sum;
    }
}