package C_Binary_Search.AAC_Upper_Bound;

public class JA {
    private static int findUpperBound(int[] nums, int target){
        int low=0, high=nums.length;

        while(low <= high){
            int mid = low + (high-low)/2;

            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }

        }

        return low; // can be n
    }
}

/*

[left ........ right)
<= target      > target

       0 1 2 3 4 5
arr = [1,2,2,2,3,5]
target = 2

left=0, right=5
mid=2 → arr[2]=2 <= 2 → left=3

left=3, right=5
mid=4 → arr[4]=3 > 2 → right=4

left=3, right=4
mid=3 → arr[3]=2 <= 2 → left=4

left == right == 4 → DONE

-------------------------------------------------------
❌ Wrong version (right = mid - 1)

       0 1 2 3 4 5
arr = [1,2,2,2,3,5]
target = 2

left=0, right=5

mid = 2 → arr[2]=2 <= 2 → left = 3
mid = 4 → arr[4]=3 > 2 → right = 3   ❌ mid thrown away

left = 3, right = 3 → stop
return 3   ❌ WRONG

We lost index 4, which was the real answer.

* */