class Solution {
    public boolean search(int[] nums, int target) {
        // int left = 0, right = nums.length-1;
        // while (left <= right) {
        //     int mid = left + (right - left)/2;

        //     if (target == nums[mid]) {
        //         return true;
        //     }

        //     if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
        //         right--; left++; continue;
        //     }

        //     if (nums[mid] < target) left = mid+1;
        //     else right = mid-1;
        // }
        // return false;

        for (int num: nums) {
            if (num == target) return true;
        }
        return false;
    }
}