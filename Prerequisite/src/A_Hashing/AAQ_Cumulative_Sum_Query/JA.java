package A_Hashing.AAQ_Cumulative_Sum_Query;

import java.util.Scanner;

public class JA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        int qn = sc.nextInt();
        int[][] queries = new int[qn][2];
        for(int[] q: queries){
            q[0] = sc.nextInt();
            q[1] = sc.nextInt();
        }

        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for(int i=1 ; i<n ; i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        for(int[] q: queries){
            int i=q[0], j=q[1];
            int answer;
            if(i == 0){
                answer = prefixSum[j];
            }
            else{
                answer = prefixSum[j] - prefixSum[i-1];
            }
            System.out.println(answer);
        }
    }
}
