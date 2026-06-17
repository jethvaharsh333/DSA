package DP.One_Dimensional.AAH_983_Minimum_Cost_For_Tickets;

import java.util.Arrays;

public class Memoization {
    public int mincostTickets(int[] days, int[] costs) {
        int[] memo = new int[days.length];
        Arrays.fill(memo, -1);

        return recurse(days.length-1, 366, days, costs, memo);
    }

    public int recurse(int index, int expiryDay, int[] days, int[] costs, int[] memo){
        if(index < 0) return 0;

        // if(index == 0) return costs[0]; WRONG:
        // doesn't handle the case where the first day might be covered by a previous pass

        // Not to purchase pass
        if(expiryDay <= days[index]) return recurse(index-1, expiryDay, days, costs, memo);

        if(memo[index] != -1) return memo[index];

        int costOneDay = costs[0] + recurse(index-1, days[index], days, costs, memo);
        int costSevenDays = costs[1] + recurse(index-1, days[index]-6, days, costs, memo);
        int costThirtyDays = costs[2] + recurse(index-1, days[index]-29, days, costs, memo);

        return memo[index] = Math.min(costOneDay, Math.min(costSevenDays, costThirtyDays));
    }
}
