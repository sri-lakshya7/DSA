class Solution {
    public int minMoves(int[] nums) {
        int moves = 0;

        // while (true) {
        //     int largest = 0, smallest = 0;
        //     boolean changes = false;
        //     for (int i = 1; i < nums.length; i++) {
        //         if (nums[i] != nums[i-1]) changes = true;
        //         if (nums[i] < nums[smallest]) smallest = i;
        //         if (nums[i] > nums[largest]) largest = i;
        //     }
        //     if (changes) {
        //         moves++;
        //         for (int i = 0; i < nums.length; i++) {
        //             if (i == largest) continue;
        //             nums[i]++;
        //         }
        //     } else break;
        // }

        int min = 0;
        for (int i = 1; i < nums.length; i++) if (nums[i] < nums[min]) min = i;
        for (int i = 0; i < nums.length; i++) moves += nums[i]-nums[min];

        return moves;
    }
}