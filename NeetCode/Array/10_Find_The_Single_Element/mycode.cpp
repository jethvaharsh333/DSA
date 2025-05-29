#include <iostream>
#include <array>
using namespace std;

int main() {
    array<int,5> arr = {1,1,3,2,2,};
    int n = arr.size();
    int xorr=0;
    for (int i=0; i<n; i++) {
        cout << xorr << " :: ";
        xorr = xorr^arr[i];
        cout << xorr << endl;
    }
    cout << xorr;

    return 0;
}
