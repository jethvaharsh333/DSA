package A_Hashing.AAC_Similar_number_within_distance_k;

import java.util.Scanner;

public class JA {
    public static void main(String[] args) {

        // IN
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i=0 ; i<n ; i++){
            array[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        // Logic
        if(containsNearbyDuplicateBruteForce(array, k)){
            System.out.println("Two numbers similar within distance " + k);
        }else{
            System.out.println("No two similar numbers found.");
        }
    }

    public static boolean containsNearbyDuplicateBruteForce(int[] nums, int k){
        int n = nums.length;

        for(int i=0 ; i<n ; i++){
            for(int j=i+1 ; j<n && j<i+k ; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }

        return false;
    }
}
