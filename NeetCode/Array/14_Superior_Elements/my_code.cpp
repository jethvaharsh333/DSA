#include <iostream>
#include <vector>
using namespace std;

int main() {
    
    vector<int> a = {187, 64 ,133, 62, 49 ,163, 50, 115, 42, 65, 60, 49, 32, 87, 141, 142, 146, 159};
    
    int arrsize = a.size();
    int max = a[arrsize-1];
    vector<int> newarr;

    for(int i=arrsize-1 ; i>=1 ; i--){
        cout << a[i-1] << ", ";
        if(a[i] < a[i-1] && max < a[i-1] ){
            newarr.push_back(a[i-1]);
            max = a[i-1];
            cout << a[i-1] << ", ";
        }
    }
    newarr.insert(newarr.begin(), a[arrsize-1]);
    
    cout << endl << endl;
    for(int i=0 ; i<newarr.size() ; i++){
        cout << newarr[i] << ", ";
    }
    
    return 0;
}
