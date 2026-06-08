package C_Binary_Search.AAG_Find_Max_Unit;

import java.util.List;

public class JB {
    private int findMaximumAlloyUnits(List<Integer> composition, List<Integer> stock, List<Integer> cost, int budget){
        int n = composition.size();

        long low = 0;
        long high = (long) 1e18;   // upper bound
        long ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            long sum = 0;

            for (int i = 0; i < n; i++) {
                long required = (long) composition.get(i) * mid;
                long need = required - stock.get(i);

                if (need < 0) need = 0;

                sum += need * cost.get(i);

                // early break to avoid overflow & useless work
                if (sum > budget) break;
            }

            if (sum <= budget) {
                ans = mid;          // mid is feasible
                low = mid + 1;      // try bigger
            } else {
                high = mid - 1;     // reduce units
            }
        }

        return (int) ans;
    }
}
