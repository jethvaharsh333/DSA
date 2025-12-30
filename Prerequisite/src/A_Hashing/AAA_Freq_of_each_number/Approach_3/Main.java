package A_Hashing.AAA_Freq_of_each_number.Approach_3;

import java.util.*;

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
        HashMap<Integer, Integer> map = new HashMap<>();

        // O(n)
        for(int i=0 ; i<n ; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // O(q)
        for(int i=0 ; i<q ; i++){
            int query = arr[i];
            int frequency = map.getOrDefault(arr[i], 0);
            System.out.println(frequency);
        }

        // TC: O(n+q), SC: O(n);

    }
}
