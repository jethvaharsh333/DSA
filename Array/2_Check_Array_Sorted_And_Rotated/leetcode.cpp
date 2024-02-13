class Solution {
public:
    bool check(vector<int>& nums) {
        // 1st way
        int count = 0;
        int n = nums.size();
        for(int i=1 ; i<n ; ++i){
            if(nums[i-1] > nums[i]){
                count++;
            }
        }
        if(nums[n-1] > nums[0]){
            count++;
        }
        return count<=1;

        // 2nd way
        // for (int i = 0, k = 0; i < nums.size(); ++i)
        //     if (nums[i] > nums[(i+1) % nums.size()] && ++k > 1)
        //         return false;
        // return true;

        // 3rd way (Not answered for all cases) => [6,7,1,1,2]
        // int min = nums[0];
        // int max = INT_MIN;
        // for(int i=1 ; i<nums.size() ; ++i){
        //     if(nums[i-1] <= nums[i]){
        //         if(min >= nums[i-1]){
        //             min = nums[i-1];
        //         }
        //     }
        //     else{
        //         for(int j=i+1 ; j<nums.size() ; ++j){
        //             if(nums[j-1] < nums[j]){
        //                 if(max < nums[j]){
        //                     max = nums[j];
        //                 }
        //             }
        //             else{
        //                 return false;
        //             }
        //         }
        //         break;
        //     }
        // }
        // if(max < min || !max){
        //     return true;
        // }
        // return false;        
    }
};

// edge case => [1,1,1,1,1] , [6,7,1,1,2]
