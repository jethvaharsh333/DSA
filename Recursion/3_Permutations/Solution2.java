// Time Complexity: O(n!); Space Complexity: O(n)
class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        genR(nums, 0, result);
        return result;
    }

    private void genR(int[] nums, int begin, List<List<Integer>> result){
        if(begin == nums.length-1){
            List<Integer> li = new ArrayList<>();
            for(int x: nums){
                li.add(x);
            }
            result.add(li);
            return;
        }
        
        for(int i=begin ; i<nums.length ; i++){
            swap(nums, begin, i);
            genR(nums, begin+1, result);
            swap(nums, begin, i);       // 2nd swap => backtrack
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
