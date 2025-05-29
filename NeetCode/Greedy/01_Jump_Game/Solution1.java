// Time complexity: O(2^n), Space complexity: O(n)

class Solution1 {
    public boolean canJump(int[] nums) {
        return canReach(nums, 0);
    }

    private boolean canReach(int[] nums, int index) {
        if(index >= nums.length-1){
            return true;
        }

        int nextJump = Math.min(index+nums[index], nums.length-1);
        
        for(int nextPosition=index+1 ; nextPosition<=nextJump ; nextPosition++){
            if(canReach(nums, nextPosition)){
                return true;
            }
        }
        
        return false;
    }
}
