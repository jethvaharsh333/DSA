// Time complexity: O(log(m*n)); Space Complexity: O(1); OPTIMAL SOLUTION
class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m*n-1;

        while (left <= right) {
            System.out.println("1 ==> "+left+","+right+" :: "+m+","+n);
            int mid = left + (right-left)/2;
            int midValue = matrix[mid/n][mid%n]; // Convert mid to 2D indices

            if(midValue == target){
                return true;
            } 
            else if(midValue < target){
                left = mid+1;
            } 
            else{
                right = mid-1;
            }   

            System.out.println("2 ==> "+left+","+right+" :: "+m+","+n+" :: "+mid+","+midValue);
        }

        return false;
    }
}
