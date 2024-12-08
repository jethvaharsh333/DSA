// Time Complexity: O(n), Space Complexity: O(n)
class Solution1 {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList());
        }

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] ans = new int[n];
        int[] count = new int[n];

        ans[0] = dfs1(adj, 0, 0, count, new boolean[n]);
        dfs2(adj, 0, ans, count, new boolean[n]);

        return ans;
    }

    private int dfs1(List<List<Integer>> adj, int node, int level, int[] count, boolean[] vis){
        vis[node] = true;
        int ans = level;
        for(int child: adj.get(node)){
            if(!vis[child]){
                ans += dfs1(adj, child, level+1, count, vis);
                count[node] += count[child];
            }
        }
        count[node]++;
        return ans;
    }

    private void dfs2(List<List<Integer>> adj, int node, int[] ans, int[] count, boolean[] vis){
        vis[node] = true;
        for(int child: adj.get(node)){
            if(!vis[child]){
                ans[child] = ans[node] - count[child] + (count.length - count[child]);
                dfs2(adj, child, ans, count, vis);
            }
        }
    }
}
