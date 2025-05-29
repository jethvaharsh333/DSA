vector<int> moveZeros(int n, vector<int> a) 
{
    // 1st way => 15ms
    int j = 0;
    for (int i = 0; i < a.size(); i++) {
        if (a[i] != 0) {
            a[j++] = a[i];
        }
    }
    for (; j < a.size(); j++) {
        a[j] = 0;
    }
    return a;

    // 2nd WAY => 19ms  (MY WAY)
    // int count = 0;
    // int index = 0;
    // for(int i=0 ; i<n ; ++i){
    //     if(a[i] == 0){
    //         count++;
    //         index = i;
    //     }
    //     else{
    //         if(count >= 1){
    //             a[index-count+1] = a[i];
    //             a[i] = 0;
    //             count--;
    //             i--;
    //         }
    //     }
    // }
    // return a;

    // 3rd way => 21ms
    // int j = -1;
    // for (int i = 0; i < n; i++) {
    //     if (a[i] == 0) {
    //         j = i;
    //         break;
    //     }
    // }
    // if (j == -1) return a;
    // for (int i = j + 1; i < n; i++) {
    //     if (a[i] != 0) {
    //         swap(a[i], a[j]);
    //         j++;
    //     }
    // }
    // return a;

    // 4th way => BRUTE FORCE
    // vector<int> temp;
    // for (int i = 0; i < n; i++) {
    //     if (a[i] != 0)
    //         temp.push_back(a[i]);
    // }
    // int nz = temp.size();
    // for (int i = 0; i < nz; i++) {
    //     a[i] = temp[i];
    // }
    // for (int i = nz; i < n; i++) {
    //     a[i] = 0;
    // }
    // return a;

    // 5th way => 19ms
    // int trackzero = -1;
    // for(int i=0 ; i<n ; ++i){
    //     if(a[i] != 0){
    //         if(trackzero != -1){
    //             swap(a[trackzero],a[i]);
    //             trackzero = (a[trackzero+1] == 0) ? trackzero+1 : i;
    //         }
    //     }
    //     else{
    //         if(trackzero == -1){
    //             trackzero = i;
    //         }
    //     }
    // }

    // return a;
}
