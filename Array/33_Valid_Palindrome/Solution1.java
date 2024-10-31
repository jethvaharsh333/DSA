//O(n)
class Solution1 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        char[] ch = s.toCharArray();

        int fp = 0, lp = s.length()-1;

        while(fp<=lp){
            if(ch[fp++] != ch[lp--]) return false;
        }

        return true;
    }
}
