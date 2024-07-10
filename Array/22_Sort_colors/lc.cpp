class Solution {
public:
    void sortColors(vector<int>& nums) {
      //logic should be extended
        // int lp=0, rp=nums.size()-1, count=0, temp=0;
        // while(rp>=lp){
        //     if(nums[lp] <= nums[rp]){
        //         lp++;
        //     }
        //     else{
        //         temp = nums[lp];
        //         nums[lp] = nums[rp];
        //         nums[rp] = temp;
        //         rp--;
        //     }
        //     count++;
        // }

        int left = -1, right = nums.size(), current = 0;
      
        while (current < right) { // Process elements until 'current' reaches 'right'
            if (nums[current] == 0) {
                // When a 0 is found, swap it with the element at 'left' position,
                // then move both 'left' and 'current' one step right.
                swap(nums[++left], nums[current++]);
            } else if (nums[current] == 2) {
                // When a 2 is found, swap it with the element just before 'right' position,
                // then decrement 'right' to move it leftward.
                // Note 'current' is not incremented because the swapped element needs to be checked.
                swap(nums[--right], nums[current]);
            } else {
                // If the element is 1, just move 'current' one step to the right.
                ++current;
            }
        }

    }
};
