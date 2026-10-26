class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int longest = 1;
        for (int n : set) {
            if (set.contains(n-1)) continue;

            int num = n, count = 0;
            while(set.contains(num)) {
                count++;
                num++;
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }
}