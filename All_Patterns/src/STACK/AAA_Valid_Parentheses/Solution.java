package STACK.AAA_Valid_Parentheses;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/valid-parentheses
 * Date: 01-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int len = s.length();

        for(int i=0 ; i<len ; i++){
            char curr = s.charAt(i);

            if(curr == '(' || curr == '[' || curr == '{'){
                stack.push(curr);
            }else{
                if(stack.isEmpty()){
                    return false;
                }

                char peek = stack.peek();
                if(curr == ')' && peek == '('){
                    stack.pop();
                }else if(curr == ']' && peek == '['){
                    stack.pop();
                }else if(curr == '}' && peek == '{'){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }

        if(stack.isEmpty())
            return true;

        return false;
    }
}