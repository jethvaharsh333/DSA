package GRAPH.DFS_AND_BFS.AAC_Keys_And_Rooms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Question link: https://leetcode.com/problems/keys-and-rooms
 * Date: 03-07-2025
 * Time complexity: O(N + K), where N = number of rooms, K = total number of keys across all rooms
 * Space complexity: O(N) for visited array + O(N) recursion stack in worst case
 */

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rooms: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        List<List<Integer>> rooms = new ArrayList<>();

        System.out.println("Enter keys in each room (space-separated integers):");
        for (int i = 0; i < n; i++) {
            System.out.print("Room " + i + ": ");
            String[] line = sc.nextLine().trim().split("\\s+");
            List<Integer> keys = new ArrayList<>();
            for (String val : line) {
                if (!val.equals("")) keys.add(Integer.parseInt(val));
            }
            rooms.add(keys);
        }

        boolean result = canVisitAllRooms(rooms);
        System.out.println("Can visit all rooms: " + result);

        sc.close();
    }


    private static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];

        dfs(0, vis, rooms);

        for(boolean ans: vis)
            if(!ans)
                return false;

        return true;
    }

    private static void dfs(int n, boolean[] vis, List<List<Integer>> rooms) {
        vis[n] = true;

        for(Integer i: rooms.get(n)){
            if(!vis[i]){
                dfs(i, vis, rooms);
            }
        }
    }
}