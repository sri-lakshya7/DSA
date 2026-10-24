class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int mid = 0;
        int right = nums.length-1;

        while (mid <= right) {
            int temp = nums[mid];
            if (nums[mid] == 0) {
                nums[mid++] = nums[left];
                nums[left++] = temp;
            } else if (nums[mid] == 2) {
                nums[mid] = nums[right];
                nums[right--] = temp;
            } else mid++;
        }
    }
}