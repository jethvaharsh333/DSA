package A_Hashing.AAI_Cnt_SubArrays_Sum_Equals_k;

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
        Map<Integer, Integer> map = new HashMap<>(); // sum -> freq
        map.put(0, 1);

        int sum=0, count=0;

        // O(N)
        for(int i=0 ; i<n ; i++){
            sum += arr[i];

            // O(1)
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        System.out.println(count);

        // TC:O(N), SC: O(N)
    }
}
