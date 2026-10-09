class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] map = new int[nums.length];
        List<List<Integer>> lst = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int idx = map[nums[i]-1];
            map[nums[i]-1]++;

            if (lst.size() == idx) lst.add(new ArrayList<Integer>());
            lst.get(idx).add(nums[i]);
        }

        return lst;
    }
}