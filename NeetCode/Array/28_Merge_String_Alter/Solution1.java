// O(n), 7ms, 16.80 beats
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len = word1.length();
        String merged = "";

        int p=0, q=0;

        while(p < word1.length() && q < word2.length()){
            char m = word1.charAt(p++);
            merged += m;
            char n = word2.charAt(q++);
            merged += n;
        }

        while(p < word1.length()){
            char m = word1.charAt(p++);
            merged += m;
        }

        while(q < word2.length()){
            char m = word2.charAt(q++);
            merged += m;
        }

        return merged;
    }
}
