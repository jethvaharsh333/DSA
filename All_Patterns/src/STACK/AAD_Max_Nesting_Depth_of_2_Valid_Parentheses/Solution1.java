package STACK.AAD_Max_Nesting_Depth_of_2_Valid_Parentheses;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 * Date: 01-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] result = new int[n];
        int depth = 0;

        for(int i=0 ; i<n ; i++){
            if(seq.charAt(i) == '('){
                depth++;
                result[i] = depth % 2;
            }else{
                result[i] = depth % 2;
                depth--;
            }
        }

        return result;
    }
}