#include <iostream>
#include <vector>
using namespace std;

int main() {
    
    int target = 8;
    
    int mat[3][4] = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12}
    } ;
    
    int rows =  sizeof (mat) / sizeof (mat[0]);
    int cols = sizeof (mat[0]) / sizeof (mat[0][0]);
    
    // int rows = mat.size();
    // int cols = mat[0].size();
    
    cout << rows << " :: " << cols << endl;

    for(int i=0 ; i<rows ; i++){
        for(int j=0 ; j<cols ; j++){
            if(mat[i][j] == target){
                cout << "Target done :: " << mat[i][j];
                return 0;
            }
        }
    }

    return 0;
}
