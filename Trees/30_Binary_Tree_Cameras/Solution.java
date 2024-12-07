// Time Complexity: O(n), Space Complexity: O(h) [h = height of tree]
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
    private int count = 0;

    public int minCameraCover(TreeNode root) {
        if(dfs(root) == 0){
            count++;
        }
        return count;
    }

    private int dfs(TreeNode root){
        if(root == null){
            return 2;
        }

        int leftCamera = dfs(root.left);
        int rightCamera = dfs(root.right);
        
        if(leftCamera==0 || rightCamera==0){
            count++;
            return 1;
        }

        if(leftCamera==1 || rightCamera==1){
            return 2;
        }

        return 0;
    }
}
