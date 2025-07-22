package RECURSION_AND_BACKTRACKING.COMBINATION.AAK_N_Queens;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/n-queens
 * Date: 23-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution1 {
    private static HashSet col = new HashSet<>();
    private static HashSet diag45 = new HashSet<>();
    private static HashSet diag135 = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        genQueen(n, 0, new ArrayList<>(), result);
        return result;
    }

    private void genQueen(int n, int r, List<String> currentList, List<List<String>> result){
        if(r == n){
            result.add(new ArrayList<>(currentList));
            return;
        }

        for(int colIndex=0 ; colIndex<n ; colIndex++){
            if(!col.contains(colIndex) && !diag45.contains(r-colIndex) && !diag135.contains(r+colIndex)){
                col.add(colIndex); diag45.add(r-colIndex); diag135.add(r+colIndex);
                char[] rowArray = new char[n];
                Arrays.fill(rowArray, '.');
                rowArray[colIndex] = 'Q';
                currentList.add(new String(rowArray));

                genQueen(n, r+1, currentList, result);

                currentList.remove(currentList.size()-1);
                col.remove(colIndex); diag45.remove(r-colIndex); diag135.remove(r+colIndex);
            }
        }
    }
}