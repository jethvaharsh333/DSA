// Time complexity: O(2^min(m,n)), Space complexity: O(m+n) [Time limit exceeded]

class Solution1 {
    public int longestCommonSubsequence(String text1, String text2) {
        return recurse(text1.length()-1, text2.length()-1, text1, text2);
    }

    private int recurse(int i, int j, String text1, String text2){
        if(i<0 || j<0){
            return 0;
        }

        if(text1.charAt(i) == text2.charAt(j)){
            return 1 + recurse(i-1, j-1, text1, text2);
        }else{
            int left = recurse(i-1, j, text1, text2);
            int right = recurse(i, j-1, text1, text2);
            return Math.max(left, right);
        }
    }
}
