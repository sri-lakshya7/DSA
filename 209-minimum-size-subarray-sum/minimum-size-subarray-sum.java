class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = nums[0];
        int min = nums.length+1;

        while (left < nums.length) {
            if (sum >= target) {
                // min = Math.min(min , right-left+1);
                int tempMin = right-left+1;
                if (min > tempMin) min = tempMin;
                sum -= nums[left++];
            } else {
                right++;
                if (right == nums.length) break;
                sum += nums[right];
            }
        }

        if (min > nums.length) return 0;
        return min;
    }
}