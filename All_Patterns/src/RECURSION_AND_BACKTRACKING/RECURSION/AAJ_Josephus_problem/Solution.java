package RECURSION_AND_BACKTRACKING.RECURSION.AAJ_Josephus_problem;

/**
 * Question link: https://www.geeksforgeeks.org/problems/josephus-problem/1
 * Date: 09-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    public int josephus(int n, int k) {
        if(n == 1){
            return 1;
        }else{
            return (josephus(n-1, k) + k - 1)%n +1;
        }
    }
}