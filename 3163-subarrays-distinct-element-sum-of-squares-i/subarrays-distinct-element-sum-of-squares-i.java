class Solution {
    public int sumCounts(List<Integer> nums) {
        int sqSum = 0;

        for (int i = 0; i < nums.size(); i++) {
            boolean[] set = new boolean[101];
            int distinct = 0;
            for (int j = i; j < nums.size(); j++) {
                int num = nums.get(j);
                if (!set[num]) distinct++;

                set[num] = true;
                sqSum += distinct * distinct;
            }
        }

        return sqSum;
    }
}