// Time Complexity: O(m*n), Space Complexity: O(m*n)

class Optimization1A {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(grid[i][j] == '1'){
                    visitingIslands(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void visitingIslands(char[][] grid, int row, int col){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]=='0') return;
    
        grid[row][col] = '0';

        int[] rowOffsets = {-1, 1, 0, 0};
        int[] colOffsets = {0, 0, 1, -1};

        for(int i=0 ; i<4 ; i++){
            visitingIslands(grid, row+rowOffsets[i], col+colOffsets[i]);
        }
    }
}
