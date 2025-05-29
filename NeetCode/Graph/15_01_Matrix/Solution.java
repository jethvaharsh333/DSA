// Time Complexity: O(m*n), Space Complexity: O(m*n)
class Solution {
    class Triple{
        int _row;
        int _col;
        int _count;

        Triple(int row, int col, int count){
            _row = row;
            _col = col;
            _count = count;
        }

        public int getRow(){
            return _row;
        }

        public int getCol(){
            return _col;
        }

        public int getCount(){
            return _count;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length, n=mat[0].length;

        Queue<Triple> queue = new LinkedList<>();
        int[][] result = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(mat[i][j] == 0){
                    visited[i][j] = true;
                    queue.add(new Triple(i, j, 0));
                }else{
                    visited[i][j] = false;
                }
            }
        }

        int[] r = {-1, 1, 0, 0};
        int[] c = {0, 0, -1, 1};

        while(!queue.isEmpty()){
            Triple tri = queue.poll();
            int row = tri.getRow();
            int col = tri.getCol();
            int count = tri.getCount();

            result[row][col] = count;

            for(int i=0 ; i<4 ; i++){
                int newRow = row + r[i];
                int newCol = col + c[i];

                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && !visited[newRow][newCol]){
                    visited[newRow][newCol] = true;
                    queue.add(new Triple(newRow, newCol, count+1));
                }
            }
        }

        return result;
    }
}
