package Graph.G12;
import java.util.*;

public class Main {
    static int[][] direction = {{-1,0}, {1,0}, {0,-1}, {0,1}};

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

        int[][] comp = new int[m][n];
        for (int[] row : comp) Arrays.fill(row, -1);

        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(matrix[i][j]=='#' && comp[i][j]==-1){
                    sizeOfComponentNumber[componentNumber] =
                            dfs(matrix, comp, componentNumber, i, j);
                    componentNumber++;
                }
            }
        }

        int maxSize = 0;

        // Each row
        for(int i=0 ; i<m ; i++){
            Set<Integer> seen = new HashSet<>();
            int size = 0;

            // current
            for(int j=0 ; j<n ; j++){
                if(matrix[i][j]!='.') seen.add(comp[i][j]);
                else size++;
            }

            //previous
            if(i-1 >= 0){
                for(int j=0 ; j<n ; j++){
                    if (matrix[i-1][j] != '.') seen.add(comp[i-1][j]);
                }
            }

            //next
            if(i+1 < m){
                for(int j=0 ; j<n ; j++){
                    if (matrix[i+1][j] != '.') seen.add(comp[i+1][j]);
                }
            }

            for(int compNum: seen) size += sizeOfComponentNumber[compNum];
            maxSize = Math.max(maxSize, size);
        }

        // Each column
        for(int j=0 ; j<n ; j++){
            Set<Integer> seen = new HashSet<>();
            int size = 0;

            // current
            for(int i=0 ; i<m ; i++){
                if(matrix[i][j]!='.') seen.add(comp[i][j]);
                else size++;
            }

            //previous
            if(j-1 >= 0){
                for(int i=0 ; i<m ; i++){
                    if (matrix[i][j-1] != '.') seen.add(comp[i][j-1]);
                }
            }

            //next
            if(j+1 < n){
                for(int i=0 ; i<m ; i++){
                    if (matrix[i][j+1] != '.') seen.add(comp[i][j+1]);
                }
            }

            for(int compNum: seen) size += sizeOfComponentNumber[compNum];
            maxSize = Math.max(maxSize, size);
        }

        return maxSize;
    }

    private static int dfs(char[][] matrix, int[][] comp,
                           int componentNumber, int startX, int startY){

        int size = 0;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startX, startY});
        comp[startX][startY] = componentNumber;

        while(!stack.isEmpty()){
            int[] cur = stack.pop();
            int m = cur[0];
            int n = cur[1];
            size++;

            for(int[] dir : direction){
                int x = m + dir[0];
                int y = n + dir[1];

                if(x>=0 && x<matrix.length &&
                        y>=0 && y<matrix[0].length &&
                        matrix[x][y]=='#' &&
                        comp[x][y]==-1){

                    comp[x][y] = componentNumber;
                    stack.push(new int[]{x, y});
                }
            }
        }

        return size;
    }
}
