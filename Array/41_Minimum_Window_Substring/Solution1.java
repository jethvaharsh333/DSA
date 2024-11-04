// Time complexity: O(n); Space Complexity: O(n)
class Solution1 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        // Count characters in t
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map1.put(t.charAt(i), map1.getOrDefault(t.charAt(i), 0) + 1);
        }

        // Sliding window variables
        int left = 0;
        int minLeft = 0, minRight = s.length();
        int count = 0; // Number of characters matched
        HashMap<Character, Integer> map2 = new HashMap<>();
        int minLength = Integer.MAX_VALUE;

        // Expand the window with the right pointer
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // Add character to map2 if it is in t
            if (map1.containsKey(ch)) {
                map2.put(ch, map2.getOrDefault(ch, 0) + 1);

                // Increase count if character's frequency matches in both maps
                if (map2.get(ch) <= map1.get(ch)) {
                    count++;
                }

                // When all characters are matched, move left to minimize the window
                while (count == t.length()) {
                    // Update minimum window
                    if (right-left+1 < minLength) {
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
