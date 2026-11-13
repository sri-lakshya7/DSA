class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>(dictionary);
        StringBuilder sb = new StringBuilder();
        StringBuilder newSB = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) != ' ') {
                sb.append(sentence.charAt(i));
                if (set.contains(sb.toString())) {
                    newSB.append(sentence.charAt(i));
                    for (; i < sentence.length() && sentence.charAt(i) != ' '; i++);
                    sb.setLength(0);
                }
            } else sb.setLength(0);

            if (i < sentence.length()) newSB.append(sentence.charAt(i));
        }

        return newSB.toString();
    }
}