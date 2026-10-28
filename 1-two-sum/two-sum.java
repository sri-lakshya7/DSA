class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        int i;

        for (i = 1; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) break;
            map.put(nums[i], i);
        }

        return new int[]{i, map.get(target-nums[i])};
    }
}