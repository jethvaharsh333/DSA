package Graph.G6_Connected_Components;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    private int findNoOfComponentsWithBfs(ArrayList<ArrayList<Integer>> adj){
        int count = 0;
        boolean[] visited = new boolean[adj.size()];
        List<Integer> totalComponentAtI = new ArrayList<>();

        int totalConnected = 0;
        for(int i=0 ; i<adj.size() ; i++){
            if(!visited[i]) {
                dfs(i, adj, visited, totalConnected);

                totalComponentAtI.add(totalConnected);
                count++;
                totalConnected = 0;
            }
        }

        return count;
    }

    // TC: O(V+E), SC: O(V)
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int totalConnected){     // O(V) - SC
        visited[node] = true; // O(V) - TC

        for(int neighbor: adj.get(node)){ // O(E) - TC
            if(!visited[neighbor]) dfs(neighbor, adj, visited, totalConnected);
        }

        return;
    }
}
