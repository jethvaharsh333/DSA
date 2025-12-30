package A_Hashing.AAA_Freq_of_each_number.Approach_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        int[] queries = new int[q];
        for(int i=0 ; i<q ; i++){
            queries[i] = sc.nextInt();
        }

        // Logic
        int maxElement = Integer.MIN_VALUE;
        // O(n)
        for(int i=0 ; i<n ; i++){
            maxElement = Math.max(arr[i], maxElement);
        }

        int[] hash = new int[maxElement+1];

        // O(n)
        for(int i=0 ; i<n ; i++){
            int element = arr[i];
            hash[element] = hash[element]+1;
        }

        // O(q)
        for(int i=0 ; i<q ; i++){
            int query = queries[i];
            int frequency = hash[query];
            System.out.println(frequency);
        }

        // TC: O(n+q), SC: O(n);

    }
}