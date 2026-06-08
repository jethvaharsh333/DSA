package Graph.G6_Connected_Components;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private int findNoOfComponentsWithBfs(ArrayList<ArrayList<Integer>> adj){
        int count = 0;
        boolean[] visited = new boolean[adj.size()];

        for(int i=0 ; i<adj.size() ; i++){
            if(!visited[i]) {
                bfs(i, adj, visited);
                count++;
            }
        }

        return count;
    }

    // TC: O(V+E), SC: O(V)
    private void bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true; // O(V) - TC

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int neighbor: adj.get(node)){  // O(E) - TC
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);    // O(V) - SC
                }
            }
        }
    }
}
