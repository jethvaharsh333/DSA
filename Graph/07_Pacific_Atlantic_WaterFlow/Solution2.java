// Time Complexity: O(m*n), Space Complexity: O(m*n + d) [d=stack depth]

class Solution2 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows=heights.length, cols=heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        
        for(int col=0 ; col<cols ; col++){
            dfs(0, col, rows, cols, pacific, heights[0][col], heights);
            dfs(rows-1, col,rows, cols, atlantic, heights[rows-1][col], heights);
        }

        for (int row = 0; row<rows; row++){
            dfs(row, 0,rows, cols, pacific, heights[row][0], heights);
            dfs(row, cols-1,rows, cols, atlantic, heights[row][cols-1], heights);
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i=0 ; i<rows ; i++){
            for (int j=0 ; j<cols ; j++){
                if(pacific[i][j] && atlantic[i][j]) result.add(Arrays.asList(i,j));
            }
        }

        return result;
    }
    private void dfs(int row, int col, int rows, int cols, boolean[][] visited, int prevHeight, int[][] heights){
        if (row<0 || row>=rows || col<0 || col>=cols || visited[row][col] || prevHeight>heights[row][col]) return;
        
        visited[row][col]= true;
        dfs(row+1, col, rows, cols, visited, heights[row][col], heights);
        dfs(row-1, col, rows, cols, visited, heights[row][col], heights);
        dfs(row, col+1, rows, cols, visited, heights[row][col], heights);
        dfs(row, col-1, rows, cols, visited, heights[row][col], heights);
    }
}"
