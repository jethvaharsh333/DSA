#include <iostream>
#include <array> 
using namespace std;

int main() {
    array<int,5> nums{3,4,5,1,2};
    // array<int,4> nums{2,1,3,4};
    
    int count = 0;
    int n = nums.size();
    for (int i = 0; i < n; i++) {
        if (nums[i] > nums[(i + 1) % n]) {
            count++;
            cout << count << " " << i << " " << ((i + 1) % n) << " conditional" << endl;
        }
        else{
            cout << count << " " << i << " " << ((i + 1) % n) << endl;
        }
    }
    if(count <= 1){
        cout << "true";
    } 
    else{
        cout << "false";
    }

    return 0;
}
