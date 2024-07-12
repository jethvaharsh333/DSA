class Solution {
public:
    int majorityElement(vector<int>& nums) {

        unordered_map<int, int> counter;
        for (int num : nums) {
            if (++counter[num] > nums.size() / 2) {
                return num;
            }
        }
        return 0;

        // int major=nums[0], count = 1;
        // for(int i=1 ; i<nums.size() ; ++i){
        //     if(count == 0){
        //         count++;
        //         major = nums[i];
        //     }
        //     else if(major==nums[i]) count++;
        //     else count--;
        // }
        // return major;

        // int co=0, cn=0, el;
        // for(int i=0; i<nums.size(); ++i){
        //     if(cn == 0){
        //         cn = 1;
        //         el = nums[i];
        //     }
        //     else if(el == nums[i]) cn++;
        //     else cn--;
        // }
        // for (int i=0; i<nums.size(); ++i) {
        //     if (nums[i] == el) co++;
        // }
        // if (co > (nums.size() / 2)) return el;
        // return -1;
    }
};
