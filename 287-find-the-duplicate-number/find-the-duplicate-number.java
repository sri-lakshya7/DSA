class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                slow = nums[0];
                while (slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                break;
            }
        } while(true);

        return fast;
    }
}