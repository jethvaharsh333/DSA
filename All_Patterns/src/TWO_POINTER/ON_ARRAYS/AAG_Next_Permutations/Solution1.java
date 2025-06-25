package TWO_POINTER.ON_ARRAYS.AAG_Next_Permutations;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/next-permutation/
 * Date: 25-06-2025
 * Time complexity: O(n! * n log n)
 *      Generates all permutations → factorial time.
 *      Sorts them → O(n log n) comparison for each.
 *      Then scans to find the current one
 * Space complexity: O(n! * n)
 *      You're storing all permutations in a Set<List<Integer>>. Way too much memory for large n.
 */

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        nextPermutation(nums);

        for(int x: nums){
            System.out.print(x + ", ");
        }
    }

    public static void nextPermutation(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        generatePermutations(0, nums.length, nums, set);
        List<List<Integer>> res = new ArrayList<>(set);

        res.sort((a, b) -> {
            for(int i=0 ; i<a.size() ; i++){
                if(!a.get(i).equals(b.get(i))) return a.get(i) - b.get(i);
            }
            return 0;
        });

        for(int i=0 ; i<res.size() ; i++){
            List<Integer> li = res.get(i);
            boolean match = true;

            for(int j=0 ; j<nums.length ; j++){
                if(!li.get(j).equals(nums[j])){
                    match = false;
                    break;
                }
            }

            if(match){
                if(i == res.size()-1){
                    Arrays.sort(nums);
                }
                else{
                    List<Integer> next = res.get(i+1);
                    for(int j = 0; j < nums.length; j++){
                        nums[j] = next.get(j);
                    }
                }
                return;
            }
        }
    }

    private static void generatePermutations(int start, int len, int[] nums, Set<List<Integer>> set){
        if(start == len){
            List<Integer> current = new ArrayList<>();
            for (int num : nums) current.add(num);
            set.add(current);
            return;
        }

        for(int i=start ; i<len ; i++){
            swap(nums, i, start);
            generatePermutations(start+1, len, nums, set);
            swap(nums, i, start);
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}