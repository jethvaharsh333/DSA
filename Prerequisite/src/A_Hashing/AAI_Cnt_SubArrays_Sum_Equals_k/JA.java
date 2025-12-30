package A_Hashing.AAI_Cnt_SubArrays_Sum_Equals_k;

import java.util.Scanner;

public class JA {
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
        int count = 0;
        // O(N)
        for(int i=0 ; i<n ; i++){
            int sum = 0;
            //O(N)
            for(int j=i ; j<n ; j++){
                sum += arr[j];

                if(sum == k) count++;
            }
        }

        System.out.println(count);

        // TC:O(N^2), SC: O(1)
    }
}
