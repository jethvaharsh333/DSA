package DP.One_Dimensional.AAD_746_Min_Cost_Climbing_Stairs;

public class Recursive {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(recurse(cost.length-1, cost), recurse(cost.length-2, cost));
    }

    public int recurse(int index, int[] cost){
        if(index <= 1) return cost[index];
        return Math.min(recurse(index-1, cost), recurse(index-2, cost)) + cost[index];
    }
}
