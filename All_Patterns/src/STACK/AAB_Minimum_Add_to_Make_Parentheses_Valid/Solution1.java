package STACK.AAB_Minimum_Add_to_Make_Parentheses_Valid;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid
 * Date: 01-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        int ct=0;

        for(int i=0 ; i<n ; i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }else{
                if(st.isEmpty()) ct++;
                else st.pop();
            }
        }

        return st.size() + ct;
    }
}