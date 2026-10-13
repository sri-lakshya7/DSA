class Solution {
    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) nums[i] = Math.abs(nums[i]);
        Arrays.sort(nums);
        long sum = 0;
        int n = nums.length, i = 0, j = n-1;
        // if (n%2==1) n--;

        while (i < j) {
            sum -= (long)nums[i] * nums[i++];
            sum += (long)nums[j] * nums[j--];
        }

        if (nums.length % 2 == 1) sum += (long)nums[j] * nums[j];

        return sum;
    }
}