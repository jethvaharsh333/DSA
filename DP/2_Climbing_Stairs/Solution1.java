// Time complexity: O(2^n), Space complexity: O(n) [TLE]

class Solution1 {
    public int climbStairs(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;

        int left = climbStairs(n-1);
        int right = climbStairs(n-2);

        return left+right;
    }
}
