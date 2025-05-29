#include<vector>

void rotateMatrix(vector<vector<int>> &mat){
    // int m = mat.size();
    // vector<vector<int>> ans(m, vector<int>(n));
    // for(int i=0 ; i<m ; i++){
    //     for(int j=0 ; j<n ; j++){
    //         ans[j][n-i-1] = mat[i][j];
    //     }
    // }
    
    int n = mat.size();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
            swap(mat[i][j], mat[j][i]);
        }
    }
    for (int i = 0; i < n; i++) {
        reverse(mat[i].begin(), mat[i].end());
    }
}
