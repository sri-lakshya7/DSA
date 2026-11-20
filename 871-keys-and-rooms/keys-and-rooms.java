class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] keyCheck = new boolean[rooms.size()];
        keyCheck[0] = true;
        for (int i = 0; i < rooms.get(0).size(); i++) {
            List<Integer> lst = rooms.get(0);
            q.offer(lst.get(i));
        }

        while(!q.isEmpty()) {
            int key = q.poll();
            if (!keyCheck[key]) {
                keyCheck[key] = true;
                List<Integer> lst = rooms.get(key);
                for(int i: lst) {
                    if (!keyCheck[i]) {
                        q.offer(i);
                    }
                }
            }
        }

        for (boolean ch: keyCheck) if(!ch) return false;
        return true;
    }
}