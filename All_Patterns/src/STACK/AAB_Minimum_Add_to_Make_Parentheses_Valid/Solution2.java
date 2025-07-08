package STACK.AAB_Minimum_Add_to_Make_Parentheses_Valid;

import java.util.*;

/**
 * Question link:
 * Date: 01-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;

        for(int i=0 ; i<s.length() ; i++){
            char c = s.charAt(i);
            if(c == '('){
                open++;
            }else{
                if(open <= 0){
                    close++;
                }else{
                    open--;
                }
            }
        }
        return open + close;
    }
}