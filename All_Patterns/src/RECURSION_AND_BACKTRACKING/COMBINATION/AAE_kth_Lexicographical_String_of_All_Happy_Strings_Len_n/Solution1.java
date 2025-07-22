package RECURSION_AND_BACKTRACKING.COMBINATION.AAE_kth_Lexicographical_String_of_All_Happy_Strings_Len_n;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n
 * Date: 17-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public static final char[] alpha = {'a', 'b', 'c'};

    public String getHappyString(int n, int k) {
        List<String> result = new ArrayList<String>();
        backtrack(n, k, new StringBuilder(), result);
        return result.size() < k ? "" : result.get(k-1);
    }

    private boolean backtrack(int n, int k, StringBuilder sb, List<String> result){
        if(n == sb.length()){
            result.add(sb.toString());
            return result.size() == k;
        }

        for(char curr: alpha){
            if (sb.length()>0 && sb.charAt(sb.length()-1)==curr) continue;

            sb.append(curr);
            if(backtrack(n, k, sb, result)) return true;
            sb.deleteCharAt(sb.length()-1);
        }

        return false;
    }
}