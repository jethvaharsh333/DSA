// Time complexity: O(n), Space complexity: O(1)

class Solution4 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maxIndex = 0;

        for(int i=0 ; i<len ; i++){
            if(i > maxIndex){
                return false;
            }
            maxIndex = Math.max(maxIndex, i+nums[i]);
        }

        return true;
    }
}
