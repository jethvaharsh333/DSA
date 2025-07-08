package STACK.A_REVISION.AAA_Longest_Valid_Parentheses;

import java.util.*;

/**
 * Question link:
 * Date: 01-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public int longestValidParentheses(String s){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max_len = 0;

        for(int i=0 ; i<s.length() ; i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();

                if(stack.isEmpty()){
                    stack.push(i);
                } else {
                    max_len = Math.max(max_len, i - stack.peek());
                }
            }
        }

        return max_len;
    }
}