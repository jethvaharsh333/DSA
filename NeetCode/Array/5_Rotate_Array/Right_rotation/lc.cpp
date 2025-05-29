class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        k = k%n;
        
        if(k<n || n!=0){
            int temp[n-k];
            for(int i=0 ; i<n-k ; i++){
                temp[i] = nums[i];
            }
            
            for(int i=0 ; i<k ; i++){
                nums[i] = nums[n-k+i];
                // nums[i] = nums[i+k+1];
            }

            for(int i=k ; i<n ; i++){
                nums[i] = temp[i-k];
            }
        }

        for(int i=0 ; i<n ; i++){
            cout << nums[i];
        }
    }
};
