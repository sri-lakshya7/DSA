class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] keyCheck = new boolean[rooms.size()];
        // keyCheck[0] = true;
        int visitedCount = 0;
        q.offer(0);

        while(!q.isEmpty()) {
            int key = q.poll();
            if (!keyCheck[key]) {
                keyCheck[key] = true;
                visitedCount++;
                List<Integer> lst = rooms.get(key);
                for(int i: lst) {
                    if (!keyCheck[i]) {
                        q.offer(i);
                    }
                }
            }
        }

        return visitedCount==rooms.size();
    }
}