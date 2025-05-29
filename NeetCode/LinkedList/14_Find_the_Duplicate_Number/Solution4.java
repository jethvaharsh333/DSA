// Time Complexity: O(n), Space Complexity: O(n)
class Solution4 {
    public int findDuplicate(int[] nums) {
        boolean arr[] = new boolean[nums.length+1];

        for(int i=0 ; i<nums.length ; i++){
            if(arr[nums[i]]) return nums[i];
            arr[nums[i]]=true;
        }
        
        return -1;
    }
}
