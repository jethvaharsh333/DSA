package STACK.AAC_Minimum_Remove_to_Make_Valid_Parentheses;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses
 * Date: 01-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0 ; i<len ; i++){
            char curr = s.charAt(i);

            if(curr == '('){
                stack.push(i);
            }else if(curr == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    sb.setCharAt(i, '*');
                }
            }
        }

        while(!stack.isEmpty()){
            int index = stack.pop();
            sb.setCharAt(index, '*');
        }

        String result = "";
        for (int i=0 ; i<sb.length() ; i++){
            if(sb.charAt(i) != '*'){
                result += sb.charAt(i);
            }
        }

        return result;
    }
}

/**

 // ✅ 1. Empty input
 Input:     ""
 Expected:  true

 // ✅ 2. One pair
 Input:     "()"
 Expected:  true

 // ✅ 3. Only open
 Input:     "("
 Expected:  false

 // ✅ 4. Only close
 Input:     ")"
 Expected:  false

 // ✅ 5. Nested
 Input:     "((()))"
 Expected:  true

 // ✅ 6. Mixed flat + nested
 Input:     "()(()())"
 Expected:  true

 // ✅ 7. Multiple flat
 Input:     "()()()()"
 Expected:  true

 // ❌ 8. Unbalanced
 Input:     "(()"
 Expected:  false

 // ❌ 9. Wrong order
 Input:     "())("
 Expected:  false

 // ❌ 10. Excess closing
 Input:     "())"
 Expected:  false

 */