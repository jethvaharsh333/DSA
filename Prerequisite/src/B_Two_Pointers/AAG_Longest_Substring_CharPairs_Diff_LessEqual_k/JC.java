package B_Two_Pointers.AAG_Longest_Substring_CharPairs_Diff_LessEqual_k;
import java.util.*;

public class JC {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        int left = 0, maxLen = 0;

        TreeMap<Character, Integer> map = new TreeMap<>();

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // Shrink window until valid
            while (map.lastKey() - map.firstKey() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

}
