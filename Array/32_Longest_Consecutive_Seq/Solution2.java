// O(nlogn)
class Solution2 {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        if (nums.length > 0) {
            Arrays.sort(nums);
            int current = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    if (nums[i] - nums[i - 1] == 1) {
                        current++;
                    } 
                    else {
                        if (current + 1 > result) {
                            result = current + 1;
                        }
                        current = 0;
                    }
                }
            }
            if (current + 1 > result) {
                result = current + 1;
            }
        }
        return result;
    }
}
