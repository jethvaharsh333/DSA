package DP.One_Dimensional.AAB_Climbing_Stairs;

public class Recursive {
    public int climbStairs(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;

        return climbStairs(n-1) + climbStairs(n-2);
    }
}
