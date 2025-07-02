package TWO_POINTER.ON_ARRAYS.AAE_Three_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Question link: https://leetcode.com/problems/3sum/
 * Date: 30-06-2025
 * Time complexity: O(n^2)
 * Space complexity: O(1) (excluding output list)
 */

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: size of array
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Input: array elements
        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Call method
        List<List<Integer>> result = threeSum(nums);

        // Output
        System.out.println("Triplets with sum zero:");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }

        sc.close();
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0 ; i<len ; i++){
            while(i!=0 && i!=len-2 && nums[i]<=0 && nums[i]==nums[i-1]){    // Not the first element and should not equals to previous element
                i++;
            }

            if(i==len-2 || nums[i]>0) {
                break;
            }

            int j = i+1;
            int k = len-1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
                else if(sum < 0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }

        return list;
    }
}