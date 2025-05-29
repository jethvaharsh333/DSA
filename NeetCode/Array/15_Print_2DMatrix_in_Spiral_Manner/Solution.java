// Time complexity: O(m.n); Space Complexity: O(m.n)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> li = new ArrayList<>();
        if(matrix.length == 0){
            return li;
        }

        int rowStart = 0, rowEnd = matrix.length-1;
        int colStart = 0, colEnd = matrix[0].length-1;
        
        while(rowStart <= rowEnd && colStart <= colEnd){
            for(int j=colStart ; j<=colEnd ; j++){
                li.add(matrix[rowStart][j]);
            }
            rowStart++;

            for(int i=rowStart ; i<=rowEnd ; i++){
                li.add(matrix[i][colEnd]);
            }
            colEnd--;
            
            if(rowStart <= rowEnd){
                for(int i=colEnd ; i>=colStart ; i--){
                    li.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if(colStart <= colEnd){
                for (int j=rowEnd ; j>=rowStart ; j--) {
                    li.add(matrix[j][colStart]);
                }
            }
            colStart++;
        }

        return li;
    }
}
