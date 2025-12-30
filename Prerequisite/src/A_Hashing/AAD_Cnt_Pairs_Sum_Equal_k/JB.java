package A_Hashing.AAD_Cnt_Pairs_Sum_Equal_k;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
        Set<Integer> set = new HashSet<>();
        int count = 0;

        //O(N)
        for(int i=0 ; i<n ; i++){
            int currElement = arr[i];

            //O(1)
            if(set.contains(k-currElement)){
                count++;
            }

            set.add(currElement);
        }

        // TC:O(N), SC:O(N)
    }
}
