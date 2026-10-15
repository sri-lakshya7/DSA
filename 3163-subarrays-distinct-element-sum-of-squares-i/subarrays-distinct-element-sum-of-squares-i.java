class Solution {
    public int sumCounts(List<Integer> nums) {
        int sqSum = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.size(); i++) {
            int distinct = 0;
            for (int j = i; j < nums.size(); j++) {
                int num = nums.get(j);
                // System.out.println(i + " " + j);
                if (!set.contains(num)) distinct++;
                set.add(num);
                // System.out.println(distinct);
                sqSum += distinct * distinct;
            }
            set.clear();
        }

        return sqSum;
    }
}