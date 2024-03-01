class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int n = nums.size();
        for(int i=0 ; i<n ; i++){
            for(int j=i+1 ; j<n ; j++){
                if(nums[i]+nums[j] == target){
                    return {i,j};
                }
            }
        }   
        return {-1,-1};

        // sort(nums.begin(), nums.end());
        // int left=0, right = n-1;
        // while (left < right) {
        //     int sum = nums[left] + nums[right];
        //     if (sum == target) {
        //         return {left+1,right};
        //     }
        //     else if (sum < target) left++;
        //     else right--;
        // }
        // return {-1,-1};
    }
};
