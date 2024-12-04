// Time Complexity: O(n), Space Complexity: O(n)
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
class Solution2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int lev=0;

        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> l=new ArrayList<>();

            for(int i=0 ; i<size ; i++){
                TreeNode node=q.poll();
                l.add(node.val);
                
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }

            if(lev%2==0){
                ans.add(l);
            }
            else{
                Collections.reverse(l);
                ans.add(l);
            }

            lev++;
        }
        return ans;
        
    }
}
