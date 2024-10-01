class Solution1 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] ans = new int[r][c];
        int m = mat.length, n = mat[0].length;
        
        if (m * n != r * c) {
            return mat;
        }
        
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[index / c][index % c] = mat[i][j];
                index++;
            }
        }

        return ans;
    }
}
