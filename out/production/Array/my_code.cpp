// Online C++ compiler to run C++ program online
#include <iostream>
#include<vector>
#include <limits.h>
using namespace std;

int main() {
    
    vector<int> prices = {7 ,1 ,5 ,4 ,3 ,6};
    int n = prices.size();
    int min = prices[0];
    int max = prices[0];
    int maxProfit = 0;

    for(int i=0 ; i<n ; i++){
        if(min > prices[i]){
            min = prices[i];
            max = 0;
            cout << "min :: " << min;
            if(max-min > maxProfit){
                maxProfit = (max-min);
                cout << " || maxProfit :: " << maxProfit;
            }
        }
        cout << endl;
        if(max < prices[i]){
            max = prices[i];
            cout << "max :: " << max;
            if(max-min > maxProfit){
                maxProfit = (max-min);
                cout << " || maxProfit :: " << maxProfit;
            }
        }
        cout << endl;
    }
    
    cout << "profit = " << maxProfit;

    return 0;
}
