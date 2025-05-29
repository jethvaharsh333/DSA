class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int count = 0;
        int index = 0;
        for(int i=0 ; i<nums.size() ; ++i){
            if(nums[i] == 0){
                count++;
                index = i;
            }
            else{
                if(count >= 1){
                    nums[index-count+1] = nums[i];
                    nums[i] = 0;
                    count--;
                    i--;
                }
            }
        }

        for(int i=0 ; i<nums.size() ; ++i){
            cout << nums[i];
        }
    }
};
