package Graph.G13;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();

        System.out.println(shortestSteps(a, b));
    }
    private static int shortestSteps(String a, String b){
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();

        List<List<Integer>> adj = new ArrayList<>();

        Set<Character> set = new HashSet<>();
        for(char ch: charsA) set.add(ch);
        for(char ch: charsB) set.add(ch);

        Map<Character, Integer> id = new HashMap<>();
        int idx = 0;
        for (char ch : set) {
            id.put(ch, idx++);
        }

        int nodes = set.size();

        for(int i=0 ; i<nodes ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0 ; i<charsA.length ; i++){
            if(charsA[i] > charsB[i]) return -1;

            char u = charsA[i];
            char v = charsB[i];

            int ui = id.get(u);
            int vi = id.get(v);

            adj.get(ui).add(vi);
            adj.get(vi).add(ui);
        }

        boolean[] visited = new boolean[nodes];
        int size = 0;
        for(int i=0 ; i<nodes ; i++){
            if(!visited[i]){
                size += (dfs(adj, visited, i) - 1);
            }
        }

        return size;
    }

    private static int dfs(List<List<Integer>> adj, boolean[] visited, int index){
        visited[index] = true;
        int size = 1; // count this node in

        for(int neighbor: adj.get(index)){
            if(!visited[neighbor]){
                size += dfs(adj, visited, neighbor);
            }
        }

        return size;
    }
}