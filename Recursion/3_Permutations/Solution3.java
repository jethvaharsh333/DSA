class Solution3 {
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
            swap(nums, begin, i);
            result.addAll(genP(nums, begin+1));
            swap(nums, begin, i);       // 2nd swap => backtrack
        }

        return result;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
