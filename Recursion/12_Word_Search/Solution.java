// Time complexity: O(m*n*4^l); Space complexity: O(l)
class Solution {
    public boolean exist(char[][] board, String word) { 
        for(int i=0 ; i<board.length ; i++){
            for(int j=0 ; j<board[0].length ; j++){
                if(board[i][j]==word.charAt(0) && search(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, int i, int j, String word, int index){
        if(i >=  board.length || i < 0 || j >=  board[0].length || j<0 || board[i][j] !=word.charAt(index)) return false;

        if(word.length() == index) return true;

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = search(board, i+1, j, word, index+1) ||
                        search(board, i-1, j, word, index+1) ||
                        search(board, i, j+1, word, index+1) ||
                        search(board, i, j-1, word, index+1);

        board[i][j] = temp;

        return found;
    }
}
