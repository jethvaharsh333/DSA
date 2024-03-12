vector<int> superiorElements(vector<int>&a) {
    // int arrsize = a.size();
    // int max = a[arrsize-1];
    // vector<int> newarr;
    // for(int i=arrsize-1 ; i>=1 ; i--){
    //     if(a[i] < a[i-1] && max < a[i-1] ){
    //         newarr.push_back(a[i-1]);
    //         max = a[i-1];
    //     }
    // }
    // newarr.insert(newarr.begin(), a[arrsize-1]);    
    // return newarr;
    
    int n = a.size();
    vector<int> ans;
    int max = a[n - 1];
    ans.push_back(a[n-1]);
    for (int i = n - 2; i >= 0; i--)
        if (a[i] > max) {
            ans.push_back(a[i]);
            max = a[i];
        }
    return ans;
}
