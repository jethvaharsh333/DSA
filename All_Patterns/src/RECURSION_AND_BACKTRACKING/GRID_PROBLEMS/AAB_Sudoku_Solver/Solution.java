package RECURSION_AND_BACKTRACKING.GRID_PROBLEMS.AAB_Sudoku_Solver;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/sudoku-solver/
 * Date: 20-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    private static final int GRID_SIZE = 9;

    public void solveSudoku(char[][] board) {
        solveBoard(board);
    }

    public boolean solveBoard(char[][] board) {
        for(int row=0 ; row<GRID_SIZE ; row++){
            for(int col=0 ; col<GRID_SIZE ; col++){
                if(board[row][col] == '.'){
                    for(int numToTry=1 ; numToTry<=GRID_SIZE ; numToTry++){
                        char number = (char) (numToTry + '0');
                        if(isValidPlacement(board, number, row, col)){
                            board[row][col] = number;

                            if(solveBoard(board)){
                                return true;
                            }
                            else{
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidPlacement(char[][] board, char number, int row, int col){
        return !isNumInRow(board, number, row) &&
                !isNumInCol(board, number, col) &&
                !isNumInSquare(board, number, row, col);
    }

    private boolean isNumInRow(char[][] board, char number, int row){
        for(int i=0 ; i<GRID_SIZE ; i++){
            if(board[row][i] == number) return true;
        }
        return false;
    }

    private boolean isNumInCol(char[][] board, char number, int col){
        for(int i=0 ; i<GRID_SIZE ; i++){
            if(board[i][col] == number) return true;
        }
        return false;
    }

    private boolean isNumInSquare(char[][] board, char number, int row, int col){
        int squareStartRow = row - row%3;
        int squareStartColumn = col - col%3;
        for(int r=squareStartRow ; r<squareStartRow+3 ; r++){
            for(int c=squareStartColumn ; c<squareStartColumn+3 ; c++){
                if(board[r][c] == number){
                    return true;
                }
            }
        }
        return false;
    }


}