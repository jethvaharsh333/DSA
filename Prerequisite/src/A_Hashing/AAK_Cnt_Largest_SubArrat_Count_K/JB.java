package A_Hashing.AAK_Cnt_Largest_SubArrat_Count_K;

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
         map.put(0, -1);
        int prefixSum = 0;
        int maximumLength=0, countMaximum=0;
        for(int j=0 ; j<n ; j++){
            prefixSum += arr[j];

            if(map.containsKey(prefixSum-k)){
                int i = map.get(prefixSum-k);
                int currentLength = j-i;

                if(maximumLength < currentLength){
                    maximumLength = currentLength;
                    countMaximum = 1;
                }else if(maximumLength == currentLength){
                    countMaximum++;
                }
            }

            if(!map.containsKey(prefixSum)){
                map.put(prefixSum, j);
            }
        }

        System.out.println(maximumLength+", "+countMaximum);
    }
}
