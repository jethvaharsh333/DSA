// Time complexity: O(n); Space Complexity: O(1)
class Solution2 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] co1 = new int[26];
        int[] co2 = new int[26];

        for(int i=0 ; i<s1.length() ; i++){
            co1[s1.charAt(i) - 'a']++;
            co2[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(co1,co2)) return true;

        for(int i=s1.length() ; i<s2.length() ; i++){
            co2[s2.charAt(i) - 'a']++;
            co2[s2.charAt(i - s1.length()) - 'a']--;
            
            if(Arrays.equals(co1,co2)) return true;
        }

        return false;
    }
}
