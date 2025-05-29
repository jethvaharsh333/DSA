// Time Complexity: O(m*n), Space Complexity: O(m*n + m+n) 

class Solution3 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> out = new ArrayList<>();
        int rLen = heights.length;
        int cLen = heights[0].length;

        int[][] visited = new int[rLen][cLen];
        for (int r = 0; r < rLen; r++) {
            dfs(out,visited,heights,r,0,0,1);
            dfs(out,visited,heights,r,cLen-1,0,2);
        }
        for (int c = 0; c < cLen; c++) {
            dfs(out,visited,heights,0,c,0,1);
            dfs(out,visited,heights,rLen-1,c,0,2);
        }

        return out;
    }

    public void dfs(List<List<Integer>> out, int[][] seen, int[][] grid, int currX, int currY, int prevHeight,int mark) {
        
        if (currX < 0 || currY < 0 || currX >= grid.length || currY >= grid[0].length) {
            return;
        }
        if (grid[currX][currY] < prevHeight) return;
        if (seen[currX][currY] == 3 || seen[currX][currY] == mark) return;
        seen[currX][currY]+=mark;
        if (seen[currX][currY] == 3) {
            out.add(Arrays.asList(currX,currY));
        }
        
        dfs(out,seen,grid,currX+1,currY, grid[currX][currY],mark);
        dfs(out,seen,grid,currX-1,currY, grid[currX][currY],mark);
        dfs(out,seen,grid,currX,currY+1, grid[currX][currY],mark);
        dfs(out,seen,grid,currX,currY-1, grid[currX][currY],mark);
    }
}
