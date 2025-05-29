// Time Complexity: O(v+e),  Space Complexity: O(v)

class Solution1 {
    class Triple{
        int node;
        boolean color;

        Triple(int node, boolean color){
            this.node = node;
            this.color = color;
        }
    }

    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        
        boolean[] visited = new boolean[len];
        boolean[] color = new boolean[len];
        Queue<Triple> queue = new LinkedList<>();

        
       for(int start=0 ; start<len ; start++){
            if(!visited[start]){
                queue.add(new Triple(start, false));
                visited[start] = true;

                while(!queue.isEmpty()){
                    Triple triple = queue.poll();
                    int node = triple.node;
                    boolean currentColor = triple.color;

                    for(int neighbor : graph[node]){
                        if(visited[neighbor]){
                            if (color[neighbor] == currentColor){
                                return false;
                            }
                        }
                        else{
                            queue.add(new Triple(neighbor, !currentColor));
                            visited[neighbor] = true;
                            color[neighbor] = !currentColor;
                        }
                    }
                }
            }
        }

        return true;
    }
}
