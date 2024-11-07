// Time complexity: O(n^2); Space Complexity: O(1)

class Solution3 {
    private int l = 0;
    private int r = 0;

    public void func(char[] ch, int i) {
        if (i >= ch.length) return;

        int s=i, e=i;
        while(e<ch.length-1 && ch[e]==ch[e + 1]) e++;

        i=e;
        while(s>=0 && e<ch.length && ch[s]==ch[e]){
            s--;
            e++;
        }

        s++;
        e--;
        
        if(e-s > r-l){
            r = e;
            l = s;
        }

        func(ch, i+1);
    }

    public String longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        func(ch, 0);
        return s.substring(l, r+1);
    }
}
