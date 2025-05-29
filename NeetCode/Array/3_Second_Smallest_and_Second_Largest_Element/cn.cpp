vector<int> getSecondOrderElements(int n, vector<int> a) {

    // 1.0 way
    // int j = INT_MIN;
    // int key = INT_MIN;

    // for (int i=1 ; i<n; ++i) {
    //     key = a[i];
    //     j = i-1;

    //     while (j>=0 && a[j]>key) {
    //         a[j+1] = a[j];
    //         j--;
    //     }

    //     a[j+1] = key;
    // }

    // return {a[n - 2],a[1]};

    // 2.0 way
    // int firstMin = INT_MAX, secondMin = INT_MAX;
    // int firstMax = INT_MIN, secondMax = INT_MIN;

    // for (int i = 0; i < n; ++i) {
    //     if (a[i] < firstMin) {
    //         secondMin = firstMin;
    //         firstMin = a[i];
    //     } else if (a[i] < secondMin && a[i] != firstMin) {
    //         secondMin = a[i];
    //     }

    //     if (a[i] > firstMax) {
    //         secondMax = firstMax;
    //         firstMax = a[i];
    //     } else if (a[i] > secondMax && a[i] != firstMax) {
    //         secondMax = a[i];
    //     }
    // }

    // return {secondMax,secondMin};

    // 2.1 way  
    int smallest = INT_MAX, secondSmallest = INT_MAX;
    int largest = INT_MIN, secondLargest = INT_MIN;

    for (int element : a) {
        if (element < smallest) {
            secondSmallest = smallest;
            smallest = element;
        } else if (element < secondSmallest && element != smallest) {
            secondSmallest = element;
        }

        if (element > largest) {
            secondLargest = largest;
            largest = element;
        } else if (element > secondLargest && element != largest) {
            secondLargest = element;
        }
    }

    return {secondLargest,secondSmallest};
}

// edge case => [5, 5, 5], [1 ,6 ,5 ,5 ,3 ,1 ,10]
