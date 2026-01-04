package A_Hashing.AAO_Min_Steps_to_All_Elements_Equal;

import java.util.*;

public class JD {
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
        // Step 1: Frequency map with ordering
        TreeMap<Integer, Integer> freq = new TreeMap<>(Collections.reverseOrder());

        for (int h : boxesInPiles) {
            freq.put(h, freq.getOrDefault(h, 0) + 1);
        }

        long steps = 0;
        long activePiles = 0;

        // Step 2: Traverse from tallest to shortest
        for (int count : freq.values()) {
            steps += activePiles;
            activePiles += count;
        }

        return steps;
    }

}
