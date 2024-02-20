class Solution {
public:
    bool check(vector<int>& nums) {
        // 1st way
        // int count = 0;
        // int n = nums.size();
        // for(int i=1 ; i<n ; ++i){
        //     if(nums[i-1] > nums[i]){
        //         count++;
        //     }
        // }
        // if(nums[n-1] > nums[0]){
        //     count++;
        // }
        // return count<=1;

        //2nd way
        int min = nums[0];
        int minIndex = 0;
        int max = INT_MIN;
        int i = 0;
        int ind = 0;
        for(i=1 ; i<nums.size() ; i++){
            if(nums[i] >= nums[i-1]){
                if(min > nums[i]){
                    min = nums[i];
                    minIndex = i;
                }
            }
            else{
                ind = i;
                max = nums[i];
                break;
            }
        }

        if(minIndex==0 && i==nums.size()){
            return true;
        }

        for(i=ind+1 ; i<nums.size() ; i++){
            if(nums[i] >= nums[i-1]){
                if(max < nums[i]){
                    max = nums[i];
                }
            }
            else{
                return false;
            }
        }

        if(min >= max){
            return true;
        }
        else{
            return false;
        }
    }

    //3rd way
    // int count = 0;
    // int n = nums.size();
    // for (int i = 0; i < n; i++) {
    //     if (nums[i] > nums[(i + 1) % n]) {
    //         count++;
    //     }
    // }
    // return count <= 1;
};

// edge case => [1,1,1,1,1] , [6,10,6], [7,9,1,1,1,3]
