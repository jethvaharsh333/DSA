package RECURSION_AND_BACKTRACKING.RECURSION.AAC_Power_Of_Four;

/**
 * Question link: https://leetcode.com/problems/power-of-four/description/
 * Date: 09-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    public boolean isPowerOfFour(int n) {
        if (n == 1)
            return true;

        if (n <= 0)
            return false;

        double logarithmBase4 = Math.log(n) / Math.log(4);

        return (logarithmBase4 == (int)logarithmBase4);
    }
}

/*

16/4 = 4/4 = 1
5/4 = 1

4^10 = 4^5 * fun(5)
4^15 = 4^7 * fun(7) * 4

n = 4^x
n = (2^2)^x = 2^(2x)
sqrt(n) = sqrt(2^(2x)) = 2^x
log₂(sqrt(n)) = log₂(2^x) = x

*/