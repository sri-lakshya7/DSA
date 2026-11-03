class Solution {
    public int minMoves(int[] nums) {
        int largest = nums[0], moves = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > largest) {
                moves += (nums[i]-largest)*i;
                largest = nums[i];
            } else {
                moves += largest - nums[i];
            }
        }
        return moves;
    }
}