// Time complexity: O(nlogn), Space complexity: O(n)

class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;

        ArrayList<Integer> dp = new ArrayList<>();

        for(int num : nums){
            int index = Collections.binarySearch(dp, num);

            if(index < 0)
                index = -(index+1);

            if(index < dp.size()){
                dp.set(index, num);
            } 
            else{
                dp.add(num);
            }
        }

        return dp.size();
    }
}
