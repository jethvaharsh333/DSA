#include<vector>

int getSingleElement(vector<int> &arr){
	int n = arr.size();
    int xorr=0;
    for (int i=0; i<n; i++) {
        xorr = xorr^arr[i];
    }
    return xorr;	
}

// In XOR[^]
// 1] number1 > number2 => number1 + number2
// 2] number1 = number2 => 0 
// 3] number1 < number2 => number2 - number1
