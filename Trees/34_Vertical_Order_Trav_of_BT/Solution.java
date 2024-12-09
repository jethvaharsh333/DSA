// Time Complexity: O(nlogn); Space Complexity: O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static int leastCol;
    static int mostCol;

    static List<List<Integer>> ans;
    static PriorityQueue<Triplets> pq;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        ans = new ArrayList<>();

        bfs(root);
        int sumCol = mostCol-leastCol+1; //leastCol is negative

        for(int i=0 ; i<sumCol ; i++)
            ans.add(new ArrayList<Integer>());

        while(!pq.isEmpty()){
            Triplets curr=pq.poll();
            ans.get(-leastCol+curr.col).add(curr.node.val);
        }

        return ans;
    }

    public static void bfs(TreeNode root){
        Queue<Triplets> q = new LinkedList<Triplets>();
        pq = new PriorityQueue<Triplets>(); // always maintain sorted queue
        int row = 0;
        int col = 0;

        q.add(new Triplets(row, col, root));
        leastCol = 0;
        mostCol = 0;
        row = 1;

        while(!q.isEmpty()){
            Triplets curr = q.poll();
            pq.add(curr); // always maintain sorted queue

            if(curr.node.left!=null){
                q.add(new Triplets(curr.row+1, curr.col-1, curr.node.left));
                leastCol = Math.min(leastCol, curr.col-1);
            }

            if(curr.node.right!=null){
                q.add(new Triplets(curr.row+1, curr.col+1, curr.node.right));
                mostCol = Math.max(mostCol, curr.col+1);
            }
        }
    }

    static class Triplets implements Comparable<Triplets>{
        int row;
        int col;
        TreeNode node;

        public Triplets(int r,int c, TreeNode n){
            row = r;
            col = c;
            node = n;
        }

        public int compareTo(Triplets p){
            if(row != p.row) return row-p.row;
            if(col != p.col) return col-p.col;
            return node.val-p.node.val;
        }
    }
}
