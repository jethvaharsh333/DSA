// Time complexity: O(m+n), Space complexity: O(n), OPTIMAL SOLUTION
class Solution2 {
    public boolean backspaceCompare(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        int k = processString(sChars);
        int p = processString(tChars);

        if(k != p) return false;
        
        for(int i=0 ; i<k ; i++){
            if(sChars[i] != tChars[i]) return false;
        }

        return true;
    }

    private int processString(char[] chars){
        int i=0;
        
        for(char c : chars){
            if(c != '#'){
                chars[i++] = c;
            } 
            else if(i>0){
                i--;
            }
        }
        
        return i;
    }
}
