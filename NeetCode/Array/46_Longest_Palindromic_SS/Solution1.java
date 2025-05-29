// Time complexity: O(n^3); Space Complexity: O(1)
class Solution1 {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        String maxStr = s.substring(0, 1);

        for(int i=0 ; i<s.length() ; i++){
            for(int j=i+maxLen ; j<=s.length() ; j++){
                if (j-i>maxLen && isPalindrome(s.substring(i, j))) {
                    maxLen = j-i;
                    maxStr = s.substring(i, j);
                }
            }
        }

        return maxStr;
    }

    private boolean isPalindrome(String s){
        int left=0, right=s.length()-1;
        
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

/*
TEST CASES: 
"babad"
"cbbd"
"SDBABKYCKLOC"
"VBABWYBABAB"
*/
