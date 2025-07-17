package RECURSION_AND_BACKTRACKING.RECURSION.AAR_Wildcard_Matching;

import java.util.*;

/**
 * Question link:
 * Date: 17-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution3 {
    public boolean isMatch(String s, String p) {
        int i=0, j=0, star=-1, match=0;

        while(i < s.length()){
            if(j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))){
                i++; j++;
            }else if(j < p.length() && p.charAt(j) == '*'){
                star = j++;
                match = i;
            }else if(star != -1){
                j = star + 1;
                i = ++match;
            }else{
                return false;
            }

        }

        while (j < p.length() && p.charAt(j) == '*'){
            j++;
        }

        return j == p.length();
    }
}