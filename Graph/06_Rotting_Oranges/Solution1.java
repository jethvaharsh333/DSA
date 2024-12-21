// Time Complexity: O(m*n), Space Complexity: O(m*n)

class Solution1 {
    private int count = 0;
    public int orangesRotting(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
                else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }

        if(freshCount == 0){
            return 0;
        }

        int minutes = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisMinute = false;

            for(int i=0 ; i<size ; i++){
                int[] current = queue.poll();
                int row=current[0], col=current[1];

                for(int[] dir : directions){
                    int newRow = row+dir[0];
                    int newCol = col+dir[1];

                    if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && grid[newRow][newCol]==1){
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        freshCount--;
                        rottedThisMinute = true;
                    }
                }
            }

            if(rottedThisMinute){
                minutes++;
            }
        }

        return freshCount==0 ? minutes : -1;
    }
}
