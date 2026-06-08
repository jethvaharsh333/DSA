package Graph.G10;

// 2 graphs F and G. Make F identical to G

import java.util.*;

public class Main{
    static List<List<Integer>> adjF;
    static List<List<Integer>> adjG;
    static boolean[] visited;
    static int[] nodeCompNumG;   // Each Node component number

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int z = sc.nextInt();

        for(int x=0 ; x<z ; x++){
            int n = sc.nextInt();
            int m1 = sc.nextInt();
            int m2 = sc.nextInt();

            adjF = new ArrayList<>();
            adjG = new ArrayList<>();

            for(int i=0 ; i<n ; i++){
                adjF.add(new ArrayList<>());
                adjG.add(new ArrayList<>());
            }

            for(int i=0 ; i<m1 ; i++){
                int u = sc.nextInt()-1;
                int v = sc.nextInt()-1;

                adjF.get(u).add(v);
                adjF.get(v).add(u);
            }

            for(int i=0 ; i<m2 ; i++){
                int u = sc.nextInt()-1;
                int v = sc.nextInt()-1;

                adjG.get(u).add(v);
                adjG.get(v).add(u);
            }

            // STEP 1: Components of G
            // Got node's component number, total components
            nodeCompNumG = new int[n];
            Arrays.fill(nodeCompNumG, -1);
            int compId = 0;

            for(int i=0 ; i<n ; i++){
                if(nodeCompNumG[i] == -1){
                    dfsG(i, compId);
                    compId++;
                }
            }

            // STEP 2: Count removals
            int removals = 0;
            for(int node=0; node<n ; node++){
                for(int neigh: adjF.get(node)){
                    // If we don't add this 'node<neigh' in code then removal will be count twice
                    if(node<neigh && nodeCompNumG[node]!=nodeCompNumG[neigh]){
                        removals++;
                    }
                }
            }

            // STEP 3: Count additions
            visited = new boolean[n];
            int additions = 0;

            for(int compNum=0 ; compNum<compId ; compNum++){
                int parts = 0;
                for(int node=0 ; node<n ; node++){
                    if(nodeCompNumG[node] == compNum && !visited[node]){
                        dfsF(node, compNum);
                        parts++;
                    }
                }

                additions += Math.max(0, parts - 1);
            }

            System.out.println(removals + additions);
        }
    }

//    private static void dfsG(int node, int compId){
//        nodeCompNumG[node] = compId;
//
//        for(int neighbor: adjG.get(node)){
//            if(nodeCompNumG[neighbor] == -1){
//                dfsG(neighbor, compId);
//            }
//        }
//    }

//    private static void dfsF(int node, int compNum) {
//        visited[node] = true;
//        for (int nei : adjF.get(node)) {
//            if (!visited[nei] && nodeCompNumG[nei] == compNum) {
//                dfsF(nei, compNum);
//            }
//        }
//    }

    static void dfsG(int start, int compId) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        nodeCompNumG[start] = compId;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int nei : adjG.get(node)) {
                if (nodeCompNumG[nei] == -1) {
                    nodeCompNumG[nei] = compId;
                    stack.push(nei);
                }
            }
        }
    }


    static void dfsF(int start, int compNum) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int nei : adjF.get(node)) {
                if (!visited[nei] && nodeCompNumG[nei] == compNum) {
                    visited[nei] = true;
                    stack.push(nei);
                }
            }
        }
    }
}
