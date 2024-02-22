#include <iostream>
#include <array>
using namespace std;

int main() {
    
    array<int,5> arr = {1,2,3,4,5};
    
    int temp = arr[0];
    for(int i=0 ; i<arr.size()-1 ; ++i){
        arr[i] = arr[i+1];
    }
    arr[arr.size()-1] = temp;
    
    for(int i=0 ; i<arr.size() ; ++i){
        cout << arr[i] << ", ";
    }

    return 0;
}
