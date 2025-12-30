package A_Hashing.AAC_Similar_number_within_distance_k;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JC {
    public static void main(String[] args) {
        // IN
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        // LOGIC
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<n ; i++){
            int currElement = arr[i];

            if (map.containsKey(currElement)) {
                int lastIndex = map.get(currElement);
                if (i - lastIndex <= k) {
                    System.out.println("TRUE");
                    return;
                }
            }

            // IMPORTANT: always update to latest index
            map.put(currElement, i);
        }

        System.out.println("FALSE");
    }
}
