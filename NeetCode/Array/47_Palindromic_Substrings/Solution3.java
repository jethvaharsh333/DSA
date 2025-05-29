// Time complexity: O(n^2); Space Complexity: O(1) , Beats: 100%, OPTIMAL SOLUTION
class Solution3 {
    private int ans = 0;
    
    public int countSubstrings(String s) {        
        for(int i=0; i<s.length() ; i++){
            i = countSubstringsUtil(s, i);
        }

        return ans;
    }

    private int countSubstringsUtil(String s, int i) {
        System.out.print(i+ ":: ");
        int l=i-1, r=i;

        // Checking for equality with next character
        while (i+1<s.length() && s.charAt(i)==s.charAt(i+1)) i++;
        System.out.print(i+ ":: ");
        
        // Calculating no. of same character
        int d = i-l;
        System.out.print(d+ ":: ");

        // Permutations of length of same character
        if(d >= 1){
            ans += ((d+1)*d)/2;
        }
        System.out.print(ans+ ":: ");
        
        // Expanding from center
        r = i+1;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            System.out.print("true:: ");
            l--;
            r++;
            ans++;
        }
        System.out.println(ans);
        
        return i;
    }
}
