// O(n), 0ms, 100% beats
class Solution3 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int minLength = Math.min(word1.length(), word2.length());

        for (int i = 0; i < minLength; i++) {
            merged.append(word1.charAt(i)).append(word2.charAt(i));
        }

        merged.append(word1.substring(minLength)).append(word2.substring(minLength));

        return merged.toString();
    }
}
