package GRAPH.DFS_AND_BFS.AAD_Cnt_No_of_Complete_Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Question link: https://leetcode.com/problems/count-the-number-of-complete-components/
 * Date: 03-07-2025
 * Time complexity: O(V + E), where V = number of vertices, E = number of edges — standard DFS traversal
 * Space complexity: O(V + E) for adjacency list + O(V) for visited array + O(V) for recursion stack
 */

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes (n): ");
        int n = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int m = sc.nextInt();

        int[][] edges = new int[m][2];
        System.out.println("Enter edges (u v): ");
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        int result = countCompleteComponents(n, edges);
        System.out.println("Number of complete components: " + result);

        sc.close();
    }

    private static int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0 ; i<n ; i++) adj.add(new ArrayList<>());

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // undirected graph
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i=0 ; i<n ; i++){
            if(!visited[i]){
                List<Integer> component = new ArrayList<>();
                dfs(i, adj, visited, component);

                int nodes = component.size();
                int edgeCount = 0;

                for(int node : component){
                    edgeCount += adj.get(node).size();
                }

                edgeCount /= 2;

                if(edgeCount == (nodes * (nodes - 1)) / 2){
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> component){
        visited[node] = true;
        component.add(node);

        for(int it: adj.get(node)){
            if(!visited[it]){
                dfs(it, adj, visited, component);
            }
        }
    }
}