// Online C++ compiler to run C++ program online
#include <iostream>
#include <vector>
using namespace std;

int main() {
    
    vector<vector<int>> mat = { {1,2,3,4} , {5,6,7,8}, {9,10,11,12}, {13,14,15,16} };
    
    int m = mat.size();
    int n = mat[0].size();
    
    cout << m << n;

    vector<vector<int>> ans(m, vector<int>(n));

    for(int i=0 ; i<m ; i++){
        for(int j=0 ; j<n ; j++){
            ans[j][n-i-1] = mat[i][j];
        }
    }
    
    cout << endl;
    
    for(int i=0 ; i<m ; i++){
        for(int j=0 ; j<n ; j++){
            cout << ans[i][j] << "\t";
        }
        cout<< endl;
    }

    return 0;
}
