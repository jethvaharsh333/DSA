// Time complexity: O(n); Space Complexity: O(n)
class Solution2 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        HashMap<Character, Integer> map1 = new HashMap<>(); // character with count
        for(int i=0 ; i<t.length() ; i++){
            map1.put(t.charAt(i), map1.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int minLeft=0, minRight=s.length();
        int count = 0; 
        int minLength = Integer.MAX_VALUE;
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(int right=0 ; right<s.length() ; right++){
            char ch = s.charAt(right);
            if(map1.containsKey(ch)){
                map2.put(ch, map2.getOrDefault(s.charAt(right), 0) + 1);
                if(map2.get(ch) <= map1.get(ch)){
                    count++;
                }

                // This loop runs only when the current window has all the characters from t with the required frequencies.
                while (count == t.length()){
                    // Updating window
                    if (right-left+1 < minLength){
                        minLength = right-left+1;
                        minLeft = left;
                        minRight = right;
                    }

                    // Try to shrink the window from the left
                    char leftChar = s.charAt(left);
                    if (map1.containsKey(leftChar)) {
                        map2.put(leftChar, map2.get(leftChar) - 1);
                        if (map2.get(leftChar) < map1.get(leftChar)) {
                            count--;
                        }
                    }

                    left++;
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight + 1);
    }
}
