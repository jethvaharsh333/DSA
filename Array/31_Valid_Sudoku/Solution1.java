// O(n)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] squares = new HashSet[9];

        for (int i=0 ; i<9 ; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            squares[i] = new HashSet<>();
        }

        for(int r=0 ; r<board[0].length ; r++){
            for(int c=0 ; c<board[0].length ; c++){
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
