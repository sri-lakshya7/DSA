class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minSum = Integer.MAX_VALUE;
        boolean unupdated = true;
        for (int i = 0; i < nums.size(); i++) {
            int sum = 0;
            for (int j = i; j < nums.size(); j++) {
                sum += nums.get(j);
                if (j-i+1 < l) continue;
                if (j-i >= r) break;
                if ((sum > 0) && (sum < minSum)) {
                    minSum = sum;
                    unupdated = false;
                }
            }
        }
        if (unupdated) return (-1);
        return minSum;
    }
}