package DP.One_Dimensional.AAH_983_Minimum_Cost_For_Tickets;

public class Tabulation {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[365+1];

        boolean[] needTravel = new boolean[366];
        for(int day: days) needTravel[day] = true;

        for(int i=1 ; i<=365 ; i++){
            if(!needTravel[i]){
                dp[i] = dp[i-1];
                continue;
            }

            int costOneDay = costs[0] + dp[i-1];
            int costSevenDays = costs[1] + dp[Math.max(0, i-7)];
            int costThirtyDays = costs[2] + dp[Math.max(0, i-30)];

            dp[i] = Math.min(costOneDay, Math.min(costSevenDays, costThirtyDays));
        }

        return dp[days[n-1]];
    }
}
