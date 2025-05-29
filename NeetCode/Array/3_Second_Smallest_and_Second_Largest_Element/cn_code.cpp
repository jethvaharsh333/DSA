// Online C++ compiler to run C++ program online
#include <iostream>
#include <array>
#include <limits.h>
using namespace std;

int main() {
    
    array<int,7> a = {1, 6 ,5 ,5 ,3 ,1 ,10};
    // array<int,3> a = {5,5,5};
    // array<int,5> a = {3, 4, 5, 1, 2};
    
    int smallest = INT_MAX, secondSmallest = INT_MAX;
    int largest = INT_MIN, secondLargest = INT_MIN;

    for (int element : a) {
        if (element < smallest) {
            secondSmallest = smallest;
            smallest = element;
            cout << "smallest = " << smallest << " :: secondSmallest = " << secondSmallest << endl;
        } else if (element < secondSmallest && element != smallest) {
            secondSmallest = element;
            cout << ":: secondSmallest = " << secondSmallest << endl;
        }

        if (element > largest) {
            secondLargest = largest;
            largest = element;
            cout << "largest = " << largest << " ==>> secondLargest = " << secondLargest << endl;
        } else if (element > secondLargest && element != largest) {
            secondLargest = element;
            cout << " ==>> secondLargest = " << secondLargest << endl;
        }
    }
    
    cout << secondLargest << " :: " << secondSmallest;
return 0;
    // return {secondLargest,secondSmallest};
}
