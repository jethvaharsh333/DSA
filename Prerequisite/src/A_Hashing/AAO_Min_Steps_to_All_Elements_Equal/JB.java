package A_Hashing.AAO_Min_Steps_to_All_Elements_Equal;

import java.util.*;

public class JB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] boxInPiles = new int[n];
        for(int i=0 ; i<n ; i++){
            boxInPiles[i] = sc.nextInt();
        }

        int steps = stepsToRemovePiles(boxInPiles);
        System.out.println(steps);
    }

    private static int stepsToRemovePiles(int[] boxInPiles){
        int steps = 0;

        // frequency map
        Map<Integer, Integer> map = new HashMap<>();
        for (int h : boxInPiles) {
            map.put(h, map.getOrDefault(h, 0) + 1);
        }

        while (map.size() > 1) {
            // find current max and next max
            int max = Integer.MIN_VALUE;
            int nextMax = Integer.MIN_VALUE;
            for (int h : map.keySet()) {
                if (h > max) {
                    nextMax = max;
                    max = h;
                } else if (h > nextMax) {
                    nextMax = h;
                }
            }

            int countAtMax = map.get(max);
            map.remove(max);

            // each pile at max needs ONE step
            steps += countAtMax;
            // move those piles down to nextMax
            map.put(nextMax, map.get(nextMax) + countAtMax);
        }

        return steps;

    }
}
