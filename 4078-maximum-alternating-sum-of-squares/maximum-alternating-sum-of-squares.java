class Solution {
    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) nums[i] = Math.abs(nums[i]);
        Arrays.sort(nums);
        long sum = 0;
        int n = nums.length, i = 0;
        if (n%2==1) n--;

        for (; i < n/2; i++) {
            sum -= ((long)nums[i]*nums[i]);
        }
        for (; i < n; i++) {
            sum += ((long)nums[i]*nums[i]);
        }
        if (nums.length % 2 == 1) sum += (long)nums[nums.length-1] * nums[nums.length-1];

        return sum;
    }
}