class Solution {
    public String getHint(String secret, String guess) {
        int x = 0, y = 0, n = secret.length();
        int[] sec = new int[10], gue = new int[10];

        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                x++;
            } else {
                gue[guess.charAt(i) - '0']++;
                sec[secret.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            y += Math.min(sec[i], gue[i]);
        }

        return new StringBuilder().append("" + x + "A" + y + "B").toString();
    }
}