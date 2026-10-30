class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> lst = new ArrayList<>();
        
        int smallest = intervals[0][0], largest = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > largest) {
                lst.add(new int[]{smallest, largest});
                smallest = intervals[i][0];
                largest = intervals[i][1];
            } else largest = Math.max(largest,intervals[i][1]);
        }
        lst.add(new int[]{smallest, largest});

        return lst.toArray(new int[lst.size()][]);
    }
}