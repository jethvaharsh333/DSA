// Time complexity: O(n), Space complexity: O(1)

class Solution4 {
    public int jump(int[] nums) {
        int len = nums.length;
        int maxIndex=0, currEnd=0;
        int jumps = 0;

        for(int i=0 ; i<len-1 ; i++){
            maxIndex = Math.max(maxIndex, i+nums[i]);
            
            if(i == currEnd){
                jumps++;
                currEnd = maxIndex;

                if(currEnd >= len-1){
                    break;
                }
            }
        }

        return jumps;
    }
}
