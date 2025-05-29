bool searchMatrix(vector<vector<int>>& mat, int target) {
    // 1st way
    // int n = mat.size(), m = mat[0].size();
    // for (int i = 0; i < n; i++) {
    //     for (int j = 0; j < m; j++) {
    //         if (mat[i][j] == target)
    //             return true;
    //     }
    // }
    // return false;

    // 2nd way
    int n = mat.size();
    int m = mat[0].size();
    int low = 0, high = n * m - 1;
    while (low <= high) {
        int mid = (low + high) / 2;
        int row = mid / m, col = mid % m;
        if (mat[row][col] == target) return true;
        else if (mat[row][col] < target) low = mid + 1;
        else high = mid - 1;
    }
    return false;
}
