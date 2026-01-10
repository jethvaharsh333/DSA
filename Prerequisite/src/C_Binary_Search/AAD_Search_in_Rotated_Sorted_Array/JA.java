package C_Binary_Search.AAD_Search_in_Rotated_Sorted_Array;

public class JA {
    public int search(int[] nums, int target) {
        int left=0, right=nums.length-1;

        while(left <= right){
            int mid = left + (right-left)/2;

            if(nums[mid] == target) return mid;

            // left sided sort w.r.t mid
            if(nums[left] <= nums[mid]){
                // left .... target .... mid .... right
                if(nums[left]<=target && target<nums[mid]){
                    right = mid-1;
                }
                // left .... mid ..... target .... right
                else{
                    left = mid+1;
                }
            }
            // right sided sort w.r.t mid
            else{
                // left .... mid ..... target .... right
                if(nums[mid]<target && target<=nums[right]){
                    left = mid+1;
                }
                // left .... target .... mid .... right
                else{
                    right = mid-1;
                }
            }
        }

        return -1;
    }
}


/*

BOUNDARY CASES:
1) nums[left] <= nums[mid]. why `=`?
A single element is always sorted.
<= allows the case where left == mid (1-element half)
Example
[3, 1] ; target = 1 ; left = 0 ; mid = 0 ; right = 1
- Step 1: mid check
nums[mid] == target ???
3 == 1 → false
- Step 2: sorted-half detection (WRONG)
nums[left] < nums[mid]
3 < 3 → false
So the code concludes: Left half is NOT sorted, Right half MUST be sorted
This is already a logical mistake, but let’s continue execution.
- Step 3: right-half target check
if (nums[mid] < target && target <= nums[right])
3 < 1 → false
So we go to else: right = mid - 1 = -1
- Step 4: loop ends
Return -1.

2) nums[left] <= target. why `=`? [LEFT MOST ELEMENT]
nums = [4,5,6,7,1,2] ; target = 4 ; left = 4 ; mid = 6
If you write: nums[left] < target   // 4 < 4 ❌ false

3) target <= nums[right]. why `=`? [RIGHT MOST ELEMENT]
nums = [6,7,1,2,3,4,5] ; target = 5 ; right = 5
If you write: target < nums[right]   // 5 < 5 ❌ false


           0 1 2 3 4 5 6
* Case 1: [4,5,6,7,8,1,2], target = 5
------------------------------------------------
           0 1 2 3 4 5 6
* Case 2: [4,5,6,7,8,1,2], target = 1
------------------------------------------------
           0 1 2 3 4 5 6
* Case 3: [6,7,0,1,2,4,5], target = 6
------------------------------------------------
           0 1 2 3 4 5 6
* Case 4: [6,7,0,1,2,4,5], target = 2

* */