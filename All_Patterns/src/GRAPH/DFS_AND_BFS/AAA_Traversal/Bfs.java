package GRAPH.DFS_AND_BFS.AAA_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 03-07-2025
 * Time complexity: O(V+E) => loop over each node(Vertex) once and traverse its adjacency list(Edges).
 * Space complexity: O(V)
 */

public class Bfs {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        /*
                      0
                     / \
                    1   4
                   / \
                  2   3
        **/

        Bfs sl = new Bfs();
        ArrayList<Integer> ans = sl.bfsOfGraph(5, adj);

        for(Integer an : ans){
            System.out.print(an + " ");
        }
    }

    private ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0] = true;

        while(!queue.isEmpty()){
            Integer node = queue.poll();
            bfs.add(node);

            for(Integer it: adj.get(node)){
                if(!visited[it]){
                    visited[it] = true;
                    queue.add(it);
                }
            }
        }

        return bfs;
    }

}