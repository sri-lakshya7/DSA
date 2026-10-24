// class Solution {
//     public void sortColors(int[] nums) {
//         int low = 0, mid = 0, high = nums.length-1;

//         while (mid <= high) {
//             if (nums[mid] == 0) {
//                 nums[mid++] = nums[low];
//                 nums[low++] = 0;
//             } else if (nums[mid] == 2) {
//                 nums[mid++] = nums[high];
//                 nums[high--] = 2;
//             } else mid++;
//         }
//     }
// }



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