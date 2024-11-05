// Time complexity: O(n); Space Complexity: O(1)
class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int maxId = -1; // Initialize to an invalid index
        int max = Integer.MIN_VALUE;

        for(int i=0 ; i<k ; i++){
            if(nums[i] >= max){
                max = nums[i];
                maxId = i;
            }
        }
        result[0] = max;

        for (int i=1 ; i<=n-k ; i++){
            int end = i + k - 1;

            if(maxId >= i){
                if(nums[end] >= max){
                    max = nums[end];
                    maxId = end;
                }
            } 
            else{
                max = Integer.MIN_VALUE;
                for (int j=i ; j<=end ; j++) {
                    if(nums[j] >= max){
                        max = nums[j];
                        maxId = j;
                    }
                }
            }
            result[i] = max;
        }

        return result;
    }
}
