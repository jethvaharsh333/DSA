package RECURSION_AND_BACKTRACKING.RECURSION.AAK_Find_the_Winner_of_Circular_Game;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/find-the-winner-of-the-circular-game/
 * Date: 02-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution2 {
    public int findTheWinner(int n, int k) {
        if(n == 1){
            return 1;
        }else{
            return (findTheWinner(n-1,k) + k-1)%n + 1;
        }
    }
}

// f(n) = (f(n-1) + k − 1)%n + 1

/**

 f(n-1) => return winner’s position in a circle of size n-1, after one person has already been eliminated
 But now, the winner's position needs to be adjusted to the new circle ehich is done by k-1

 for e.g. => n=5, k=2 =>
 People are: [1, 2, 3, 4, 5]
 Every 2nd person is removed.

 Round 1:
 Start at 1, count 2 → eliminate 2
 New circle: [1, 3, 4, 5]
 Next round starts from 3 (right after the removed person)
 Now to map this winner's position back to the original circle, we need to offset their index by k steps (but one step already removed the person, so we offset by k - 1).

 k-1 => shifting the winner of the smaller problem f(n - 1) by k steps. But 1 step has already been consumed. So net = k-1

 % n => wrap around the circle

 +1: because positions are 1-based

 */