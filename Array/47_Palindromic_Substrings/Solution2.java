// Time complexity: O(n^2); Space Complexity: O(1)
class Solution2 {
    private int palindromeCount(String s, int left, int right){
        int ans = 0;

        while(left>=0 && right<s.length() && s.charAt(left--)==s.charAt(right++)){
            ans++;
        }

        return ans;
    }

    public int countSubstrings(String s) {
        int count = 0;

        for(int i=0 ; i<s.length() ; i++){
            int even = palindromeCount(s, i, i+1);
            int odd = palindromeCount(s, i-1, i+1);
            count += even + odd + 1;
        }

        return count;
    }
}
