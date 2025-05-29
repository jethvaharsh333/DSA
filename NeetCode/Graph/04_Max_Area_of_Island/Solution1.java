// Time Complexity: O(m*n), Space Complexity: O(m*n)

class Solution1 {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;

        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, visitingIslands(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    private int visitingIslands(int[][] grid, int row, int col){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]==0) return 0;
    
        grid[row][col] = 0;

        int area = 1;
        area += visitingIslands(grid, row-1, col);
        area += visitingIslands(grid, row+1, col);
        area += visitingIslands(grid, row, col-1);
        area += visitingIslands(grid, row, col+1);

        return area;
    }
}
