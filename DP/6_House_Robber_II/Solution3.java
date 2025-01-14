// Time complexity: O(n), Space complexity: O(1)

class Solution3 {
    public int rob1(int[] nums) {
        int len = nums.length;

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
    
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        int[] num1 = new int[len-1];
        int[] num2 = new int[len-1];

        for(int i=0 ; i<len-1 ; i++){
            num1[i] = nums[i + 1]; 
            num2[i] = nums[i];
        }

        return Math.max(rob1(num1), rob1(num2));
    }
}
