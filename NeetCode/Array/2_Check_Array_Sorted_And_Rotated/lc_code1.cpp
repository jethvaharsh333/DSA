#include <iostream>
#include <array> 
using namespace std;

int main() {
    array<int,5> nums{3,4,5,1,2};
    // array<int,4> nums{2,1,3,4}; 
    
    int count = 0;
    int n = nums.size();
    for(int i=1 ; i<n ; ++i){
        if(nums[i-1] > nums[i]){
            count++;
            cout << "true " << count << endl;
        }
    }
    if(nums[n-1] > nums[0]){
        count++;
        cout << "false " << count << endl;
    }
    
    if(count<=1){
        cout<<count;
    }
    
    return 1;
}
