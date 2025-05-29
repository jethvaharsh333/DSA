// O(n), 1ms, 84.38 beats
class Solution2 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int p=0, q=0;

        while (p < word1.length() || q < word2.length()) {
            if (p < word1.length()) {
                merged.append(word1.charAt(p++));
            }
            if (q < word2.length()) {
                merged.append(word2.charAt(q++));
            }
        }

        return merged.toString();
    }
}
