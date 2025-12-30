package A_Hashing.AAG_Sum_Within_range_For_each_Query;

import java.util.Scanner;

public class JB {
    public static void main(String[] args) {
        // INPUT
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0 ; i<n ; i++){
            nums[i] = sc.nextInt();
        }

        int q = sc.nextInt();
        int[][] queries = new int[q][2];
        for(int i=0 ; i<q ; i++){
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }

        // LOGIC
        int[] prefix = new int[n+1];
        for(int i=1 ; i<=n ; i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }

        for(int[] query : queries){
            int l = query[0];
            int r = query[1];

            int sum = prefix[r] - prefix[l-1];
            System.out.println(sum);
        }

        //TC: O(N+Q), SC: O(N)
    }
}
