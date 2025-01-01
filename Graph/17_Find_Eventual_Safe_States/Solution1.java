// Time Complexity: O(v+e+vlogv), Space Complexity: O(v+e) [v = number of nodes, e = number of edges]

class Solution1 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int len = graph.length;

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0 ; i<len ; i++){
            adjList.add(new ArrayList<>());
        }

        int[] inDegree = new int[len];
        
        for(int i=0 ; i<len ; i++){
            for(int neighbor: graph[i]){
                adjList.get(neighbor).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();

        for(int i=0 ; i<len ; i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            safeNodes.add(node);

            for(int it: adjList.get(node)){
                inDegree[it]--;
                if(inDegree[it]==0)
                    queue.add(it);
            }
        }
        
        Collections.sort(safeNodes);
        return safeNodes;
    }
}
