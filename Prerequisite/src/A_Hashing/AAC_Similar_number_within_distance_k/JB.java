package A_Hashing.AAC_Similar_number_within_distance_k;

import java.util.Arrays;
import java.util.Scanner;

public class JB {
    public static void main(String[] args) {
        // IN
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        // Logic
        int maxElement = arr[0];
        for(int i=0 ; i<n ; i++){
            maxElement = Math.max(maxElement, arr[i]);
        }

        int[] hash = new int[maxElement+1];
        Arrays.fill(hash, -1);

        for(int i=0 ; i<n ; i++){
            int currElement = arr[i];

            if(hash[currElement]==-1){
                hash[currElement] = i;
            }
            else{
                int lastOccurredIndex = hash[currElement];
                if(i-lastOccurredIndex<=k){
                    System.out.println("TRUE");
                    return;
                }
            }
        }

        System.out.println("FALSE");
    }
}
