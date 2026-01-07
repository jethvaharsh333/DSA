package B_Two_Pointers.AAG_Longest_Substring_CharPairs_Diff_LessEqual_k;
import java.util.*;

public class JB {
    public int longestSubstring(String s, int k) {
        int[] freq = new int[128];   // ASCII
        TreeSet<Integer> set = new TreeSet<>();

        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            int c = s.charAt(right);

            freq[c]++;
            set.add(c);

            while (set.last() - set.first() > k) {
                int lc = s.charAt(left);
                freq[lc]--;
                if (freq[lc] == 0) set.remove(lc);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

}
