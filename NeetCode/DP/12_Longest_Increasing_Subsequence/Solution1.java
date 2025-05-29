// Time complexity: O(n^2), Space complexity: O(n)

class Solution1 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;

        int[] li = new int[len];
        Arrays.fill(li, 1);

        int maxLen = 1;

        for(int i=1 ; i<len ; i++){
            for(int prev=0 ; prev<i ; prev++){
                if(nums[prev] < nums[i]){
                    li[i] = Math.max(li[i], 1+li[prev]);
                }
            }
            if(li[i] > maxLen){
                maxLen = li[i];
            }
        }

        return maxLen;
    }
}
