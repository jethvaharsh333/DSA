package STACK.A_REVISION.AAA_Longest_Valid_Parentheses;

import java.util.*;

/**
 * Question link:
 * Date: 01-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    public int longestValidParentheses(String s){
        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;
        int lastInvalid = -1;  // index of last unmatched ')'

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i); // store index of '('
            } else {
                if (!stack.isEmpty()) {
                    stack.pop(); // matched with a '('
                    if (!stack.isEmpty()) {
                        maxLen = Math.max(maxLen, i - stack.peek());
                    } else {
                        maxLen = Math.max(maxLen, i - lastInvalid);
                    }
                } else {
                    lastInvalid = i; // update last invalid ')'
                }
            }
        }

        return maxLen;

    }
}