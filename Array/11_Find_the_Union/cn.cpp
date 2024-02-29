vector < int > sortedArray(vector < int > a, vector < int > b) {
    int i=0; 
    int j=0;
    vector<int> arr;
    int n1 = a.size();
    int n2 = b.size();
    while (i < n1 && j < n2){
        if (a[i] <= b[j]){
            if (arr.size() == 0 || arr.back() != a[i]){
                arr.push_back(a[i]);
            }
            i++;
        }
        else{
            if (arr.size() == 0 || arr.back() != b[j]){
                arr.push_back(b[j]);
            }
            j++;
        }
    }
    while (i < n1){
        if (arr.size() == 0 || arr.back() != a[i]){
            arr.push_back(a[i]);
        }
        i++;
    }
    while (j < n2){
        if (arr.size() == 0 || arr.back() != b[j]){
            arr.push_back(b[j]);
        }
        j++;
    }
    return arr;
}
