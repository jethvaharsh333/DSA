// O(n), 100% beats & OPTIMAL
class Solution2 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 1)
            return true;
        
        int start = 0, end = s.length() - 1;

        while (start < end) {
            char sCur = s.charAt(start);
            char eCur = s.charAt(end);
            
            // converting to lower case
            if (sCur >= 'A' && sCur <= 'Z')
                sCur = (char) (sCur + 32);
            if (eCur >= 'A' && eCur <= 'Z')
                eCur = (char) (eCur + 32);

            // validating for lower characters and numbers
            boolean sValid = (sCur >= 'a' && sCur <= 'z') || (sCur >= '0' && sCur <= '9');
            boolean eValid = (eCur >= 'a' && eCur <= 'z') || (eCur >= '0' && eCur <= '9');
            
            if (!sValid) {
                start++;
                continue;
            }
            if (!eValid) {
                end--;
                continue;
            }

            if (sValid && eValid) {
                if (sCur == eCur) {
                    start++;
                    end--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
