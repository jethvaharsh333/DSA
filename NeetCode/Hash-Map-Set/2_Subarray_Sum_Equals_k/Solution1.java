// 1087ms, 19.02beats
class Solution1 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int len = nums.length;

        for(int i=0; i<len ; i++){
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
