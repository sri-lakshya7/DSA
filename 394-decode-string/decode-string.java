class Solution {
    public String decodeString(String s) {
        Deque<StringBuilder> strSt = new ArrayDeque<>();
        Deque<Integer> cntSt = new ArrayDeque<>();

        int num = 0;
        StringBuilder sb = new StringBuilder();

        // for (int i = 0; i < s.length(); i++) {
        //     char ch = s.charAt(i);
        for (char ch: s.toCharArray()) {
            if (ch-'0'>=0 && ch-'0'<=9) {
                num = (num*10)+(ch-'0');
            } else if (ch == '[') {
                cntSt.push(num);
                strSt.push(sb);

                sb = new StringBuilder();
                num = 0;
            } else if (ch == ']') {
                int count = cntSt.pop();
                StringBuilder lastStr = strSt.pop();

                for (int j = 0; j < count; j++) {
                    lastStr.append(sb);
                }
                sb = lastStr;
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}