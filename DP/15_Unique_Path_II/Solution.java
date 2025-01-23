// Time complexity: O(m*n), Space complexity: O(n)

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        return uniquePaths(m, n, obstacleGrid);
    }

    public int uniquePaths(int m, int n, int[][] obstacleGrid) {
        int[] prev = new int[n+1];

        for(int i=1 ; i<m+1 ; i++){
            int[] curr = new int[n+1];

            for(int j=0 ; j<n+1 ; j++){
                if(i==0 || j==0 || obstacleGrid[i-1][j-1] == 1){
                    curr[j] = 0;
                }else if(i==1 && j==1){
                    curr[j] = 1;
                }else{
                    curr[j] = prev[j] + curr[j-1];
                }
            }    

            prev = curr;
        }

        return prev[n];
    }
}
