package A_Hashing.AAN_Two_Disjoint_SubArray_Sum_Of_Both_Max;

import java.util.Scanner;

public class JA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }

        int answer = twoDisjointSubarraySumOfBothMax(arr);
        System.out.println(answer);
    }

    static int twoDisjointSubarraySumOfBothMax(int[] arr){
        int n = arr.length;
        int maxSumPrefixAndSuffix = 0;

        for(int j=0 ; j<n ; j++){
            maxSumPrefixAndSuffix = Math.max(maxSumPrefixAndSuffix, maxFromPrefix(j, arr) + maxFromSuffix(j, arr));
        }

        return maxSumPrefixAndSuffix;
    }

    static int maxFromPrefix(int index, int[] arr){
        int curr = 0, max = 0;

        for(int i = 0; i < index; i++){
            curr = Math.max(0, curr + arr[i]);
            max = Math.max(max, curr);
        }
        return max;
    }

    static int maxFromSuffix(int index, int[] arr){
        int curr = 0, max = 0;

        for(int i = index; i < arr.length; i++){
            curr = Math.max(0, curr + arr[i]);
            max = Math.max(max, curr);
        }
        return max;
    }
}

/*
*INPUT
[-10, -15, 2, 4, -15, -20, 1, 2]
*OUTPUT [Not in index right now for explanation]
[2, 4] & [1, 2] => 6 + 3 => 9

Test cases:
* Duplicates [true]
* Negatives [true]

--------------------------- MISSED EDGE CASES
* Single Element Array
[7]
=>[7] & 0 = 7

* Two Elements Only [1 +ve and 1 -ve]
[5, -2]
=> [5] & [] => 5

* All negatives
[-5, -2, -8] => [] + [] = 0
*/