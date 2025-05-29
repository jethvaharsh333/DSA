// Time Complexity: O(V+E), Space Complexity: O(V+E) [V = number of courses, E = number of prerequisites] (Kahn's Algorithm)
class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int v = numCourses;
        ArrayList<Integer>[] adj = new ArrayList[v];

        for(int i=0 ; i<v ; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] arr : prerequisites){
            int src = arr[0];
            int dest = arr[1];

            adj[dest].add(src);
        }

        int[] visited = new int[v];

        for(int i=0 ; i<v ; i++){
            if(visited[i] == 0){
                if(!dfs(adj,visited,i)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(ArrayList<Integer>[] adj, int visited[], int curr){
        if(visited[curr] == 2){
            return true;
        }
        if(visited[curr] == 1){
            return false;
        }
        visited[curr]=1;
        
        for(int i=0; i<adj[curr].size() ; i++){
            int x = adj[curr].get(i);

            if(visited[x] != 2){
                if(!dfs(adj,visited,x)){
                    return false;
                }
            }
        }

        visited[curr] = 2;
        return true;
    }
}
