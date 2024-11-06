// Time complexity: O(n); Space Complexity: O(1)
class Solution2 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];

        for (int i=0 ; i<nums.length ; i++) {
            sum = sum + nums[i];
            max = Math.max(sum, max);

            if(sum < 0){
                sum = 0;
            }
        }

        return max;
    }
}
