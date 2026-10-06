class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> resList = new ArrayList<>();
        helper(digits, 0, "", resList);

        return resList;
    }

    private void helper(String dig, int i, String prev, List<String> lst) {
        if (i == dig.length()) {
            lst.add(prev);
            return;
        }

        char ch = dig.charAt(i);
        for (int j = 0; j < numMap(ch).length(); j++) {
            helper(dig, i+1, prev + numMap(ch).charAt(j), lst);
        }
    }

    private String numMap(char ch) {
        if (ch == '2') return "abc";
        if (ch == '3') return "def";
        if (ch == '4') return "ghi";
        if (ch == '5') return "jkl";
        if (ch == '6') return "mno";
        if (ch == '7') return "pqrs";
        if (ch == '8') return "tuv";
        return "wxyz";
    }
}