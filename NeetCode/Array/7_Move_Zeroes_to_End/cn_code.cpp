#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    
    vector<int> a{  0,0,0,0,7,0,4, 0, 0, 0 ,13, 95, 36, 79  };
    int n = 13;
    
    int trackzero = -1;
    for(int i=0 ; i<n ; ++i){
        if(a[i] != 0){
            if(trackzero != -1){
                cout << " ==1 :: " << i << " :: " <<  trackzero << " :: ";
                for(int x=0 ; x<n ;x++){
                    cout << a[x] << ", ";
                }
                cout << endl;
                
                swap(a[trackzero],a[i]);
                trackzero = (a[trackzero+1] == 0) ? trackzero+1 : i;
                
                cout << " ==1 :: " << i << " :: " <<  trackzero << " :: " ;
                for(int x=0 ; x<n ;x++){
                    cout << a[x] << ", ";
                }
                cout << endl<< endl;
            }
            else{
                cout << " first out" << endl << endl;
            }
        }
        else{
            if(trackzero == -1){
                cout << " ==0 :: " << i << " :: " <<  trackzero << " :: ";
                for(int x=0 ; x<n ;x++){
                    cout << a[x] << ", ";
                }
                cout << endl;
                
                trackzero = i;
                
                cout << " ==0 :: " << i << " :: " <<  trackzero << " :: " ;
                for(int x=0 ; x<n ;x++){
                    cout << a[x] << ", ";
                }
                cout << endl << endl;
            }
            else{
                cout << " second out" << endl << endl;
            }
        }
    }
    
    
    for(int x=0 ; x<n ;x++){
        cout << a[x] << ", ";
    }

    return 0;
}
