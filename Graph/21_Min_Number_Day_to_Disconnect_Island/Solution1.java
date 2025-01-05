class Solution1 {
    public int minDays(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        if (isDisconnected(grid)) return 0;

        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    if (isDisconnected(grid)) return 1;
                    grid[i][j] = 1;
                }
            }
        }

        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    for(int x=0 ; x<m ; x++){
                        for(int y=0 ; y<n ; y++){
                            if(grid[x][y] == 1){
                                grid[x][y] = 0;
                                if (isDisconnected(grid)) return 2;
                                grid[x][y] = 1;
                            }
                        }
                    }
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }

    private void dfs(int[][] grid, boolean[][] visited, int i, int j){
        int m=grid.length, n=grid[0].length;
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==0 || visited[i][j]) return;

        visited[i][j] = true;
        dfs(grid, visited, i+1, j);
        dfs(grid, visited, i-1, j);
        dfs(grid, visited, i, j+1);
        dfs(grid, visited, i, j-1);
    }

    private boolean isDisconnected(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int components = 0;

        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    components++;
                    if(components > 1) return true;
                    dfs(grid, visited, i, j);
                }
            }
        }

        return components != 1;
    }
}
