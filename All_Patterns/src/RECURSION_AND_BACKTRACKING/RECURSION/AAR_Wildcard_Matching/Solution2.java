package RECURSION_AND_BACKTRACKING.RECURSION.AAR_Wildcard_Matching;

import java.util.*;

/**
 * Question link:
 * Date: 17-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return match(0, 0, s, p);
    }

    private boolean match(int i, int j, String s, String p) {
        // If result already computed, return from memo
        if (memo[i][j] != null) return memo[i][j];

        // Base case: pattern finished
        if (j == p.length()) {
            return memo[i][j] = (i == s.length());
        }

        boolean result;

        if (p.charAt(j) == '*') {
            // '*' can either match zero characters (move pattern)
            // or match one character from string (if possible)
            boolean skip = match(i, j + 1, s, p);  // '*' matches nothing
            boolean use = (i < s.length()) && match(i + 1, j, s, p); // '*' matches s[i]
            result = skip || use;
        } else {
            // Match if current characters match or pattern has '?'
            boolean firstMatch = (i < s.length()) &&
                    (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?');
            result = firstMatch && match(i + 1, j + 1, s, p);
        }

        // Save and return
        return memo[i][j] = result;
    }
}