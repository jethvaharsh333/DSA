// Time Complexity: O(n), Space Complexity: O(n)
class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len == 0) return 0;

        int maxSS = 0;
        int left=0, right=0;
        HashMap<Character, Integer> map = new HashMap<>();

        while(right<len){
            char ele = s.charAt(right);
            if (map.containsKey(ele) && map.get(ele) >= left) {
                left = map.get(ele) + 1;
            }
            map.put(ele, right);
            maxSS = Math.max(maxSS, right - left + 1);
            ++right;
        }

        return maxSS;
    }
}
