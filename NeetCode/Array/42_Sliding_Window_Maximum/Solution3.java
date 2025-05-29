// Time complexity: O(n); Space Complexity: O(1); OPTIMAL SOLUTION
class Solution3 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] re = new int[nums.length+1-k];

        int maxId = 0;
        int max = Integer.MIN_VALUE;

        for (int x=0 ; x<k ; x++){
            if(nums[x] >= max){
                max = nums[x];
                maxId = x;
            }
        }

        re[0] = max;
        
        for(int i=1, end; i<re.length; i++){
            end = i+k-1;

            // Check if previous max is still in the window
            if(i <= maxId){
                if(max <= nums[end]){
                    max = nums[end];
                    maxId = end;
                }
            }
            // Here, previous max is not in the window
            else{
                // Now we know if the element we are gonna add is greater than max then new element is already greater than remaining elements before that. As max been passed away.
                if (nums[end] >= max-1) {
                    max = nums[end];
                    maxId = end;
                } 
                // Now the above condition is not correct then we can know th eement `max` which has already been gone is greater than new element which we are going to add in the window. So simply check if elemt next to max (first element of window)is equal to the max.
                else if (nums[i] == max-1 || nums[i] == max) {
                    max = nums[i];
                    maxId = i;
                } 
                else {
                    max = Integer.MIN_VALUE;
                    for (int x = i; x < end + 1; x++) {
                        if (nums[x] >= max) {
                            max = nums[x];
                            maxId = x;
                        }
                    }
                }
            }
            re[i] = max;
        }
        return re;
    }
}
