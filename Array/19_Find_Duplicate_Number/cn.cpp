#include <bits/stdc++.h>

int findDuplicate(vector<int> &arr, int n){
  int freq[n + 1] = {0};

  for (int i = 0; i < n; i++) {
    if (freq[arr[i]] == 0) {
      freq[arr[i]] += 1;
    } 
    else {
      return arr[i];
    }
  }

  return 0;
}
