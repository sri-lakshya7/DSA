class Solution {
    public boolean isNumber(String s) {
        boolean hasE = false, isDecimal = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '-' || ch == '+') {
                if(i > 0 && (s.charAt(i-1) == 'e' || s.charAt(i-1) == 'E')) {
                    if (i == s.length()-1) return false;
                    continue;
                }
                if (s.length() == 1) return false;
                if (i==0) continue;
                return false;
            }

            if (ch-'0' >= 0 && ch-'0' <= 9) continue;

            if (ch == 'e' || ch == 'E') {
                if (i == 0 || i == s.length()-1) return false;
                if (s.charAt(i-1) == '+' || s.charAt(i-1) == '-') return false;
                else if (hasE) return false;
                else hasE = true;
                continue;
            }

            if (ch == '.') {
                if (isDecimal || hasE || s.length() == 1) return false;
                if (!((i>0 && isNum(s.charAt(i-1))) || (i<s.length()-1 && isNum(s.charAt(i+1))))) return false;
                isDecimal = true;
                continue;
            }

            return false;
        }

        return true;
    }

    private boolean isNum(char ch) {
        if (ch-'0' >= 0 && ch-'0'<=9) return true;
        return false;
    }
}