package RECURSION_AND_BACKTRACKING.RECURSION.AAH_Delete_Middle_Element_of_Stack;

import java.util.*;

/**
 * Question link: https://www.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1
 * Date: 02-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    public void deleteMidHelper(Stack<Integer> s, int size, int current)
    {
        if(current == size/2){
            s.pop();
            return;
        }

        int temp = s.pop();
        current += 1;
        deleteMidHelper(s, size, current);

        s.push(temp);
    }

    public void deleteMid(Stack<Integer> s) {
        int sz = s.size();
        deleteMidHelper(s, sz, 0);
    }
}