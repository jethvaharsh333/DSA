// Time complexity: O(n), Space complexity: O(1)

class Solution4 {
    public int rob(int[] nums) {
        int len = nums.length;

        if(len == 0) return 0;
        if(len == 1) return nums[0];

        int prev = 0;
        int prevOfPrev = 0;
        int ans = 0;

        for(int i=0 ; i<len ; i++){
            int pick = prevOfPrev + nums[i];
            int noPick = prev;
            ans = Math.max(pick, noPick);
            prevOfPrev = prev;
            prev = ans;
        }

        return ans;
    }
}
