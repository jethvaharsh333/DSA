// Time complexity: O(n!); Space complexity: O(n^2)
class Solution2 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i=0 ; i<n ; i++){
            for (int j=0 ; j<n; j++){
                board[i][j] = '.';
            }
        }
        solve(0, board, results, n);
        return results;
    }

    void solve(int row, char[][] board, List<List<String>> results, int n) {
        if(row == n){
            results.add(constructBoard(board));
            return;
        }
        for(int col=0 ; col<n ; col++){
            if(isSafe(row, col, board, n)){
                board[row][col] = 'Q';
                solve(row + 1, board, results, n); 
                board[row][col] = '.'; 
            }
        }
    }

    boolean isSafe(int row, int col, char[][] board, int n) {
        for(int i=0 ; i<row ; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        for (int i=row-1,j=col-1 ; i>=0&&j>=0 ; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        for (int i=row-1,j=col+1 ; i>=0&&j<n ; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    List<String> constructBoard(char[][] board) {
        List<String> currentList = new ArrayList<>();
        for(char[] row : board){
            currentList.add(new String(row));
        }
        return currentList;
    }
}
