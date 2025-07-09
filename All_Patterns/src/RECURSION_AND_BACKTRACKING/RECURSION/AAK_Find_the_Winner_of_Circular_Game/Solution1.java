package RECURSION_AND_BACKTRACKING.RECURSION.AAK_Find_the_Winner_of_Circular_Game;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/find-the-winner-of-the-circular-game
 * Date: 02-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public int findTheWinner(int n, int k) {
        List<Integer> li = new ArrayList<Integer>();

        for(int i=1 ; i<=n ; i++){
            li.add(i);
        }

        int jump = 0;

        while(li.size() > 1){
            jump = (jump + k - 1) % li.size();
            li.remove(jump);
        }

        return li.get(0);
    }
}