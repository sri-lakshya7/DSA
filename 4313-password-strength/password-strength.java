class Solution {
    public int passwordStrength(String password) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        boolean[] digit = new boolean[10];
        boolean[] special = new boolean[4];
        int points = 0;
        
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (ch - 'a' >= 0 && ch - 'a' < 26 && !lower[ch-'a']) {
                if (!lower[ch-'a']) {
                    lower[ch-'a'] = true;
                    points++;
                }
            } else if (ch - 'A' >= 0 && ch - 'A' < 26 && !upper[ch-'A']) {
                if (!upper[ch-'A']) {
                    upper[ch-'A'] = true;
                    points += 2;
                }
            } else if (ch-'0' >= 0 && ch-'0' < 10) {
                if (!digit[ch-'0']) {
                    digit[ch-'0'] = true;
                    points+= 3;
                }
            } else {
                if (ch == '!') {
                    if (!special[0]) {
                        special[0] = true;
                        points += 5;
                    }
                } else if (ch == '@') {
                    if (!special[1]) {
                        special[1] = true;
                        points += 5;
                    }
                } else if (ch == '#') {
                    if (!special[2]) {
                        special[2] = true;
                        points += 5;
                    }
                } else if (ch == '$') {
                    if (!special[3]) {
                        special[3] = true;
                        points += 5;
                    }
                }
            }
        }


        return points;
    }
}