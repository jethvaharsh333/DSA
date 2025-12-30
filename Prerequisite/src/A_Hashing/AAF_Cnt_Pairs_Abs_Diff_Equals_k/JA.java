package A_Hashing.AAF_Cnt_Pairs_Abs_Diff_Equals_k;

import java.util.Scanner;

public class JA {
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
        int count = 0;
        //O(N)
        for(int i=0 ; i<n ; i++){
            //O(N)
            for(int j=i+1 ; j<n ; j++){
                if(Math.abs(arr[i]-arr[j])==k){
                    count++;
                }
            }
        }

        System.out.println(count);

        // TC:O(N^2), SC:O(1)
    }
}
