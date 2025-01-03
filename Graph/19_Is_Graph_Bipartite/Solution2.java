// Time Complexity: O(v+e), Space Complexity: O(v)

class Solution2 {
    public boolean isBipartite(int[][] graph) {
        int[] vis = new int[graph.length];
        for(int i=0 ; i<graph.length ; i++){
            if(vis[i] == 0){
                if(dfs(graph,i,vis,1) == false){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int[][] graph,int src,int[] vis,int color){
        vis[src] = color;

        for(Integer i : graph[src]){
            if(vis[i] == 0){
                if(color == 1){
                    if(dfs(graph,i,vis,2) == false) return false;
                }
                else{
                    if(dfs(graph,i,vis,1) == false) return false;
                }
            }
            else{
                if(vis[i] == vis[src]){
                    return false;
                }
            }
        }
        
        return true;
    }
}
