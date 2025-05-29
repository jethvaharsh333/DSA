// Time Complexity: O(n* 2^n); Space Complexity: O(n)
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        genPalindrome(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void genPalindrome(String s, int start, List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=start ; i<s.length() ; i++){
            if(isPalindrome(s, start, i)){
                current.add(s.substring(start, i+1));
                genPalindrome(s, i+1, current, result);
                current.remove(current.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}
