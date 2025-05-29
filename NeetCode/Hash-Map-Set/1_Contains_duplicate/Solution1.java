// Time exceeded
class Solution1 {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }
}

/*
The brute force approach compares each element with every other element in the array to check for duplicates. 
If any duplicates are found, it returns true. This approach is straightforward but has a time complexity of O(n^2), making it less efficient for large arrays.
*/
