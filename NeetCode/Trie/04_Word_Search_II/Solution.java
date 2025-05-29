// Time Complexity: O(n*m*4^Lmax + L), Space Complexity: O(L+Lmax)
class Solution {
    class Trie{
        Trie[] links = new Trie[26];
        String word = null;
    }

    private Trie buildTrie(String[] words){
        Trie root = new Trie();

        for(String str: words){
            Trie node = root;
            for(char ch: str.toCharArray()){
                int index = ch-'a';
                if(node.links[index] == null){
                    node.links[index] = new Trie();
                }
                node = node.links[index];
            }
            node.word = str;
        }

        return root;
    }

    private void backtrack(char[][] board, int row, int col, Trie node, List<String> result){
        char ch = board[row][col];

        if(ch=='#' || node.links[ch-'a']==null){
            return;
        }

        node = node.links[ch-'a'];

        if(node.word != null){
            result.add(node.word);
            node.word = null;
        }

        board[row][col] = '#';

        int[] rowOffsets = {-1, 1, 0, 0};
        int[] colOffsets = {0, 0, -1, 1};

        for(int i=0 ; i<4 ; i++){
            int newRow = row + rowOffsets[i];
            int newCol = col + colOffsets[i];

            if(newRow>=0 && newRow<board.length && newCol>=0 && newCol<board[0].length){
                backtrack(board, newRow, newCol, node, result);
            }
        }

        board[row][col] = ch;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = buildTrie(words);
        List<String> result = new ArrayList<>();

        for(int row=0 ; row<board.length ; row++){
            for(int col=0 ; col<board[0].length ; col++){
                backtrack(board, row, col, root, result);
            }
        }

        return result;
    }
}
