package TWO_POINTER.ON_ARRAYS.AAA_Sort_Array_By_Parity_II;

import java.util.Scanner;

/**
 * Question link:
 * Date: 28-06-2025
 * Time complexity: O(n) - We traverse the array once
 * Space complexity: O(n) - We use an extra array to store the result
 */

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements: ");
        for(int i=0 ; i<n ; i++){
            nums[i] = sc.nextInt();
        }

        int[] res = sortArrayByParityII(nums);

        for(int x: res){
            System.out.println(x);
        }
    }

    public static int[] sortArrayByParityII(int[] nums) {
        int len = nums.length;

        int[] arr = new int[len];
        int even=0, odd=1;

        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]%2 == 0){
                arr[even] = nums[i];
                even += 2;
            }else{
                arr[odd] = nums[i];
                odd += 2;
            }
        }

        return arr;
    }
}