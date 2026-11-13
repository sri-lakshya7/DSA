class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        if (sentence.length() == 1) return sentence;
        Trie dict = new Trie();
        for (String str: dictionary) dict.addWord(str);
        StringBuilder sb = new StringBuilder();

        int left = 0;
        for (int i = 1; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch != ' ' && i != sentence.length()-1) continue;
            if (i == sentence.length()-1) i++;
            int right = dict.search(sentence, left, i-1);

            if (right < left) appendWord(sb, sentence, left, i-1);
            else appendWord(sb, sentence, left, right);
            left = i+1;
        }

        if (sb.charAt(sb.length()-1) == ' ') sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    private void appendWord(StringBuilder sb, String str, int left, int right) {
        for (int i = left; i <= right; i++) {
            char ch = str.charAt(i);
            sb.append(ch);
        }
        sb.append(" ");
    }

    class Trie {
        private class TrieNode {
            TrieNode[] children;
            boolean eow;

            TrieNode() {
                this.children = new TrieNode[26];
                this.eow = false;
            }
        }

        private TrieNode root = new TrieNode();

        public void addWord(String str) {
            TrieNode curr = root;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (curr.children[ch-'a'] == null) curr.children[ch-'a'] = new TrieNode();
                curr = curr.children[ch-'a'];
            }
            curr.eow = true;
        }

        public int search(String str, int left, int right) {
            TrieNode curr = root;
            for (int i = left; i <= right; i++) {
                char ch = str.charAt(i);
                if (curr.eow) return i-1;
                if (curr.children[ch - 'a'] == null) break;
                curr = curr.children[ch-'a'];
            }
            return left - 1;
        }
    }
}