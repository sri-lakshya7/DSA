class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> lst = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], -1) + 1);
            int idx = map.get(nums[i]);

            if (lst.size() == idx) lst.add(new ArrayList<Integer>());
            lst.get(idx).add(nums[i]);
        }

        return lst;
    }
}