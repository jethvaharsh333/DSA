// Time complexity: O(n²),  Space complexity: O(n)

class Solution1 {
    Set<Integer> seen = new HashSet();
    int MAX_EDGE_VAL = 1000;

    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[MAX_EDGE_VAL + 1];

        for(int i=0 ; i<=MAX_EDGE_VAL ; i++){
            graph[i] = new ArrayList();
        }

        for(int[] edge: edges){
            seen.clear();

            if(!graph[edge[0]].isEmpty() && !graph[edge[1]].isEmpty() && dfs(graph, edge[0], edge[1])){
                return edge;
            }

            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        throw new AssertionError();
    }

    private boolean dfs(ArrayList<Integer>[] graph, int source, int target){
        if(!seen.contains(source)){
            seen.add(source);
            
            if(source == target) return true;
            
            for(int neighbor: graph[source]){
                if(dfs(graph, neighbor, target)) return true;
            }
        }
        return false;
    }
}
