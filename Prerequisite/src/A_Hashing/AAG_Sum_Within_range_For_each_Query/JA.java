package A_Hashing.AAG_Sum_Within_range_For_each_Query;

import java.util.Scanner;

public class JA {
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
        for(int[] query : queries){
            int sum = bruteForceSum(nums, query[0] , query[1]);
            System.out.println(sum);
        }

        //TC: O(N*Q), SC: O(1)
    }

    static int bruteForceSum(int[] nums, int l, int r) {
        int sum = 0;
        for (int i = l; i <= r; ++i) {
            sum += nums[i];
        }
        return sum;
    }
}
