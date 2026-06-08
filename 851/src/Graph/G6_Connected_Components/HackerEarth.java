package Graph.G6_Connected_Components;

import java.util.Scanner;
import java.util.ArrayList;

public class HackerEarth {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // My error i don't use "-1". We have to do it for 0-based indexing we have used.
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}
