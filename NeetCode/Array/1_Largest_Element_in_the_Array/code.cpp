#include <bits/stdc++.h> 
#include <algorithm>
int largestElement(vector<int> &arr, int n) {
    // Write your code here.

    // 1st way [Assigning]
    int max = INT_MIN;
    for(int i=0 ; i<n ; i++){
        if(arr[i] > max){
            max = arr[i];
        }
    }
    return max;

    // 2nd way [Swapping]
    // int temp = INT_MIN;
    // for (int i=0; i<n-1; i++) {
    //     for (int j=0; j < n-i-1; j++) {
    //         if (arr[j] > arr[j+1]) {
    //             temp = arr[j];
    //             arr[j] = arr[j+1];
    //             arr[j+1] = temp;
    //         }
    //     }
    // }
    // return arr[n-1];
}
