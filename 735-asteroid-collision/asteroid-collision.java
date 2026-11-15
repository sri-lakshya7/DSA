class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(asteroids[0]);

        for (int i = 1; i < asteroids.length; i++) {
            if (asteroids[i] < 0) {
                while (!stack.isEmpty()) {
                    int last = stack.peek(), curr = asteroids[i]*(-1);
                    if ((last < 0) || (last >= curr)) break;
                    stack.pop();
                }
                if (stack.peek() == null) stack.push(asteroids[i]);
                else if (stack.peek() == asteroids[i]*(-1)) stack.pop();
                else if (stack.peek() > asteroids[i]*(-1)) continue;
                else stack.push(asteroids[i]);
            } else stack.push(asteroids[i]);
        }
        int[] result = new int[stack.size()];
        for (int i = result.length-1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}