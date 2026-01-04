package A_Hashing.ZZZ_Me.AAA_2_Disjoint_Subarray_same_Max_Sum;
import java.util.*;

public class JA {
    public static void main(String[] args) {
        int[] arr = {1, 2, -1, 2, 1, -1, 2};
        System.out.println(maxEqualDisjointSubarraySum(arr));
    }

    static class Interval {
        int start, end;

        public Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static int maxEqualDisjointSubarraySum(int[] arr) {
        int n = arr.length;

        // Prefix sum
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        // Map: sum -> list of subarray intervals
        Map<Integer, List<Interval>> map = new HashMap<>();

        // Generate all subarrays
        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {
                int sum = prefix[r + 1] - prefix[l];
                map.computeIfAbsent(sum, k -> new ArrayList<>())
                        .add(new Interval(l, r));
            }
        }

        // Sort sums in descending order
        List<Integer> sums = new ArrayList<>(map.keySet());
        sums.sort(Collections.reverseOrder());

        // Check each sum
        for (int sum : sums) {
            List<Interval> intervals = map.get(sum);

            // Sort intervals by start index
            intervals.sort(Comparator.comparingInt(a -> a.start));

            Interval prev = intervals.get(0);
            for (int i = 1; i < intervals.size(); i++) {
                Interval curr = intervals.get(i);

                // Disjoint check
                if (prev.end < curr.start) {
                    return sum;
                }

                // Keep the interval with smaller end
                if (curr.end < prev.end) {
                    prev = curr;
                }
            }
        }

        return 0; // No valid pair
    }
}
