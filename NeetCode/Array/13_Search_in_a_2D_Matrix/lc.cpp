class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        // 1st way
        // int n = matrix.size(), m = matrix[0].size();
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         if (matrix[i][j] == target)
        //             return true;
        //     }
        // }
        // return false;

        // 2nd way
        // int n = matrix.size();
        // int m = matrix[0].size();
        // int low = 0, high = n * m - 1;
        // while (low <= high) {
        //     int mid = (low + high) / 2;
        //     int row = mid / m, col = mid % m;
        //     if (matrix[row][col] == target) return true;
        //     else if (matrix[row][col] < target) low = mid + 1;
        //     else high = mid - 1;
        // }
        // return false;

        int n = matrix.size();
        int m = matrix[0].size();
        int left = 0;
        int right = n * m - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int a = mid / m;
            int b = (mid - a * m);
            if (matrix[a][b] == target) {
                return true;
            } else if (matrix[a][b] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
};
