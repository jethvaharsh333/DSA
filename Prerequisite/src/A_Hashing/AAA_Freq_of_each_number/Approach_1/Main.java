package A_Hashing.AAA_Freq_of_each_number.Approach_1;

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
        //O(q)
        for(int i=0 ; i<q ; i++){
            int query = queries[i];
            int count = 0;
            for(int j=0 ; j<n ; j++){  //O(n)
                if(arr[j] == query){
                    count += 1;
                }
            }

            System.out.println(count);
        }

        // TC: O(n*q)
        // SC: O(1)
    }
}

/*

5
1 2 2 3 5
3
5 3 2

* */