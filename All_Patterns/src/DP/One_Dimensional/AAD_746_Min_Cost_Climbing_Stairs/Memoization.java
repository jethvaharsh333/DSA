package DP.One_Dimensional.AAD_746_Min_Cost_Climbing_Stairs;

import java.util.Arrays;

public class Memoization {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length+1];
        Arrays.fill(memo, -1);

        return Math.min(recurse(cost.length-1, cost, memo), recurse(cost.length-2, cost, memo));
    }

    public int recurse(int index, int[] cost, int[] memo){
        if(index <= 1) return cost[index];
        if(memo[index] != -1) return memo[index];

        return cost[index] + Math.min(recurse(index-1, cost, memo), recurse(index-2, cost, memo));
    }
}
