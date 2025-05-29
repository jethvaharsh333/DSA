vector<int> alternateNumbers(vector<int>&a) {
    // vector<int> pos;
    // vector<int> neg;
    // int n = a.size();
    // for(int i=0;i<n;i++){
    //     if(a[i]>0) pos.push_back(a[i]);
    //     else neg.push_back(a[i]);
    // }
    // for(int i=0;i<n/2;i++){
    //     a[2*i] = pos[i];
    //     a[2*i+1] = neg[i];
    // }
    // return a;

    int n = a.size();
    vector<int> ans(n,0);
    int posIndex = 0, negIndex = 1;
        for(int i = 0;i<n;i++){
            if(a[i]<0){
                ans[negIndex] = a[i];
                negIndex+=2;
            }
            else{
            ans[posIndex] = a[i];
            posIndex+=2;
        }
    }
    return ans;
}
