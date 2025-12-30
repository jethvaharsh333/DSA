package A_Hashing.AAE_Cnt_Pairs_Difference_Equals_k;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JB {
    public static void main(String[] args) {
        // INPUT
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        // LOGIC
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        // O(N)
        for(int i=0 ; i<n ; i++){
            int currElement = arr[i];

            // O(1)
            if(map.containsKey(k+currElement)){
                count += map.get(k+currElement);
            }

            // O(1)
            map.put(currElement, map.getOrDefault(currElement, 0)+1);
        }

        System.out.println(count);

        // TC: O(N), SC: O(N)
    }
}
