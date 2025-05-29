// Time Complexity: O(n*(max-min)), Space Complexity: O(1)

class Solution3 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left=matrix[0][0], right=matrix[n - 1][n - 1];

        while(left < right){
            int mid = left + (right-left)/2;

            if(countLessEqual(matrix, mid, n) < k){
                left = mid + 1;
            } 
            else{
                right = mid;
            }
        }

        return left;
    }

    private int countLessEqual(int[][] matrix, int target, int n) {
        int count=0, row=n-1, col=0;

        while(row>=0 && col<n){
            if(matrix[row][col] <= target){
                count += (row+1);
                col++;
            } 
            else{
                row--;
            }
        }

        return count;
    }
}
