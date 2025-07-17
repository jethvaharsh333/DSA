package RECURSION_AND_BACKTRACKING.RECURSION.AAQ_Regular_Expression_Matching;

import java.util.*;

/**
 * Question link:
 * Date: 12-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return match(0, s, 0, p);
    }

    private boolean match(int idS, String s, int idP, String p) {
        // Memoization check
        if (memo[idS][idP] != null) {
            return memo[idS][idP];
        }

        // Base case: if pattern is consumed
        if (idP == p.length()) {
            return memo[idS][idP] = (idS == s.length());
        }

        // Check current char match
        boolean firstMatch = (idS < s.length()) &&
                (s.charAt(idS) == p.charAt(idP) || p.charAt(idP) == '.');

        boolean result;

        // If next character is '*'
        if (idP + 1 < p.length() && p.charAt(idP + 1) == '*') {
            result = match(idS, s, idP + 2, p) || (firstMatch && match(idS + 1, s, idP, p));
        } else {
            result = firstMatch && match(idS + 1, s, idP + 1, p);
        }

        // Store and return result
        memo[idS][idP] = result;
        return result;
    }
}
