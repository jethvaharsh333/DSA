package RECURSION_AND_BACKTRACKING.RECURSION.AAM_Tower_Of_Hanoi;

import java.util.*;

/**
 * Question link: https://www.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1
 * Date: 11-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    public int towerOfHanoi(int n, int from, int to, int aux) {
        if (n == 0) {
            return 0;
        }

        int moves1 = towerOfHanoi(n - 1, from, aux, to);
        int moves2 = 1;
        int moves3 = towerOfHanoi(n - 1, aux, to, from);

        return moves1 + moves2 + moves3;

    }
}
