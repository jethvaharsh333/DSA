class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        //1st app
        vector<int> res(nums.size());
        int lp = 0, rp = nums.size() - 1, mp = nums.size() - 1;
        while (lp <= rp) {
            if (abs(nums[lp]) > abs(nums[rp])) {
                res[mp] = nums[lp] * nums[lp];
                lp++;
            } else {
                res[mp] = nums[rp] * nums[rp];
                rp--;
            }   
            mp--;
        }
        return res;

          //We can use two pointers to read the positive and negative parts of the array - one pointer j in the positive direction, and another i in the negative direction.
          //Now that we are reading two increasing arrays (the squares of the elements), we can merge these arrays together using a two-pointer technique.

        //2nd app
        // int N = nums.size();
        // int forward = 0;
        // while(forward < N && nums[forward] < 0){
        //     forward++;
        // }
        // int backward = forward - 1; 
        
        // vector<int> ans(N);
        // int cursor = 0; 
        
        // while(backward >= 0 && forward < N){
        //     if(nums[backward]*nums[backward] < nums[forward]*nums[forward]){
        //         ans[cursor++] = nums[backward]*nums[backward];
        //         backward--;
        //     } else{
        //         ans[cursor++] = nums[forward]*nums[forward];
        //         forward++;
        //     }
        // }
        
        // while(backward >= 0){
        //     ans[cursor++] = nums[backward]*nums[backward];
        //     backward--;
        // }
        
        // while(forward < N){
        //     ans[cursor++] = nums[forward]*nums[forward];
        //     forward++;
        // }
        // return ans;

        
    
        
        // EVERYTHING WRONG-- NOT MVING POINTYER -- NOT PROPERLY INTERCHANGING VALUE INSIDE nums
        // int n = nums.size();
        // int temp = 0;
        // int lp = nums[0];
        // int rp = nums;
        // int mv = n-1;
        // while(mv != 0){
        //     if(abs(lp) > abs(rp)){
        //         temp = rp;
        //         rp = pow(lp,2);
        //         lp = temp;
        //     }
        //     else{
        //         rp = rp*rp;
        //     }
        //     --mv;
        // }
        // return nums;
        
    }
};
