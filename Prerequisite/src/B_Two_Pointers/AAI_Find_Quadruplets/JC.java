package B_Two_Pointers.AAI_Find_Quadruplets;

import java.util.Scanner;

public class JC {
    private static int findQuadruplets(int[] nums, int k1, int k2) {
        int n = nums.length;
        int count = 0;

        for(int j=1 ; j<n-2 ; j++){
            int countA=0, countB=0;

            int i = j-1;
            while(i >= 0){
                if(nums[i] + nums[j] > k1){
                    countA++;
                }
                i--;
            }

            int k=j+1, l=n-1;
            while(k < l){
                if(nums[k] + nums[l] > k2){
                    countB += l-k;
                    l--;
                }else{
                    k++;
                }
            }

            count += countA*countB;
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

/*
* [1,2,3,4,5] k=4  && x[i] + x[j] > k
*
* i=0, j=4 => c += 5
* i=0, j=3 => c += 4
* i=0, j=2 => 3+1 = 4 > 4 => FALSE
* i=1, j=2 => c += 5
* i=1, j=1 => 1==j => FALSE
* */