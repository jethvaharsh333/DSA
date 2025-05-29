// Time complexity: O(n^2); Space complexity: O(n); 92.37% beats & OPTIMAL SOLUTION
class Solution3 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0 ; i<len ; i++){
            while(i!=0 && i!=len-2 && nums[i]<=0 && nums[i]==nums[i-1]){    // Not the first element and should not equals to previous element 
                i++;
            }
            if(i==len-2 || nums[i]>0) {
                break;
            }
            int j = i+1;
            int k = len-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
                else if(sum < 0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }

        return list;
    }
}
