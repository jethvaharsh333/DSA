package GRAPH.DFS_AND_BFS.AAC_Keys_And_Rooms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Question link: https://leetcode.com/problems/keys-and-rooms
 * Date: 03-07-2025
 * Time complexity: O(N + K), where N = number of rooms, K = total number of keys across all rooms
 * Space complexity: O(N) for visited array + O(N) for queue in worst case
 */

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rooms: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        List<List<Integer>> rooms = new LinkedList<>();
        System.out.println("Enter keys in each room (space-separated):");
        for (int i = 0; i < n; i++) {
            System.out.print("Room " + i + ": ");
            String[] keys = sc.nextLine().trim().split("\\s+");
            List<Integer> roomKeys = new LinkedList<>();
            for (String key : keys) {
                if (!key.isEmpty()) roomKeys.add(Integer.parseInt(key));
            }
            rooms.add(roomKeys);
        }

        boolean result = canVisitAllRooms(rooms);
        System.out.println("Can visit all rooms: " + result);

        sc.close();
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.offer(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            int room = q.poll();
            for (int key : rooms.get(room)) {
                if (!vis[key]) {
                    vis[key] = true;
                    q.offer(key);
                }
            }
        }

        for (boolean v : vis) {
            if (!v) return false;
        }

        return true;
    }
}