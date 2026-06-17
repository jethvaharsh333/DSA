package DP.One_Dimensional.AAH_983_Minimum_Cost_For_Tickets;

public class Recursive {
    public int mincostTickets(int[] days, int[] costs) {
        return recurse(days.length-1, 366, days, costs);
    }

    public int recurse(int index, int expiryDay, int[] days, int[] costs){
        if(index < 0) return 0;

        // if(index == 0) return costs[0];
        // WRONG: doesn't handle the case where the first day might be covered by a previous pass

        // Not to purchase pass
        if(expiryDay <= days[index]) return recurse(index-1, expiryDay, days, costs);

        int costOneDay = costs[0] + recurse(index-1, days[index], days, costs);
        int costSevenDays = costs[1] + recurse(index-1, days[index]-6, days, costs);
        int costThirtyDays = costs[2] + recurse(index-1, days[index]-29, days, costs);

        return Math.min(costOneDay, Math.min(costSevenDays, costThirtyDays));
    }
}
