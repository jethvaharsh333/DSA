package RECURSION_AND_BACKTRACKING.RECURSION.AAQ_Regular_Expression_Matching;

/**
 * Question link: https://leetcode.com/problems/regular-expression-matching/
 * Date: 12-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public boolean isMatch(String s, String p) {
        return match(0, s, 0, p);
    }

    private boolean match(int idS, String s, int idP, String p){
        if(idP == p.length()){
            return idS == s.length();
        }

        boolean firstMatch = (idS<s.length()) && (s.charAt(idS) == p.charAt(idP) || p.charAt(idP) == '.');

        if(idP+1<p.length() && p.charAt(idP+1)=='*'){
            return match(idS, s, idP+2, p) || (firstMatch && match(idS+1, s, idP, p));
        }else{
            return firstMatch && match(idS+1, s, idP+1, p);
        }
    }
}

/*

This is not a simple string-checking algo where loops will be handy. Because of the "*" wildcard which
introduces non-determinism. At any point, I can either use the * or skip it. This creates branching decisions.
Should I use * to match this character or skip it and try a different path?

So introducing different paths means recursion will be part of solution.

MORE TEST CASES:-

| `s`             | `p`             | Expected | Explanation
| --------------- | --------------- | -------- | -----------------------------------
| `"ab"`          | `".*"`          | `true`   | `.*` matches any
| `"aab"`         | `"c*a*b"`       | `true`   | `'c*' → "", 'a*' → "aa", 'b' → "b"`
| `"mississippi"` | `"mis*is*p*."`  | `false`  | Doesn’t match at end
| `"mississippi"` | `"mis*is*ip*."` | `true`   | `.*` trick expanded
| `"abc"`         | `"a.*c"`        | `true`   | middle can be anything
| `"abbbbc"`      | `"ab*c"`        | `true`   | `b*` → multiple b
| `"abcbcd"`      | `"a.*c.*d"`     | `true`   | multiple wildcards
| `"abcd"`        | `"d*"`          | `false`  | d\* allows multiple `d` but no `a` at start
| `"abcd"`        | `".*d"`         | `true`   | full match to `abcd` ending in `d`

Algo:
1] Base case: if pattern is empty, check if string is also empty
2] Check if first character of string and pattern match (or pattern has '.')
3] If next char in pattern is '*':
    Option 1: Skip "x*" pattern
    Option 2: Use "*" if first character matches
4] If no '*', move both pointers if current chars match
5] Return true if any valid path leads to end of both s and p

*/