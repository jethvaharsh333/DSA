#include <bits/stdc++.h> 
vector<int> rotateArray(vector<int>& arr, int n) {
    // 1st way
    int temp = arr[0];
    for(int i=0 ; i<n-1 ; ++i){
        arr[i] = arr[i+1];
    }
    arr[n-1] = temp;

    // 2nd way
    // for(int i=0;i<n-1;i++){
    //     swap(arr[i],arr[i+1]);
    // }

    return arr;
}
