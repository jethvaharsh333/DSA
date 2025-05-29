// Time complexity: O(log(m)+log(n)); Space Complexity: O(n)
class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m=matrix.length, n=matrix[0].length;
        int left=0, right=m-1;
        System.out.println(m+","+n+" :: "+left+","+right);

        while(left < right){
            int mid = left + (right-left)/2;

            System.out.println("1: "+matrix[mid][n-1]+" :: "+mid);
            if(matrix[mid][n-1] == target){
                return true;
            } 
            else if(matrix[mid][n-1] > target){
                right = mid;
            }
            else{
                left = mid+1;
            }
            
            System.out.println("1: "+left+","+right);
        }

        int row = right;
        left = 0;
        right = n-1;
        while(left <= right){
            int mid = left + (right-left)/2;

            System.out.println("2: "+matrix[row][mid]+" :: "+mid);
            if(matrix[row][mid] == target){
                return true;
            }
            else if(matrix[row][mid] > target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }

            System.out.println("1: "+left+","+right);
        }

        return false;
    }
}
