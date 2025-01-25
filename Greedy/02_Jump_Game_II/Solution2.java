// Time complexity: O(n^2), Space complexity: O(n)

class Solution2 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return calcSteps(0, nums, dp);
    }

    private int calcSteps(int index, int[] nums, int[] dp){
        if(index>=nums.length-1){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        int val = nums[index];
        int min = Integer.MAX_VALUE;

        for(int i=index+1 ; i<=index+val  && i<nums.length ; i++){
            int steps = calcSteps(i, nums, dp);
            if(steps != Integer.MAX_VALUE){
                min = Math.min(min, steps+1);
            }
        }

        dp[index] = min;
        return dp[index];
    }
}
