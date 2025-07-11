package RECURSION_AND_BACKTRACKING.RECURSION.AAN_Different_Ways_to_Add_Parentheses;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/different-ways-to-add-parentheses/description/
 * Date: 11-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return compute(expression);
    }

    private List<Integer> compute(String str){
        List<Integer> results = new ArrayList<>();

        if(isNumber(str)){
            results.add(Integer.parseInt(str));
            return results;
        }

        int len = str.length();
        for(int i=0 ; i<len ; i++){
            char curr = str.charAt(i);

            if(isOperator(curr)){
                List<Integer> left = compute(str.substring(0, i));
                List<Integer> right = compute(str.substring(i+1));

                for(int l: left){
                    for(int r: right){
                        results.add(operate(l, r, curr));
                    }
                }
            }
        }

        return results;
    }

    private boolean isNumber(String str){
        for(char ch: str.toCharArray()){
            if(!Character.isDigit(ch)) return false;
        }

        return true;
    }

    private boolean isOperator(char ch){
        return ch=='+' || ch=='-' || ch=='*';
    }

    private int operate(int a, int b, char ch){
        switch (ch) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            default: throw new IllegalArgumentException("Invalid operator: " + ch);
        }
    }
}