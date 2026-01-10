package B_Two_Pointers.AAI_Find_Quadruplets;

import java.util.Scanner;

public class JA {
    private static int findQuadruplets(int[] nums, int k1, int k2){
        int n = nums.length;
        int count = 0;

        for(int i=0 ; i<n-3 ; i++){
            for(int j=i+1 ; j<n-2 ; j++){
                for(int k=j+1 ; k<n-1 ; k++){
                    for(int l=k+1 ; l<n ; l++){
                        if(nums[i]+nums[j]>k1 && nums[l]+nums[k]>k2){
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k1 = sc.nextInt();
        int k2 = sc.nextInt();

        System.out.println(findQuadruplets(nums, k1, k2));
    }
}
