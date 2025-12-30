package A_Hashing.AAF_Cnt_Pairs_Abs_Diff_Equals_k;

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
            /*
                |a-b|=k
                a-b=k || b-a=k
                b=a-k || b=a+k

                |a-b|=0 ⇒ a==b
            */
            if (k == 0) {
                if(map.containsKey(currElement)){
                    count += map.get(currElement);
                }
            }
            else{
                if(map.containsKey(currElement + k)){
                    count += map.get(currElement + k);
                }
                if(map.containsKey(currElement - k)){
                    count += map.get(currElement - k);
                }
            }

            // O(1)
            map.put(currElement, map.getOrDefault(currElement, 0)+1);
        }

        System.out.println(count);

        // TC: O(N), SC: O(N)
    }
}
