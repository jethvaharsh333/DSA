// Time complexity: O(n), Space complexity: O(1)

class Solution5 {
    public boolean canJump(int[] nums) {
        int index = nums.length-1;

        for(int i=nums.length-2 ; i>=0 ; i--){
            if(i+nums[i] >= index){
                index = i;
            }
        }

        return index == 0;
    }
}
