package A_Hashing.AAJ_Longest_SubArray_Sum_Equals_k;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JB_2 {
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
        Map<Integer, Integer> map = new HashMap<>(); // PREFIX_SUM (1st occurrence) -> INDEX
        map.put(0, -1);

        int prefixSum = 0;
        int maxLength = 0;

        for(int j=0 ; j<n ; j++){
            prefixSum += arr[j];

            if(map.containsKey(prefixSum-k)){
                int i = map.get(prefixSum-k);
                int currentLength = j-i;

                maxLength = Math.max(maxLength, currentLength);
            }

            // Store first occurrence only
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum, j);
            }
        }

        System.out.println(maxLength);
    }
}
