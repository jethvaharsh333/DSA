package B_Two_Pointers.AAB_No_Of_Subarray_Cnt_Distinct_No_LessEqual_K;

import java.util.HashSet;
import java.util.Set;


// *** WRONG: IT DOES NOT SUPPORT DUPLICATE NUMBER LOGIC
/*
* A HashSet does not track frequency.
*
* Example:
* nums = [1, 2, 1]
* k = 1
*
* Step-by-step:
    - j = 0 → set = {1}
    - j = 1 → set = {1,2} ❌ size > k
        - remove nums[i] = 1 → set = {2}
        - BUT window still contains another 1 at j=2 later
    You removed the value completely, even though it still exists in the window.
*
* */

public class JA {
    private int SubArrayCntOfDistinctNumberLessEqualThanK(int[] nums, int k){
        int n = nums.length;
        int count = 0;

        Set<Integer> set = new HashSet<>();

        for(int i=0,j=0 ; j<n ; j++){
            set.add(nums[j]);

            while(set.size() > k){
                set.remove(nums[i]);
                i++;
            }

            count += (j-i+1);
        }

        return count;
    }
}
