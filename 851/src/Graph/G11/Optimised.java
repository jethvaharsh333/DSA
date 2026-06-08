package Graph.G11;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


class Optimsed {
    static int[][] direction = {
            {-1,0}, {1,0}, {0,-1}, {0,1}
    };

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        while(x-- > 0){
            int m = sc.nextInt();
            int n = sc.nextInt();

            char[][] matrix = new char[m][n];

            for(int i=0 ; i<m ; i++){
                matrix[i] = sc.next().toCharArray();
            }

            System.out.println(maximizes(matrix, m, n));
        }
    }

    private static int maximizes(char[][] matrix, int m, int n){
        int componentNumber = 0;
        int[] sizeOfComponentNumber = new int[m*n];

        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(matrix[i][j]=='.'){
                    sizeOfComponentNumber[componentNumber] = dfs(matrix, componentNumber, i, j);
                }
            }
        }

        int maxSize = Integer.MIN_VALUE;

        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(matrix[i][j] == '#'){
                    int size = 0;
                    Set<Integer> set = new HashSet<>();

                    for(int[] dir: direction){
                        int x = i + dir[0];
                        int y = j + dir[1];

                        if(x>=0 && x<m && y>=0 && y<n && matrix[x][y]=='.'){
                            set.add(matrix[x][y]-'0');
                        }

                        for(int k: set){
                            size += sizeOfComponentNumber[k];
                        }

                        maxSize = Math.max(maxSize, size);
                    }
                }
            }
        }

        return maxSize + 1; // +1 for '#' joined
    }

    private static int dfs(char[][] matrix, int componentNumber, int m, int n){
        matrix[m][n] = (char)(componentNumber+'0');
        int size = 0;

        for(int[] dir: direction){
            int x = m + dir[0];
            int y = n + dir[1];

            if(x>=0 && x<m && y>=0 && y<n && matrix[x][y]=='.'){
                size += dfs(matrix, componentNumber, x, y);
            }
        }

        return size;
    }
}
