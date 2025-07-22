package RECURSION_AND_BACKTRACKING.GRID_PROBLEMS.AAA_Rat_in_Maze_Problem;

import java.util.*;

/**
 * Question link: https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
 * Date: 20-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    // Function to find all possible paths
    public static ArrayList<String> ans = new ArrayList<>();
    public void dfs(int[][] maze,int i,int j, StringBuilder str,int[][] visited){
        if( i < 0 || j < 0 || i >= maze.length || j >= maze[0].length || maze[i][j] == 0 || visited[i][j] == 1){
            return;
        }
        if(i == maze.length - 1 && j == maze[0].length - 1){
            ans.add(str.toString());
            return;
        }
        visited[i][j] = 1;
        dfs(maze,i+1,j,str.append("D"),visited);
        str.deleteCharAt(str.length()-1);
        dfs(maze,i,j-1,str.append("L"),visited);
        str.deleteCharAt(str.length()-1);
        dfs(maze,i,j+1,str.append("R"),visited);
        str.deleteCharAt(str.length()-1);
        dfs(maze,i-1,j,str.append("U"),visited);
        str.deleteCharAt(str.length()-1);
        visited[i][j] = 0;
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ans = new ArrayList();
        int visited[][] = new int[maze.length][maze[0].length];
        StringBuilder str = new StringBuilder("");
        if(maze[0][0] == 0){
            return new ArrayList<String>();
        }
        else{
            dfs(maze,0,0,str,visited);
            return ans;
        }

    }
}