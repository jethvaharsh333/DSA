// Time complexity: O(n), Space Complexity: O(1), Optimal Solution
class Solution2 {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int maxLength = 0; // longest valid substring
        int maxCount = 0; // most freq character in window
        int l = 0;
        int[] count = new int[26];

        for(int r=0 ; r<len ; r++){
            char currCh = s.charAt(r);
            count[currCh-'A']++;
            maxCount = Math.max(maxCount, count[currCh-'A']);

            while(r-l+1-maxCount > k){
                char leftCh = s.charAt(l);
                count[leftCh-'A']--;
                l++;
            }

            maxLength = Math.max(maxLength, r-l+1);
        }
        
        return maxLength;
    }
}
