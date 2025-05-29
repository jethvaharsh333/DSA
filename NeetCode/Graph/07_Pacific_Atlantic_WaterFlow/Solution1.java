// Time Complexity: O(m*n), Space Complexity: O(m*n)

class Solution1 {
    private static final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new LinkedList<>();
        int n=heights.length, m=heights[0].length;
        
        if(heights==null || n==0 || m==0){
            return res;
        }
        
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        
        for(int i=0 ; i<n ; i++){
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, m-1});
            pacific[i][0] = true;
            atlantic[i][m-1] = true;
        }

        for(int j=0 ; j<m ; j++){
            pQueue.offer(new int[]{0, j});
            aQueue.offer(new int[]{n-1, j});
            pacific[0][j] = true;
            atlantic[n-1][j] = true;
        }

        bfs(heights, pQueue, pacific);
        bfs(heights, aQueue, atlantic);

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }


        return res;
    }

    public void bfs(int[][]heights, Queue<int[]> queue, boolean[][]visited){
        int n=heights.length, m=heights[0].length;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int[] d : dir){
                int x = cur[0]+d[0];
                int y = cur[1]+d[1];
                if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || heights[x][y] < heights[cur[0]][cur[1]]){
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            } 
        }
    }
}
