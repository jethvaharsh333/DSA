package GRAPH.DFS_AND_BFS.AAB_Find_If_Path_Exist;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/find-if-path-exists-in-graph
 * Date: 03-07-2025
 * Time complexity: O(V + E) — We visit each node and each edge once.
 * Space complexity: O(V + E) for adjacency list + O(V) for visited array + O(V) for BFS queue
 */

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes (n): ");
        int n = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int m = sc.nextInt();

        int[][] edges = new int[m][2];
        System.out.println("Enter the edges (u v): ");
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        System.out.print("Enter source node: ");
        int source = sc.nextInt();

        System.out.print("Enter destination node: ");
        int destination = sc.nextInt();

        boolean result = validPath(n, edges, source, destination);
        System.out.println("Path exists from source to destination: " + result);

        sc.close();
    }


    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0 ; i<n ; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);

        while(!queue.isEmpty()){
            int node = queue.poll();
            if(node == destination) return true;

            for(Integer it: adj.get(node)){
                if(!visited[it]){
                    visited[it] = true;
                    queue.add(it);
                }
            }
        }

        return false;
    }

}