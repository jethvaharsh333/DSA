// Time Complexity: O(v+e), Space Complexity: O(v) [v = number of nodes, e = number of edges]

class Solution2 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int len = graph.length;
        int[] visited = new int[len];
        int[] pathVisited = new int[len];
        int[] check = new int[len];


        for(int i=0 ; i<len ; i++){
            if(visited[i]==0){
                dfsCheck(i, graph, visited, pathVisited, check);
            }
        }

        List<Integer> li = new ArrayList<>();
        for(int i=0 ; i<len ; i++){
            if(check[i] == 1){
                li.add(i);
            }
        }

        return li;
    }

    private boolean dfsCheck(int node, int[][] graph, int[] visited, int[] pathVisited, int[] check){
        if(visited[node] == 1){
            return pathVisited[node] == 1;
        }
        
        visited[node] = 1;
        pathVisited[node] = 1;
        check[node] = 0;

        for(int neighbor : graph[node]){
            if(visited[neighbor] == 0){
                if(dfsCheck(neighbor, graph, visited, pathVisited, check) == true)
                    return true;
            }
            else if(pathVisited[neighbor] == 1)
                return true;
        }

        check[node] = 1;
        pathVisited[node] = 0;

        return false;
    }
}
