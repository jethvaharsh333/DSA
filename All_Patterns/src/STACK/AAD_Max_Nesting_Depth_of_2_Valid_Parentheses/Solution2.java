package STACK.AAD_Max_Nesting_Depth_of_2_Valid_Parentheses;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings
 * Date: 01-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    public int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
        int depth=0, maxDepth=0;

        int[] ans = new int[len];

        for(int i=0 ; i<len ; i++){
            if(seq.charAt(i) == '('){
                depth++;
            }else{
                if(i>0 && seq.charAt(i-1)!='('){
                    maxDepth -= 1;
                }
                depth--;
            }

            maxDepth = Math.max(maxDepth, depth);

            ans[i] = maxDepth%2 == 0 ? 1 : 0;
        }

        return ans;
    }
}