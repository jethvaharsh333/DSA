package RECURSION_AND_BACKTRACKING.COMBINATION.AAD_Letter_Case_Permutation;

import java.util.*;

/**
 * Question link:
 * Date: 17-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(0, new StringBuilder(s), result);
        return result;
    }

    private void backtrack(int start, StringBuilder sb, List<String> result){
        int len = sb.length();

        if(start == len){
            result.add(sb.toString());
            return;
        }

        char ch = sb.charAt(start);

        if(Character.isLetter(ch)){
            backtrack(start+1, sb, result);
            sb.setCharAt(start, flipCase(ch));
            backtrack(start+1, sb, result);
            sb.setCharAt(start, ch);
        }else{
            backtrack(start+1, sb, result);
        }
    }

    private char flipCase(char ch){
        return Character.isLowerCase(ch) ? Character.toUpperCase(ch) : Character.toLowerCase(ch);
    }
}