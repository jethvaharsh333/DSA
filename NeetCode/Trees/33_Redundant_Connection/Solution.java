// Time Complexity: O(n*α(n)), Space Complexity: O(n) [α(n) = inverse Ackermann function]
class Solution {
    int[] parent;
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];

        for(int i=1 ; i<=n ; i++){
            parent[i] = i;
        }

        for(int[] edge: edges){
            if(!union(edge[0], edge[1])){
                return edge;
            }
        }

        return new int[]{};
    }

    int find(int node){
        if(node != parent[node]){
            parent[node] = find(parent[node]);
        }

        return parent[node];
    }

    boolean union(int node1, int node2){
        int root1 = find(node1);
        int root2 = find(node2);

        if(root1 == root2){
            return false;
        }

        parent[root1] = root2;
        return true;
    }
}
