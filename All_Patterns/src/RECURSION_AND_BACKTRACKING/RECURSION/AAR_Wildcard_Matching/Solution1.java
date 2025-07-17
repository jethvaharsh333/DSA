package RECURSION_AND_BACKTRACKING.RECURSION.AAR_Wildcard_Matching;

import java.util.*;

/**
 * Question link:
 * Date: 17-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public boolean isMatch(String s, String p) {
        return match(0, 0, s, p);
    }

    private boolean match(int i, int j, String s, String p){
        if(j == p.length()){
            return i == s.length();
        }

        if(p.charAt(j) == '*'){
            return match(i, j+1, s, p) || (i<s.length() && match(i+1, j, s, p));
        }else if(i<s.length() && (p.charAt(j)=='?' || s.charAt(i) == p.charAt(j))){
            return match(i+1, j+1, s, p);
        }else{
            return false;
        }
    }
}

/*

Algo:
1]  if pattern is finished:
       return true if string is also finished, else false
2]  if p current char is * then
        a) match(i, j+1)                    // skip '*'
        b) i < s.length && match(i+1, j)    // use '*' on s[i]
    else if pattern[j] == '?' or s[i] == p[j]:
        → match(i+1, j+1)
    else return false

*/