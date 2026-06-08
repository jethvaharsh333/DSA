package Graph.GX;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        while(x-- > 0){
            int n = sc.nextInt();

            int[] a = new int[n];
            for(int i=0 ; i<n ; i++){
                a[i] = sc.nextInt()-1;
            }

            int[] c = new int[n];
            for(int i=0 ; i<n ; i++){
                c[i] = sc.nextInt();
            }

            List<Integer> permutation = findMaxCost(n, a, c);

            for(int num: permutation) System.out.print((num + 1) + " ");
            System.out.println();
        }
    }

    private static List<Integer> findMaxCost(int n, int[] a, int[] c){
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0 ; i<n ; i++) graph.add(new ArrayList<>());

        for(int i=0 ; i<n ; i++){
            graph.get(i).add(a[i]);
        }

        // topoSort
        int[] inDegree = new int[n];
        for(int node=0 ; node<n ; node++){
            for(int neigh: graph.get(node)){
                inDegree[neigh]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ; i<n ; i++){
            if(inDegree[i] == 0) queue.offer(i);
        }

        List<Integer> result = new ArrayList<>();
        boolean[] removed = new boolean[n];
        while(!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);
            removed[node] = true;

            for(int neigh: graph.get(node)){
                if(--inDegree[neigh] == 0) queue.add(neigh);
            }
        }

        boolean[] visited = new boolean[n];

        for(int node=0 ; node<n ; node++){
            if(removed[node] || visited[node]) continue;

            List<Integer> cyclic = new ArrayList<>();
            int currNode = node;

            while(!visited[currNode]){
                visited[currNode] = true;
                cyclic.add(currNode);
                currNode = a[currNode];
            }

            int minNode = cyclic.get(0);
            for(int v: cyclic){
                if(c[v] < c[minNode]) minNode = v;
            }

            boolean start = false;
            for(int v: cyclic){
                if(start) result.add(v);
                if(v == minNode) start = true;
            }
            for(int v: cyclic){
                if(v == minNode) break;
                result.add(v);
            }

            result.add(minNode);
        }

        return result;
    }
}
