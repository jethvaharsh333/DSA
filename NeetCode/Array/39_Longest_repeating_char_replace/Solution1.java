// Time complexity: O(n)
class Solution1 {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int maxLength = 0; // longest valid substring
        int maxCount = 0; // most freq character in window
        int l = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int r=0 ; r<len ; r++){
            char currCh = s.charAt(r);
            map.put(currCh, map.getOrDefault(currCh, 0)+1);
            maxCount = Math.max(maxCount, map.get(currCh));

            while(r-l+1-maxCount > k){
                char leftCh = s.charAt(l);
                map.put(leftCh, map.get(leftCh)-1);
                l++;
            }

            maxLength = Math.max(maxLength, r-l+1);
        }
        return maxLength;
    }
}
