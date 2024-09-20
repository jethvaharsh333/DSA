// n.logn - 20ms
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1])
                return true;
        }
        return false;
    }
}

/*
The sorting approach sorts the array in ascending order and then checks for adjacent elements that are the same. 
If any duplicates are found, it returns true. Sorting helps in bringing duplicates together, simplifying the check. 
However, sorting has a time complexity of O(n log n).
*/
