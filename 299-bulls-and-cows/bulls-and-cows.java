class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char ch = secret.charAt(i);
            HashSet<Integer> set = map.getOrDefault(ch, new HashSet<Integer>());
            set.add(i);
            map.put(ch, set);
        }
        int x = 0, y = 0;
        boolean[] check = new boolean[secret.length()];

        for (int i = 0; i < guess.length(); i++) {
            char ch = guess.charAt(i);
            if (map.containsKey(ch) && map.get(ch).contains(i)) {
                x++;
                check[i] = true;
                map.get(ch).remove(i);
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            char ch = guess.charAt(i);
            if (!check[i] && map.containsKey(ch) && map.get(ch).size() != 0) {
                y++;
                Iterator<Integer> it = map.get(ch).iterator();
                if (it.hasNext()) {
                    it.next();
                    it.remove();
                }
            }
        }

        return new StringBuilder().append(x).append("A").append(y).append("B").toString();
    }
}