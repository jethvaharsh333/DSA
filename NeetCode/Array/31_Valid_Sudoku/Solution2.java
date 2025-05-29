// O(1) [OPTIMAL SOLUTION]
class Solution2 {
    public boolean isValidSudoku(char[][] board) {
       boolean[][] rows = new boolean[9][9];
       boolean[][] cols = new boolean[9][9];
       boolean[][] squares = new boolean[9][9];

        for(int r=0 ; r<9 ; r++){
            for(int c=0 ; c<9 ; c++){
                char curr = board[r][c];
                if(curr != '.'){
                    int num = curr-'1';
                    int squareIndex = (r/3)*3+(c/3);
                    if(rows[r][num] || cols[c][num] || squares[squareIndex][num]){
                        return false;
                    }

                    rows[r][num] = true;
                    cols[c][num] = true;
                    squares[squareIndex][num] = true;
                }
            }
        }

        return true;
    }
}
