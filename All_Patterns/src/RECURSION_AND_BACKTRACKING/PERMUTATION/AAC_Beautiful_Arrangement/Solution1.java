package RECURSION_AND_BACKTRACKING.PERMUTATION.AAC_Beautiful_Arrangement;

import java.util.*;

/**
 * Question link:
 * Date: 17-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    public int countArrangement(int n) {
        int[] nums = new int[n];
        for(int i=0 ; i<n ; i++){
            nums[i] = i+1;
        }

        List<List<Integer>> permutations = genPermutations(0, nums, new ArrayList<List<Integer>>());
        int count = 0;

        for(int i=0 ; i<permutations.size() ; i++){
            List<Integer> li = permutations.get(i);
            boolean isValid = true;

            for(int j=0 ; j<li.size() ; j++){
                int val = li.get(j);
                int pos = j+1;
                if(val%pos!=0 && pos%val!=0){
                    isValid = false;
                    break;
                }
            }

            if(isValid) count++;
        }

        return count;
    }

    private List<List<Integer>> genPermutations(int start, int[] nums, List<List<Integer>> result){
        if(nums.length == start){
            List<Integer> li = new ArrayList<Integer>();
            for(int x: nums) li.add(x);
            result.add(new ArrayList<Integer>(li));
            return result;
        }

        for(int i=start ; i<nums.length ; i++){
            swap(i, start, nums);
            genPermutations(start+1, nums, result);
            swap(i, start, nums);
        }

        return result;
    }

    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*

Example (n = 3):

All permutations of [1, 2, 3] are:
[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 1, 2]
[3, 2, 1]

We will now check which of these are beautiful.

1. [1, 2, 3]
Check position by position:
i = 1: number = 1 → 1 % 1 == 0 => Correct
i = 2: number = 2 → 2 % 2 == 0 => Correct
i = 3: number = 3 → 3 % 3 == 0 => Correct
=> Correct

2. [1, 3, 2]
i = 1: 1 % 1 == 0 => Correct
i = 2: 3 % 2 == 1 => Wrong, 2 % 3 == 2 => Wrong
=> Wrong

3. [2, 1, 3]
i = 1: 2 % 1 == 0 => Correct
i = 2: 1 % 2 == 1 => Wrong but 2 % 1 == 0 => Correct
i = 3: 3 % 3 == 0 => Correct
=> Correct

4. [2, 3, 1]
i = 1: 2 % 1 == 0 => Correct
i = 2: 3 % 2 == 1 => Wrong and 2 % 3 == 2 => Wrong
=> Wrong

5. [3, 1, 2]
i = 1: 3 % 1 == 0 => Correct
i = 2: 1 % 2 == 1 => Wrong but 2 % 1 == 0 => Correct
i = 3: 2 % 3 == 2 => Wrong and 3 % 2 == 1 => Wrong
=> Wrong

6. [3, 2, 1]
i = 1: 3 % 1 == 0 => Correct
i = 2: 2 % 2 == 0 => Correct
i = 3: 1 % 3 == 1 => Wrong but 3 % 1 == 0 => Correct
=> Correct

=> Correct Final Count for n = 3:
Valid permutations are:
[1, 2, 3]
[2, 1, 3]
[3, 2, 1]

Output = 3

*/