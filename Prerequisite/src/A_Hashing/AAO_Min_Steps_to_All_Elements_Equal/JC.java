package A_Hashing.AAO_Min_Steps_to_All_Elements_Equal;

import java.util.*;

public class JC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] boxInPiles = new int[n];
        for(int i=0 ; i<n ; i++){
            boxInPiles[i] = sc.nextInt();
        }

        long steps = stepsToRemovePiles(boxInPiles);
        System.out.println(steps);
    }

    private static long stepsToRemovePiles(int[] boxesInPiles) {
        // Step 1: Frequency map
        Map<Integer, Integer> freq = new HashMap<>();
        for (int h : boxesInPiles) {
            freq.put(h, freq.getOrDefault(h, 0) + 1);
        }

        // Step 2: Sort unique heights in descending order
        List<Integer> heights = new ArrayList<>(freq.keySet());
        heights.sort(Collections.reverseOrder());

        long steps = 0;
        long activePiles = 0;

        // Step 3: Traverse heights
        for (int i = 0; i < heights.size() - 1; i++) {
            activePiles += freq.get(heights.get(i));
            steps += activePiles;
        }

        return steps;
    }

}
