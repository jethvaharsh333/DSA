// Online C++ compiler to run C++ program online
#include <iostream>
#include <array>
using namespace std;

int main() {
    
    array<int,7> nums = {1,2,3,4,5,6,7};
    int k = 13;
    
    int n = nums.size();
    k = k%n;
    
    if(k<n || n!=0){
        int temp[n-k];
        for(int i=0 ; i<n-k ; i++){
            temp[i] = nums[i];
        }
        
        for(int i=0 ; i<k ; i++){
            // nums[i] = nums[n-k+i];
            nums[i] = nums[i+k+1];
        }

        for(int i=k ; i<n ; i++){
            nums[i] = temp[i-k];
        }
    }
    
    cout << endl << "final --------------" << endl;

    for(int i=0 ; i<n ; i++){
        cout << nums[i] << ", ";
    }

    return 0;
}
