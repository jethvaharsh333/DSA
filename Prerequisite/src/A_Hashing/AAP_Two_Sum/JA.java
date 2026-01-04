package A_Hashing.AAP_Two_Sum;

import java.util.*;

public class JA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        int[] answer = findIndexTwoSum(arr, target);

        if(answer[0] == -1 || answer[1] == -1) System.out.println("No such 2 elements found.");

        System.out.println("Indexes: " + answer[0] + ", " + answer[1]);
    }

    private static int[] findIndexTwoSum(int[] arr, int target){
        int n = arr.length;

        for(int i=0 ; i<n-1 ; i++){
            for(int j=i+1 ; j<n ; j++){
                if(arr[i]+arr[j] == target){
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }
}
