class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] keyCheck = new boolean[rooms.size()];
        keyCheck[0] = true;
        int visitedCount = 1;
        q.offer(0);

        while(!q.isEmpty()) {
            int curr = q.poll();
            for (int key: rooms.get(curr)) {
                if (!keyCheck[key]) {
                    keyCheck[key] = true;
                    visitedCount++;
                    q.offer(key);
                }
            }
        }

        return visitedCount==rooms.size();
    }
}