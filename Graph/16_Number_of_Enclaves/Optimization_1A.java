//  Time Complexity: O(m*n), Space Complexity: O(1)

class Optimization_1A {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for(int j=0 ; j<cols ; j++){
            if(grid[0][j] == 1){
                dfs(grid, 0, j);
            }
        }

        for(int i=1 ; i<rows ; i++){
            if(grid[i][cols-1] == 1){
                dfs(grid, i, cols-1);
            }
        }

        for(int j=cols-2 ; j>=0 ; j--){
            if(grid[rows-1][j] == 1){
                dfs(grid, rows-1, j);
            }
        }

        for(int i=rows-2 ; i>0 ; i--){
            if(grid[i][0] == 1){
                dfs(grid, i, 0);
            }
        }

        int count = 0;
        for(int i=0 ; i<rows ; i++){
            for(int j=0 ; j<cols ; j++){
                count += grid[i][j];
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int row, int col){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]==0) return;

        grid[row][col] = 0;

        dfs(grid, row-1, col);
        dfs(grid, row, col-1);
        dfs(grid, row+1, col);
        dfs(grid, row, col+1);

        return;
    }
}
