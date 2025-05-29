// O(n^3)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0 ; i<len-2 ; i++){
            for(int j=i+1 ; j<len-1 ; j++){
                for(int k=j+1 ; k<len ; k++){
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> curr = new ArrayList<>();
                        curr.add(nums[i]);
                        curr.add(nums[j]);
                        curr.add(nums[k]);
                        Collections.sort(curr);
                        if(!result.contains(curr)){
                            result.add(curr);
                        }
                    }
                }
            }   
        }
      
        return result;
    }
}

/*  ANOTHER WAY WITH O(n^3) 
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0 ; i<len-2 ; i++){
            if (i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1 ; j<len-1 ; j++){
                if (j>i+1 && nums[j]==nums[j-1]) continue;
                for(int k=j+1 ; k<len ; k++){
                    if (k>j+1 && nums[k]==nums[k-1]) continue;
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }   
        }
        return result;
    }
}
*/
