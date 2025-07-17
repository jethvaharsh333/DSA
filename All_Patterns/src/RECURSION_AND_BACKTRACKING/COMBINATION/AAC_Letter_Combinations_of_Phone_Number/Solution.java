package RECURSION_AND_BACKTRACKING.COMBINATION.AAC_Letter_Combinations_of_Phone_Number;

import java.util.*;

/**
 * Question link:
 * Date: 17-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    private static String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        StringBuilder str = new StringBuilder();
        genCombination(digits, str, result);

        return result;
    }

    private void genCombination(String digits, StringBuilder str, List<String> result){
        if(digits.length() == 0){
            result.add(str.toString());
            return;
        }

        for(char ch: dict[digits.charAt(0) - '0'].toCharArray()){
            str.append(ch);
            genCombination(digits.substring(1), str, result);
            str.deleteCharAt(str.length()-1);
        }
    }
}