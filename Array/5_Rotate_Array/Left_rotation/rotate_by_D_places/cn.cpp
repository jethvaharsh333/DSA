vector<int> rotateArray(vector<int>arr, int k) {
    // 1st way
    // int n = arr.size();
    // vector<int> rotatedArr(n);
    // for (int i=0 ; i<n; i++) {
    //     rotatedArr[(i-k+n) % n] = arr[i];
    // }
    // return rotatedArr;

    // 2nd way
    // int n = arr.size();
    // if (n == 0)
    //     return arr;
    // k = k % n;
    // if (k > n)
    //     return arr;
    // int temp[k];
    // for (int i=0 ; i<k ; ++i){
    //     temp[i] = arr[i];
    // }
    // for (int i=0 ; i<n-k ; ++i){
    //     arr[i] = arr[i+k];
    // }
    // for (int i = n-k ; i<n ; ++i){
    //     arr[i] = temp[i-n+k];
    // }
    // return arr;

    // 3rd way => 8ms
    int n = arr.size();
    for (int i = 0; i < k; i++) {
        int temp = arr[0];
        for (int j = 0; j < n - 1; j++) {
            arr[j] = arr[j + 1];
        }
        arr[n - 1] = temp;
    }
    return arr;
}
