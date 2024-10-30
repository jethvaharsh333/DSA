// O(1)
class Solution1 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] squares = new HashSet[9];

        for (int i=0 ; i<9 ; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            squares[i] = new HashSet<>();
        }

        for(int r=0 ; r<9 ; r++){
            for(int c=0 ; c<9 ; c++){
                char num = board[r][c];
                if(num == '.') continue;

                int squareIndex = (r/3)*3 + c/3;
                if(rows[r].contains(num) || cols[c].contains(num) || squares[squareIndex].contains(num))
                    return false;

                rows[r].add(num);
                cols[c].add(num);
                squares[squareIndex].add(num);        
            }
        }

        return true;
    }
}
