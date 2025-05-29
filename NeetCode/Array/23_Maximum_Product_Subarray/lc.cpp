class Solution {
public:
    int maxProduct(vector<int>& nums) {
        // int omp = nums[0], nmp = nums[0];
        // for(int i=0; i<nums.size(); ++i){
        //     if(nmp*nums[i] >= nmp ){
        //         nmp *= nums[i];
        //     }
        //     else{
        //         nmp = 1;
        //     }
        //     if(omp < nmp){
        //         omp = nmp;
        //     }
        // }

        // return omp;

        double maxi = nums[0], mini = nums[0], ans = nums[0];

        for(int i = 1;i < nums.size();i++){
            if(nums[i] < 0){
                swap(maxi,mini);
            }
            maxi = max((double)nums[i], maxi * nums[i]);
            mini = min((double)nums[i], mini * nums[i]);
            ans = max(ans,maxi);
        }
        
        return (int)ans;

    }
};
