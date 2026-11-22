class Solution {
    public boolean checkString(String s) {
        boolean bAppeared = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') bAppeared = true;
            else if (bAppeared) return false;
        }
        return true;
    }
}