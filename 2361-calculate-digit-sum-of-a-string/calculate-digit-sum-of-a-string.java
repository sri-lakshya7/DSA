class Solution {
    public String digitSum(String s, int k) {
        if (s.length() <= k) return s;
        StringBuilder result = new StringBuilder(s);

        while (result.length() > k) {
            result = helper(result, k);
        }
        return result.toString();
    }

    private StringBuilder helper(StringBuilder old, int k) {
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < old.length(); i+=k) {
            int sum = 0;
            for (int j = i; j < i+k && j < old.length(); j++) {
                char ch = old.charAt(j);
                sum += (ch-'0');
            }
            newStr.append(sum);
        }
        return newStr;
    }
}