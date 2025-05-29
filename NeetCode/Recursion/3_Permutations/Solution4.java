// Time Complexity: O(n!), Space Complexity: O(n), Efficient solution
class Solution4 {
    public List<List<Integer>> permute(int[] nums) {
        return genP(nums, 0);
    }

    private List<List<Integer>> genP(int[] nums, int begin){
        List<List<Integer>> result = new ArrayList<>();
        
        if(begin == nums.length-1){
            List<Integer> li = new ArrayList<>();
            for(int x: nums){
                li.add(x);
            }
            result.add(li);
            return result;
        }
        
        for(int i=begin ; i<nums.length ; i++){
            int temp = nums[begin];
            nums[begin] = nums[i];
            nums[i] = temp;

            result.addAll(genP(nums, begin+1));
            
            nums[i] = nums[begin];
            nums[begin] = temp;  
        }

        return result;
    }

    private void swap(int[] nums, int i, int j){
        
    }
}
