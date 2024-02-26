class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        // 1st way
        int i = 1;
        for(int j=1 ; j<nums.size() ; j++){
            if(nums[j] != nums[j-1]){
                nums[i++] = nums[j];
            }
        }
        return i;

        // 2nd way
        // int i = 0;
        // for(int j=1 ; j<nums.size() ; j++){
        //     if(nums[j] != nums[j-1]){
        //         nums[++i] = nums[j];
        //     }
        // }
        // return i+1;
    }
};
